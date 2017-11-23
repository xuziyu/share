package com.barter.share.bas.service.imp;

import java.lang.reflect.InvocationTargetException;
import java.util.List;

import com.barter.share.bas.dao.ISysModuleDao;
import com.barter.share.bas.dao.imp.SysModuleDao;
import com.barter.share.bas.entity.SysModule;
import com.barter.share.bas.service.ISysModuleService;
import com.barter.share.framework.entity.Page;

public class SysModuleService implements ISysModuleService {
	ISysModuleDao iSysModuleDao = new SysModuleDao();
	@Override
	public void insert(SysModule sysModule) throws NoSuchMethodException, SecurityException, IllegalAccessException,
			IllegalArgumentException, InvocationTargetException {
		iSysModuleDao.insert(sysModule);
	}

	@Override
	public void delete(String moduleId) {
		iSysModuleDao.delete(moduleId);
	}

	@Override
	public void update(SysModule sysModule) throws NoSuchMethodException, SecurityException, IllegalAccessException,
			IllegalArgumentException, InvocationTargetException {
		iSysModuleDao.update(sysModule);
	}

	@Override
	public List<SysModule> list() {
		return iSysModuleDao.list();
	}

	@Override
	public List<SysModule> load(String moduleId) {
		return iSysModuleDao.load(moduleId);
	}

	@Override
	public Page pageList(int pageIndex, int pageSize, SysModule sysModule) throws NoSuchMethodException,
			SecurityException, IllegalAccessException, IllegalArgumentException, InvocationTargetException {
		return iSysModuleDao.pageList(pageIndex, pageSize, sysModule);
	}

	@Override
	public void codeCheck(SysModule sysModule) throws NoSuchMethodException, SecurityException, IllegalAccessException,
			IllegalArgumentException, InvocationTargetException {
		iSysModuleDao.validateUnique4Code(sysModule);
	}

}
