package com.barter.share.framework.web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 
 * 功能描述:action基类
 * @author Administrator
 * @version 1.0
 * 创建日期:2017年5月12日
 */
public class BasAction extends HttpServlet {
	public static final String METHOD_NAME = "method";//操作名

	public static final String METHOD_NAME_EDIT = "edit";//编辑

	public static final String METHOD_NAME_SAVE = "save";//保存

	public static final String METHOD_NAME_DELETE = "delete";//删除

	public static final String METHOD_NAME_LIST = "list";//查询列表
	
	public static final String METHOD_NAME_PAGE = "page";//分页查询列表

	public static final String METHOD_NAME_LOAD = "load";//加载
	
	public static final String METHOD_NAME_CUSTOMER = "customer";
	
	public static final String METHOD_NAME_EMPLOYEE = "employee";
	
	protected static final String ADDR_JSP_ERROR = "/page/common/error.jsp" ;//错误处理页
	
	
	public static final String PAGE_PARAM_PAGE_INDEX = "pageIndex" ;
	public static final String PAGE_PARAM_PAGE_SIZE = "pageSize" ;
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charSet=UTF-8");
		response.setCharacterEncoding("utf-8");
		doGet(request, response);
	}
}
