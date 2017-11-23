package com.barter.share.bas.frontaction;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.barter.share.bas.dao.imp.CustomerImp;
import com.barter.share.bas.entity.Customer;
import com.barter.share.framework.exception.ValidateException;
import com.barter.share.framework.util.StringUtil;
import com.barter.share.framework.web.BasAction;


/**
 * Servlet implementation class LoginAction
 */
public class LoginfAction extends BasAction{
	private static final long serialVersionUID = 1L;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginfAction() {
        super();
        // TODO Auto-generated constructor stub
    }
  
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");//设置请求编码
		response.setContentType("text/html; charset=UTF-8");//设置响应的html编码
		response.setCharacterEncoding("utf-8");//
		String method=request.getParameter(METHOD_NAME);
		if(METHOD_NAME_SAVE.equals(method)){
			save(request, response);
		}else{
			open(request, response);
		}
	
	    //response.sendRedirect("/page/Login.jsp");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
		request.setCharacterEncoding("utf-8");//设置请求编码
		response.setContentType("text/html; charset=UTF-8");//设置响应的html编码
		response.setCharacterEncoding("utf-8");//
	}
	private void open(HttpServletRequest request,HttpServletResponse response)throws ServletException,IOException{	
		request.getRequestDispatcher("/WEB-INF/jsp/front/customer/Login.jsp").forward(request, response);
	}
	private void save(HttpServletRequest request,HttpServletResponse response)throws ServletException,IOException{	
		PrintWriter out = response.getWriter();
		String code=request.getParameter("code");
		String password=request.getParameter("password");
	    CustomerImp customerImp=new CustomerImp();
	    Customer customer;
	    if (!StringUtil.isEmpty(code)) {
	    	try {
	    		customer = customerImp.llist(code);
	    		if(!customer.getPassword().equals(password)){
					out.println("<script language='javascript'>alert('密码错误！');window.location.href='/share/front/LoginfAction.action'</script>");
					return;
			    }
			    request.getSession().setAttribute("code", code);
			    request.getSession().setAttribute("password", password);
			    String name = customer.getName();
			    String id = customer.getId();
			    request.getSession().setAttribute("name", name);
			    request.getSession().setAttribute("id", id);
			    response.sendRedirect("/share/front/WomenAction.action");
			} catch (Exception e) {
				out.println("<script language='javascript'>alert('账号不存在！');window.location.href='/share/front/LoginfAction.action'</script>");
				return;
			}
		}else {
			out.println("<script language='javascript'>alert('请输入账号！');window.location.href='/share/front/LoginfAction.action'</script>");
			return;
		}
	}

}
