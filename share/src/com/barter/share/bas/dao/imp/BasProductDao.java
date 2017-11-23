package com.barter.share.bas.dao.imp;

import java.lang.reflect.InvocationTargetException;
import java.util.List;

import com.barter.share.bas.dao.IBasProductDao;
import com.barter.share.bas.entity.BasProduct;
import com.barter.share.bas.vo.BasProductFrontVo;
import com.barter.share.bas.vo.FabricVo;
import com.barter.share.bas.vo.FashionElementVo;
import com.barter.share.bas.vo.GrossWeightVo;
import com.barter.share.bas.vo.PlaceVo;
import com.barter.share.bas.vo.StereotypeVo;
import com.barter.share.framework.dao.BaseDao;
import com.barter.share.framework.entity.Page;
import com.barter.share.framework.exception.ValidateException;
import com.barter.share.framework.util.StringUtil;

public class BasProductDao extends BaseDao implements IBasProductDao {

	@Override
	public void insert(BasProduct basProduct) throws NoSuchMethodException, SecurityException, IllegalAccessException, IllegalArgumentException, InvocationTargetException {
		StringBuffer sql = new StringBuffer("INSERT INTO bas_product ");
		sql.append("(product_id, code, name, brand_id, category_big_id, category_small_id, product_place, market_year,");
		sql.append(" market_season, fashion_element, fabric, stereotype, gross_weight) ");
		sql.append("VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?)");
		Object [] paramsValue =StringUtil.reflectValue(basProduct);
		super.update(sql, paramsValue);
	}

	@Override
	public void delete(String productId) {
		StringBuffer sql = new StringBuffer("DELETE FROM bas_product WHERE product_id = ?");
		Object [] paramsValue ={productId};
		super.update(sql, paramsValue);
	}

	@Override
	public void update(BasProduct basProduct) throws NoSuchMethodException, SecurityException, IllegalAccessException, IllegalArgumentException, InvocationTargetException {
		StringBuffer sql = new StringBuffer("UPDATE bas_product SET code = ?, name = ?, brand_id = ?, category_big_id = ?,");
		sql.append(" category_small_id = ?, product_place = ?, market_year = ?, market_season = ?,");
		sql.append(" fashion_element = ?, fabric = ?, stereotype = ?, gross_weight = ? WHERE product_id = ?");
		Object [] paramsValue =StringUtil.leftOne(StringUtil.reflectValue(basProduct));
		super.update(sql, paramsValue);

	}

	@Override
	public List<BasProduct> list() {
		StringBuffer sql = new StringBuffer("SELECT * FROM bas_product");
		Object [] paramsValue =null;
		return super.query(sql, paramsValue, BasProduct.class);
	}

	@Override
	public List<BasProduct> load(String productId) {
		StringBuffer sql = new StringBuffer("SELECT * FROM bas_product WHERE 1 = 1");
		sql.append(" AND product_id = ?");
		Object [] paramsValue ={productId};
		return super.query(sql, paramsValue, BasProduct.class);
	}

	@Override
	public List<BasProduct> pageResult(int pageIndex, int pageSize, BasProduct basProduct) throws NoSuchMethodException, SecurityException, IllegalAccessException, IllegalArgumentException, InvocationTargetException {
		StringBuffer sql = new StringBuffer("SELECT * FROM bas_product WHERE 1 = 1");
		Object [] paramsValue = StringUtil.reflectValue(basProduct);
		Object [] paramsValueTrim =new Object[paramsValue.length];
		String [] sqlAppend ={" AND product_id LIKE ?"," AND code LIKE ?"," AND name LIKE ?",
				" AND brand_id LIKE ?"," AND category_big_id LIKE ?",
				" AND category_small_id LIKE ?"," AND product_place LIKE ?",
				" AND market_year LIKE ?"," AND market_season LIKE ?",
				" AND fashion_element LIKE ?"," AND fabric LIKE ?",
				" AND stereotype LIKE ?"," AND gross_weight LIKE ?"};
		
		if (basProduct!=null) {
			int valueIndex =0;
			for (int i = 0; i < paramsValue.length; i++) {
				if (!StringUtil.isEmpty(paramsValue[i])) {
					sql.append(sqlAppend[i]);
					paramsValueTrim[valueIndex] = "%"+paramsValue[i]+"%";
					valueIndex++;
				}
			}
		}
		sql.append(" order by product_id desc");
		sql.append(" limit " + pageIndex * pageSize + "," + pageSize);
		return super.query(sql, paramsValueTrim, BasProduct.class);
	}

	@Override
	public int pageRowCount(BasProduct basProduct) throws NoSuchMethodException, SecurityException, IllegalAccessException, IllegalArgumentException, InvocationTargetException {
		StringBuffer sql = new StringBuffer("SELECT COUNT(product_id) FROM bas_product WHERE 1 = 1");
		Object [] paramsValue = StringUtil.reflectValue(basProduct);
		Object [] paramsValueTrim =new Object[paramsValue.length];
		String [] sqlAppend ={" AND product_id LIKE ?"," AND code LIKE ?",
				" AND name LIKE ?","  AND brand_id LIKE ?"," AND category_big_id LIKE ?",
				" AND category_small_id LIKE ?"," AND product_place LIKE ?",
				" AND market_year LIKE ?"," AND market_season LIKE ?",
				" AND fashion_element LIKE ?"," AND fabric LIKE ?",
				" AND stereotype LIKE ?"," AND gross_weight LIKE ?"};
		if (basProduct!=null) {
			int valueIndex =0;
			for (int i = 0; i < paramsValue.length; i++) {
				if (!StringUtil.isEmpty(paramsValue[i])) {
					sql.append(sqlAppend[i]);
					paramsValueTrim[valueIndex] = "%"+paramsValue[i]+"%";
					valueIndex++;
				}
			}
		}
		return super.resultRowCount(sql, paramsValueTrim);
	}

	@Override
	public Page pageList(int pageIndex, int pageSize, BasProduct basProduct) throws NoSuchMethodException, SecurityException, IllegalAccessException, IllegalArgumentException, InvocationTargetException {
		Page page = new Page();
		int rowCount =0;
		//获得 查询结果的行数
		rowCount = pageRowCount(basProduct);
		int pageCount = (rowCount - 1) / pageSize + 1;

		if (pageIndex < 0) {
			pageIndex = 0;
		}

		if (pageIndex > pageCount) {
			pageIndex = pageCount;
		}
		//把查询到的 实体对象数组   存到  result 并作为属性 给  page对象
		List result = pageResult(pageIndex, pageSize,basProduct);
		page.setPageSize(pageSize);
		page.setPageIndex(pageIndex);
		page.setPageCount(pageCount);
		page.setRowCount(rowCount);
		page.setResult(result);
		if (pageIndex == 0) {
			page.setHasPrior(false);
		} else {
			page.setHasPrior(true);
		}

		if (pageIndex >= pageCount - 1) {
			page.setHasNext(false);
		} else {
			page.setHasNext(true);
		}
		return page;
	}

	@Override
	public void validateUnique4Code(BasProduct basProduct) throws NoSuchMethodException, SecurityException, IllegalAccessException, IllegalArgumentException, InvocationTargetException {
		StringBuffer sql = new StringBuffer("SELECT COUNT(product_id) FROM bas_product WHERE code = ?");
		Object [] paramsValueTrim ={basProduct.getCode()};
		int count =super.resultRowCount(sql, paramsValueTrim);
		if (count==1) {
			throw new ValidateException("编号重复:" + basProduct.getCode());
		}
	}

	@Override
	public List<BasProductFrontVo> frontPage(int pageIndex, int pageSize,String priceMin ,String priceMax  ,String orderBy ,  BasProductFrontVo basProductFrontVo) throws NoSuchMethodException, SecurityException, IllegalAccessException, IllegalArgumentException, InvocationTargetException {
		StringBuffer sql = new StringBuffer("SELECT bas_product.* , bas_product_sku.price_real AS price_real, bas_product_sku.price_old AS price_old, bas_file_upload.full_path AS full_path ");
		sql.append("FROM bas_product ");
		sql.append("INNER JOIN bas_product_sku ");
		sql.append("ON bas_product.product_id = bas_product_sku.product_id ");
		sql.append("INNER JOIN bas_file_upload ");
		sql.append("ON bas_file_upload.file_upload_id = bas_product_sku.pic_middle_file_id ");
		sql.append("WHERE 1 = 1");
		Object [] paramsValue =new Object[StringUtil.reflectValue(basProductFrontVo).length];	
		if (basProductFrontVo!=null) {
			int valueIndex =0;
			if (basProductFrontVo.getBrandId()!=null) {
				sql.append(" AND bas_product.brand_id = ?");
				paramsValue[valueIndex] = basProductFrontVo.getBrandId();
				valueIndex++;
			}if (basProductFrontVo.getCategorySmallId()!=null) {
				sql.append(" AND bas_product.category_small_id = ?");
				paramsValue[valueIndex] = basProductFrontVo.getCategorySmallId();
				valueIndex++;
			}if (basProductFrontVo.getName()!=null) {
				sql.append(" AND bas_product.name LIKE ?");
				paramsValue[valueIndex] = "%"+basProductFrontVo.getName()+"%";
				valueIndex++;
			}if (basProductFrontVo.getProductPlace()!=null) {
				sql.append(" AND bas_product.product_place = ?");
				paramsValue[valueIndex] = basProductFrontVo.getProductPlace();
				valueIndex++;
			}if (basProductFrontVo.getMarketSeason()!=null) {
				sql.append(" AND bas_product.market_season = ?");
				paramsValue[valueIndex] = basProductFrontVo.getMarketSeason();
				valueIndex++;
			}if (basProductFrontVo.getFashionElement()!=null) {
				sql.append(" AND bas_product.fashion_element = ?");
				paramsValue[valueIndex] = basProductFrontVo.getFashionElement();
				valueIndex++;
			}if (basProductFrontVo.getFabric()!=null) {
				sql.append(" AND bas_product.fabric = ?");
				paramsValue[valueIndex] = basProductFrontVo.getFabric();
				valueIndex++;
			}if (basProductFrontVo.getStereotype()!=null) {
				sql.append(" AND bas_product.stereotype = ?");
				paramsValue[valueIndex] = basProductFrontVo.getStereotype();
				valueIndex++;
			}if (basProductFrontVo.getGrossWeight()!=null) {
				sql.append(" AND bas_product.gross_weight = ?");
				paramsValue[valueIndex] = basProductFrontVo.getGrossWeight();
				valueIndex++;
			}if (!StringUtil.isEmpty(priceMin)) {
				sql.append(" AND bas_product_sku.price_real >= ?");
				paramsValue[valueIndex] = priceMin;
				valueIndex++;
			}if (!StringUtil.isEmpty(priceMax)) {
				sql.append(" AND bas_product_sku.price_real <= ?");
				paramsValue[valueIndex] = priceMax;
				valueIndex++;
			}
		}
		if (!StringUtil.isEmpty(orderBy)) {
			sql.append(" order by ");
			sql.append(orderBy);
			sql.append(" desc");
		}
		sql.append(" limit " + pageIndex * pageSize + "," + pageSize);
		return super.query(sql, paramsValue, BasProductFrontVo.class);
	}

	@Override
	public int frontPageRowCount(String priceMin ,String priceMax  ,BasProductFrontVo basProductFrontVo) throws NoSuchMethodException, SecurityException, IllegalAccessException, IllegalArgumentException, InvocationTargetException {
		StringBuffer sql = new StringBuffer("SELECT COUNT(bas_product.brand_id) ");
		sql.append("FROM bas_product ");
		sql.append("INNER JOIN bas_product_sku ");
		sql.append("ON bas_product.product_id = bas_product_sku.product_id ");
		sql.append("INNER JOIN bas_file_upload ");
		sql.append("ON bas_file_upload.file_upload_id = bas_product_sku.pic_middle_file_id ");
		sql.append("WHERE 1 = 1");
		Object [] paramsValue =new Object[StringUtil.reflectValue(basProductFrontVo).length];	
		if (basProductFrontVo!=null) {
			int valueIndex =0;
			if (basProductFrontVo.getBrandId()!=null) {
				sql.append(" AND bas_product.brand_id = ?");
				paramsValue[valueIndex] = basProductFrontVo.getBrandId();
				valueIndex++;
			}if (basProductFrontVo.getCategorySmallId()!=null) {
				sql.append(" AND bas_product.category_small_id = ?");
				paramsValue[valueIndex] = basProductFrontVo.getCategorySmallId();
				valueIndex++;
			}if (basProductFrontVo.getName()!=null) {
				sql.append(" AND bas_product.name LIKE ?");
				paramsValue[valueIndex] = "%"+basProductFrontVo.getName()+"%";
				valueIndex++;
			}if (basProductFrontVo.getProductPlace()!=null) {
				sql.append(" AND bas_product.product_place = ?");
				paramsValue[valueIndex] = basProductFrontVo.getProductPlace();
				valueIndex++;
			}if (basProductFrontVo.getMarketSeason()!=null) {
				sql.append(" AND bas_product.market_season = ?");
				paramsValue[valueIndex] = basProductFrontVo.getMarketSeason();
				valueIndex++;
			}if (basProductFrontVo.getFashionElement()!=null) {
				sql.append(" AND bas_product.fashion_element = ?");
				paramsValue[valueIndex] = basProductFrontVo.getFashionElement();
				valueIndex++;
			}if (basProductFrontVo.getFabric()!=null) {
				sql.append(" AND bas_product.fabric = ?");
				paramsValue[valueIndex] = basProductFrontVo.getFabric();
				valueIndex++;
			}if (basProductFrontVo.getStereotype()!=null) {
				sql.append(" AND bas_product.stereotype = ?");
				paramsValue[valueIndex] = basProductFrontVo.getStereotype();
				valueIndex++;
			}if (basProductFrontVo.getGrossWeight()!=null) {
				sql.append(" AND bas_product.gross_weight = ?");
				paramsValue[valueIndex] = basProductFrontVo.getGrossWeight();
				valueIndex++;
			}if (!StringUtil.isEmpty(priceMin)) {
				sql.append(" AND bas_product_sku.price_real >= ?");
				paramsValue[valueIndex] = priceMin;
				valueIndex++;
			}if (!StringUtil.isEmpty(priceMax)) {
				sql.append(" AND bas_product_sku.price_real <= ?");
				paramsValue[valueIndex] = priceMax;
				valueIndex++;
			}
			
		}
		return super.resultRowCount(sql, paramsValue);
	}

	@Override
	public Page frontPageList(int pageIndex, int pageSize,String priceMin ,String priceMax  , String orderBy ,  BasProductFrontVo basProductFrontVo) throws NoSuchMethodException, SecurityException, IllegalAccessException, IllegalArgumentException, InvocationTargetException {
		Page page = new Page();
		int rowCount =0;
		//获得 查询结果的行数
		rowCount = frontPageRowCount(priceMin , priceMax , basProductFrontVo);
		int pageCount = (rowCount - 1) / pageSize + 1;

		if (pageIndex < 0) {
			pageIndex = 0;
		}

		if (pageIndex > pageCount) {
			pageIndex = pageCount;
		}
		//把查询到的 实体对象数组   存到  result 并作为属性 给  page对象
		@SuppressWarnings("rawtypes")
		List result = frontPage(pageIndex, pageSize,priceMin ,priceMax  ,orderBy, basProductFrontVo);
		page.setPageSize(pageSize);
		page.setPageIndex(pageIndex);
		page.setPageCount(pageCount);
		page.setRowCount(rowCount);
		page.setResult(result);
		if (pageIndex == 0) {
			page.setHasPrior(false);
		} else {
			page.setHasPrior(true);
		}

		if (pageIndex >= pageCount - 1) {
			page.setHasNext(false);
		} else {
			page.setHasNext(true);
		}
		return page;
	}

	@Override
	public List<PlaceVo> place() {
		StringBuffer sql = new StringBuffer("SELECT DISTINCT(product_place) FROM bas_product");
		String [] paramsValue=null;
		return query(sql, paramsValue, PlaceVo.class);
	}

	@Override
	public List<FashionElementVo> fashionElement() {
		StringBuffer sql = new StringBuffer("SELECT DISTINCT(fashion_element) FROM bas_product");
		String [] paramsValue=null;
		return query(sql, paramsValue, FashionElementVo.class);
	}

	@Override
	public List<FabricVo> fabric() {
		StringBuffer sql = new StringBuffer("SELECT DISTINCT(fabric) FROM bas_product");
		String [] paramsValue=null;
		return query(sql, paramsValue, FabricVo.class);
	}

	@Override
	public List<StereotypeVo> stereotype() {
		StringBuffer sql = new StringBuffer("SELECT DISTINCT(stereotype) FROM bas_product");
		String [] paramsValue=null;
		return query(sql, paramsValue, StereotypeVo.class);
	}

	@Override
	public List<GrossWeightVo> grossWeight() {
		StringBuffer sql = new StringBuffer("SELECT DISTINCT(gross_weight) FROM bas_product");
		String [] paramsValue=null;
		return query(sql, paramsValue, GrossWeightVo.class);
	}
	
}
