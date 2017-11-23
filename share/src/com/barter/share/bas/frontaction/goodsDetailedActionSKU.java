package com.barter.share.bas.frontaction;

import java.io.IOException;
import java.math.BigDecimal;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.websocket.Session;

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
import com.barter.share.framework.dbutil.DbConnection;
import com.barter.share.framework.web.BasAction;

/**
 * Servlet implementation class AdminAction
 */
public class goodsDetailedActionSKU extends BasAction {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public goodsDetailedActionSKU() {
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
		
		System.out.println("颜色ID"+request.getParameter("productSkuId"));
		System.out.println("大小ID"+request.getParameter("SkuId"));
		System.out.println("产品ID"+request.getParameter("productId"));
		
		if(request.getSession().getAttribute("id")==null){
			request.getRequestDispatcher("/front/LoginfAction.action").forward(request, response);;
		}else{
		
		DbConnection connection=new DbConnection();
		PreparedStatement preparedStatement;
		StringBuffer sql = new StringBuffer("SELECT bas_product_sku.product_sku_id ");
		sql.append("FROM bas_product_sku ");
		sql.append("INNER JOIN bas_product ");
		sql.append("ON bas_product.product_id = bas_product_sku.product_id ");
		sql.append("INNER JOIN bas_sku_color ");
		sql.append("ON bas_sku_color.sku_color_id = bas_product_sku.sku_color_id ");
		sql.append("INNER JOIN bas_sku_size ");
		sql.append("ON bas_sku_size.sku_size_id = bas_product_sku.sku_size_id ");
		sql.append("WHERE 1 = 1 and bas_sku_color.sku_color_id = ");
		sql.append("'"+request.getParameter("productSkuId")+"'");
		sql.append(" and bas_sku_size.sku_size_id = ");
		sql.append("'"+request.getParameter("SkuId")+"'");
		sql.append(" and bas_product.product_id = ");
		sql.append("'"+request.getParameter("productId")+"'");
		String productID=null;
			try {
				preparedStatement=connection.getConnection().prepareStatement(sql.toString());
				System.out.println("准备执行where");
				System.out.println("准备过where");
				ResultSet resultSet=preparedStatement.executeQuery();
				while(resultSet.next()){
					productID=resultSet.getObject(1).toString();
				}
				resultSet.close();
				preparedStatement.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}finally {
			connection.close();
			}
		System.out.println("产品SKUid"+productID);
		request.setAttribute("productSkuId", productID);
		
		HttpSession session=request.getSession();
		session.setAttribute("productSkuId", productID);

		
		request.getRequestDispatcher("/front/CartfAction.action?method=save").forward(request, response);}
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
