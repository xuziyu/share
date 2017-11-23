package com.barter.share.bas.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.barter.share.bas.entity.BasCustomer;
import com.barter.share.bas.service.ILoginService;
import com.barter.share.bas.service.imp.LoginServiceImp;
import com.barter.share.framework.dbutil.ServiceProxyFactory;
import com.barter.share.framework.web.BasAction;

/**
 * Servlet implementation class LoginAction
 */
public class LoginAction extends BasAction {
	
	private static final long serialVersionUID = 1L;
       
	LoginServiceImp loginServiceImp = new LoginServiceImp();
	
	ILoginService iLoginService =  (ILoginService)ServiceProxyFactory.getProxyInstance(loginServiceImp);
    
	/**
     * @see HttpServlet#HttpServlet()
     */
    public LoginAction() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			String method = request.getParameter(METHOD_NAME);
			if(METHOD_NAME_CUSTOMER.equals(method)){
				customer(request, response);
			}else if(METHOD_NAME_EMPLOYEE.equals(method)){
				employee(request, response);
			}else{
				request.getRequestDispatcher("/WEB-INF/jsp/admin/common/Login.jsp").forward(request, response);
			}
		}catch(Exception ex){
			ex.printStackTrace();
			// 转发到错误提示页
			request.setAttribute("exception", ex);
			request.getRequestDispatcher(ADDR_JSP_ERROR).forward(request, response);
		}
	
			
	}

	private void employee(HttpServletRequest request, HttpServletResponse response) {

		
	}

	private void customer(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		Integer usercode =Integer.parseInt(request.getParameter("usercode")) ;
		String pwd = request.getParameter("pwd");
		System.out.println(request.getParameter("usercode"));
		System.out.println(request.getParameter("pwd"));
		BasCustomer basCustomer = iLoginService.customerLogin(usercode);
		if(basCustomer.getPassword().equals(pwd)){
			System.out.println("登录");
			BasCustomer user = new BasCustomer();
			user.setCustomerId(basCustomer.getCustomerId());
			System.out.println(basCustomer.getCustomerId());
			user.setName(basCustomer.getName());
			user.setCode(basCustomer.getCode());
			user.setGender(basCustomer.getGender());
			user.setPassword(basCustomer.getPassword());
			user.setNeedRecvMoney(basCustomer.getNeedRecvMoney());
			user.setContactName(basCustomer.getContactName());
			user.setContactMobile(basCustomer.getContactName());
			user.setAddress(basCustomer.getAddress());
			
			HttpSession session = request.getSession() ;
			session.setAttribute("s_user", user);
			
			
			request.getRequestDispatcher("/WEB-INF/jsp/admin/common/CustomerIndex.jsp").forward(request, response);
					
		}else{
			System.out.println("登录失败");
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
