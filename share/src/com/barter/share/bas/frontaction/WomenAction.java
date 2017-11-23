package com.barter.share.bas.frontaction;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.barter.share.bas.entity.BasBrand;
import com.barter.share.bas.entity.BasCategoryBig;
import com.barter.share.bas.entity.BasCategorySmall;
import com.barter.share.bas.entity.BasProductSku;
import com.barter.share.bas.service.IWomenService;
import com.barter.share.bas.service.imp.WomenService;
import com.barter.share.bas.vo.WomenVo;
import com.barter.share.framework.dbutil.ServiceProxyFactory;
import com.barter.share.framework.web.BasAction;

/**
 * Servlet implementation class WomenAction
 */
public class WomenAction extends BasAction {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public WomenAction() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		try {

				adBrand(request, response);
				
				
		} catch (Exception ex) {
			ex.printStackTrace();
			//转发到错误提示页
			request.setAttribute("exception", ex);
			request.getRequestDispatcher(ADDR_JSP_ERROR).forward(request, response);
		}
	}
	
		private void adBrand(HttpServletRequest request, HttpServletResponse response) throws NoSuchMethodException, SecurityException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, ServletException, IOException {
			WomenService womenService = new WomenService();
			IWomenService iWomenService =(IWomenService)ServiceProxyFactory.getProxyInstance(womenService);
			List<BasBrand> listAdBrand =iWomenService.adBrand();
			request.setAttribute("listAdBrand", listAdBrand);
			List<WomenVo> listAdProduct =iWomenService.adProduct();
			request.setAttribute("listAdProduct", listAdProduct);
			List<BasCategoryBig> listNavBig =iWomenService.navBig();
			request.setAttribute("listNavBig", listNavBig);	
			List<BasCategorySmall> listNavSmall =iWomenService.navSmall();
			request.setAttribute("listNavSmall", listNavSmall);
			
			
			request.getRequestDispatcher("/resource/front/font/women.jsp").forward(request, response);
		}
		
		

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
