package com.barter.share.bas.dao.imp;

import java.lang.reflect.InvocationTargetException;
import java.util.List;

import com.barter.share.bas.dao.IBasDictDetailDao;
import com.barter.share.bas.entity.BasDictDetail;
import com.barter.share.framework.dao.BaseDao;
import com.barter.share.framework.entity.Page;
import com.barter.share.framework.exception.ValidateException;
import com.barter.share.framework.util.StringUtil;

public class BasDictDetailDao extends BaseDao implements IBasDictDetailDao {

	@Override
	public void insert(BasDictDetail basDictDetail) throws NoSuchMethodException, SecurityException,
			IllegalAccessException, IllegalArgumentException, InvocationTargetException {
		StringBuffer sql = new StringBuffer("INSERT INTO bas_dict_detail (dict_detail_id, dict_id, option_code, option_label, seq_num) VALUES ");
		sql.append("(?, ?, ?, ?, ?)");
		Object [] paramsValue =StringUtil.reflectValue(basDictDetail);
		super.update(sql, paramsValue);
	}

	@Override
	public void delete(String dictDetailId) {
		StringBuffer sql = new StringBuffer("DELETE FROM bas_dict_detail WHERE dict_detail_id = ?");
		Object [] paramsValue ={dictDetailId};
		super.update(sql, paramsValue);
	}

	@Override
	public void update(BasDictDetail basDictDetail) throws NoSuchMethodException, SecurityException,
			IllegalAccessException, IllegalArgumentException, InvocationTargetException {
		StringBuffer sql = new StringBuffer("UPDATE bas_dict_detail SET dict_id = ? ,option_code = ? ,option_label = ? ,seq_num  = ? WHERE dict_detail_id = ?");
		Object [] paramsValue =StringUtil.leftOne(StringUtil.reflectValue(basDictDetail));
		super.update(sql, paramsValue);
	}

	@Override
	public List<BasDictDetail> list() {
		StringBuffer sql = new StringBuffer("SELECT * FROM bas_dict_detail");
		Object [] paramsValue =null;
		return super.query(sql, paramsValue, BasDictDetail.class);
	}

	@Override
	public List<BasDictDetail> load(String dictDetailId) {
		StringBuffer sql = new StringBuffer("SELECT * FROM bas_dict_detail WHERE 1 = 1 AND dict_detail_id = ?");
		Object [] paramsValue ={dictDetailId};
		return super.query(sql, paramsValue, BasDictDetail.class);
	}

	@Override
	public List<BasDictDetail> pageResult(int pageIndex, int pageSize, BasDictDetail basDictDetail)
			throws NoSuchMethodException, SecurityException, IllegalAccessException, IllegalArgumentException,
			InvocationTargetException {
		StringBuffer sql = new StringBuffer("SELECT * FROM bas_dict_detail WHERE 1 = 1");
		Object [] paramsValue = StringUtil.reflectValue(basDictDetail);
		Object [] paramsValueTrim =new Object[paramsValue.length];
		String [] sqlAppend ={" and dict_detail_id like ?"," and dict_id like ?"," and option_code like ?"," and option_label like ?"," and seq_num like ?"};
		if (basDictDetail!=null) {
			int valueIndex =0;
			for (int i = 0; i < paramsValue.length; i++) {
				if (!StringUtil.isEmpty(paramsValue[i])) {
					sql.append(sqlAppend[i]);
					paramsValueTrim[valueIndex] = "%"+paramsValue[i]+"%";
					valueIndex++;
				}
			}
		}
		sql.append(" order by option_code asc");
		sql.append(" limit " + pageIndex * pageSize + "," + pageSize);
		return super.query(sql, paramsValueTrim, BasDictDetail.class);
	}

	@Override
	public int pageRowCount(BasDictDetail basDictDetail) throws NoSuchMethodException, SecurityException,
			IllegalAccessException, IllegalArgumentException, InvocationTargetException {
		StringBuffer sql = new StringBuffer("SELECT COUNT(dict_detail_id) FROM bas_dict_detail WHERE 1 = 1");
		Object [] paramsValue = StringUtil.reflectValue(basDictDetail);
		Object [] paramsValueTrim =new Object[paramsValue.length];
		String [] sqlAppend ={" and dict_detail_id like ?"," and dict_id like ?"," and option_code like ?"," and option_label like ?"," and seq_num like ?"};
		if (basDictDetail!=null) {
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
	public Page pageList(int pageIndex, int pageSize, BasDictDetail basDictDetail) throws NoSuchMethodException,
			SecurityException, IllegalAccessException, IllegalArgumentException, InvocationTargetException {
		Page page = new Page();
		int rowCount =0;
		//获得 查询结果的行数
		rowCount = pageRowCount(basDictDetail);
		int pageCount = (rowCount - 1) / pageSize + 1;

		if (pageIndex < 0) {
			pageIndex = 0;
		}

		if (pageIndex > pageCount) {
			pageIndex = pageCount;
		}
		//把查询到的 实体对象数组   存到  result 并作为属性 给  page对象
		List result = pageResult(pageIndex, pageSize,basDictDetail);
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
	public void validateUnique4Code(BasDictDetail basDictDetail) throws NoSuchMethodException, SecurityException,
			IllegalAccessException, IllegalArgumentException, InvocationTargetException {
		StringBuffer sql = new StringBuffer("SELECT COUNT(dict_detail_id) FROM bas_dict_detail WHERE option_code = ?");
		String [] paramsValue = {basDictDetail.getOptionCode()};
		int count =super.resultRowCount(sql, null);
		if (count==1) {
			throw new ValidateException("编号重复:" + basDictDetail.getOptionCode());
		}
	}

}
