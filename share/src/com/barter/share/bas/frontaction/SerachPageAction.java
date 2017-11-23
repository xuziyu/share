package com.barter.share.bas.frontaction;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.List;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.barter.share.bas.entity.BasBrand;
import com.barter.share.bas.entity.BasCategorySmall;
import com.barter.share.bas.entity.BasProduct;
import com.barter.share.bas.service.IBasBrandService;
import com.barter.share.bas.service.IBasCategorySmallService;
import com.barter.share.bas.service.IBasProductService;
import com.barter.share.bas.service.imp.BasBrandService;
import com.barter.share.bas.service.imp.BasCategorySmallService;
import com.barter.share.bas.service.imp.BasProductService;
import com.barter.share.bas.vo.BasProductFrontVo;
import com.barter.share.bas.vo.FabricVo;
import com.barter.share.bas.vo.FashionElementVo;
import com.barter.share.bas.vo.GrossWeightVo;
import com.barter.share.bas.vo.PlaceVo;
import com.barter.share.bas.vo.StereotypeVo;
import com.barter.share.framework.dbutil.ServiceProxyFactory;
import com.barter.share.framework.entity.Page;
import com.barter.share.framework.util.StringUtil;
import com.barter.share.framework.web.BasAction;
import com.sun.xml.internal.bind.v2.model.core.ID;

/**
 * Servlet implementation class AdminAction
 */
public class SerachPageAction extends BasAction {
	private static final long serialVersionUID = 1L;
     
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SerachPageAction() {
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
		try {
			Page(request,response);
		} catch (NoSuchMethodException | SecurityException | IllegalAccessException | IllegalArgumentException
				| InvocationTargetException e) {
			e.printStackTrace();
		}
	}
	@SuppressWarnings("unused")
	private void Page(HttpServletRequest request, HttpServletResponse response) throws NoSuchMethodException, SecurityException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, ServletException, IOException {
		BasProductService basProductService = new BasProductService();
		IBasProductService iBasProductService = (IBasProductService)ServiceProxyFactory.getProxyInstance(basProductService);
		BasBrandService basBrandService = new BasBrandService();
		IBasBrandService iBasBrandService =(IBasBrandService)ServiceProxyFactory.getProxyInstance(basBrandService);
		BasCategorySmallService basCategorySmallService = new BasCategorySmallService();
		IBasCategorySmallService iBasCategorySmallService = (IBasCategorySmallService)ServiceProxyFactory.getProxyInstance(basCategorySmallService);
		
		String strPageIndex = request.getParameter("pageIndex");
		String strPageSize = request.getParameter("pageSize");
		int pageIndex = StringUtil.isEmpty(strPageIndex)?0:Integer.valueOf(strPageIndex);
		int pageSize = StringUtil.isEmpty(strPageSize)?42:Integer.valueOf(strPageSize);
		String orderBy = request.getParameter("orderBy");
		String brandId = request.getParameter("brandId");
		String categorySmallId = request.getParameter("categorySmallId");
		String name = request.getParameter("name");
		String productPlace = request.getParameter("productPlace");
		String marketSeason = request.getParameter("marketSeason");
		String fashionElement = request.getParameter("fashionElement");
		String fabric = request.getParameter("fabric");
		String stereotype = request.getParameter("stereotype");
		String grossWeight = request.getParameter("grossWeight");
		String priceMin = request.getParameter("priceMin");
		String priceMax = request.getParameter("priceMax");
		BasProductFrontVo basProductFrontVo = new BasProductFrontVo();
		basProductFrontVo.setBrandId(brandId);
		basProductFrontVo.setCategorySmallId(categorySmallId);
		basProductFrontVo.setName(name);
		basProductFrontVo.setProductPlace(productPlace);
		//上市季节
		basProductFrontVo.setMarketSeason(StringUtil.strToBigDecimal(marketSeason));
		//流行元素
		basProductFrontVo.setFashionElement(fashionElement);
		//流行面料
		basProductFrontVo.setFabric(fabric);
		//流行版型
		basProductFrontVo.setStereotype(stereotype);
		//毛重
		basProductFrontVo.setGrossWeight(StringUtil.strToBigDecimal(grossWeight));
		
		Page page = iBasProductService.frontPageList(pageIndex, pageSize,priceMin ,priceMax , orderBy, basProductFrontVo);
		request.setAttribute("page", page);
		List<BasBrand> listBasBrand =iBasBrandService.list();
		request.setAttribute("listBasBrand", listBasBrand);
		
		List<BasCategorySmall> listBasCategorySmall =iBasCategorySmallService.list();
		request.setAttribute("listBasCategorySmall", listBasCategorySmall);
		
		List<PlaceVo> listPlace = iBasProductService.place();
		request.setAttribute("listPlace", listPlace);
		
		List<FashionElementVo> listFashionElement = iBasProductService.fashionElement();
		request.setAttribute("listFashionElement", listFashionElement);
		
		List<FabricVo> listFabric = iBasProductService.fabric();
		request.setAttribute("listFabric", listFabric);
		
		List<StereotypeVo> listStereotype = iBasProductService.stereotype();
		request.setAttribute("listStereotype", listStereotype);
		
		List<GrossWeightVo> listGrossWeight = iBasProductService.grossWeight();
		request.setAttribute("listGrossWeight", listGrossWeight);
		
		request.getRequestDispatcher("/WEB-INF/jsp/front/search/search_page.jsp").forward(request, response);
	}
}
