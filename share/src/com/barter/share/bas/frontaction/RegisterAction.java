package com.barter.share.bas.frontaction;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.Writer;
import java.util.UUID;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.jasper.tagplugins.jstl.core.Out;

import com.barter.share.bas.dao.imp.CustomerImp;
import com.barter.share.bas.entity.Customer;
import com.barter.share.framework.exception.DbException;
import com.barter.share.framework.exception.ValidateException;
import com.barter.share.framework.util.StringUtil;
import com.barter.share.framework.web.BasAction;


/**
 * Servlet implementation class RegisterAction
 */
public class RegisterAction extends BasAction {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RegisterAction() {
        super();
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
	
		
	}
	private void open(HttpServletRequest request, HttpServletResponse response)throws ServletException,IOException{
		request.getRequestDispatcher("/WEB-INF/jsp/front/customer/register.jsp").forward(request, response);
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
	private void save(HttpServletRequest request,HttpServletResponse response)throws ServletException,IOException{
		String code = (String)request.getSession().getAttribute("code");
		String inputCode=request.getParameter("code");//验证码
		CustomerImp customerImp=new CustomerImp();
		String userName=request.getParameter("user");
		try {
			customerImp.load(userName);
		} catch (Exception e) {
			PrintWriter out = response.getWriter();
			out.println("<script language='javascript'>alert('名称已经存在！');window.location.href='/share/front/RegisterAction.action'</script>");
			return;
		}
		
		String password=request.getParameter("password");//通过密码
	
		String rpassword=request.getParameter("rpassword");//确认密码
		if (StringUtil.isEmpty(password)) {
			PrintWriter out = response.getWriter();
			out.println("<script language='javascript'>alert('密码不能为空！');window.location.href='/share/front/RegisterAction.action'</script>");
			return;
		}
		if (StringUtil.isEmpty(rpassword)) {
			PrintWriter out = response.getWriter();
			out.println("<script language='javascript'>alert('确认密码不能为空！');window.location.href='/share/front/RegisterAction.action'</script>");
			return;
		}
		if(!password.equals(rpassword)){
			PrintWriter out = response.getWriter();
			out.println("<script language='javascript'>alert('两次不一致！');window.location.href='/share/front/RegisterAction.action'</script>");
			return;
		}
		if (!code.toLowerCase().equals(inputCode.toLowerCase())) {
			PrintWriter out = response.getWriter();
			out.println("<script language='javascript'>alert('验证码错误！');window.location.href='/share/front/RegisterAction.action'</script>");
			return;
		}
		String telephone=request.getParameter("telephone");//电话号码
		////customerImp.load(telephone);
		customerImp.list(telephone);
	
		String id=StringUtil.generateUUID();
		
				Customer customer=new Customer();
				customer.setId(id);
				customer.setName(userName);
				customer.setPassword(password);
				customer.setTelephone(telephone);
				customerImp.insert(customer);
				request.setAttribute("customer", customer);
				PrintWriter out = response.getWriter();
				out.println("<script language='javascript'>alert('注册成功！');window.location.href='/share/front/LoginfAction.action'</script>");
		
	}

}
