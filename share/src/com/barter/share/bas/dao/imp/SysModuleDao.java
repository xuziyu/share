package com.barter.share.bas.dao.imp;

import java.lang.reflect.InvocationTargetException;
import java.util.List;

import com.barter.share.bas.dao.ISysModuleDao;
import com.barter.share.bas.entity.SysModule;
import com.barter.share.framework.dao.BaseDao;
import com.barter.share.framework.entity.Page;
import com.barter.share.framework.exception.ValidateException;
import com.barter.share.framework.util.StringUtil;

public class SysModuleDao extends BaseDao implements ISysModuleDao {

	@Override
	public void insert(SysModule sysModule) throws NoSuchMethodException, SecurityException, IllegalAccessException,
			IllegalArgumentException, InvocationTargetException {
		StringBuffer sql = new StringBuffer("INSERT INTO sys_module (module_id, code, name, enabled) VALUES (?, ?, ?, ?)");
		Object [] paramsValue =StringUtil.reflectValue(sysModule);
		super.update(sql, paramsValue);
	}

	@Override
	public void delete(String moduleId) {
		StringBuffer sql = new StringBuffer("DELETE FROM sys_module WHERE module_id = ?");
		Object [] paramsValue ={moduleId};
		super.update(sql, paramsValue);
	}

	@Override
	public void update(SysModule sysModule) throws NoSuchMethodException, SecurityException, IllegalAccessException,
			IllegalArgumentException, InvocationTargetException {
		StringBuffer sql = new StringBuffer("UPDATE sys_module SET code = ? , name = ? , enabled = ? WHERE module_id = ?");
		Object [] paramsValue =StringUtil.leftOne(StringUtil.reflectValue(sysModule));
		super.update(sql, paramsValue);
	}

	@Override
	public List<SysModule> list() {
		StringBuffer sql = new StringBuffer("SELECT * FROM sys_module");
		Object [] paramsValue =null;
		return super.query(sql, paramsValue, SysModule.class);
	}

	@Override
	public List<SysModule> load(String moduleId) {
		StringBuffer sql = new StringBuffer("SELECT * FROM sys_module WHERE 1 = 1 AND module_id = ?");
		Object [] paramsValue ={moduleId};
		return super.query(sql, paramsValue, SysModule.class);
	}

	@Override
	public List<SysModule> pageResult(int pageIndex, int pageSize, SysModule sysModule) throws NoSuchMethodException,
			SecurityException, IllegalAccessException, IllegalArgumentException, InvocationTargetException {
		StringBuffer sql = new StringBuffer("SELECT * FROM sys_module WHERE 1 = 1");
		Object [] paramsValue = StringUtil.reflectValue(sysModule);
		Object [] paramsValueTrim =new Object[paramsValue.length];
		String [] sqlAppend ={" AND module_id like ?"," and code like ?"," and name like ?"," and enabled LIKE ?"};
		if (sysModule!=null) {
			int valueIndex =0;
			for (int i = 0; i < paramsValue.length; i++) {
				if (!StringUtil.isEmpty(paramsValue[i])) {
					sql.append(sqlAppend[i]);
					paramsValueTrim[valueIndex] = "%"+paramsValue[i]+"%";
					valueIndex++;
				}
			}
		}
		sql.append(" order by module_id desc");
		sql.append(" limit " + pageIndex * pageSize + "," + pageSize);
		return super.query(sql, paramsValueTrim, SysModule.class);
	}

	@Override
	public int pageRowCount(SysModule sysModule) throws NoSuchMethodException, SecurityException,
			IllegalAccessException, IllegalArgumentException, InvocationTargetException {
		StringBuffer sql = new StringBuffer("SELECT COUNT(module_id) FROM sys_module WHERE 1 = 1");
		Object [] paramsValue = StringUtil.reflectValue(sysModule);
		Object [] paramsValueTrim =new Object[paramsValue.length];
		String [] sqlAppend ={" AND module_id like ?"," and code like ?"," and name like ?"," and enabled LIKE ?"};
		if (sysModule!=null) {
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
	public Page pageList(int pageIndex, int pageSize, SysModule sysModule) throws NoSuchMethodException,
			SecurityException, IllegalAccessException, IllegalArgumentException, InvocationTargetException {
		Page page = new Page();
		int rowCount =0;
		//获得 查询结果的行数
		rowCount = pageRowCount(sysModule);
		int pageCount = (rowCount - 1) / pageSize + 1;

		if (pageIndex < 0) {
			pageIndex = 0;
		}

		if (pageIndex > pageCount) {
			pageIndex = pageCount;
		}
		//把查询到的 实体对象数组   存到  result 并作为属性 给  page对象
		List result = pageResult(pageIndex, pageSize,sysModule);
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
	public void validateUnique4Code(SysModule sysModule) throws NoSuchMethodException, SecurityException,
			IllegalAccessException, IllegalArgumentException, InvocationTargetException {
		StringBuffer sql = new StringBuffer("SELECT COUNT(module_id) FROM sys_module WHERE code = ?");
		Object [] paramsValueTrim ={sysModule.getCode()};
		int count =super.resultRowCount(sql, paramsValueTrim);
		if (count==1) {
			throw new ValidateException("编码重复:" + sysModule.getCode());
		}
	}

}
