package com.barter.share.bas.service.imp;

import java.lang.reflect.InvocationTargetException;
import java.util.List;

import com.barter.share.bas.dao.ISysRoleMenuDao;
import com.barter.share.bas.dao.imp.SysRoleMenuDao;
import com.barter.share.bas.entity.SysRoleMenu;
import com.barter.share.bas.service.ISysRoleMenuService;
import com.barter.share.bas.vo.SysRoleMenuVo;
import com.barter.share.framework.entity.Page;

public class SysRoleMenuService implements ISysRoleMenuService{
	ISysRoleMenuDao iSysRoleMenuDao = new SysRoleMenuDao();
	@Override
	public void insert(SysRoleMenu sysRoleMenu) throws NoSuchMethodException, SecurityException, IllegalAccessException,
			IllegalArgumentException, InvocationTargetException {
		iSysRoleMenuDao.insert(sysRoleMenu);
	}

	@Override
	public void delete(String roleMenuId) {
		iSysRoleMenuDao.delete(roleMenuId);
	}

	@Override
	public void update(SysRoleMenu sysRoleMenu) throws NoSuchMethodException, SecurityException, IllegalAccessException,
			IllegalArgumentException, InvocationTargetException {
		iSysRoleMenuDao.update(sysRoleMenu);
	}

	@Override
	public List<SysRoleMenu> list() {
		return iSysRoleMenuDao.list();
	}

	@Override
	public List<SysRoleMenu> load(String roleMenuId) {
		return iSysRoleMenuDao.load(roleMenuId);
	}

	@Override
	public Page pageList(int pageIndex, int pageSize, SysRoleMenuVo sysRoleMenuVo) throws NoSuchMethodException,
			SecurityException, IllegalAccessException, IllegalArgumentException, InvocationTargetException {
		return iSysRoleMenuDao.pageList(pageIndex, pageSize, sysRoleMenuVo);
	}

	@Override
	public void codeCheck(SysRoleMenu sysRoleMenu) throws NoSuchMethodException, SecurityException,
			IllegalAccessException, IllegalArgumentException, InvocationTargetException {
		iSysRoleMenuDao.validateUnique4Code(sysRoleMenu);
	}
	
}
