package com.barter.share.bas.service.imp;

import java.util.List;

import com.barter.share.bas.dao.IAdminLoginDao;
import com.barter.share.bas.dao.imp.AdminLoginDao;
import com.barter.share.bas.entity.SysEmployee;
import com.barter.share.bas.service.IAdminLoginService;

public class AdminLoginService implements IAdminLoginService {
	IAdminLoginDao iAdminLoginDao = new AdminLoginDao();
	@Override
	public List<SysEmployee> load(String code) {
		return iAdminLoginDao.load(code);
	}

}
