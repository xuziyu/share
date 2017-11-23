package com.barter.share.bas.dao.imp;

import java.lang.reflect.InvocationTargetException;
import java.util.List;

import com.barter.share.bas.dao.IBasSkuSizeDao;
import com.barter.share.bas.entity.BasSkuSize;
import com.barter.share.framework.dao.BaseDao;
import com.barter.share.framework.entity.Page;
import com.barter.share.framework.exception.ValidateException;
import com.barter.share.framework.util.StringUtil;

public class BasSkuSizeDao extends BaseDao implements IBasSkuSizeDao {

	@Override
	public void insert(BasSkuSize basSkuSize) throws NoSuchMethodException, SecurityException, IllegalAccessException,
			IllegalArgumentException, InvocationTargetException {
		StringBuffer sql = new StringBuffer("INSERT INTO bas_sku_size (sku_size_id, code, name, descr) VALUES (?, ?, ?, ?)");
		Object [] paramsValue =StringUtil.reflectValue(basSkuSize);
		super.update(sql, paramsValue);
	}

	@Override
	public void delete(String skuSizeId) {
		StringBuffer sql = new StringBuffer("DELETE FROM bas_sku_size WHERE sku_size_id = ?");
		Object [] paramsValue ={skuSizeId};
		super.update(sql, paramsValue);
	}

	@Override
	public void update(BasSkuSize basSkuSize) throws NoSuchMethodException, SecurityException, IllegalAccessException,
			IllegalArgumentException, InvocationTargetException {
		StringBuffer sql = new StringBuffer("UPDATE bas_sku_size SET code = ? ,name = ? ,descr = ? WHERE sku_size_id = ?");
		Object [] paramsValue =StringUtil.leftOne(StringUtil.reflectValue(basSkuSize));
		super.update(sql, paramsValue);
	}

	@Override
	public List<BasSkuSize> list() {
		StringBuffer sql = new StringBuffer("SELECT * FROM bas_sku_size");
		Object [] paramsValue =null;
		return super.query(sql, paramsValue, BasSkuSize.class);
	}

	@Override
	public List<BasSkuSize> load(String skuSizeId) {
		StringBuffer sql = new StringBuffer("SELECT * FROM bas_sku_size WHERE 1 = 1 AND sku_size_id = ?");
		Object [] paramsValue ={skuSizeId};
		return super.query(sql, paramsValue, BasSkuSize.class);
	}

	@Override
	public List<BasSkuSize> pageResult(int pageIndex, int pageSize, BasSkuSize basSkuSize) throws NoSuchMethodException,
			SecurityException, IllegalAccessException, IllegalArgumentException, InvocationTargetException {
		StringBuffer sql = new StringBuffer("SELECT * FROM bas_sku_size WHERE 1 = 1");
		Object [] paramsValue = StringUtil.reflectValue(basSkuSize);
		Object [] paramsValueTrim =new Object[paramsValue.length];
		String [] sqlAppend ={" AND sku_size_id like ?"," AND code like ?"," AND name LIKE ?"," AND descr LIKE ?"};
		if (basSkuSize!=null) {
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
		return super.query(sql, paramsValueTrim, BasSkuSize.class);
	}

	@Override
	public int pageRowCount(BasSkuSize basSkuSize) throws NoSuchMethodException, SecurityException,
			IllegalAccessException, IllegalArgumentException, InvocationTargetException {
		StringBuffer sql = new StringBuffer("SELECT COUNT(sku_size_id) FROM bas_sku_size WHERE 1 = 1");
		Object [] paramsValue = StringUtil.reflectValue(basSkuSize);
		Object [] paramsValueTrim =new Object[paramsValue.length];
		String [] sqlAppend ={" AND sku_size_id like ?"," AND code like ?"," AND name LIKE ?"," AND descr LIKE ?"};
		if (basSkuSize!=null) {
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
	public Page pageList(int pageIndex, int pageSize, BasSkuSize basSkuSize) throws NoSuchMethodException,
			SecurityException, IllegalAccessException, IllegalArgumentException, InvocationTargetException {
		Page page = new Page();
		int rowCount =0;
		//获得 查询结果的行数
		rowCount = pageRowCount(basSkuSize);
		int pageCount = (rowCount - 1) / pageSize + 1;

		if (pageIndex < 0) {
			pageIndex = 0;
		}

		if (pageIndex > pageCount) {
			pageIndex = pageCount;
		}
		//把查询到的 实体对象数组   存到  result 并作为属性 给  page对象
		List result = pageResult(pageIndex, pageSize,basSkuSize);
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
	public void validateUnique4Code(BasSkuSize basSkuSize) throws NoSuchMethodException, SecurityException,
			IllegalAccessException, IllegalArgumentException, InvocationTargetException {
		StringBuffer sql = new StringBuffer("SELECT COUNT(sku_size_id) FROM bas_sku_size WHERE code = ?");
		String [] paramsValue = {basSkuSize.getCode()};
		int count =super.resultRowCount(sql, paramsValue);
		if (count==1) {
			throw new ValidateException("编号重复:" + basSkuSize.getCode());
		}
	}

}
