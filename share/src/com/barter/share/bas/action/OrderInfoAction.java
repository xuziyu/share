package com.barter.share.bas.action;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.barter.share.bas.entity.SalOrder;
import com.barter.share.bas.service.ISalOrderService;
import com.barter.share.bas.service.ISalOrederVOService;
import com.barter.share.bas.service.imp.SalOrderServiceImp;
import com.barter.share.bas.service.imp.SalOrderVOServiceImp;
import com.barter.share.bas.vo.SalOrderVO;
import com.barter.share.framework.dbutil.ServiceProxyFactory;
import com.barter.share.framework.entity.Page;
import com.barter.share.framework.util.DateUtility;
import com.barter.share.framework.util.StringUtil;
import com.barter.share.framework.web.BasAction;

public class OrderInfoAction extends BasAction {

	private static final long serialVersionUID = 1L;
	SalOrderServiceImp salOrderServiceImp = new SalOrderServiceImp();
	ISalOrderService iSalOrderService = (ISalOrderService)ServiceProxyFactory.getProxyInstance(salOrderServiceImp);
	
	SalOrderVOServiceImp salOrderVOServiceImp = new SalOrderVOServiceImp();
	ISalOrederVOService iSalOrederVOService = (ISalOrederVOService) ServiceProxyFactory.getProxyInstance(salOrderVOServiceImp);
//	ISalOrderService iSalOrderService = (ISalOrderService)ServiceProxyFactory
//			.getProxyInstance("com.barter.share.bas.service.imp.SalOrderServiceImp");
	
	public OrderInfoAction() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.getSession().invalidate();
		try {
			String method = request.getParameter(METHOD_NAME);// 返回操作名称
			if (METHOD_NAME_EDIT.equals(method)) {// 编辑操作,包括:新增、修改的编辑
				edit(request, response);
			} else if (METHOD_NAME_SAVE.equals(method)) {// 保存操作,包括:新增、修改的保存
				save(request, response);
			} else if (METHOD_NAME_DELETE.equals(method)) {// 删除操作
				delete(request, response);
			}else if("insert".equals(method)){
				insert(request, response);
			} else { // 其余为查询列表
				pageList(request, response);
			}
		} catch (Exception ex) {
			ex.printStackTrace();
			// 转发到错误提示页
			request.setAttribute("exception", ex);
			request.getRequestDispatcher(ADDR_JSP_ERROR).forward(request, response);
		}
	}

	
	private void insert(HttpServletRequest request, HttpServletResponse response) throws IOException {
		SalOrder salOrder = new SalOrder();
		System.out.println("insert");
		bindRequest2Entity(salOrder, request);
		iSalOrderService.insert(salOrder);
		// 重定向到查询列表页面
		response.sendRedirect("OrderInfoAction.action?method=pageList");
	}

	private void pageList(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("pageList");
		String strPageIndex = request.getParameter(PAGE_PARAM_PAGE_INDEX);
		String strPageSize = request.getParameter(PAGE_PARAM_PAGE_SIZE);
		int pageIndex = StringUtil.isEmpty(strPageIndex) ? 0 : Integer.parseInt(strPageIndex);
		int pageSize = StringUtil.isEmpty(strPageSize) ? 5 : Integer.parseInt(strPageSize);
		String orderId = request.getParameter("orderId");
		String customerId = request.getParameter("customerId");
		request.setAttribute("orderId", orderId);
		request.setAttribute("customerId", customerId);
		// 执行查询
		Page page = iSalOrderService.pageList(pageIndex, pageSize, orderId, customerId);
		// 查询结果放入request,转发到页面
		request.setAttribute("page", page);
		request.getRequestDispatcher("/WEB-INF/jsp/admin/bas/OrderInfo/SalOrderPageList.jsp").forward(request,
				response);
	}

	private void edit(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		SalOrder salOrder = new SalOrder();
		System.out.println(request.getParameter("orderId"));
		// 如果是修改操作,则查询数据
		if (!StringUtil.isEmpty(request.getParameter("orderId"))) {
			Integer orderId = Integer.parseInt(request.getParameter("orderId"));
			salOrder = iSalOrderService.load(orderId);
			System.out.println("edit");
			// 其它初始化操作
			// 数据放入request,转发到页面
			request.setAttribute("salOrder", salOrder);
			request.getRequestDispatcher("/WEB-INF/jsp/admin/bas/OrderInfo/SalOrderPageListEdit.jsp").forward(request,
					response);
		}else{
			request.getRequestDispatcher("/WEB-INF/jsp/admin/bas/OrderInfo/SalOrderPageListInsert.jsp").forward(request, response);
		}

	}

	private void save(HttpServletRequest request, HttpServletResponse response)
			throws IOException, NoSuchMethodException, SecurityException, IllegalAccessException,
			IllegalArgumentException, InvocationTargetException {
		SalOrder salOrder = new SalOrder();
		bindRequest2Entity(salOrder, request);
		iSalOrderService.update(salOrder);
		System.out.println("save");
		// 重定向到查询列表页面
		response.sendRedirect("OrderInfoAction.action?method=pageList");
	}

	private void delete(HttpServletRequest request, HttpServletResponse response) throws IOException {
		String orderId = request.getParameter("orderId").toString();
		iSalOrderService.delete(orderId);
		response.sendRedirect("OrderInfoAction.action?method=pageList");
	}

	/**
	 * 将请求参数信息绑定到实体
	 * 
	 * @param employee
	 * @param request
	 */
	private void bindRequest2Entity(SalOrder salOrder, HttpServletRequest request) {
		salOrder.setOrderId(request.getParameter("orderId"));
		System.out.println("bindRequest2Entity:传入实体");
		salOrder.setCustomerId(request.getParameter("customerId"));
		salOrder.setOrderCode(request.getParameter("orderCode"));
		salOrder.setTatalMoney(StringUtil.strToBigDecimal(request.getParameter("tatalMoney")));
		salOrder.setDiscountRate(StringUtil.strToBigDecimal(request.getParameter("discountRate")));
		salOrder.setActualTatalMoney(StringUtil.strToBigDecimal(request.getParameter("actualTatalMoney")));
		salOrder.setPayStatus(StringUtil.strToBigDecimal(request.getParameter("payStatus")));
		salOrder.setPayDate(DateUtility.getDate(request.getParameter("payDate")));
//		salOrder.setCreateDatetime(DateUtility.getDate(request.getParameter("createDatetime")));
	}

}
