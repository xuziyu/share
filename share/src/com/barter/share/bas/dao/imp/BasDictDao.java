package com.barter.share.bas.dao.imp;

import java.lang.reflect.InvocationTargetException;
import java.util.List;

import com.barter.share.bas.dao.IBasDictDao;
import com.barter.share.bas.entity.BasDict;
import com.barter.share.framework.dao.BaseDao;
import com.barter.share.framework.entity.Page;
import com.barter.share.framework.exception.ValidateException;
import com.barter.share.framework.util.StringUtil;

public class BasDictDao extends BaseDao implements IBasDictDao {

	@Override
	public void insert(BasDict basDict) throws NoSuchMethodException, SecurityException, IllegalAccessException,
			IllegalArgumentException, InvocationTargetException {
		StringBuffer sql = new StringBuffer("INSERT INTO bas_dict (dict_id, dict_code, dict_label) VALUES ");
		sql.append("(?, ?, ?)");
		Object [] paramsValue =StringUtil.reflectValue(basDict);
		super.update(sql, paramsValue);
	}

	@Override
	public void delete(String dictId) {
		StringBuffer sql = new StringBuffer("DELETE FROM bas_dict WHERE dict_id = ?");
		Object [] paramsValue ={dictId};
		super.update(sql, paramsValue);
	}

	@Override
	public void update(BasDict basDict) throws NoSuchMethodException, SecurityException, IllegalAccessException,
			IllegalArgumentException, InvocationTargetException {
		StringBuffer sql = new StringBuffer("UPDATE bas_dict SET dict_code = ? , dict_label = ? WHERE dict_id = ?");
		Object [] paramsValue =StringUtil.leftOne(StringUtil.reflectValue(basDict));
		super.update(sql, paramsValue);
	}

	@Override
	public List<BasDict> list() {
		StringBuffer sql = new StringBuffer("SELECT * FROM bas_dict");
		Object [] paramsValue =null;
		return super.query(sql, paramsValue, BasDict.class);
	}

	@Override
	public List<BasDict> load(String dictId) {
		StringBuffer sql = new StringBuffer("SELECT * FROM bas_dict WHERE 1 = 1 AND dict_id = ?");
		Object [] paramsValue ={dictId};
		return super.query(sql, paramsValue, BasDict.class);
	}

	@Override
	public List<BasDict> pageResult(int pageIndex, int pageSize, BasDict basDict) throws NoSuchMethodException,
			SecurityException, IllegalAccessException, IllegalArgumentException, InvocationTargetException {
		StringBuffer sql = new StringBuffer("SELECT * FROM bas_dict WHERE 1 = 1");
		Object [] paramsValue = StringUtil.reflectValue(basDict);
		Object [] paramsValueTrim =new Object[paramsValue.length];
		String [] sqlAppend ={" AND dict_id LIKE ?"," AND dict_code LIKE ?"," AND dict_label LIKE ?"};
		if (basDict!=null) {
			int valueIndex =0;
			for (int i = 0; i < paramsValue.length; i++) {
				if (!StringUtil.isEmpty(paramsValue[i])) {
					sql.append(sqlAppend[i]);
					paramsValueTrim[valueIndex] = "%"+paramsValue[i]+"%";
					valueIndex++;
				}
			}
		}
		sql.append(" order by dict_code asc");
		sql.append(" limit " + pageIndex * pageSize + "," + pageSize);
		return super.query(sql, paramsValueTrim, BasDict.class);
	}

	@Override
	public int pageRowCount(BasDict basDict) throws NoSuchMethodException, SecurityException, IllegalAccessException,
			IllegalArgumentException, InvocationTargetException {
		StringBuffer sql = new StringBuffer("SELECT COUNT(dict_id) FROM bas_dict WHERE 1 = 1");
		Object [] paramsValue = StringUtil.reflectValue(basDict);
		Object [] paramsValueTrim =new Object[paramsValue.length];
		String [] sqlAppend ={" AND dict_id LIKE ?"," AND dict_code LIKE ?"," AND dict_label LIKE ?"};
		if (basDict!=null) {
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
	public Page pageList(int pageIndex, int pageSize, BasDict basDict) throws NoSuchMethodException, SecurityException,
			IllegalAccessException, IllegalArgumentException, InvocationTargetException {
		Page page = new Page();
		int rowCount =0;
		//获得 查询结果的行数
		rowCount = pageRowCount(basDict);
		int pageCount = (rowCount - 1) / pageSize + 1;

		if (pageIndex < 0) {
			pageIndex = 0;
		}

		if (pageIndex > pageCount) {
			pageIndex = pageCount;
		}
		//把查询到的 实体对象数组   存到  result 并作为属性 给  page对象
		List result = pageResult(pageIndex, pageSize,basDict);
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
	public void validateUnique4Code(BasDict basDict) throws NoSuchMethodException, SecurityException,
			IllegalAccessException, IllegalArgumentException, InvocationTargetException {
		StringBuffer sql = new StringBuffer("SELECT COUNT(dict_id) FROM bas_dict WHERE dict_code = ?");
		String [] paramsValue = {basDict.getDictCode()};
		int count =super.resultRowCount(sql, paramsValue);
		if (count==1) {
			throw new ValidateException("编号重复:" + basDict.getDictCode());
		}
	}

}
