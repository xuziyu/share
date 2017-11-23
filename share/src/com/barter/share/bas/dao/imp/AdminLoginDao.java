package com.barter.share.bas.dao.imp;

import java.util.List;

import com.barter.share.bas.dao.IAdminLoginDao;
import com.barter.share.bas.entity.SysEmployee;
import com.barter.share.framework.dao.BaseDao;

public class AdminLoginDao extends BaseDao implements IAdminLoginDao {

	@Override
	public List<SysEmployee> load(String code) {
		StringBuffer sql = new StringBuffer("SELECT * FROM sys_employee WHERE code = ?");
		String [] paramsValue = {code};
		return query(sql, paramsValue, SysEmployee.class);
	}

}
