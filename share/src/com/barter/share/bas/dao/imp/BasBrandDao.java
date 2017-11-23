package com.barter.share.bas.dao.imp;

import java.lang.reflect.InvocationTargetException;
import java.util.List;

import com.barter.share.bas.dao.IBasBrandDao;
import com.barter.share.bas.entity.BasBrand;
import com.barter.share.framework.dao.BaseDao;
import com.barter.share.framework.entity.Page;
import com.barter.share.framework.exception.ValidateException;
import com.barter.share.framework.util.StringUtil;

public class BasBrandDao extends BaseDao implements IBasBrandDao {

	@Override
	public void insert(BasBrand basBrand) throws NoSuchMethodException, SecurityException, IllegalAccessException, IllegalArgumentException, InvocationTargetException {
		StringBuffer sql = new StringBuffer("INSERT INTO bas_brand (brand_id,code,name,slogan)VALUES");
		sql.append("(?,?,?,?)");
		Object [] paramsValue =StringUtil.reflectValue(basBrand);
		super.update(sql, paramsValue);
	}

	@Override
	public void delete(String brandId) {
		StringBuffer sql = new StringBuffer("DELETE FROM bas_brand WHERE");
		sql.append(" brand_id = ?");
		Object [] paramsValue = {brandId};
		super.update(sql, paramsValue);
	}

	@Override
	public void update(BasBrand basBrand) throws NoSuchMethodException, SecurityException, IllegalAccessException, IllegalArgumentException, InvocationTargetException {
		StringBuffer sql = new StringBuffer("UPDATE bas_brand SET");
		sql.append(" code = ? ,name = ?,slogan=?");
		sql.append(" WHERE brand_id =?");
		Object [] paramsValue =StringUtil.leftOne(StringUtil.reflectValue(basBrand));
		super.update(sql, paramsValue);
	}

	@Override
	public List<BasBrand> list() {
		StringBuffer sql = new StringBuffer("SELECT * FROM bas_brand WHERE 1=1");
		return super.query(sql, null, BasBrand.class);
	}

	@Override
	public List<BasBrand> load(String brandId) {
		StringBuffer sql = new StringBuffer("SELECT * FROM bas_brand WHERE 1=1");
		sql.append(" AND brand_id = ?");
		Object [] paramsValue ={brandId};
		return super.query(sql, paramsValue, BasBrand.class);
	}

	@Override
	public Page pageList(int pageIndex, int pageSize, BasBrand basBrand) throws NoSuchMethodException, SecurityException, IllegalAccessException, IllegalArgumentException, InvocationTargetException {
		Page page = new Page();
		int rowCount = 0;
		rowCount = pageRowCount(basBrand);
		//
		int pageCount = (rowCount - 1) / pageSize + 1;

		if (pageIndex < 0) {
			pageIndex = 0;
		}

		if (pageIndex > pageCount) {
			pageIndex = pageCount;
		}
		List result = pageResult(pageIndex, pageSize, basBrand);
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
	public List<BasBrand> pageResult(int pageIndex, int pageSize, BasBrand basBrand) throws NoSuchMethodException, SecurityException, IllegalAccessException, IllegalArgumentException, InvocationTargetException {
		StringBuffer sql = new StringBuffer("SELECT * FROM bas_brand WHERE 1=1");
		Object [] paramsValue =StringUtil.reflectValue(basBrand);
		Object [] paramsValueTrim =new Object[paramsValue.length];
		String [] sqlAppend ={" and brand_id like ?"," and code like ?"," and name like ?"," and slogan like ?"};
		if (basBrand!=null) {
			int valueIndex =0;
			for (int i = 0; i < paramsValue.length; i++) {
				if (!StringUtil.isEmpty(paramsValue[i])) {
					sql.append(sqlAppend[i]);
					paramsValueTrim[valueIndex] = "%"+paramsValue[i]+"%";
					valueIndex++;
				}
			}
		}
		sql.append(" order by code asc");
		sql.append(" limit " + pageIndex * pageSize + "," + pageSize);
		return super.query(sql, paramsValueTrim, BasBrand.class);
	}

	@Override
	public int pageRowCount(BasBrand basBrand) throws NoSuchMethodException, SecurityException, IllegalAccessException, IllegalArgumentException, InvocationTargetException {
		StringBuffer sql = new StringBuffer("SELECT COUNT(brand_id) FROM bas_brand WHERE 1=1");
		Object [] paramsValue =StringUtil.reflectValue(basBrand);
		Object [] paramsValueTrim =new Object[paramsValue.length];
		String [] sqlAppend ={" and brand_id like ?"," and code like ?"," and name like ?"," and slogan like ?"};
		if (basBrand!=null) {
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
	public void validateUnique4Code(BasBrand basBrand) throws NoSuchMethodException, SecurityException, IllegalAccessException, IllegalArgumentException, InvocationTargetException {
		StringBuffer sql = new StringBuffer("SELECT COUNT(brand_id) FROM bas_brand WHERE code = ?");
		Object [] paramsValueTrim ={basBrand.getCode()};
		int count =super.resultRowCount(sql, paramsValueTrim);
		if (count==1) {
			throw new ValidateException("编号重复:" + basBrand.getCode());
		}
	}
	
	
}
