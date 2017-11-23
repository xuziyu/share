package com.barter.share.bas.dao.imp;

import java.lang.reflect.InvocationTargetException;
import java.util.List;

import com.barter.share.bas.dao.IBasProductVoDao;
import com.barter.share.bas.vo.BasProductVo;
import com.barter.share.framework.dao.BaseDao;
import com.barter.share.framework.dbutil.DbConnection;
import com.barter.share.framework.entity.Page;
import com.barter.share.framework.util.StringUtil;

public class BasProductVoDao extends BaseDao implements IBasProductVoDao {

	@Override
	public void insert(BasProductVo basProductVo) throws NoSuchMethodException, SecurityException,
			IllegalAccessException, IllegalArgumentException, InvocationTargetException {
		
	}

	@Override
	public void delete(String productId) {
		
	}

	@Override
	public void update(BasProductVo basProductVo) throws NoSuchMethodException, SecurityException,
			IllegalAccessException, IllegalArgumentException, InvocationTargetException {
		
	}

	@Override
	public List<BasProductVo> list() {
		return null;
	}

	@Override
	public List<BasProductVo> load(String productId) {
		return null;
	}
	

	@Override
	public List<BasProductVo> pageResult(int pageIndex, int pageSize, BasProductVo basProductVo)
			throws NoSuchMethodException, SecurityException, IllegalAccessException, IllegalArgumentException,
			InvocationTargetException {
		StringBuffer sql = new StringBuffer("SELECT bas_product.* , bas_brand.name AS brand_name , bas_category_big.name AS big_name , bas_category_small.name AS small_name ");
		sql.append("FROM bas_product ");
		sql.append("INNER JOIN bas_brand ");
		sql.append("ON bas_product.brand_id = bas_brand.brand_id ");
		sql.append("INNER JOIN bas_category_big ");
		sql.append("ON bas_category_big.category_big_id = bas_product.category_big_id ");
		sql.append("INNER JOIN bas_category_small ");
		sql.append("ON bas_category_small.category_small_id = bas_product.category_small_id ");
		sql.append("WHERE 1 = 1");
		Object [] paramsValue = StringUtil.reflectValue(basProductVo);
		Object [] paramsValueTrim =new Object[paramsValue.length];
		String [] sqlAppend ={" AND bas_product.product_id LIKE ?"," AND bas_product.code LIKE ?",
				" AND bas_product.name LIKE ?"," AND bas_product.brand_id LIKE ?"," AND bas_product.category_big_id LIKE ?",
				" AND bas_product.category_small_id LIKE ?"," AND bas_product.product_place LIKE ?"," AND bas_product.market_year LIKE ?",
				" AND bas_product.market_season LIKE ?"," AND bas_product.fashion_element LIKE ?"," AND bas_product.fabric LIKE ?",
				" AND bas_product.stereotype LIKE ?"," AND bas_product.gross_weight LIKE ?"," AND bas_brand.name LIKE ?",
				" AND bas_category_big.name LIKE ?"," AND bas_category_small.name LIKE ?"};
		if (basProductVo!=null) {
			int valueIndex =0;
			for (int i = 0; i < paramsValue.length; i++) {
				if (!StringUtil.isEmpty(paramsValue[i])) {
					sql.append(sqlAppend[i]);
					paramsValueTrim[valueIndex] = "%"+paramsValue[i]+"%";
					valueIndex++;
				}
			}
		}
		sql.append(" order by bas_product.code asc");
		sql.append(" limit " + pageIndex * pageSize + "," + pageSize);
		return super.query(sql, paramsValueTrim, BasProductVo.class);
	}

	@Override
	public int pageRowCount(BasProductVo basProductVo) throws NoSuchMethodException, SecurityException,
			IllegalAccessException, IllegalArgumentException, InvocationTargetException {
		StringBuffer sql = new StringBuffer("SELECT COUNT(bas_product.product_id) ");
		sql.append("FROM bas_product ");
		sql.append("INNER JOIN bas_brand ");
		sql.append("ON bas_product.brand_id = bas_brand.brand_id ");
		sql.append("INNER JOIN bas_category_big ");
		sql.append("ON bas_category_big.category_big_id = bas_product.category_big_id ");
		sql.append("INNER JOIN bas_category_small ");
		sql.append("ON bas_category_small.category_small_id = bas_product.category_small_id ");
		sql.append("WHERE 1 = 1");
		Object [] paramsValue = StringUtil.reflectValue(basProductVo);
		Object [] paramsValueTrim =new Object[paramsValue.length];
		String [] sqlAppend ={" AND bas_product.product_id LIKE ?"," AND bas_product.code LIKE ?",
				" AND bas_product.name LIKE ?"," AND bas_product.brand_id LIKE ?"," AND bas_product.category_big_id LIKE ?",
				" AND bas_product.category_small_id LIKE ?"," AND bas_product.product_place LIKE ?"," AND bas_product.market_year LIKE ?",
				" AND bas_product.market_season LIKE ?"," AND bas_product.fashion_element LIKE ?"," AND bas_product.fabric LIKE ?",
				" AND bas_product.stereotype LIKE ?"," AND bas_product.gross_weight LIKE ?"," AND bas_brand.name LIKE ?",
				" AND bas_category_big.name LIKE ?"," AND bas_category_small.name LIKE ?"};
		if (basProductVo!=null) {
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
	public Page pageList(int pageIndex, int pageSize, BasProductVo basProductVo) throws NoSuchMethodException,
			SecurityException, IllegalAccessException, IllegalArgumentException, InvocationTargetException {
		Page page = new Page();
		int rowCount =0;
		//获得 查询结果的行数
		rowCount = pageRowCount(basProductVo);
		int pageCount = (rowCount - 1) / pageSize + 1;

		if (pageIndex < 0) {
			pageIndex = 0;
		}

		if (pageIndex > pageCount) {
			pageIndex = pageCount;
		}
		//把查询到的 实体对象数组   存到  result 并作为属性 给  page对象
		List result = pageResult(pageIndex, pageSize,basProductVo);
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
	public void validateUnique4Code(BasProductVo basProductVo) throws NoSuchMethodException, SecurityException,
			IllegalAccessException, IllegalArgumentException, InvocationTargetException {
		
	}

}
