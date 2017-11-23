package com.barter.share.bas.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.barter.share.bas.entity.SalOrderDetailReview;
import com.barter.share.bas.service.ISalOrderDetailReviewService;
import com.barter.share.bas.service.imp.SalOrderDetailReviewServiceImp;
import com.barter.share.framework.dbutil.ServiceProxyFactory;
import com.barter.share.framework.entity.Page;
import com.barter.share.framework.util.DateUtility;
import com.barter.share.framework.util.StringUtil;
import com.barter.share.framework.web.BasAction;

/**
 * Servlet implementation class salOrderDetailReviewAction
 */
public class salOrderDetailReviewAction extends BasAction {
	private static final long serialVersionUID = 1L;

	SalOrderDetailReviewServiceImp salOrderDetailReviewServiceImp = new SalOrderDetailReviewServiceImp();
	ISalOrderDetailReviewService iSalOrderDetailReviewService = (ISalOrderDetailReviewService)
			ServiceProxyFactory.getProxyInstance(salOrderDetailReviewServiceImp)
;	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public salOrderDetailReviewAction() {
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
			} else if ("insert".equals(method)) {
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

	private void load(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		SalOrderDetailReview salOrderDetailReview = new SalOrderDetailReview();
		int orderDetailId= Integer.parseInt(request.getParameter("orderDetailId"));
		salOrderDetailReview = iSalOrderDetailReviewService.load(orderDetailId);
		System.out.println("load");
		// 其它初始化操作
		// 数据放入request,转发到页面
		request.setAttribute("salOrderDetailReview", salOrderDetailReview);	
		request.getRequestDispatcher("/WEB-INF/jsp/admin/bas/OrderInfo/SalOrderDetailReviewLoad.jsp").forward(request, response);
	
	}

	private void pageList(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("pageList");
		String strPageIndex = request.getParameter(PAGE_PARAM_PAGE_INDEX);
		String strPageSize = request.getParameter(PAGE_PARAM_PAGE_SIZE);
		int pageIndex = StringUtil.isEmpty(strPageIndex) ? 0 : Integer.parseInt(strPageIndex);
		int pageSize = StringUtil.isEmpty(strPageSize) ? 5 : Integer.parseInt(strPageSize);
		
		String orderDetailReviewId = request.getParameter("orderDetailReviewId");
		String orderDetailId = request.getParameter("orderDetailId");
		
		request.setAttribute("orderDetailReviewId", orderDetailReviewId);
		request.setAttribute("orderDetailId", orderDetailId);
		// 执行查询
		Page page = iSalOrderDetailReviewService.pageList(pageIndex, pageSize, orderDetailReviewId, orderDetailId);
		// 查询结果放入request,转发到页面
		request.setAttribute("page", page);
		request.getRequestDispatcher("/WEB-INF/jsp/admin/bas/OrderInfo/SalOrderDetailReviewList.jsp").forward(request,
				response);
	}

	private void insert(HttpServletRequest request, HttpServletResponse response) throws IOException {
		SalOrderDetailReview salOrderDetailReview = new SalOrderDetailReview();
		System.out.println("insert");
		bindRequest2Entity(salOrderDetailReview, request);
		iSalOrderDetailReviewService.insert(salOrderDetailReview);
		// 重定向到查询列表页面
		response.sendRedirect("salOrderDetailReviewAction.action?method=pageList");
	}

	private void delete(HttpServletRequest request, HttpServletResponse response) throws IOException {
		String orderDetailReviewId = request.getParameter("orderDetailReviewId");
		System.out.println("delete");
		iSalOrderDetailReviewService.delete(orderDetailReviewId);
		response.sendRedirect("/WEB-INF/jsp/admin/bas/OrderInfo/SalOrderDetailReviewList.jsp");

	}

	private void save(HttpServletRequest request, HttpServletResponse response) throws IOException {
		SalOrderDetailReview salOrderDetailReview = new SalOrderDetailReview();
		bindRequest2Entity(salOrderDetailReview, request);
		iSalOrderDetailReviewService.update(salOrderDetailReview);
		response.sendRedirect("salOrderDetailReviewAction.action?method=pagelist");
	}

	private void edit(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		SalOrderDetailReview salOrderDetailReview = new SalOrderDetailReview();
		// 如果是修改操作,则查询数据
		if (!StringUtil.isEmpty(request.getParameter("orderDetailReviewId"))) {
			int orderDetailReviewId= Integer.parseInt(request.getParameter("orderDetailReviewId"));
			salOrderDetailReview = iSalOrderDetailReviewService.load(orderDetailReviewId);
			System.out.println("edit");
			// 其它初始化操作
			// 数据放入request,转发到页面
			request.setAttribute("salOrderDetailReview", salOrderDetailReview);
			request.getRequestDispatcher("/WEB-INF/jsp/admin/bas/OrderInfo/SalOrderDetailReviewEdit.jsp").forward(request,
					response);
		} else {
			request.getRequestDispatcher("/WEB-INF/jsp/admin/bas/OrderInfo/SalOrderDetailReviewInsert.jsp").forward(request,
					response);
		}
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

	private void bindRequest2Entity(SalOrderDetailReview salOrderDetailReview, HttpServletRequest request) {
		salOrderDetailReview.setOrderDetailReviewId(request.getParameter("orderDetailReviewId"));
		salOrderDetailReview.setOrderDetailId(request.getParameter("orderDetailId"));
		salOrderDetailReview.setReviewGrade(StringUtil.strToBigDecimal(request.getParameter("reviewGrade")));
		salOrderDetailReview.setContent(request.getParameter("content"));
		salOrderDetailReview.setCreateDate(DateUtility.getDate(request.getParameter("createDate")));
	}

}
