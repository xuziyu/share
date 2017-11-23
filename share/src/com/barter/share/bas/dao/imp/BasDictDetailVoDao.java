package com.barter.share.bas.dao.imp;

import java.lang.reflect.InvocationTargetException;
import java.util.List;

import com.barter.share.bas.dao.IBasDictDetailVoDao;
import com.barter.share.bas.vo.BasDictDetailVo;
import com.barter.share.framework.dao.BaseDao;
import com.barter.share.framework.entity.Page;
import com.barter.share.framework.util.StringUtil;

public class BasDictDetailVoDao extends BaseDao implements IBasDictDetailVoDao {

	@Override
	public void insert(BasDictDetailVo basDictDetailVo) throws NoSuchMethodException, SecurityException,
			IllegalAccessException, IllegalArgumentException, InvocationTargetException {
		
	}

	@Override
	public void delete(String dictDetailId) {
		
	}

	@Override
	public void update(BasDictDetailVo basDictDetailVo) throws NoSuchMethodException, SecurityException,
			IllegalAccessException, IllegalArgumentException, InvocationTargetException {
		
	}

	@Override
	public List<BasDictDetailVo> list() {
		return null;
	}

	@Override
	public List<BasDictDetailVo> load(String dictDetailId) {
		return null;
	}

	@Override
	public List<BasDictDetailVo> pageResult(int pageIndex, int pageSize, BasDictDetailVo basDictDetailVo)
			throws NoSuchMethodException, SecurityException, IllegalAccessException, IllegalArgumentException,
			InvocationTargetException {
		StringBuffer sql = new StringBuffer("SELECT bas_dict_detail.* , bas_dict.dict_code AS dict_code ");
		sql.append("FROM bas_dict_detail ");
		sql.append("INNER JOIN bas_dict ");
		sql.append("ON bas_dict.dict_id = bas_dict_detail.dict_id ");
		sql.append("WHERE 1 = 1");
		Object [] paramsValue = StringUtil.reflectValue(basDictDetailVo);
		Object [] paramsValueTrim =new Object[paramsValue.length];
		String [] sqlAppend ={" and bas_dict_detail.dict_id like ?"," and bas_dict_detail.option_code like ?",
				" and bas_dict_detail.option_label like ?",
				" and bas_dict_detail.seq_num like ?"," and bas_dict.dict_code like ?"};
		if (basDictDetailVo!=null) {
			int valueIndex =0;
			for (int i = 0; i < paramsValue.length; i++) {
				if (!StringUtil.isEmpty(paramsValue[i])) {
					sql.append(sqlAppend[i]);
					paramsValueTrim[valueIndex] = "%"+paramsValue[i]+"%";
					valueIndex++;
				}
			}
		}
		sql.append(" order by bas_dict_detail.dict_id desc");
		sql.append(" limit " + pageIndex * pageSize + "," + pageSize);
		return super.query(sql, paramsValueTrim, BasDictDetailVo.class);
	}

	@Override
	public int pageRowCount(BasDictDetailVo basDictDetailVo) throws NoSuchMethodException, SecurityException,
			IllegalAccessException, IllegalArgumentException, InvocationTargetException {
		StringBuffer sql = new StringBuffer("SELECT COUNT(bas_dict_detail.dict_id) ");
		sql.append("FROM bas_dict_detail ");
		sql.append("INNER JOIN bas_dict ");
		sql.append("ON bas_dict.dict_id = bas_dict_detail.dict_id ");
		sql.append("WHERE 1 = 1");
		Object [] paramsValue = StringUtil.reflectValue(basDictDetailVo);
		Object [] paramsValueTrim =new Object[paramsValue.length];
		String [] sqlAppend ={" and bas_dict_detail.dict_id like ?"," and bas_dict_detail.option_code like ?",
				" and bas_dict_detail.option_label like ?",
				" and bas_dict_detail.seq_num like ?"," and bas_dict.dict_code like ?"};
		if (basDictDetailVo!=null) {
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
	public Page pageList(int pageIndex, int pageSize, BasDictDetailVo basDictDetailVo) throws NoSuchMethodException,
			SecurityException, IllegalAccessException, IllegalArgumentException, InvocationTargetException {
		Page page = new Page();
		int rowCount =0;
		//获得 查询结果的行数
		rowCount = pageRowCount(basDictDetailVo);
		int pageCount = (rowCount - 1) / pageSize + 1;

		if (pageIndex < 0) {
			pageIndex = 0;
		}

		if (pageIndex > pageCount) {
			pageIndex = pageCount;
		}
		//把查询到的 实体对象数组   存到  result 并作为属性 给  page对象
		List result = pageResult(pageIndex, pageSize,basDictDetailVo);
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
	public void validateUnique4Code(BasDictDetailVo basDictDetailVo) throws NoSuchMethodException, SecurityException,
			IllegalAccessException, IllegalArgumentException, InvocationTargetException {
		
	}

}
