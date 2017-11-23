package com.barter.share.bas.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.barter.share.bas.entity.SalOrderDetail;
import com.barter.share.bas.service.ISalOrderDetailService;
import com.barter.share.bas.service.imp.SalOrderDetailServiceImp;
import com.barter.share.framework.dbutil.ServiceProxyFactory;
import com.barter.share.framework.entity.Page;
import com.barter.share.framework.util.DateUtility;
import com.barter.share.framework.util.StringUtil;
import com.barter.share.framework.web.BasAction;

/**
 * Servlet implementation class SalOrderDetailAction
 */
public class SalOrderDetailAction extends BasAction {
	private static final long serialVersionUID = 1L;

	SalOrderDetailServiceImp salOrderDetailServiceImp = new SalOrderDetailServiceImp();
	ISalOrderDetailService iSalOrderDetailService = (ISalOrderDetailService)ServiceProxyFactory.
			getProxyInstance(salOrderDetailServiceImp);
	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public SalOrderDetailAction() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
			String method = request.getParameter(METHOD_NAME);// 返回操作名称
			if (METHOD_NAME_EDIT.equals(method)) {// 编辑操作,包括:新增、修改的编辑
				edit(request, response);
			} else if (METHOD_NAME_SAVE.equals(method)) {// 保存操作,包括:新增、修改的保存
				save(request, response);
			} else if (METHOD_NAME_DELETE.equals(method)) {// 删除操作
				delete(request, response);
			} else if ("insert".equals(method)){
				insert(request, response);
			}else if("load".equals(method)){
				load(request, response);
			}
			else { // 其余为查询列表
				pageList(request, response);
			}
		} catch (Exception ex) {
			ex.printStackTrace();
			// 转发到错误提示页
			request.setAttribute("exception", ex);
			request.getRequestDispatcher(ADDR_JSP_ERROR).forward(request, response);
		}
	}
	private void load(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		System.out.println("load");	
		SalOrderDetail salOrderDetail = new SalOrderDetail();
		String orderId = request.getParameter("orderId");
		salOrderDetail = iSalOrderDetailService.load(null, orderId);
		request.setAttribute("salOrderDetail", salOrderDetail);
		request.getRequestDispatcher("/WEB-INF/jsp/admin/bas/OrderInfo/SalOrderDetailLoad.jsp").forward(request, response);
		
	}

	private void pageList(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("pageList");
		String strPageIndex = request.getParameter(PAGE_PARAM_PAGE_INDEX);
		String strPageSize = request.getParameter(PAGE_PARAM_PAGE_SIZE);

		int pageIndex = StringUtil.isEmpty(strPageIndex) ? 0 : Integer.parseInt(strPageIndex);
		int pageSize = StringUtil.isEmpty(strPageSize) ? 5 : Integer.parseInt(strPageSize);

		String orderDetailId = request.getParameter("orderDetailId");
		String orderId = request.getParameter("orderId");

		request.setAttribute("orderDetailId", orderDetailId);
		request.setAttribute("orderId", orderId);
		
		// 执行查询
		Page page = iSalOrderDetailService.pageList(pageIndex, pageSize, orderDetailId, orderDetailId);
		// 查询结果放入request,转发到页面
		request.setAttribute("page", page);
		request.getRequestDispatcher("/WEB-INF/jsp/admin/bas/OrderInfo/SalOrderDetailList.jsp").forward(request,
				response);
	}

	private void insert(HttpServletRequest request, HttpServletResponse response) throws IOException {
		SalOrderDetail salOrderDetail = new SalOrderDetail();
		System.out.println("insert");
		bindRequest2Entity(salOrderDetail, request);
		iSalOrderDetailService.insert(salOrderDetail);
		response.sendRedirect("SalOrderDetailAction.Action?method=pagelist");
	}

	private void delete(HttpServletRequest request, HttpServletResponse response) throws IOException {
		String orderDetailId = request.getParameter("orderDetailId");
		iSalOrderDetailService.delete(orderDetailId);
		response.sendRedirect("SalOrderDetailAction.Action?method=pagelist");
	}

	private void save(HttpServletRequest request, HttpServletResponse response) throws IOException {
		SalOrderDetail salOrderDetail = new SalOrderDetail();
		bindRequest2Entity(salOrderDetail, request);
		iSalOrderDetailService.update(salOrderDetail);
		response.sendRedirect("SalOrderDetailAction.Action?method=pagelist");
	}

	private void edit(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		SalOrderDetail salOrderDetail = new SalOrderDetail();
		// 如果是修改操作,则查询数据
		if (!StringUtil.isEmpty(request.getParameter("orderDetailId"))) {
			String orderDetailId = request.getParameter("orderDetailId");
			salOrderDetail = iSalOrderDetailService.load(orderDetailId, null);
			System.out.println("edit");
			// 其它初始化操作
			// 数据放入request,转发到页面
			request.setAttribute("salOrderDetail", salOrderDetail);
			request.getRequestDispatcher("/WEB-INF/jsp/admin/bas/OrderInfo/SalOrderDetailEdit.jsp").forward(request,
					response);
		} else {
			request.getRequestDispatcher("/WEB-INF/jsp/admin/bas/OrderInfo/SalOrderDetailInsert.jsp").forward(request,
					response);
		}
	}

	private void bindRequest2Entity(SalOrderDetail salOrderDetail, HttpServletRequest request) {
		salOrderDetail.setOrderDetailId(request.getParameter("orderDetailId"));
		salOrderDetail.setOrderId(request.getParameter("orderId"));
		salOrderDetail.setProductSkuId(request.getParameter("productSkuId"));
		salOrderDetail.setOrderDetailCode(request.getParameter("orderDetailCode"));
		salOrderDetail.setName(request.getParameter("name"));
		salOrderDetail.setAmount(StringUtil.strToBigDecimal(request.getParameter("amount")));
		salOrderDetail.setPrice(StringUtil.strToBigDecimal(request.getParameter("price")));
		salOrderDetail.setRemark(request.getParameter("remark"));
		salOrderDetail.setStockOutStatus(StringUtil.strToBigDecimal(request.getParameter("stockOutStatus")));
		salOrderDetail.setStockOutDate(DateUtility.getDate(request.getParameter("stockOutDate")));
		salOrderDetail.setLogisticsStatus(StringUtil.strToBigDecimal(request.getParameter("logisticsStatus")));
		salOrderDetail.setLogisticsArriveDate(DateUtility.getDate(request.getParameter("logisticsArriveDate")));
		salOrderDetail.setLogisticsSignDate(DateUtility.getDate(request.getParameter("logisticsSignDate")));
		salOrderDetail.setReviewStatus(StringUtil.strToBigDecimal(request.getParameter("reviewStatus")));
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
