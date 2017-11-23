package com.barter.share.framework.web;

import java.io.IOException;
import java.util.Iterator;
import java.util.List;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.barter.share.bas.service.ISysMenuService;
import com.barter.share.bas.service.imp.SysMenuService;
import com.barter.share.bas.vo.SysMenuUrlVo;
import com.barter.share.framework.dbutil.ServiceProxyFactory;

/**
 * Servlet Filter implementation class AdminAuthenFilter
 */
public class AdminAuthenFilter implements Filter {

    /**
     * Default constructor. 
     */
    public AdminAuthenFilter() {
    	
    }

	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {
		
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		HttpServletRequest httpRequest = (HttpServletRequest)request;
		HttpServletResponse httpResponse = (HttpServletResponse)response;
		HttpSession session = httpRequest.getSession();
		if (session==null) {
			httpResponse.sendRedirect("");
			return ;
		}
		String employeeId = (String)session.getAttribute("employeeId");
		SysMenuService sysMenuService = new SysMenuService();
		ISysMenuService iSysMenuService = (ISysMenuService)ServiceProxyFactory.getProxyInstance(sysMenuService);
		List<SysMenuUrlVo> listSysMenuUrlVo = iSysMenuService.loadUrl(employeeId);
		boolean haveAuthen = false;
		String currentURI = httpRequest.getRequestURI();
		String contextPath = httpRequest.getServletContext().getContextPath();
		String currentPath = currentURI.substring(contextPath.length());
		for(SysMenuUrlVo sysMenuUrlVo :listSysMenuUrlVo){
			if (sysMenuUrlVo.getMenuUrl().equals(currentPath)) {
				haveAuthen = true;
				break;
			}
		}
		if (!haveAuthen) {
			httpResponse.sendRedirect("/share/resource/admin/main/login.jsp");
			return;
		}
		chain.doFilter(request, response);
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		
	}

}
