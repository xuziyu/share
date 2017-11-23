package com.barter.share.bas.action;

import java.io.IOException;
import java.math.BigDecimal;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.barter.share.bas.service.IBasProductSkuVoService;
import com.barter.share.bas.service.IBasProductVoService2;
import com.barter.share.bas.service.ISalOrederVOService;
import com.barter.share.bas.service.imp.BasProductSkuVoService;
import com.barter.share.bas.service.imp.BasProductVoService2;
import com.barter.share.bas.service.imp.SalOrderVOServiceImp;
import com.barter.share.bas.vo.BasProductSkuVo;
import com.barter.share.bas.vo.SalOrderVO;
import com.barter.share.framework.dbutil.ServiceProxyFactory;
import com.barter.share.framework.entity.Page;
import com.barter.share.framework.util.DateUtility;
import com.barter.share.framework.util.StringUtil;
import com.barter.share.framework.web.BasAction;

/**
 * Servlet implementation class SalOrderVOAction
 */
public class SalOrderVOAction extends BasAction {
	private static final long serialVersionUID = 1L;

	SalOrderVOServiceImp salOrderVOServiceImp = new SalOrderVOServiceImp();
	ISalOrederVOService iSalOrederVOService = (ISalOrederVOService) ServiceProxyFactory
			.getProxyInstance(salOrderVOServiceImp);

	BasProductSkuVoService basProductSkuVoService = new BasProductSkuVoService();
	IBasProductSkuVoService iBasProductSkuVoService = (IBasProductSkuVoService) ServiceProxyFactory
			.getProxyInstance(basProductSkuVoService);

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public SalOrderVOAction() {
		super();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
			String method = request.getParameter(METHOD_NAME);// 返回操作名称
			if ("joinselect".equals(method)) {// 编辑操作,包括:新增、修改的编辑
				joinselect(request, response);
			} else if (METHOD_NAME_DELETE.equals(method)) {// 删除操作
				delete(request, response);
			}else if ("insertall".equals(method)) {
				insertall(request, response);
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

	private void delete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String orderId = request.getParameter("orderId");
		String orderDetailId = request.getParameter("orderDetailId");
		iSalOrederVOService.delete(orderId, orderDetailId);
		response.sendRedirect("SalOrderVOAction.Action?method=pagelist");
	}

	private void pageList(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
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
		Page page = iSalOrederVOService.pageList(pageIndex, pageSize, customerId, orderId);
		// 查询结果放入request,转发到页面
		request.setAttribute("page", page);
		request.getRequestDispatcher("/WEB-INF/jsp/front/OrderInfo/OrderInfo.jsp").forward(request,
				response);
	}

	private void insertall(HttpServletRequest request, HttpServletResponse response) throws IOException {
		System.out.println("insertall");
		HttpSession session = request.getSession();
		// BasProductSkuVo basProductSkuVo =
		// iBasProductSkuVoService.load(request.getParameter("Skuid"));
		BasProductSkuVo basProductSkuVo = new BasProductSkuVo();
		SalOrderVO salOrderVO = new SalOrderVO();
		salOrderVO.setOrderId(StringUtil.generateUUID());
		salOrderVO.setCustomerId("customerId");
		salOrderVO.setOrderCode(StringUtil.generateUUID());
		salOrderVO.setTatalMoney(basProductSkuVo.getPriceReal());
		// salOrderVO.setDiscountRate();
		// salOrderVO.setActualTatalMoney();
		// salOrderVO.setPayDate(payDate);
		// salOrderVO.setPayStatus();
		salOrderVO.setOrderDetailId(StringUtil.generateUUID());
		salOrderVO.setOrderDetailCode(StringUtil.generateUUID());
		// salOrderVO.setProductSkuId();
		// salOrderVO.setName();
		// salOrderVO.setAmount();
		// salOrderVO.setPrice();
		// salOrderVO.setRemark();
		// salOrderVO.setStockOutStatus();
		// salOrderVO.setStockOutDate();
		// salOrderVO.setLogisticsStatus();
		// salOrderVO.setLogisticsArriveDate();
		// salOrderVO.setLogisticsSignDate();
		// salOrderVO.setReviewStatus();
		salOrderVO.setOrderDetailReviewId(StringUtil.generateUUID());
		// salOrderVO.setReviewGrade();
		// salOrderVO.setContent();
		// salOrderVO.setCreateDate();
		iSalOrederVOService.insert(salOrderVO);
		response.sendRedirect("OrderInfoAction.action?method=pageList");
	}

	private void joinselect(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		SalOrderVO salOrderVO = iSalOrederVOService.load(request.getParameter("customerId"));
		System.out.println("joinselect");
		request.setAttribute("salOrderVO", salOrderVO);
		request.getRequestDispatcher("/WEB-INF/jsp/admin/bas/OrderInfo/SalOrderVOLoad.jsp").forward(request, response);
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
