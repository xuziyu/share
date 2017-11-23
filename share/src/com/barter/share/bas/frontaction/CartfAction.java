package com.barter.share.bas.frontaction;

import java.io.IOException;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.barter.share.bas.service.ICrtCartFrontService;
import com.barter.share.bas.service.imp.CrtCartFrontService;
import com.barter.share.bas.vo.CartVo;
import com.barter.share.framework.dbutil.ServiceProxyFactory;
import com.barter.share.framework.util.DateUtility;
import com.barter.share.framework.util.StringUtil;
import com.barter.share.framework.web.BasAction;

/**
 * Servlet implementation class CartAction
 */
public class CartfAction extends BasAction {
	private static final long serialVersionUID = 1L;
	CrtCartFrontService crtCartFrontService = new CrtCartFrontService();
	ICrtCartFrontService iCrtCartFrontService = (ICrtCartFrontService)ServiceProxyFactory.getProxyInstance(crtCartFrontService);   
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CartfAction() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String method=request.getParameter(METHOD_NAME);
		if(METHOD_NAME_SAVE.equals(method)){
			save(request, response);
		}else if ("delete".equals(method)) {
			deleteCart(request , response);
		}else if ("insert".equals(method)) {
			insert(request,response);
		}else{
			open(request, response);
		}
		request.setCharacterEncoding("utf-8");//设置请求编码
		response.setContentType("text/html; charset=UTF-8");//设置响应的html编码
		response.setCharacterEncoding("utf-8");
		
		
	}

	private void insert(HttpServletRequest request, HttpServletResponse response) throws IOException {
		/**
		 * 
		 */
		String cartId = StringUtil.generateUUID();
		String id = (String)request.getSession().getAttribute("id");
		String productSkuId = request.getParameter("productSkuId");
		Date date = new Date();
		String strDate = DateUtility.dateToString(date);
		iCrtCartFrontService.insert(cartId, id, productSkuId ,strDate);
		response.sendRedirect("/share/front/CartfAction.action");
		/**
		 * 
		 */
	}

	private void deleteCart(HttpServletRequest request, HttpServletResponse response) throws IOException {
		String cartId = request.getParameter("cartId");
		iCrtCartFrontService.delete(cartId);
		response.sendRedirect("/share/front/CartfAction.action");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
		request.setCharacterEncoding("utf-8");//设置请求编码
		response.setContentType("text/html; charset=UTF-8");//设置响应的html编码
		response.setCharacterEncoding("utf-8");	
		
		
	}
	
	private  void save(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String value = "1";
		String productSkuId = request.getParameter("ddd");
		request.setAttribute("productSkuId", productSkuId);
		request.getSession().setAttribute("productSkuId", productSkuId);
		request.setAttribute("value", value);
		request.getRequestDispatcher("/SalOrderAction.Action?method=gopay").forward(request, response);
	}
	private  void open(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	   String id = (String)request.getSession().getAttribute("id");
		if (StringUtil.isEmpty(id)) {
			response.sendRedirect("/share/front/LoginfAction.action");
			return;
		}
		List<CartVo> listCartVo = iCrtCartFrontService.pageList(id);
		request.setAttribute("listCartVo", listCartVo);
		request.getRequestDispatcher("/WEB-INF/jsp/front/cart/cart.jsp").forward(request, response);
	} 
}
