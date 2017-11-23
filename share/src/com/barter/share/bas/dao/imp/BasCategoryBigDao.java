package com.barter.share.bas.dao.imp;

import java.lang.reflect.InvocationTargetException;
import java.util.List;

import com.barter.share.bas.dao.IBasCategoryBigDao;
import com.barter.share.bas.entity.BasCategoryBig;
import com.barter.share.framework.dao.BaseDao;
import com.barter.share.framework.entity.Page;
import com.barter.share.framework.exception.ValidateException;
import com.barter.share.framework.util.StringUtil;

public class BasCategoryBigDao extends BaseDao implements IBasCategoryBigDao {

	@Override
	public void insert(BasCategoryBig basCategoryBig) throws NoSuchMethodException, SecurityException, IllegalAccessException, IllegalArgumentException, InvocationTargetException {
		StringBuffer sql = new StringBuffer("INSERT INTO bas_category_big (category_big_id, name, descr) VALUES ");
		sql.append("(?, ?, ?)");
		Object [] paramsValue =StringUtil.reflectValue(basCategoryBig);
		super.update(sql, paramsValue);
	}

	@Override
	public void delete(String categoryBigId) {
		StringBuffer sql = new StringBuffer("DELETE FROM bas_category_big WHERE category_big_id = ?");
		Object [] paramsValue ={categoryBigId};
		super.update(sql, paramsValue);
	}

	@Override
	public void update(BasCategoryBig basCategoryBig) throws NoSuchMethodException, SecurityException, IllegalAccessException, IllegalArgumentException, InvocationTargetException {
		StringBuffer sql = new StringBuffer("UPDATE bas_category_big SET name=? , descr = ? WHERE category_big_id = ?");
		Object [] paramsValue =StringUtil.leftOne(StringUtil.reflectValue(basCategoryBig));
		super.update(sql, paramsValue);
		
	}

	@Override
	public List<BasCategoryBig> list() {
		StringBuffer sql = new StringBuffer("SELECT * FROM bas_category_big");
		Object [] paramsValue =null;
		return super.query(sql, paramsValue, BasCategoryBig.class);
	}

	@Override
	public List<BasCategoryBig> load(String categoryBigId) {
		StringBuffer sql = new StringBuffer("SELECT * FROM bas_category_big WHERE 1=1");
		sql.append(" AND category_big_id = ?");
		Object [] paramsValue ={categoryBigId};
		return super.query(sql, paramsValue, BasCategoryBig.class);
	}

	@Override
	public List<BasCategoryBig> pageResult(int pageIndex, int pageSize, BasCategoryBig basCategoryBig) throws NoSuchMethodException, SecurityException, IllegalAccessException, IllegalArgumentException, InvocationTargetException {
		StringBuffer sql = new StringBuffer("SELECT * FROM bas_category_big WHERE 1=1");
		Object [] paramsValue = StringUtil.reflectValue(basCategoryBig);
		Object [] paramsValueTrim =new Object[paramsValue.length];
		String [] sqlAppend ={" AND category_big_id LIKE ?"," AND name LIKE ?"," AND descr LIKE ?"};
		if (basCategoryBig!=null) {
			int valueIndex =0;
			for (int i = 0; i < paramsValue.length; i++) {
				if (!StringUtil.isEmpty(paramsValue[i])) {
					sql.append(sqlAppend[i]);
					paramsValueTrim[valueIndex] = "%"+paramsValue[i]+"%";
					valueIndex++;
				}
			}
		}
		sql.append(" order by category_big_id desc");
		sql.append(" limit " + pageIndex * pageSize + "," + pageSize);
		return super.query(sql, paramsValueTrim, BasCategoryBig.class);
	}

	@Override
	public int pageRowCount(BasCategoryBig basCategoryBig) throws NoSuchMethodException, SecurityException, IllegalAccessException, IllegalArgumentException, InvocationTargetException {
		StringBuffer sql = new StringBuffer("SELECT COUNT(category_big_id) FROM bas_category_big WHERE 1=1");
		Object [] paramsValue = StringUtil.reflectValue(basCategoryBig);
		Object [] paramsValueTrim =new Object[paramsValue.length];
		String [] sqlAppend ={" AND category_big_id LIKE ?"," AND name LIKE ?"," AND descr LIKE ?"};
		if (basCategoryBig!=null) {
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
	public Page pageList(int pageIndex, int pageSize, BasCategoryBig basCategoryBig) throws NoSuchMethodException, SecurityException, IllegalAccessException, IllegalArgumentException, InvocationTargetException {
		Page page = new Page();
		int rowCount =0;
		//获得 查询结果的行数
		rowCount = pageRowCount(basCategoryBig);
		int pageCount = (rowCount - 1) / pageSize + 1;

		if (pageIndex < 0) {
			pageIndex = 0;
		}

		if (pageIndex > pageCount) {
			pageIndex = pageCount;
		}
		//把查询到的 实体对象数组   存到  result 并作为属性 给  page对象
		List result = pageResult(pageIndex, pageSize,basCategoryBig);
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
	public void validateUnique4Code(BasCategoryBig basCategoryBig) throws NoSuchMethodException, SecurityException, IllegalAccessException, IllegalArgumentException, InvocationTargetException {
		StringBuffer sql = new StringBuffer("SELECT COUNT(category_big_id) FROM bas_category_big WHERE name = ?");
		Object [] paramsValueTrim ={basCategoryBig.getName()};
		int count =super.resultRowCount(sql, paramsValueTrim);
		if (count==1) {
			throw new ValidateException("名称重复:" + basCategoryBig.getName());
		}
	}

}
