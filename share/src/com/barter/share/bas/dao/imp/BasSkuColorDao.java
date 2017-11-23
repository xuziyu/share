package com.barter.share.bas.dao.imp;

import java.lang.reflect.InvocationTargetException;
import java.util.List;

import com.barter.share.bas.dao.IBasSkuColorDao;
import com.barter.share.bas.entity.BasSkuColor;
import com.barter.share.framework.dao.BaseDao;
import com.barter.share.framework.entity.Page;
import com.barter.share.framework.exception.ValidateException;
import com.barter.share.framework.util.StringUtil;

public class BasSkuColorDao extends BaseDao implements IBasSkuColorDao {

	@Override
	public void insert(BasSkuColor basSkuColor) throws NoSuchMethodException, SecurityException, IllegalAccessException,
			IllegalArgumentException, InvocationTargetException {
		StringBuffer sql = new StringBuffer("INSERT INTO bas_sku_color (sku_color_id, code, name, descr, rgb) VALUES ");
		sql.append("(?, ?, ?, ?, ?)");
		Object [] paramsValue =StringUtil.reflectValue(basSkuColor);
		super.update(sql, paramsValue);
	}

	@Override
	public void delete(String skuColorId) {
		StringBuffer sql = new StringBuffer("DELETE FROM bas_sku_color WHERE sku_color_id = ?");
		Object [] paramsValue ={skuColorId};
		super.update(sql, paramsValue);
	}

	@Override
	public void update(BasSkuColor basSkuColor) throws NoSuchMethodException, SecurityException, IllegalAccessException,
			IllegalArgumentException, InvocationTargetException {
		StringBuffer sql = new StringBuffer("UPDATE bas_sku_color SET code = ? , name = ? , descr = ? , rgb = ? WHERE sku_color_id = ?");
		Object [] paramsValue =StringUtil.leftOne(StringUtil.reflectValue(basSkuColor));
		super.update(sql, paramsValue);
	}

	@Override
	public List<BasSkuColor> list() {
		StringBuffer sql = new StringBuffer("SELECT * FROM bas_sku_color");
		Object [] paramsValue =null;
		return super.query(sql, paramsValue, BasSkuColor.class);
	}

	@Override
	public List<BasSkuColor> load(String skuColorId) {
		StringBuffer sql = new StringBuffer("SELECT * FROM bas_sku_color WHERE 1 = 1 AND sku_color_id = ?");
		Object [] paramsValue ={skuColorId};
		return super.query(sql, paramsValue, BasSkuColor.class);
	}

	@Override
	public List<BasSkuColor> pageResult(int pageIndex, int pageSize, BasSkuColor basSkuColor)
			throws NoSuchMethodException, SecurityException, IllegalAccessException, IllegalArgumentException,
			InvocationTargetException {
		StringBuffer sql = new StringBuffer("SELECT * FROM bas_sku_color WHERE 1 = 1");
		Object [] paramsValue = StringUtil.reflectValue(basSkuColor);
		Object [] paramsValueTrim =new Object[paramsValue.length];
		String [] sqlAppend ={" AND sku_color_id LIKE ?"," AND code LIKE ?"," AND name LIKE ?"," AND descr LIKE ?"," AND rgb LIKE ?"};
		if (basSkuColor!=null) {
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
		return super.query(sql, paramsValueTrim, BasSkuColor.class);
	}

	@Override
	public int pageRowCount(BasSkuColor basSkuColor) throws NoSuchMethodException, SecurityException,
			IllegalAccessException, IllegalArgumentException, InvocationTargetException {
		StringBuffer sql = new StringBuffer("SELECT COUNT(sku_color_id) FROM bas_sku_color WHERE 1 = 1");
		Object [] paramsValue = StringUtil.reflectValue(basSkuColor);
		Object [] paramsValueTrim =new Object[paramsValue.length];
		String [] sqlAppend ={" AND sku_color_id LIKE ?"," AND code LIKE ?"," AND name LIKE ?"," AND descr LIKE ?"," AND rgb LIKE ?"};
		if (basSkuColor!=null) {
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
	public Page pageList(int pageIndex, int pageSize, BasSkuColor basSkuColor) throws NoSuchMethodException,
			SecurityException, IllegalAccessException, IllegalArgumentException, InvocationTargetException {
		Page page = new Page();
		int rowCount =0;
		//获得 查询结果的行数
		rowCount = pageRowCount(basSkuColor);
		int pageCount = (rowCount - 1) / pageSize + 1;

		if (pageIndex < 0) {
			pageIndex = 0;
		}

		if (pageIndex > pageCount) {
			pageIndex = pageCount;
		}
		//把查询到的 实体对象数组   存到  result 并作为属性 给  page对象
		List result = pageResult(pageIndex, pageSize,basSkuColor);
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
	public void validateUnique4Code(BasSkuColor basSkuColor) throws NoSuchMethodException, SecurityException,
			IllegalAccessException, IllegalArgumentException, InvocationTargetException {
		StringBuffer sql = new StringBuffer("SELECT COUNT(sku_color_id) FROM bas_sku_color WHERE code = ?");
		String [] paramsValue = {basSkuColor.getCode()};
		int count =super.resultRowCount(sql, paramsValue);
		if (count==1) {
			throw new ValidateException("编号重复:" + basSkuColor.getCode());
		}
	}

}
