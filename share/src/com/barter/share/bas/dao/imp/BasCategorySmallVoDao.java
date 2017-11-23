package com.barter.share.bas.dao.imp;

import java.lang.reflect.InvocationTargetException;
import java.util.List;

import com.barter.share.bas.dao.IBasCategorySmallVoDao;
import com.barter.share.bas.vo.BasCategorySmallVo;
import com.barter.share.framework.dao.BaseDao;
import com.barter.share.framework.entity.Page;
import com.barter.share.framework.util.StringUtil;

public class BasCategorySmallVoDao extends BaseDao implements IBasCategorySmallVoDao {

	@Override
	public void insert(BasCategorySmallVo basCategorySmallVo) throws NoSuchMethodException, SecurityException,
			IllegalAccessException, IllegalArgumentException, InvocationTargetException {
		
	}

	@Override
	public void delete(String categorySmallId) {
		
	}

	@Override
	public void update(BasCategorySmallVo basCategorySmallVo) throws NoSuchMethodException, SecurityException,
			IllegalAccessException, IllegalArgumentException, InvocationTargetException {
		
	}

	@Override
	public List<BasCategorySmallVo> list() {
		return null;
	}

	@Override
	public List<BasCategorySmallVo> load(String categorySmallId) {
		return null;
	}

	@Override
	public List<BasCategorySmallVo> pageResult(int pageIndex, int pageSize, BasCategorySmallVo basCategorySmallVo)
			throws NoSuchMethodException, SecurityException, IllegalAccessException, IllegalArgumentException,
			InvocationTargetException {
		StringBuffer sql = new StringBuffer("SELECT bas_category_small.* , bas_category_big.name AS bas_category_big_name ");
		sql.append("FROM bas_category_small ");
		sql.append("INNER JOIN bas_category_big ");
		sql.append("ON bas_category_big.category_big_id = bas_category_small.category_big_id ");
		sql.append("WHERE 1 = 1");
		Object [] paramsValue = StringUtil.reflectValue(basCategorySmallVo);
		Object [] paramsValueTrim =new Object[paramsValue.length];
		String [] sqlAppend ={" AND bas_category_small.category_small_id LIKE ?"," AND bas_category_small.category_big_id LIKE ?"," AND bas_category_small.name LIKE ?"," AND bas_category_small.descr LIKE ?"," AND bas_category_big.name LIKE ?"};
		if (basCategorySmallVo!=null) {
			int valueIndex =0;
			for (int i = 0; i < paramsValue.length; i++) {
				if (!StringUtil.isEmpty(paramsValue[i])) {
					sql.append(sqlAppend[i]);
					paramsValueTrim[valueIndex] = "%"+paramsValue[i]+"%";
					valueIndex++;
				}
			}
		}
		sql.append(" order by bas_category_small.category_small_id desc");
		sql.append(" limit " + pageIndex * pageSize + "," + pageSize);
		return super.query(sql, paramsValueTrim, BasCategorySmallVo.class);
	}

	@Override
	public int pageRowCount(BasCategorySmallVo basCategorySmallVo) throws NoSuchMethodException, SecurityException,
			IllegalAccessException, IllegalArgumentException, InvocationTargetException {
		StringBuffer sql = new StringBuffer("SELECT COUNT(bas_category_small.category_small_id) ");
		sql.append("FROM bas_category_small ");
		sql.append("INNER JOIN bas_category_big ");
		sql.append("ON bas_category_big.category_big_id = bas_category_small.category_big_id ");
		sql.append("WHERE 1 = 1");
		Object [] paramsValue = StringUtil.reflectValue(basCategorySmallVo);
		Object [] paramsValueTrim =new Object[paramsValue.length];
		String [] sqlAppend ={" AND bas_category_small.category_small_id LIKE ?"," AND bas_category_small.category_big_id LIKE ?"," AND bas_category_small.name LIKE ?"," AND bas_category_small.descr LIKE ?"," AND bas_category_big.name LIKE ?"};
		if (basCategorySmallVo!=null) {
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
	public Page pageList(int pageIndex, int pageSize, BasCategorySmallVo basCategorySmallVo)
			throws NoSuchMethodException, SecurityException, IllegalAccessException, IllegalArgumentException,
			InvocationTargetException {
		Page page = new Page();
		int rowCount =0;
		//获得 查询结果的行数
		rowCount = pageRowCount(basCategorySmallVo);
		int pageCount = (rowCount - 1) / pageSize + 1;

		if (pageIndex < 0) {
			pageIndex = 0;
		}

		if (pageIndex > pageCount) {
			pageIndex = pageCount;
		}
		//把查询到的 实体对象数组   存到  result 并作为属性 给  page对象
		List result = pageResult(pageIndex, pageSize,basCategorySmallVo);
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
	public void validateUnique4Code(BasCategorySmallVo basCategorySmallVo) throws NoSuchMethodException,
			SecurityException, IllegalAccessException, IllegalArgumentException, InvocationTargetException {
		
	}

}
