package com.barter.share.bas.action;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.barter.share.bas.entity.BasCustomer;
import com.barter.share.bas.entity.SysEmployee;
import com.barter.share.bas.service.IAdminLoginService;
import com.barter.share.bas.service.ILoginService;
import com.barter.share.bas.service.imp.AdminLoginService;
import com.barter.share.bas.service.imp.LoginServiceImp;
import com.barter.share.framework.dbutil.ServiceProxyFactory;
import com.barter.share.framework.exception.DbException;
import com.barter.share.framework.web.BasAction;

/**
 * Servlet implementation class LoginAction
 */
public class AdminLoginAction extends BasAction {
	
	private static final long serialVersionUID = 1L;
       
    
	/**
     * @see HttpServlet#HttpServlet()
     */
    public AdminLoginAction() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String xxx = request.getParameter("xxx");
		if ("zhuxiao".equals(xxx)) {
			HttpSession session = request.getSession();
			session.removeAttribute("employeeId");
			response.sendRedirect("/share/resource/admin/main/login.jsp");
		} else {
			request.setCharacterEncoding("utf-8");
			response.setContentType("text/html;charSet=UTF-8");
			response.setCharacterEncoding("utf-8");
			AdminLoginService adminLoginService = new AdminLoginService();
			IAdminLoginService iAdminLoginService = (IAdminLoginService)ServiceProxyFactory.getProxyInstance(adminLoginService);
			String code = request.getParameter("user");
			String password = request.getParameter("password");
			List<SysEmployee> listSysEmployee = iAdminLoginService.load(code);
			if (listSysEmployee.size()==0) {
				throw new DbException("账号不正确");
			}
			String dbCode = listSysEmployee.get(0).getCode();
			String dbpassword = listSysEmployee.get(0).getPassword();
			String employeeId = listSysEmployee.get(0).getEmployeeId();
			if (!dbpassword.equals(password)) {
				throw new DbException("密码不正确");
			}
			HttpSession session = request.getSession();
			session.setAttribute("dbCode", dbCode);
			session.setAttribute("dbpassword", dbpassword);
			session.setAttribute("employeeId", employeeId);
			request.getRequestDispatcher("/WEB-INF/jsp/admin/bas/front/front.jsp").forward(request, response);
		}
	}

}
