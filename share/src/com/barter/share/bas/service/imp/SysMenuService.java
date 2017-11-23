package com.barter.share.bas.service.imp;

import java.lang.reflect.InvocationTargetException;
import java.util.List;

import com.barter.share.bas.dao.ISysMenuDao;
import com.barter.share.bas.dao.imp.SysMenuDao;
import com.barter.share.bas.entity.SysMenu;
import com.barter.share.bas.service.ISysMenuService;
import com.barter.share.bas.vo.SysMenuUrlVo;
import com.barter.share.bas.vo.SysMenuVo;
import com.barter.share.framework.entity.Page;

public class SysMenuService implements ISysMenuService {
	ISysMenuDao iSysMenuDao = new SysMenuDao();
	@Override
	public void insert(SysMenu sysMenu) throws NoSuchMethodException, SecurityException, IllegalAccessException,
			IllegalArgumentException, InvocationTargetException {
		iSysMenuDao.insert(sysMenu);
	}

	@Override
	public void delete(String menuId) {
		iSysMenuDao.delete(menuId);
	}

	@Override
	public void update(SysMenu sysMenu) throws NoSuchMethodException, SecurityException, IllegalAccessException,
			IllegalArgumentException, InvocationTargetException {
		iSysMenuDao.update(sysMenu);
	}

	@Override
	public List<SysMenu> list() {
		return iSysMenuDao.list();
	}

	@Override
	public List<SysMenu> load(String menuId) {
		return iSysMenuDao.load(menuId);
	}

	@Override
	public Page pageList(int pageIndex, int pageSize, SysMenuVo sysMenuVo) throws NoSuchMethodException,
			SecurityException, IllegalAccessException, IllegalArgumentException, InvocationTargetException {
		return iSysMenuDao.pageList(pageIndex, pageSize, sysMenuVo);
	}

	@Override
	public void codeCheck(SysMenu sysMenu) throws NoSuchMethodException, SecurityException, IllegalAccessException,
			IllegalArgumentException, InvocationTargetException {
		iSysMenuDao.validateUnique4Code(sysMenu);
	}

	@Override
	public List<SysMenuUrlVo> loadUrl(String employeeId) {
		return iSysMenuDao.loadUrl(employeeId);
	}
	
}
