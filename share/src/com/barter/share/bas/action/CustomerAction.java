package com.barter.share.bas.action;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.barter.share.bas.entity.BasCustomer;
import com.barter.share.bas.service.ISerCustomer;
import com.barter.share.bas.service.imp.SerCustomer;
import com.barter.share.framework.dbutil.ServiceProxyFactory;
import com.barter.share.framework.entity.Page;
import com.barter.share.framework.exception.BaseException;
import com.barter.share.framework.util.StringUtil;
import com.barter.share.framework.web.BasAction;

/**
 * Servlet implementation class CustomerAction
 */
public class CustomerAction extends BasAction {
	private static final long serialVersionUID = 1L;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CustomerAction() {
        super();
     }
     @Override
     public void init(ServletConfig config) throws ServletException {
     	super.init(config);
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			String method = request.getParameter(METHOD_NAME);//返回操作名称
			if (METHOD_NAME_EDIT.equals(method)) {//编辑操作,包括:新增、修改的编辑
				Edit(request, response);
			} else if (METHOD_NAME_SAVE.equals(method)) {//保存操作,包括:新增、修改的保存
				Save(request, response);
			} else if (METHOD_NAME_DELETE.equals(method)) {//删除操作
				Delete(request, response);
			} else { //其余为查询列表
				PageList(request, response);
			}
		} catch (Exception ex) {
			ex.printStackTrace();
			//转发到错误提示页
			request.setAttribute("exception", ex);
			request.getRequestDispatcher(ADDR_JSP_ERROR).forward(request, response);
		}
	}

	private void PageList(HttpServletRequest request, HttpServletResponse response) {
		String strPageIndex =request.getParameter(PAGE_PARAM_PAGE_INDEX);
		String strPpageSize = request.getParameter(PAGE_PARAM_PAGE_SIZE);
		int pageIndex = StringUtil.isEmpty(strPageIndex)?0:Integer.parseInt(strPageIndex);
		int pageSize = StringUtil.isEmpty(strPpageSize)?5:Integer.parseInt(strPpageSize);
		String code = request.getParameter("code");
		String name = request.getParameter("name");
		String gender = request.getParameter("gender");
		String password = request.getParameter("password");
		String needRecvMoney = request.getParameter("needRecvMoney");
		String contactName = request.getParameter("contactName");
		String contactMobile = request.getParameter("contactMobile");
		String address = request.getParameter("address");
		BasCustomer customer =new BasCustomer();
		request.setAttribute("code", code);
		request.setAttribute("name", name);
		request.setAttribute("gender", gender);
		request.setAttribute("password", password);
		request.setAttribute("needRecvMoney", needRecvMoney);
		request.setAttribute("contactName", contactName);
		request.setAttribute("contactMobile", contactMobile);
		request.setAttribute("address", address);
		Page page = new Page();
		SerCustomer serCustomer = new SerCustomer();
		ISerCustomer iSerCustomer = (ISerCustomer)ServiceProxyFactory.getProxyInstance(serCustomer);
		customer.setCode(code);
		customer.setName(name);
		customer.setGender(gender);
		customer.setPassword(password);
		customer.setNeedRecvMoney(StringUtil.strToBigDecimal(needRecvMoney));
		customer.setContactName(contactName);
		customer.setContactMobile(contactMobile);
		customer.setAddress(address);
		try {
			page = iSerCustomer.pageList(pageIndex, pageSize, customer);
			request.setAttribute("page", page);
			request.getRequestDispatcher("/WEB-INF/jsp/admin/bas/customer/Customer.jsp").forward(request, response);
		} catch (Exception e) {
			e.printStackTrace();
			throw new BaseException("异常："+e.getMessage());
		}
	}

	private void Delete(HttpServletRequest request, HttpServletResponse response) {
		String customerId = request.getParameter("id");
		SerCustomer serCustomer = new SerCustomer();
		ISerCustomer iSerCustomer = (ISerCustomer)ServiceProxyFactory.getProxyInstance(serCustomer);
		iSerCustomer.delete(customerId);
		try {
			response.sendRedirect("/share/admin/CustomerAction.action?pageName=customer");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private void Save(HttpServletRequest request, HttpServletResponse response) {
		SerCustomer serCustomer = new SerCustomer();
		ISerCustomer iSerCustomer = (ISerCustomer)ServiceProxyFactory.getProxyInstance(serCustomer);
		String customerId = request.getParameter("id");
		String code = request.getParameter("code");
		String name = request.getParameter("name");
		String gender = request.getParameter("gender");
		String password = request.getParameter("password");
		String needRecvMoney = request.getParameter("needRecvMoney");
		String contactName = request.getParameter("contactName");
		String contactMobile = request.getParameter("contactMobile");
		String address = request.getParameter("address");
		BasCustomer customer =new BasCustomer();
		customer.setCode(code);
		customer.setName(name);
		customer.setGender(gender);
		customer.setPassword(password);
		customer.setNeedRecvMoney(StringUtil.strToBigDecimal(needRecvMoney));
		customer.setContactName(contactName);
		customer.setContactMobile(contactMobile);
		customer.setAddress(address);
		if (StringUtil.isEmpty(customerId)) {
			customerId = StringUtil.generateUUID();
			customer.setCustomerId(customerId);
			try {
				iSerCustomer.codeCheck(customer);
				iSerCustomer.insert(customer);
				response.sendRedirect("/share/admin/CustomerAction.action?pageName=customer");
			} catch (Exception e) {
				e.printStackTrace();
			}
		} else {
			customer.setCustomerId(customerId);
			try {
				iSerCustomer.codeCheck(customer);
				iSerCustomer.update(customer);
				response.sendRedirect("/share/admin/CustomerAction.action?pageName=customer");
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	private void Edit(HttpServletRequest request, HttpServletResponse response) {
		String customerId = request.getParameter("id");
		SerCustomer serCustomer = new SerCustomer();
		ISerCustomer iSerCustomer = (ISerCustomer)ServiceProxyFactory.getProxyInstance(serCustomer);
		if (StringUtil.isEmpty(customerId)) {
			try {
				request.getRequestDispatcher("/WEB-INF/jsp/admin/bas/customer/Customer_edit.jsp").forward(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}else {
			List<BasCustomer> list = iSerCustomer.load(customerId);
			BasCustomer customer = list.get(0);
			request.setAttribute("id", "&id="+customerId);
			request.setAttribute("customer", customer);
			try {
				request.getRequestDispatcher("/WEB-INF/jsp/admin/bas/customer/Customer_edit.jsp").forward(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
