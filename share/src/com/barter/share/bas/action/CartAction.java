package com.barter.share.bas.action;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.barter.share.bas.entity.BasCustomer;
import com.barter.share.bas.entity.BasProductSku;
import com.barter.share.bas.entity.CrtCart;
import com.barter.share.bas.service.IBasProductSkuService;
import com.barter.share.bas.service.ICrtCartService;
import com.barter.share.bas.service.ICrtCartVoService;
import com.barter.share.bas.service.ISerCustomer;
import com.barter.share.bas.service.imp.BasProductSkuService;
import com.barter.share.bas.service.imp.CrtCartService;
import com.barter.share.bas.service.imp.CrtCartVoService;
import com.barter.share.bas.service.imp.SerCustomer;
import com.barter.share.bas.vo.CrtCartVo;
import com.barter.share.framework.dbutil.ServiceProxyFactory;
import com.barter.share.framework.entity.Page;
import com.barter.share.framework.exception.BaseException;
import com.barter.share.framework.util.DateUtility;
import com.barter.share.framework.util.StringUtil;
import com.barter.share.framework.web.BasAction;

/**
 * Servlet implementation class CartAction
 */
public class CartAction extends BasAction {
	private static final long serialVersionUID = 1L;
	CrtCartService crtCartService = new CrtCartService();
	ICrtCartService iCrtCartService =(ICrtCartService)ServiceProxyFactory.getProxyInstance(crtCartService);
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CartAction() {
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
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charSet=UTF-8");
		response.setCharacterEncoding("utf-8");
		String method = request.getParameter(METHOD_NAME);
		if (METHOD_NAME_EDIT.equals(method)) {
			crtCartEdit(request,response);
		}else if (METHOD_NAME_SAVE.equals(method)) {
			crtCartSave(request,response);
		}else if (METHOD_NAME_DELETE.equals(method)) {
			crtCartDelete(request,response);
		}else {
			crtCartPageList(request,response);
		}
	}
	private void crtCartPageList(HttpServletRequest request, HttpServletResponse response) {
		CrtCartVoService crtCartVoService = new CrtCartVoService();
		ICrtCartVoService iCrtCartVoService = (ICrtCartVoService)ServiceProxyFactory.getProxyInstance(crtCartVoService);
		String strPageIndex =request.getParameter(PAGE_PARAM_PAGE_INDEX);
		String strPpageSize = request.getParameter(PAGE_PARAM_PAGE_SIZE);
		int pageIndex = StringUtil.isEmpty(strPageIndex)?0:Integer.parseInt(strPageIndex);
		int pageSize = StringUtil.isEmpty(strPpageSize)?5:Integer.parseInt(strPpageSize);
		String customerId = request.getParameter("customerId");
		String productSkuId = request.getParameter("productSkuId");
		String createDate = request.getParameter("createDate");
		Page page = new Page();
		CrtCartVo crtCartVo = new CrtCartVo();
		crtCartVo.setCustomerId(customerId);
		crtCartVo.setProductSkuId(productSkuId);
		crtCartVo.setCreateDate(DateUtility.getDate(createDate));
		try {
			page = iCrtCartVoService.pageList(pageIndex, pageSize, crtCartVo);
			request.setAttribute("page", page);
			request.getRequestDispatcher("/WEB-INF/jsp/admin/bas/cart/crt_cart.jsp").forward(request, response);
		} catch (Exception e) {
			e.printStackTrace();
			throw new BaseException("异常："+e.getMessage());
		}
	}
	private void crtCartDelete(HttpServletRequest request, HttpServletResponse response) {
		String cartId = request.getParameter("id");
		iCrtCartService.delete(cartId);
		try {
			response.sendRedirect("/share/admin/CartAction.action");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	private void crtCartSave(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String cartId = request.getParameter("id");
		String customerId = request.getParameter("customerId");
		String productSkuId = request.getParameter("productSkuId");
		String createDate = request.getParameter("createDate");
		CrtCart crtCart =new CrtCart();
		crtCart.setCustomerId(customerId);
		crtCart.setProductSkuId(productSkuId);
		crtCart.setCreateDate(DateUtility.getDate(createDate));
		if (StringUtil.isEmpty(cartId)) {
			cartId = StringUtil.generateUUID();
			crtCart.setCartId(cartId);
			try {
//				iCrtCartService.codeCheck(crtCart);
				iCrtCartService.insert(crtCart);
				response.sendRedirect("/share/admin/CartAction.action");
			} catch (Exception e) {
				e.printStackTrace();
			}
		} else {
			crtCart.setCartId(cartId);
			try {
//				iCrtCartService.codeCheck(crtCart);
				iCrtCartService.update(crtCart);
				response.sendRedirect("/share/admin/CartAction.action");
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
	private void crtCartEdit(HttpServletRequest request, HttpServletResponse response) {
		SerCustomer serCustomer = new SerCustomer();
		BasProductSkuService basProductSkuService = new BasProductSkuService();
		IBasProductSkuService iBasProductSkuService = (IBasProductSkuService)ServiceProxyFactory.getProxyInstance(basProductSkuService);
		ISerCustomer iSerCustomer = (ISerCustomer)ServiceProxyFactory.getProxyInstance(serCustomer);
		List<BasCustomer> listBasCustomer = iSerCustomer.list();
		List<BasProductSku> listBasProductSku = iBasProductSkuService.list();
		request.setAttribute("listBasCustomer", listBasCustomer);
		request.setAttribute("listBasProductSku", listBasProductSku);
		String cartId = request.getParameter("id");
		if (StringUtil.isEmpty(cartId)) {
			try {
				request.getRequestDispatcher("/WEB-INF/jsp/admin/bas/cart/crt_cart_edit.jsp").forward(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}else {
			List<CrtCart> list = iCrtCartService.load(cartId);
			CrtCart crtCart = list.get(0);
			request.setAttribute("id", "&id="+cartId);
			request.setAttribute("crtCart", crtCart);
			try {
				request.getRequestDispatcher("/WEB-INF/jsp/admin/bas/cart/crt_cart_edit.jsp").forward(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
}
