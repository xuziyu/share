package com.barter.share.bas.frontaction;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.barter.share.bas.entity.BasCustomer;
import com.barter.share.bas.service.IBasCustomerService;
import com.barter.share.bas.service.IBasProductSkuVoService;
import com.barter.share.bas.service.IProductVOService;
import com.barter.share.bas.service.ISalOrderService;
import com.barter.share.bas.service.ISalOrederVOService;
import com.barter.share.bas.service.ISerCustomer;
import com.barter.share.bas.service.imp.BasCustomerService;
import com.barter.share.bas.service.imp.BasProductSkuVoService;
import com.barter.share.bas.service.imp.ProductVOService;
import com.barter.share.bas.service.imp.SalOrderServiceImp;
import com.barter.share.bas.service.imp.SalOrderVOServiceImp;
import com.barter.share.bas.service.imp.SerCustomer;
import com.barter.share.bas.vo.ProductSkuVO;
import com.barter.share.bas.vo.SalOrderVO;
import com.barter.share.framework.dbutil.ServiceProxyFactory;
import com.barter.share.framework.entity.Page;
import com.barter.share.framework.util.DateUtility;
import com.barter.share.framework.util.StringUtil;
import com.barter.share.framework.web.BasAction;

/**
 * Servlet implementation class SalOrderAction
 */
public class SalOrderAction extends BasAction {
	private static final long serialVersionUID = 1L;

	SalOrderVOServiceImp salOrderVOServiceImp = new SalOrderVOServiceImp();
	ISalOrederVOService iSalOrederVOService = (ISalOrederVOService) ServiceProxyFactory
			.getProxyInstance(salOrderVOServiceImp);

	BasProductSkuVoService basProductSkuVoService = new BasProductSkuVoService();
	IBasProductSkuVoService iBasProductSkuVoService = (IBasProductSkuVoService) ServiceProxyFactory
			.getProxyInstance(basProductSkuVoService);

	ProductVOService productVOService = new ProductVOService();
	IProductVOService iProductVOService = (IProductVOService) ServiceProxyFactory.getProxyInstance(productVOService);

	SerCustomer serCustomer = new SerCustomer();
	ISerCustomer iSerCustomer = (ISerCustomer) ServiceProxyFactory.getProxyInstance(serCustomer);

	BasCustomerService basCustomerService = new BasCustomerService();
	IBasCustomerService iBasCustomerService = (IBasCustomerService) ServiceProxyFactory.getProxyInstance(basCustomerService);
	
	SalOrderServiceImp salOrderServiceImp = new SalOrderServiceImp();
	ISalOrderService iSalOrderService = (ISalOrderService) ServiceProxyFactory.getProxyInstance(salOrderServiceImp);
	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public SalOrderAction() {
		super();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
			String method = request.getParameter(METHOD_NAME);
			if ("insertall".equals(method)) {
				insertall(request, response);
			} else if ("gopay".equals(method)) {
				gopay(request, response);
			} else if("pay".equals(method)){
				pay(request, response);
			}else if("pagelistnotpay".equals(method)){
				pagelistnotpay(request, response);
			}else if("pagelistnotarrive".equals(method)){
				pagelistnotarrive(request, response);
			}else if("pagelistnocomment".equals(method)){
				pagelistnocomment(request, response);
			}else{
				pagelist(request, response);
			}
		} catch (Exception ex) {
			ex.printStackTrace();
			// 转发到错误提示页
			request.setAttribute("exception", ex);
			request.getRequestDispatcher(ADDR_JSP_ERROR).forward(request, response);
		}
	}

	private void pagelistnocomment(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		String customerId = session.getAttribute("id").toString();
//		String customerId = "0857fc49-1a10-4fd6-8b87-eca03aa3c74d";
		String strPageIndex = request.getParameter(PAGE_PARAM_PAGE_INDEX);
		String strPageSize = request.getParameter(PAGE_PARAM_PAGE_SIZE);
		int pageIndex = StringUtil.isEmpty(strPageIndex) ? 0 : Integer.parseInt(strPageIndex);
		int pageSize = StringUtil.isEmpty(strPageSize) ? 5 : Integer.parseInt(strPageSize);
		String orderId = request.getParameter("orderId");
		request.setAttribute("orderId", orderId);
		request.setAttribute("customerId", customerId);
		Page page = salOrderVOServiceImp.pagenocomment(pageIndex, pageSize, customerId);
		request.setAttribute("page", page);
		request.getRequestDispatcher("/WEB-INF/jsp/front/OrderInfo/OrderInfoNoComment.jsp").forward(request, response);		
	}

	private void pagelistnotarrive(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		String customerId = session.getAttribute("customerId").toString();
//		String customerId = "0857fc49-1a10-4fd6-8b87-eca03aa3c74d";
		String strPageIndex = request.getParameter(PAGE_PARAM_PAGE_INDEX);
		String strPageSize = request.getParameter(PAGE_PARAM_PAGE_SIZE);
		int pageIndex = StringUtil.isEmpty(strPageIndex) ? 0 : Integer.parseInt(strPageIndex);
		int pageSize = StringUtil.isEmpty(strPageSize) ? 5 : Integer.parseInt(strPageSize);
		String orderId = request.getParameter("orderId");
		request.setAttribute("orderId", orderId);
		request.setAttribute("customerId", customerId);
		Page page = salOrderVOServiceImp.pagenotarrive(pageIndex, pageSize, customerId);
		request.setAttribute("page", page);
		request.getRequestDispatcher("/WEB-INF/jsp/front/OrderInfo/OrderInfo.jsp").forward(request, response);
	}

	private void pagelistnotpay(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		String customerId = session.getAttribute("customerId").toString();
//		String customerId = "0857fc49-1a10-4fd6-8b87-eca03aa3c74d";
		String strPageIndex = request.getParameter(PAGE_PARAM_PAGE_INDEX);
		String strPageSize = request.getParameter(PAGE_PARAM_PAGE_SIZE);
		int pageIndex = StringUtil.isEmpty(strPageIndex) ? 0 : Integer.parseInt(strPageIndex);
		int pageSize = StringUtil.isEmpty(strPageSize) ? 5 : Integer.parseInt(strPageSize);
		String orderId = request.getParameter("orderId");
		request.setAttribute("orderId", orderId);
		request.setAttribute("customerId", customerId);
		Page page = salOrderVOServiceImp.pagenotpay(pageIndex, pageSize, customerId);
		request.setAttribute("page", page);
		request.getRequestDispatcher("/WEB-INF/jsp/front/OrderInfo/OrderInfo.jsp").forward(request, response);
		
	}

	private void pagelist(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		String customerId = session.getAttribute("id").toString();
//		String customerId = "0857fc49-1a10-4fd6-8b87-eca03aa3c74d";
		String strPageIndex = request.getParameter(PAGE_PARAM_PAGE_INDEX);
		String strPageSize = request.getParameter(PAGE_PARAM_PAGE_SIZE);
		int pageIndex = StringUtil.isEmpty(strPageIndex) ? 0 : Integer.parseInt(strPageIndex);
		int pageSize = StringUtil.isEmpty(strPageSize) ? 5 : Integer.parseInt(strPageSize);
		String orderId = request.getParameter("orderId");
		request.setAttribute("orderId", orderId);
		request.setAttribute("customerId", customerId);
		Page page = salOrderVOServiceImp.pageList(pageIndex, pageSize, customerId, orderId);
		request.setAttribute("page", page);
		request.getRequestDispatcher("/WEB-INF/jsp/front/OrderInfo/OrderInfo.jsp").forward(request, response);
	}

	private void pay(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		System.out.println("pay");
		HttpSession session = request.getSession();
		String customerId  = session.getAttribute("id").toString();
//		String customerId = "0857fc49-1a10-4fd6-8b87-eca03aa3c74d";
		System.out.println("用户ID" + customerId);
//		BasCustomer basCustomer = iBasCustomerService.basCustomer(customerId);
		System.out.println("密码：" + session.getAttribute("password"));
		System.out.println(request.getParameter("paypassword"));
		if(request.getParameter("paypassword").equals(session.getAttribute("password"))){
			iSalOrderService.payState(request.getParameter("orderId"));
			request.getRequestDispatcher("/WEB-INF/jsp/front/OrderInfo/PaySuccess.jsp").forward(request, response);
		}else {
			request.getRequestDispatcher("/WEB-INF/jsp/front/OrderInfo/PayError.jsp").forward(request, response);
		}
	}

	private void cart(HttpServletRequest request, HttpServletResponse response) {

	}

	private void gopay(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("gopay");
		HttpSession session = request.getSession();
		String customerId = session.getAttribute("id").toString();
		System.out.println("用户ID："+customerId);
//		String customerId = "0857fc49-1a10-4fd6-8b87-eca03aa3c74d";
//		String productSkuId = session.getAttribute("ProductSkuId").toString();
		String productSkuId = session.getAttribute("productSkuId").toString();
		System.out.println("skuid:"+productSkuId);
		ProductSkuVO productSkuVO = iProductVOService.salorder(productSkuId);
		BasCustomer basCustomer = iBasCustomerService.basCustomer(customerId);
		request.getParameter("value");
		request.setAttribute("productSkuVO", productSkuVO);
		request.setAttribute("basCustomer", basCustomer);
		request.getRequestDispatcher("/WEB-INF/jsp/front/OrderInfo/CommitOrder.jsp").forward(request, response);

	}

	private void insertall(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		System.out.println("insertall");
		
		HttpSession session = request.getSession();
		// BasProductSkuVo basProductSkuVo =
		// iBasProductSkuVoService.load(request.getParameter("Skuid"));
		System.out.println(session.getAttribute("productSkuId").toString());
		String productSkuId = session.getAttribute("productSkuId").toString();
		ProductSkuVO productSkuVO = iProductVOService.salorder(productSkuId);
		SalOrderVO salOrderVO = new SalOrderVO();
		salOrderVO.setOrderId(StringUtil.generateUUID());
		salOrderVO.setCustomerId(session.getAttribute("id").toString());
		salOrderVO.setOrderCode(StringUtil.generateUUID());
		salOrderVO.setTatalMoney(productSkuVO.getPriceReal());
		// salOrderVO.setDiscountRate();
		salOrderVO.setActualTatalMoney(productSkuVO.getPriceReal());
		// salOrderVO.setPayDate(payDate);
		salOrderVO.setPayStatus(StringUtil.strToBigDecimal("0"));
		salOrderVO.setOrderDetailId(StringUtil.generateUUID());
		salOrderVO.setOrderDetailCode(StringUtil.generateUUID());
		salOrderVO.setProductSkuId(productSkuId);
		salOrderVO.setName(productSkuVO.getName());
		salOrderVO.setAmount(StringUtil.strToBigDecimal("1"));
		salOrderVO.setPrice(productSkuVO.getPriceReal());
		salOrderVO.setRemark(request.getParameter("remark"));
		// salOrderVO.setStockOutStatus();
		// salOrderVO.setStockOutDate();
		// salOrderVO.setLogisticsStatus();
		// salOrderVO.setLogisticsArriveDate();
		// salOrderVO.setLogisticsSignDate();
		// salOrderVO.setReviewStatus();
		salOrderVO.setOrderDetailReviewId(StringUtil.generateUUID());
		// salOrderVO.setReviewGrade();
		// salOrderVO.setContent();
		salOrderVO.setCreateDate(DateUtility.getDate(request.getParameter("")));
		iSalOrederVOService.insert(salOrderVO);
		request.setAttribute("salOrderVO", salOrderVO);
		request.getRequestDispatcher("/WEB-INF/jsp/front/OrderInfo/Pay.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
