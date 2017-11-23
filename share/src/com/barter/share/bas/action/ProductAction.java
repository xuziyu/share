package com.barter.share.bas.action;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.barter.share.bas.entity.BasBrand;
import com.barter.share.bas.entity.BasCategoryBig;
import com.barter.share.bas.entity.BasCategorySmall;
import com.barter.share.bas.entity.BasFileUpload;
import com.barter.share.bas.entity.BasProduct;
import com.barter.share.bas.entity.BasProductSku;
import com.barter.share.bas.entity.BasSkuColor;
import com.barter.share.bas.entity.BasSkuSize;
import com.barter.share.bas.service.IBasBrandService;
import com.barter.share.bas.service.IBasCategoryBigService;
import com.barter.share.bas.service.IBasCategorySmallService;
import com.barter.share.bas.service.IBasCategorySmallVoService;
import com.barter.share.bas.service.IBasFileUploadService;
import com.barter.share.bas.service.IBasProductService;
import com.barter.share.bas.service.IBasProductSkuService;
import com.barter.share.bas.service.IBasProductSkuVoService;
import com.barter.share.bas.service.IBasProductVoService;
import com.barter.share.bas.service.IBasSkuColorService;
import com.barter.share.bas.service.IBasSkuSizeService;
import com.barter.share.bas.service.imp.BasBrandService;
import com.barter.share.bas.service.imp.BasCategoryBigService;
import com.barter.share.bas.service.imp.BasCategorySmallService;
import com.barter.share.bas.service.imp.BasCategorySmallVoService;
import com.barter.share.bas.service.imp.BasFileUploadService;
import com.barter.share.bas.service.imp.BasProductService;
import com.barter.share.bas.service.imp.BasProductSkuService;
import com.barter.share.bas.service.imp.BasProductSkuVoService;
import com.barter.share.bas.service.imp.BasProductVoService;
import com.barter.share.bas.service.imp.BasSkuColorService;
import com.barter.share.bas.service.imp.BasSkuSizeService;
import com.barter.share.bas.vo.BasCategorySmallVo;
import com.barter.share.bas.vo.BasProductSkuVo;
import com.barter.share.bas.vo.BasProductVo;
import com.barter.share.framework.dbutil.ServiceProxyFactory;
import com.barter.share.framework.entity.Page;
import com.barter.share.framework.exception.BaseException;
import com.barter.share.framework.util.StringUtil;
import com.barter.share.framework.web.BasAction;

/**
 * Servlet implementation class ProductAction
 */
public class ProductAction extends BasAction {
	private static final String PAGE_NAME="pageName";
	private static final String PAGE_NAME_BRAND="brand";
	private static final String PAGE_NAME_CATEPORYBIG="categoryBig";
	private static final String PAGE_NAME_CATEPORYSMALL="categorySmall";
	private static final String PAGE_NAME_PRODUCT="product";
	private static final String PAGE_NAME_PRODUCTSKU="productSKU";
	private static final long serialVersionUID = 1L;
	BasBrandService basBrandService = new BasBrandService();
	IBasBrandService iBasBrandService = (IBasBrandService)ServiceProxyFactory.getProxyInstance(basBrandService);
	BasCategorySmallService basCategorySmallService = new BasCategorySmallService();
	IBasCategorySmallService iBasCategorySmallService = (IBasCategorySmallService)ServiceProxyFactory.getProxyInstance(basCategorySmallService);
	BasCategoryBigService basCategoryBigService = new BasCategoryBigService();
	IBasCategoryBigService iBasCategoryBigService = (IBasCategoryBigService)ServiceProxyFactory.getProxyInstance(basCategoryBigService);
	BasProductSkuService basProductSkuService = new BasProductSkuService();
	IBasProductSkuService iBasProductSkuService = (IBasProductSkuService)ServiceProxyFactory.getProxyInstance(basProductSkuService);
	BasProductService basProductService = new BasProductService();
	IBasProductService iBasProductService = (IBasProductService)ServiceProxyFactory.getProxyInstance(basProductService);
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ProductAction() {
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
		String pageName = request.getParameter(PAGE_NAME);
		if (PAGE_NAME_PRODUCT.equals(pageName)) {
			product(request,response);
		}else if (PAGE_NAME_PRODUCTSKU.equals(pageName)) {
			productSKU(request,response);
		}else if (PAGE_NAME_CATEPORYBIG.equals(pageName)) {
			categoryBig(request,response);
		}else if (PAGE_NAME_CATEPORYSMALL.equals(pageName)) {
			categorySmall(request,response);
		}else if (PAGE_NAME_BRAND.equals(pageName)) {
			brand(request,response);
		}
	}
	/**
	 * 商品品牌界面
	 * @param request
	 * @param response
	 * @throws IOException 
	 * @throws ServletException 
	 */
	private void brand(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String method = request.getParameter(METHOD_NAME);
		if (METHOD_NAME_EDIT.equals(method)) {
			brandEdit(request,response);
		}else if (METHOD_NAME_SAVE.equals(method)) {
			brandSave(request,response);
		}else if (METHOD_NAME_DELETE.equals(method)) {
			brandDelete(request,response);
		}else {
			brandPageList(request,response);
		}
	}
	private void brandPageList(HttpServletRequest request, HttpServletResponse response) {
		String strPageIndex =request.getParameter(PAGE_PARAM_PAGE_INDEX);
		String strPpageSize = request.getParameter(PAGE_PARAM_PAGE_SIZE);
		int pageIndex = StringUtil.isEmpty(strPageIndex)?0:Integer.parseInt(strPageIndex);
		int pageSize = StringUtil.isEmpty(strPpageSize)?100:Integer.parseInt(strPpageSize);
		String code = request.getParameter("code");
		String name = request.getParameter("name");
		String slogan = request.getParameter("slogan");
		request.setAttribute("code", code);
		request.setAttribute("name", name);
		Page page = new Page();
		BasBrand basBrand = new BasBrand();
		
		basBrand.setCode(code);
		basBrand.setName(name);
		basBrand.setSlogan(slogan);
		try {
			page = iBasBrandService.pageList(pageIndex, pageSize, basBrand);
			request.setAttribute("page", page);
			request.getRequestDispatcher("/WEB-INF/jsp/admin/bas/product/product_brand.jsp").forward(request, response);
		} catch (Exception e) {
			e.printStackTrace();
			throw new BaseException("异常："+e.getMessage());
		}
	}

	private void brandDelete(HttpServletRequest request, HttpServletResponse response) {
		String brandId = request.getParameter("id");
		iBasBrandService.delete(brandId);
		try {
			response.sendRedirect("/share/admin/ProductAction.action?pageName=brand");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private void brandSave(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String brandId = request.getParameter("id");
		String code = request.getParameter("code");
		String name = request.getParameter("name");
		String slogan = request.getParameter("slogan");
		BasBrand basBrand =new BasBrand();
		basBrand.setCode(code);
		basBrand.setName(name);
		basBrand.setSlogan(slogan);
		if (StringUtil.isEmpty(brandId)) {
			brandId = StringUtil.generateUUID();
			basBrand.setBrandId(brandId);
			try {
				iBasBrandService.codeCheck(basBrand);
				iBasBrandService.insert(basBrand);
				response.sendRedirect("/share/admin/ProductAction.action?pageName=brand");
			} catch (Exception e) {
				e.printStackTrace();
				request.setAttribute("exception", e);
				request.getRequestDispatcher("/WEB-INF/jsp/admin/common/error.jsp").forward(request, response);
			}
		} else {
			basBrand.setBrandId(brandId);
			try {
//				iBasBrandService.codeCheck(basBrand);
				iBasBrandService.update(basBrand);
				response.sendRedirect("/share/admin/ProductAction.action?pageName=brand");
			} catch (Exception e) {
				e.printStackTrace();
				request.setAttribute("exception", e);
				request.getRequestDispatcher("/WEB-INF/jsp/admin/common/error.jsp").forward(request, response);
			}
		}
	}

	private void brandEdit(HttpServletRequest request, HttpServletResponse response) {
		String brandId = request.getParameter("id");
		if (StringUtil.isEmpty(brandId)) {
			try {
				request.getRequestDispatcher("/WEB-INF/jsp/admin/bas/product/product_brand_edit.jsp").forward(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}else {
			List<BasBrand> list = iBasBrandService.load(brandId);
			BasBrand basBrand = list.get(0);
			request.setAttribute("id", "&id="+brandId);
			request.setAttribute("basBrand", basBrand);
			try {
				request.getRequestDispatcher("/WEB-INF/jsp/admin/bas/product/product_brand_edit.jsp").forward(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	/**
	 * 商品小类
	 * @param request
	 * @param response
	 * @throws IOException 
	 * @throws ServletException 
	 */
	private void categorySmall(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String method = request.getParameter(METHOD_NAME);
		if (METHOD_NAME_EDIT.equals(method)) {
			categorySmallEdit(request,response);
		}else if (METHOD_NAME_SAVE.equals(method)) {
			categorySmallSave(request,response);
		}else if (METHOD_NAME_DELETE.equals(method)) {
			categorySmallDelete(request,response);
		}else {
			categorySmallPageList(request,response);
		}
	}
	private void categorySmallPageList(HttpServletRequest request, HttpServletResponse response) {
		BasCategorySmallVoService basCategorySmallVoService = new BasCategorySmallVoService();
		IBasCategorySmallVoService iBasCategorySmallVoService = (IBasCategorySmallVoService)ServiceProxyFactory.getProxyInstance(basCategorySmallVoService);
		String strPageIndex =request.getParameter(PAGE_PARAM_PAGE_INDEX);
		String strPpageSize = request.getParameter(PAGE_PARAM_PAGE_SIZE);
		int pageIndex = StringUtil.isEmpty(strPageIndex)?0:Integer.parseInt(strPageIndex);
		int pageSize = StringUtil.isEmpty(strPpageSize)?100:Integer.parseInt(strPpageSize);
		String categoryBigId = request.getParameter("categoryBigId");
		String name = request.getParameter("name");
		String descr = request.getParameter("descr");
		Page page = new Page();
		BasCategorySmallVo basCategorySmallVo = new BasCategorySmallVo();
		basCategorySmallVo.setCategoryBigId(categoryBigId);
		basCategorySmallVo.setName(name);
		basCategorySmallVo.setDescr(descr);
		try {
			page = iBasCategorySmallVoService.pageList(pageIndex, pageSize, basCategorySmallVo);
			request.setAttribute("page", page);
			request.getRequestDispatcher("/WEB-INF/jsp/admin/bas/product/product_category_small.jsp").forward(request, response);
		} catch (Exception e) {
			e.printStackTrace();
			throw new BaseException("异常："+e.getMessage());
		}
	}

	private void categorySmallDelete(HttpServletRequest request, HttpServletResponse response) {
		String categorySmallId = request.getParameter("id");
		iBasCategorySmallService.delete(categorySmallId);
		try {
			response.sendRedirect("/share/admin/ProductAction.action?pageName=categorySmall");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private void categorySmallSave(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String categorySmallId = request.getParameter("id");
		String categoryBigId = request.getParameter("categoryBigId");
		String name = request.getParameter("name");
		String descr = request.getParameter("descr");
		BasCategorySmall basCategorySmall = new BasCategorySmall();
		basCategorySmall.setCategoryBigId(categoryBigId);
		basCategorySmall.setName(name);
		basCategorySmall.setDescr(descr);
		if (StringUtil.isEmpty(categorySmallId)) {
			categorySmallId = StringUtil.generateUUID();
			basCategorySmall.setCategorySmallId(categorySmallId);
			try {
				iBasCategorySmallService.codeCheck(basCategorySmall);
				iBasCategorySmallService.insert(basCategorySmall);
				response.sendRedirect("/share/admin/ProductAction.action?pageName=categorySmall");
			} catch (Exception e) {
				e.printStackTrace();
				request.setAttribute("exception", e);
				request.getRequestDispatcher("/WEB-INF/jsp/admin/common/error.jsp").forward(request, response);
			}
		} else {
			basCategorySmall.setCategorySmallId(categorySmallId);
			try {
//				iBasCategorySmallService.codeCheck(basCategorySmall);
				iBasCategorySmallService.update(basCategorySmall);
				response.sendRedirect("/share/admin/ProductAction.action?pageName=categorySmall");
			} catch (Exception e) {
				e.printStackTrace();
				request.setAttribute("exception", e);
				request.getRequestDispatcher("/WEB-INF/jsp/admin/common/error.jsp").forward(request, response);
			}
		}
	}

	private void categorySmallEdit(HttpServletRequest request, HttpServletResponse response) {
		String categorySmallId = request.getParameter("id");
		List<BasCategoryBig> listBasCategoryBig = iBasCategoryBigService.list();
		request.setAttribute("listBasCategoryBig", listBasCategoryBig);
		if (StringUtil.isEmpty(categorySmallId)) {
			try {
				request.getRequestDispatcher("/WEB-INF/jsp/admin/bas/product/product_category_small_edit.jsp").forward(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}else {
			List<BasCategorySmall> list = iBasCategorySmallService.load(categorySmallId);
			BasCategorySmall basCategorySmall = list.get(0);
			request.setAttribute("id", "&id="+categorySmallId);
			request.setAttribute("basCategorySmall", basCategorySmall);
			try {
				request.getRequestDispatcher("/WEB-INF/jsp/admin/bas/product/product_category_small_edit.jsp").forward(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	/**
	 * 商品大类
	 * @param request
	 * @param response
	 * @throws IOException 
	 * @throws ServletException 
	 */
	private void categoryBig(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String method = request.getParameter(METHOD_NAME);
		if (METHOD_NAME_EDIT.equals(method)) {
			categoryBigEdit(request,response);
		}else if (METHOD_NAME_SAVE.equals(method)) {
			categoryBigSave(request,response);
		}else if (METHOD_NAME_DELETE.equals(method)) {
			categoryBigDelete(request,response);
		}else {
			categoryBigPageList(request,response);
		}
	}
	private void categoryBigPageList(HttpServletRequest request, HttpServletResponse response) {
		String strPageIndex =request.getParameter(PAGE_PARAM_PAGE_INDEX);
		String strPpageSize = request.getParameter(PAGE_PARAM_PAGE_SIZE);
		int pageIndex = StringUtil.isEmpty(strPageIndex)?0:Integer.parseInt(strPageIndex);
		int pageSize = StringUtil.isEmpty(strPpageSize)?5:Integer.parseInt(strPpageSize);
		String name = request.getParameter("name");
		String descr = request.getParameter("descr");
		Page page = new Page();
		BasCategoryBig basCategoryBig = new BasCategoryBig();
		basCategoryBig.setName(name);
		basCategoryBig.setDescr(descr);
		try {
			page = iBasCategoryBigService.pageList(pageIndex, pageSize, basCategoryBig);
			request.setAttribute("page", page);
			request.getRequestDispatcher("/WEB-INF/jsp/admin/bas/product/product_category_big.jsp").forward(request, response);
		} catch (Exception e) {
			e.printStackTrace();
			throw new BaseException("异常："+e.getMessage());
		}
	}

	private void categoryBigDelete(HttpServletRequest request, HttpServletResponse response) {
		String categoryBigId = request.getParameter("id");
		iBasCategoryBigService.delete(categoryBigId);
		try {
			response.sendRedirect("/share/admin/ProductAction.action?pageName=categoryBig");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private void categoryBigSave(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String categoryBigId = request.getParameter("id");
		String name = request.getParameter("name");
		String descr = request.getParameter("descr");
		BasCategoryBig basCategoryBig = new BasCategoryBig();
		basCategoryBig.setName(name);
		basCategoryBig.setDescr(descr);
		if (StringUtil.isEmpty(categoryBigId)) {
			categoryBigId = StringUtil.generateUUID();
			basCategoryBig.setCategoryBigId(categoryBigId);
			try {
				iBasCategoryBigService.codeCheck(basCategoryBig);
				iBasCategoryBigService.insert(basCategoryBig);
				response.sendRedirect("/share/admin/ProductAction.action?pageName=categoryBig");
			} catch (Exception e) {
				e.printStackTrace();
				request.setAttribute("exception", e);
				request.getRequestDispatcher("/WEB-INF/jsp/admin/common/error.jsp").forward(request, response);
			}
		} else {
			basCategoryBig.setCategoryBigId(categoryBigId);
			try {
//				iBasCategoryBigService.codeCheck(basCategoryBig);
				iBasCategoryBigService.update(basCategoryBig);
				response.sendRedirect("/share/admin/ProductAction.action?pageName=categoryBig");
			} catch (Exception e) {
				e.printStackTrace();
				request.setAttribute("exception", e);
				request.getRequestDispatcher("/WEB-INF/jsp/admin/common/error.jsp").forward(request, response);
			}
		}
	}

	private void categoryBigEdit(HttpServletRequest request, HttpServletResponse response) {
		String categoryBigId = request.getParameter("id");
		if (StringUtil.isEmpty(categoryBigId)) {
			try {
				request.getRequestDispatcher("/WEB-INF/jsp/admin/bas/product/product_category_big_edit.jsp").forward(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}else {
			List<BasCategoryBig> list = iBasCategoryBigService.load(categoryBigId);
			BasCategoryBig basCategoryBig = list.get(0);
			request.setAttribute("id", "&id="+categoryBigId);
			request.setAttribute("basCategoryBig", basCategoryBig);
			try {
				request.getRequestDispatcher("/WEB-INF/jsp/admin/bas/product/product_category_big_edit.jsp").forward(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	/**
	 * 商品sku库存
	 * @param request
	 * @param response
	 * @throws IOException 
	 * @throws ServletException 
	 */
	private void productSKU(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String method = request.getParameter(METHOD_NAME);
		if (METHOD_NAME_EDIT.equals(method)) {
			productSKUEdit(request,response);
		}else if (METHOD_NAME_SAVE.equals(method)) {
			productSKUSave(request,response);
		}else if (METHOD_NAME_DELETE.equals(method)) {
			productSKUDelete(request,response);
		}else {
			productSKUPageList(request,response);
		}
	}
	private void productSKUPageList(HttpServletRequest request, HttpServletResponse response) {
		BasProductSkuVoService basProductSkuVoService = new BasProductSkuVoService();
		IBasProductSkuVoService iBasProductSkuVoService =(IBasProductSkuVoService)ServiceProxyFactory.getProxyInstance(basProductSkuVoService);
		String strPageIndex =request.getParameter(PAGE_PARAM_PAGE_INDEX);
		String strPpageSize = request.getParameter(PAGE_PARAM_PAGE_SIZE);
		int pageIndex = StringUtil.isEmpty(strPageIndex)?0:Integer.parseInt(strPageIndex);
		int pageSize = StringUtil.isEmpty(strPpageSize)?100:Integer.parseInt(strPpageSize);
		String productId = request.getParameter("productId");
		String skuColorId = request.getParameter("skuColorId");
		String skuSizeId = request.getParameter("skuSizeId");
		String barCode = request.getParameter("barCode");
		String priceReal = request.getParameter("priceReal");
		String priceOld = request.getParameter("priceOld");
		String priceCost = request.getParameter("priceCost");
		String pricePlanPurchase = request.getParameter("pricePlanPurchase");
		String amountStock = request.getParameter("amountStock");
		String amountInit = request.getParameter("amountInit");
		String amountMinStock = request.getParameter("amountMinStock");
		String amountMaxStock = request.getParameter("amountMaxStock");
		String picOriFileId = request.getParameter("picOriFileId");
		String picBigFileId = request.getParameter("picBigFileId");
		String picMiddleFileId = request.getParameter("picMiddleFileId");
		String picSmallFileId = request.getParameter("picSmallFileId");
		String productDefaultType = request.getParameter("productDefaultType");
		Page page = new Page();
		BasProductSkuVo basProductSkuVo = new BasProductSkuVo();
		basProductSkuVo.setProductId(productId);
		basProductSkuVo.setSkuColorId(skuColorId);
		basProductSkuVo.setSkuSizeId(skuSizeId);
		basProductSkuVo.setBarCode(barCode);
		basProductSkuVo.setPriceReal(StringUtil.strToBigDecimal(priceReal));
		basProductSkuVo.setPriceOld(StringUtil.strToBigDecimal(priceOld));
		basProductSkuVo.setPriceCost(StringUtil.strToBigDecimal(priceCost));
		basProductSkuVo.setPricePlanPurchase(StringUtil.strToBigDecimal(pricePlanPurchase));
		basProductSkuVo.setAmountStock(StringUtil.strToBigDecimal(amountStock));
		basProductSkuVo.setAmountInit(StringUtil.strToBigDecimal(amountInit));
		basProductSkuVo.setAmountMinStock(StringUtil.strToBigDecimal(amountMinStock));
		basProductSkuVo.setAmountMaxStock(StringUtil.strToBigDecimal(amountMaxStock));
		basProductSkuVo.setPicOriFileId(picOriFileId);
		basProductSkuVo.setPicBigFileId(picBigFileId);
		basProductSkuVo.setPicMiddleFileId(picMiddleFileId);
		basProductSkuVo.setPicSmallFileId(picSmallFileId);
		basProductSkuVo.setProductDefaultType(StringUtil.strToBigDecimal(productDefaultType));
		try {
			page = iBasProductSkuVoService.pageList(pageIndex, pageSize, basProductSkuVo);
			request.setAttribute("page", page);
			request.getRequestDispatcher("/WEB-INF/jsp/admin/bas/product/product_sku.jsp").forward(request, response);
		} catch (Exception e) {
			e.printStackTrace();
			throw new BaseException("异常："+e.getMessage());
		}
	}

	private void productSKUDelete(HttpServletRequest request, HttpServletResponse response) {
		String productSkuId = request.getParameter("id");
		iBasProductSkuService.delete(productSkuId);
		try {
			response.sendRedirect("/share/admin/ProductAction.action?pageName=productSKU");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private void productSKUSave(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String productSkuId = request.getParameter("id");
		String productId = request.getParameter("productId");
		String skuColorId = request.getParameter("skuColorId");
		String skuSizeId = request.getParameter("skuSizeId");
		String barCode = request.getParameter("barCode");
		String priceReal = request.getParameter("priceReal");
		String priceOld = request.getParameter("priceOld");
		String priceCost = request.getParameter("priceCost");
		String pricePlanPurchase = request.getParameter("pricePlanPurchase");
		String amountStock = request.getParameter("amountStock");
		String amountInit = request.getParameter("amountInit");
		String amountMinStock = request.getParameter("amountMinStock");
		String amountMaxStock = request.getParameter("amountMaxStock");
		String picOriFileId = request.getParameter("picOriFileId");
		String picBigFileId = request.getParameter("picBigFileId");
		String picMiddleFileId = request.getParameter("picMiddleFileId");
		String picSmallFileId = request.getParameter("picSmallFileId");
		String productDefaultType = request.getParameter("productDefaultType");
		BasProductSku basProductSku = new BasProductSku();
		basProductSku.setProductId(productId);
		basProductSku.setSkuColorId(skuColorId);
		basProductSku.setSkuSizeId(skuSizeId);
		basProductSku.setBarCode(barCode);
		basProductSku.setPriceReal(StringUtil.strToBigDecimal(priceReal));
		basProductSku.setPriceOld(StringUtil.strToBigDecimal(priceOld));
		basProductSku.setPriceCost(StringUtil.strToBigDecimal(priceCost));
		basProductSku.setPricePlanPurchase(StringUtil.strToBigDecimal(pricePlanPurchase));
		basProductSku.setAmountStock(StringUtil.strToBigDecimal(amountStock));
		basProductSku.setAmountInit(StringUtil.strToBigDecimal(amountInit));
		basProductSku.setAmountMinStock(StringUtil.strToBigDecimal(amountMinStock));
		basProductSku.setAmountMaxStock(StringUtil.strToBigDecimal(amountMaxStock));
		basProductSku.setPicOriFileId(picOriFileId);
		basProductSku.setPicBigFileId(picBigFileId);
		basProductSku.setPicMiddleFileId(picMiddleFileId);
		basProductSku.setPicSmallFileId(picSmallFileId);
		basProductSku.setProductDefaultType(StringUtil.strToBigDecimal(productDefaultType));
		if (StringUtil.isEmpty(productSkuId)) {
			productSkuId = StringUtil.generateUUID();
			basProductSku.setProductSkuId(productSkuId);
			try {
				iBasProductSkuService.codeCheck(basProductSku);
				iBasProductSkuService.insert(basProductSku);
				response.sendRedirect("/share/admin/ProductAction.action?pageName=productSKU");
			} catch (Exception e) {
				e.printStackTrace();
				request.setAttribute("exception", e);
				request.getRequestDispatcher("/WEB-INF/jsp/admin/common/error.jsp").forward(request, response);
			}
		} else {
			basProductSku.setProductSkuId(productSkuId);
			try {
//				iBasProductSkuService.codeCheck(basProductSku);
				iBasProductSkuService.update(basProductSku);
				response.sendRedirect("/share/admin/ProductAction.action?pageName=productSKU");
			} catch (Exception e) {
				e.printStackTrace();
				request.setAttribute("exception", e);
				request.getRequestDispatcher("/WEB-INF/jsp/admin/common/error.jsp").forward(request, response);
			}
		}
	}

	private void productSKUEdit(HttpServletRequest request, HttpServletResponse response) {
		BasSkuColorService basSkuColorService = new BasSkuColorService();
		BasSkuSizeService basSkuSizeService = new BasSkuSizeService();
		IBasSkuColorService iBasSkuColorService = (IBasSkuColorService)ServiceProxyFactory.getProxyInstance(basSkuColorService);
		IBasSkuSizeService iBasSkuSizeService = (IBasSkuSizeService)ServiceProxyFactory.getProxyInstance(basSkuSizeService);
		List<BasProduct> listBasProduct = iBasProductService.list();
		List<BasSkuColor> listBasSkuColor = iBasSkuColorService.list();
		List<BasSkuSize> listBasSkuSize = iBasSkuSizeService.list();
		request.setAttribute("listBasProduct", listBasProduct);
		request.setAttribute("listBasSkuColor", listBasSkuColor);
		request.setAttribute("listBasSkuSize", listBasSkuSize);
		BasFileUploadService basFileUploadService = new BasFileUploadService();
		IBasFileUploadService iBasFileUploadService = (IBasFileUploadService)ServiceProxyFactory.getProxyInstance(basFileUploadService);
		List<BasFileUpload> listOri = iBasFileUploadService.loadOri();
		List<BasFileUpload> listBig = iBasFileUploadService.loadBig();
		List<BasFileUpload> listMid = iBasFileUploadService.loadMid();
		List<BasFileUpload> listSmall =iBasFileUploadService.loadSmall(); 
		request.setAttribute("listOri", listOri);
		request.setAttribute("listBig", listBig);
		request.setAttribute("listMid", listMid);
		request.setAttribute("listSmall", listSmall);
		String productSkuId = request.getParameter("id");
		if (StringUtil.isEmpty(productSkuId)) {
			try {
				request.getRequestDispatcher("/WEB-INF/jsp/admin/bas/product/product_sku_edit.jsp").forward(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}else {
			List<BasProductSku> list = iBasProductSkuService.load(productSkuId);
			BasProductSku basProductSku = list.get(0);
			request.setAttribute("id", "&id="+productSkuId);
			request.setAttribute("basProductSku", basProductSku);
			try {
				request.getRequestDispatcher("/WEB-INF/jsp/admin/bas/product/product_sku_edit.jsp").forward(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	/**
	 * 商品界面
	 * @param request
	 * @param response
	 * @throws IOException 
	 * @throws ServletException 
	 */
	private void product(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String method = request.getParameter(METHOD_NAME);
		if (METHOD_NAME_EDIT.equals(method)) {
			productEdit(request,response);
		}else if (METHOD_NAME_SAVE.equals(method)) {
			productSave(request,response);
		}else if (METHOD_NAME_DELETE.equals(method)) {
			productDelete(request,response);
		}else {
			productPageList(request,response);
		}
	}

	private void productPageList(HttpServletRequest request, HttpServletResponse response) {
		BasProductVoService basProductVoService = new BasProductVoService();
		IBasProductVoService iBasProductVoService = (IBasProductVoService)ServiceProxyFactory.getProxyInstance(basProductVoService);
		String strPageIndex =request.getParameter(PAGE_PARAM_PAGE_INDEX);
		String strPpageSize = request.getParameter(PAGE_PARAM_PAGE_SIZE);
		int pageIndex = StringUtil.isEmpty(strPageIndex)?0:Integer.parseInt(strPageIndex);
		int pageSize = StringUtil.isEmpty(strPpageSize)?100:Integer.parseInt(strPpageSize);
		String code = request.getParameter("code");
		String name = request.getParameter("name");
		String brandId = request.getParameter("brandId");
		String categoryBigId = request.getParameter("categoryBigId");
		String categorySmallId = request.getParameter("categorySmallId");
		String productPlace = request.getParameter("productPlace");
		String marketYear = request.getParameter("marketYear");
		String marketSeason = request.getParameter("marketSeason");
		String fashionElement = request.getParameter("fashionElement");
		String fabric = request.getParameter("fabric");
		String stereotype = request.getParameter("stereotype");
		String grossWeight = request.getParameter("grossWeight");
		Page page = new Page();
		BasProductVo basProductVo = new BasProductVo();
		basProductVo.setCode(code);
		basProductVo.setName(name);
		basProductVo.setBrandId(brandId);
		basProductVo.setCategoryBigId(categoryBigId);
		basProductVo.setCategorySmallId(categorySmallId);
		basProductVo.setProductPlace(productPlace);
		basProductVo.setMarketYear(StringUtil.strToBigDecimal(marketYear));
		basProductVo.setMarketSeason(StringUtil.strToBigDecimal(marketSeason));
		basProductVo.setFashionElement(fashionElement);
		basProductVo.setFabric(fabric);
		basProductVo.setStereotype(stereotype);
		basProductVo.setGrossWeight(StringUtil.strToBigDecimal(grossWeight));
		try {
			page = iBasProductVoService.pageList(pageIndex, pageSize, basProductVo);
			request.setAttribute("page", page);
			request.getRequestDispatcher("/WEB-INF/jsp/admin/bas/product/product.jsp").forward(request, response);
		} catch (Exception e) {
			e.printStackTrace();
			throw new BaseException("异常："+e.getMessage());
		}
	}

	private void productDelete(HttpServletRequest request, HttpServletResponse response) {
		String productId = request.getParameter("id");
		iBasProductService.delete(productId);
		try {
			response.sendRedirect("/share/admin/ProductAction.action?pageName=product");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private void productSave(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String productId = request.getParameter("id");
		String code = request.getParameter("code");
		String name = request.getParameter("name");
		String brandId = request.getParameter("brandId");
		String categoryBigId = request.getParameter("categoryBigId");
		String categorySmallId = request.getParameter("categorySmallId");
		String productPlace = request.getParameter("productPlace");
		String marketYear = request.getParameter("marketYear");
		String marketSeason = request.getParameter("marketSeason");
		String fashionElement = request.getParameter("fashionElement");
		String fabric = request.getParameter("fabric");
		String stereotype = request.getParameter("stereotype");
		String grossWeight = request.getParameter("grossWeight");
		BasProduct basProduct = new BasProduct();
		basProduct.setCode(code);
		basProduct.setName(name);
		basProduct.setBrandId(brandId);
		basProduct.setCategoryBigId(categoryBigId);
		basProduct.setCategorySmallId(categorySmallId);
		basProduct.setProductPlace(productPlace);
		basProduct.setMarketYear(StringUtil.strToBigDecimal(marketYear));
		basProduct.setMarketSeason(StringUtil.strToBigDecimal(marketSeason));
		basProduct.setFashionElement(fashionElement);
		basProduct.setFabric(fabric);
		basProduct.setStereotype(stereotype);
		basProduct.setGrossWeight(StringUtil.strToBigDecimal(grossWeight));
		if (StringUtil.isEmpty(productId)) {
			productId = StringUtil.generateUUID();
			basProduct.setProductId(productId);
			try {
				iBasProductService.codeCheck(basProduct);
				iBasProductService.insert(basProduct);
				response.sendRedirect("/share/admin/ProductAction.action?pageName=product");
			} catch (Exception e) {
				e.printStackTrace();
				request.setAttribute("exception", e);
				request.getRequestDispatcher("/WEB-INF/jsp/admin/common/error.jsp").forward(request, response);
			}
		} else {
			basProduct.setProductId(productId);
			try {
//				iBasProductService.codeCheck(basProduct);
				iBasProductService.update(basProduct);
				response.sendRedirect("/share/admin/ProductAction.action?pageName=product");
			} catch (Exception e) {
				e.printStackTrace();
				request.setAttribute("exception", e);
				request.getRequestDispatcher("/WEB-INF/jsp/admin/common/error.jsp").forward(request, response);
			}
		}
	}

	private void productEdit(HttpServletRequest request, HttpServletResponse response) {
		String productId = request.getParameter("id");
		List<BasCategoryBig> listBasCategoryBig = iBasCategoryBigService.list();
		request.setAttribute("listBasCategoryBig", listBasCategoryBig);
		List<BasCategorySmall> listBasCategorySmall = iBasCategorySmallService.list();
		request.setAttribute("listBasCategorySmall", listBasCategorySmall);
		List<BasBrand> listBasBrand = iBasBrandService.list();
		request.setAttribute("listBasBrand", listBasBrand);
		if (StringUtil.isEmpty(productId)) {
			try {
				request.getRequestDispatcher("/WEB-INF/jsp/admin/bas/product/product_edit.jsp").forward(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}else {
			List<BasProduct> list = iBasProductService.load(productId);
			BasProduct basProduct = list.get(0);
			request.setAttribute("id", "&id="+productId);
			request.setAttribute("basProduct", basProduct);
			try {
				request.getRequestDispatcher("/WEB-INF/jsp/admin/bas/product/product_edit.jsp").forward(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
}
