package com.barter.share.bas.service;

import java.lang.reflect.InvocationTargetException;
import java.util.List;

import com.barter.share.bas.entity.SysOrganization;
import com.barter.share.bas.vo.SysOrganizationVo;
import com.barter.share.framework.entity.Page;

public interface ISysOrganizationService {
	public void insert(SysOrganization sysOrganization) throws NoSuchMethodException, SecurityException, IllegalAccessException, IllegalArgumentException, InvocationTargetException;
	public void delete(String organizationId);
	public void update(SysOrganization sysOrganization) throws NoSuchMethodException, SecurityException, IllegalAccessException, IllegalArgumentException, InvocationTargetException;
	public List<SysOrganization> list();
	public List<SysOrganization> load(String organizationId);
	public Page pageList(int pageIndex, int pageSize, SysOrganizationVo sysOrganizationVo) throws NoSuchMethodException, SecurityException, IllegalAccessException, IllegalArgumentException, InvocationTargetException;
	public void codeCheck(SysOrganization sysOrganization) throws NoSuchMethodException, SecurityException, IllegalAccessException, IllegalArgumentException, InvocationTargetException;
}
