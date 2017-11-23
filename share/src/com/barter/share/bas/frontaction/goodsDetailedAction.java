package com.barter.share.bas.frontaction;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.barter.share.bas.dao.IBasProductSkuVoDao2;
import com.barter.share.bas.dao.ISalOrderDetailReviewDaoFront;
import com.barter.share.bas.dao.imp.BasProductSkuVoDao2;
import com.barter.share.bas.dao.imp.SalOrderDetailReviewDaoFront;
import com.barter.share.bas.entity.SalOrderDetailReview;
import com.barter.share.bas.service.IBasProductVoService;
import com.barter.share.bas.service.IBasProductVoService2;
import com.barter.share.bas.service.imp.BasProductVoService;
import com.barter.share.bas.service.imp.BasProductVoService2;
import com.barter.share.bas.vo.BasProductSkuVo;
import com.barter.share.bas.vo.BasProductVo;
import com.barter.share.framework.web.BasAction;

/**
 * Servlet implementation class AdminAction
 */
public class goodsDetailedAction extends BasAction {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public goodsDetailedAction() {
        super();
        // TODO Auto-generated constructor stub
    } 

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charSet=utf-8");
		response.setCharacterEncoding("utf-8");
		
		HttpSession session=request.getSession();
		
		IBasProductSkuVoDao2 productSku=new BasProductSkuVoDao2();
		List<BasProductSkuVo> productSkuList =productSku.load(request.getParameter("productId"));
		

		
		IBasProductSkuVoDao2 productSkucolor=new BasProductSkuVoDao2();
		List<BasProductSkuVo> productSkucolorList =productSkucolor.color(request.getParameter("productId"));
		
		IBasProductSkuVoDao2 productSkusize=new BasProductSkuVoDao2();
		List<BasProductSkuVo> productSkusizeList =productSkusize.size(request.getParameter("productId"));
		
		IBasProductVoService2 product=new BasProductVoService2();
		BasProductVo productList=product.load(request.getParameter("productId"));
		
		session.setAttribute("s_ProductVoList", productList);
		session.setAttribute("s_ProductSkuVoList", productSkuList);
		session.setAttribute("s_ProductSkuVosize", productSkusizeList);
		session.setAttribute("s_ProductSkuVocolor", productSkucolorList);
		
		
		ISalOrderDetailReviewDaoFront orderReview=new SalOrderDetailReviewDaoFront();
		List<SalOrderDetailReview> orderReviewList=new ArrayList<SalOrderDetailReview>();
		for(BasProductSkuVo result2:productSkuList) {
			System.out.println("得到成品的ID"+result2.getProductSkuId());
			List<SalOrderDetailReview> list=orderReview.load(result2.getProductSkuId());
			for(SalOrderDetailReview relist:list){ 
				orderReviewList.add(relist);			
			}
			
		}session.setAttribute("s_SalOrderDetailReviewList", orderReviewList);
		
		
		System.out.println("loadguo le");
		request.getRequestDispatcher("/WEB-INF/jsp/front/product_detail/product_detail.jsp").forward(request, response);
	}

	
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
	
	protected void adminQueryList(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		IBasProductVoService basproduct=new BasProductVoService();
		List<BasProductVo> a =basproduct.load(request.getParameter("productId"));

		request.setAttribute("page", null);
		request.getRequestDispatcher("/WEB-INF/jsp/admin/bas/Sysemployee/AdminManege.jsp").forward(request, response);
		
	}
}
