package com.barter.share.bas.dao.imp;

import java.lang.reflect.InvocationTargetException;
import java.util.List;

import com.barter.share.bas.dao.ISysRoleDao;
import com.barter.share.bas.entity.SysRole;
import com.barter.share.framework.dao.BaseDao;
import com.barter.share.framework.entity.Page;
import com.barter.share.framework.exception.ValidateException;
import com.barter.share.framework.util.StringUtil;

public class SysRoleDao extends BaseDao implements ISysRoleDao {

	@Override
	public void insert(SysRole sysRole) throws NoSuchMethodException, SecurityException, IllegalAccessException,
			IllegalArgumentException, InvocationTargetException {
		StringBuffer sql = new StringBuffer("INSERT INTO sys_role (role_id, name) VALUES (?, ?)");
		Object [] paramsValue =StringUtil.reflectValue(sysRole);
		super.update(sql, paramsValue);
	}

	@Override
	public void delete(String roleId) {
		StringBuffer sql = new StringBuffer("DELETE FROM sys_role WHERE role_id = ?");
		Object [] paramsValue ={roleId};
		super.update(sql, paramsValue);
	}

	@Override
	public void update(SysRole sysRole) throws NoSuchMethodException, SecurityException, IllegalAccessException,
			IllegalArgumentException, InvocationTargetException {
		StringBuffer sql = new StringBuffer("UPDATE sys_role SET name = ? WHERE role_id = ?");
		Object [] paramsValue =StringUtil.leftOne(StringUtil.reflectValue(sysRole));
		super.update(sql, paramsValue);
	}

	@Override
	public List<SysRole> list() {
		StringBuffer sql = new StringBuffer("SELECT * FROM sys_role");
		Object [] paramsValue =null;
		return super.query(sql, paramsValue, SysRole.class);
	}

	@Override
	public List<SysRole> load(String roleId) {
		StringBuffer sql = new StringBuffer("SELECT * FROM sys_role WHERE 1 = 1 AND role_id = ?");
		Object [] paramsValue ={roleId};
		return super.query(sql, paramsValue, SysRole.class);
	}

	@Override
	public List<SysRole> pageResult(int pageIndex, int pageSize, SysRole sysRole) throws NoSuchMethodException,
			SecurityException, IllegalAccessException, IllegalArgumentException, InvocationTargetException {
		StringBuffer sql = new StringBuffer("SELECT * FROM sys_role WHERE 1 = 1");
		Object [] paramsValue = StringUtil.reflectValue(sysRole);
		Object [] paramsValueTrim =new Object[paramsValue.length];
		String [] sqlAppend ={" AND role_id like ?"," AND name LIKE ?"};
		if (sysRole!=null) {
			int valueIndex =0;
			for (int i = 0; i < paramsValue.length; i++) {
				if (!StringUtil.isEmpty(paramsValue[i])) {
					sql.append(sqlAppend[i]);
					paramsValueTrim[valueIndex] = "%"+paramsValue[i]+"%";
					valueIndex++;
				}
			}
		}
		sql.append(" order by role_id desc");
		sql.append(" limit " + pageIndex * pageSize + "," + pageSize);
		return super.query(sql, paramsValueTrim, SysRole.class);
	}

	@Override
	public int pageRowCount(SysRole sysRole) throws NoSuchMethodException, SecurityException, IllegalAccessException,
			IllegalArgumentException, InvocationTargetException {
		StringBuffer sql = new StringBuffer("SELECT COUNT(role_id) FROM sys_role WHERE 1 = 1");
		Object [] paramsValue = StringUtil.reflectValue(sysRole);
		Object [] paramsValueTrim =new Object[paramsValue.length];
		String [] sqlAppend ={" AND role_id like ?"," AND name LIKE ?"};
		if (sysRole!=null) {
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
	public Page pageList(int pageIndex, int pageSize, SysRole sysRole) throws NoSuchMethodException, SecurityException,
			IllegalAccessException, IllegalArgumentException, InvocationTargetException {
		Page page = new Page();
		int rowCount =0;
		//获得 查询结果的行数
		rowCount = pageRowCount(sysRole);
		int pageCount = (rowCount - 1) / pageSize + 1;

		if (pageIndex < 0) {
			pageIndex = 0;
		}

		if (pageIndex > pageCount) {
			pageIndex = pageCount;
		}
		//把查询到的 实体对象数组   存到  result 并作为属性 给  page对象
		List result = pageResult(pageIndex, pageSize,sysRole);
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
	public void validateUnique4Code(SysRole sysRole) throws NoSuchMethodException, SecurityException,
			IllegalAccessException, IllegalArgumentException, InvocationTargetException {
		StringBuffer sql = new StringBuffer("SELECT COUNT(role_id) FROM sys_role WHERE name = ?");
		Object [] paramsValueTrim ={sysRole.getName()};
		int count =super.resultRowCount(sql, paramsValueTrim);
		if (count==1) {
			throw new ValidateException("名称重复:" + sysRole.getName());
		}
	}

}
