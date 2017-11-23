package com.barter.share.bas.service.imp;

import java.lang.reflect.InvocationTargetException;
import java.util.List;

import com.barter.share.bas.dao.ISysOrganizationDao;
import com.barter.share.bas.dao.imp.SysOrganizationDao;
import com.barter.share.bas.entity.SysOrganization;
import com.barter.share.bas.service.ISysOrganizationService;
import com.barter.share.bas.vo.SysOrganizationVo;
import com.barter.share.framework.entity.Page;

public class SysOrganizationService implements ISysOrganizationService {
	ISysOrganizationDao iSysOrganizationDao = new SysOrganizationDao();
	@Override
	public void insert(SysOrganization sysOrganization) throws NoSuchMethodException, SecurityException,
			IllegalAccessException, IllegalArgumentException, InvocationTargetException {
		iSysOrganizationDao.insert(sysOrganization);
	}

	@Override
	public void delete(String organizationId) {
		iSysOrganizationDao.delete(organizationId);
	}

	@Override
	public void update(SysOrganization sysOrganization) throws NoSuchMethodException, SecurityException,
			IllegalAccessException, IllegalArgumentException, InvocationTargetException {
		iSysOrganizationDao.update(sysOrganization);
	}

	@Override
	public List<SysOrganization> list() {
		return iSysOrganizationDao.list();
	}

	@Override
	public List<SysOrganization> load(String organizationId) {
		return iSysOrganizationDao.load(organizationId);
	}

	@Override
	public Page pageList(int pageIndex, int pageSize, SysOrganizationVo sysOrganizationVo) throws NoSuchMethodException,
			SecurityException, IllegalAccessException, IllegalArgumentException, InvocationTargetException {
		return iSysOrganizationDao.pageList(pageIndex, pageSize, sysOrganizationVo);
	}

	@Override
	public void codeCheck(SysOrganization sysOrganization) throws NoSuchMethodException, SecurityException,
			IllegalAccessException, IllegalArgumentException, InvocationTargetException {
		iSysOrganizationDao.validateUnique4Code(sysOrganization);
	}

}
