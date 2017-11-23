package com.barter.share.bas.service.imp;

import java.lang.reflect.InvocationTargetException;
import java.util.List;

import com.barter.share.bas.dao.ISysRoleDao;
import com.barter.share.bas.dao.imp.SysRoleDao;
import com.barter.share.bas.entity.SysRole;
import com.barter.share.bas.service.ISysRoleService;
import com.barter.share.framework.entity.Page;

public class SysRoleService implements ISysRoleService {
	ISysRoleDao iSysRoleDao = new SysRoleDao();
	@Override
	public void insert(SysRole sysRole) throws NoSuchMethodException, SecurityException, IllegalAccessException,
			IllegalArgumentException, InvocationTargetException {
		iSysRoleDao.insert(sysRole);
	}

	@Override
	public void delete(String roleId) {
		iSysRoleDao.delete(roleId);
	}

	@Override
	public void update(SysRole sysRole) throws NoSuchMethodException, SecurityException, IllegalAccessException,
			IllegalArgumentException, InvocationTargetException {
		iSysRoleDao.update(sysRole);
	}

	@Override
	public List<SysRole> list() {
		return iSysRoleDao.list();
	}

	@Override
	public List<SysRole> load(String roleId) {
		return iSysRoleDao.load(roleId);
	}

	@Override
	public Page pageList(int pageIndex, int pageSize, SysRole sysRole) throws NoSuchMethodException, SecurityException,
			IllegalAccessException, IllegalArgumentException, InvocationTargetException {
		return iSysRoleDao.pageList(pageIndex, pageSize, sysRole);
	}

	@Override
	public void codeCheck(SysRole sysRole) throws NoSuchMethodException, SecurityException, IllegalAccessException,
			IllegalArgumentException, InvocationTargetException {
		iSysRoleDao.validateUnique4Code(sysRole);
	}

}
