package com.barter.share.bas.dao.imp;

import java.lang.reflect.InvocationTargetException;
import java.util.List;

import com.barter.share.bas.dao.IBasCategorySmallDao;
import com.barter.share.bas.entity.BasCategorySmall;
import com.barter.share.framework.dao.BaseDao;
import com.barter.share.framework.entity.Page;
import com.barter.share.framework.exception.ValidateException;
import com.barter.share.framework.util.StringUtil;

public class BasCategorySmallDao extends BaseDao implements IBasCategorySmallDao {

	@Override
	public void insert(BasCategorySmall basCategorySmall) throws NoSuchMethodException, SecurityException, IllegalAccessException, IllegalArgumentException, InvocationTargetException {
		StringBuffer sql = new StringBuffer("INSERT INTO bas_category_small (category_small_id, category_big_id, name, descr) VALUES ");
		sql.append("(?, ?, ?, ?)");
		Object [] paramsValue =StringUtil.reflectValue(basCategorySmall);
		super.update(sql, paramsValue);
	}

	@Override
	public void delete(String categorySmallId) {
		StringBuffer sql = new StringBuffer("DELETE FROM bas_category_small WHERE 1 = 1");
		sql.append(" AND category_small_id = ?");
		Object [] paramsValue ={categorySmallId};
		super.update(sql, paramsValue);
	}

	@Override
	public void update(BasCategorySmall basCategorySmall) throws NoSuchMethodException, SecurityException, IllegalAccessException, IllegalArgumentException, InvocationTargetException {
		StringBuffer sql = new StringBuffer("UPDATE bas_category_small SET category_big_id = ? ,name = ? ,descr = ? WHERE category_small_id = ?");
		Object [] paramsValue =StringUtil.leftOne(StringUtil.reflectValue(basCategorySmall));
		super.update(sql, paramsValue);
	}

	@Override
	public List<BasCategorySmall> list() {
		StringBuffer sql = new StringBuffer("SELECT * FROM bas_category_small");
		Object [] paramsValue =null;
		return super.query(sql, paramsValue, BasCategorySmall.class);
	}

	@Override
	public List<BasCategorySmall> load(String categorySmallId) {
		StringBuffer sql = new StringBuffer("SELECT * FROM bas_category_small WHERE 1=1");
		sql.append(" AND category_small_id = ?");
		Object [] paramsValue ={categorySmallId};
		return super.query(sql, paramsValue, BasCategorySmall.class);
	}

	@Override
	public List<BasCategorySmall> pageResult(int pageIndex, int pageSize, BasCategorySmall basCategorySmall) throws NoSuchMethodException, SecurityException, IllegalAccessException, IllegalArgumentException, InvocationTargetException {
		StringBuffer sql = new StringBuffer("SELECT * FROM bas_category_small WHERE 1=1");
		Object [] paramsValue = StringUtil.reflectValue(basCategorySmall);
		Object [] paramsValueTrim =new Object[paramsValue.length];
		String [] sqlAppend ={" AND category_small_id LIKE ?"," AND category_big_id LIKE ?"," AND name LIKE ?"," AND descr LIKE ?"};
		if (basCategorySmall!=null) {
			int valueIndex =0;
			for (int i = 0; i < paramsValue.length; i++) {
				if (!StringUtil.isEmpty(paramsValue[i])) {
					sql.append(sqlAppend[i]);
					paramsValueTrim[valueIndex] = "%"+paramsValue[i]+"%";
					valueIndex++;
				}
			}
		}
		sql.append(" order by category_small_id desc");
		sql.append(" limit " + pageIndex * pageSize + "," + pageSize);
		return super.query(sql, paramsValueTrim, BasCategorySmall.class);
	}

	@Override
	public int pageRowCount(BasCategorySmall basCategorySmall) throws NoSuchMethodException, SecurityException, IllegalAccessException, IllegalArgumentException, InvocationTargetException {
		StringBuffer sql = new StringBuffer("SELECT COUNT(category_small_id) FROM bas_category_small WHERE 1 = 1");
		Object [] paramsValue = StringUtil.reflectValue(basCategorySmall);
		Object [] paramsValueTrim =new Object[paramsValue.length];
		String [] sqlAppend ={" AND category_small_id LIKE ?"," AND category_big_id LIKE ?"," AND name LIKE ?"," AND descr LIKE ?"};
		if (basCategorySmall!=null) {
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
	public Page pageList(int pageIndex, int pageSize, BasCategorySmall basCategorySmall) throws NoSuchMethodException, SecurityException, IllegalAccessException, IllegalArgumentException, InvocationTargetException {
		Page page = new Page();
		int rowCount =0;
		//获得 查询结果的行数
		rowCount = pageRowCount(basCategorySmall);
		int pageCount = (rowCount - 1) / pageSize + 1;

		if (pageIndex < 0) {
			pageIndex = 0;
		}

		if (pageIndex > pageCount) {
			pageIndex = pageCount;
		}
		//把查询到的 实体对象数组   存到  result 并作为属性 给  page对象
		List result = pageResult(pageIndex, pageSize,basCategorySmall);
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
	public void validateUnique4Code(BasCategorySmall basCategorySmall) throws NoSuchMethodException, SecurityException, IllegalAccessException, IllegalArgumentException, InvocationTargetException {
		StringBuffer sql = new StringBuffer("SELECT COUNT(category_small_id) FROM bas_category_small WHERE name = ?");
		Object [] paramsValueTrim ={basCategorySmall.getName()};
		int count =super.resultRowCount(sql, paramsValueTrim);
		if (count==1) {
			throw new ValidateException("名字重复:" + basCategorySmall.getName());
		}
	}

}
