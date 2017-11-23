package com.barter.share.bas.dao;

import java.lang.reflect.InvocationTargetException;
import java.util.List;

import com.barter.share.bas.entity.SysOrganization;
import com.barter.share.bas.vo.SysOrganizationVo;
import com.barter.share.framework.entity.Page;

public interface ISysOrganizationDao {
	public void insert(SysOrganization sysOrganization) throws NoSuchMethodException, SecurityException, IllegalAccessException, IllegalArgumentException, InvocationTargetException;
	public void delete(String organizationId);
	public void update(SysOrganization sysOrganization) throws NoSuchMethodException, SecurityException, IllegalAccessException, IllegalArgumentException, InvocationTargetException;
	public List<SysOrganization> list();
	public List<SysOrganization> load(String organizationId);
	public List<SysOrganizationVo> pageResult(int pageIndex, int pageSize, SysOrganizationVo sysOrganizationVo) throws NoSuchMethodException, SecurityException, IllegalAccessException, IllegalArgumentException, InvocationTargetException;
	public int pageRowCount(SysOrganizationVo sysOrganizationVo) throws NoSuchMethodException, SecurityException, IllegalAccessException, IllegalArgumentException, InvocationTargetException;
	public Page pageList(int pageIndex, int pageSize, SysOrganizationVo sysOrganizationVo) throws NoSuchMethodException, SecurityException, IllegalAccessException, IllegalArgumentException, InvocationTargetException;
	public void validateUnique4Code(SysOrganization sysOrganization) throws NoSuchMethodException, SecurityException, IllegalAccessException, IllegalArgumentException, InvocationTargetException;
}
