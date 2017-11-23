package com.barter.share.bas.service;

import java.lang.reflect.InvocationTargetException;
import java.util.List;

import com.barter.share.bas.entity.SysRole;
import com.barter.share.framework.entity.Page;

public interface ISysRoleService {
	public void insert(SysRole sysRole) throws NoSuchMethodException, SecurityException, IllegalAccessException, IllegalArgumentException, InvocationTargetException;
	public void delete(String roleId);
	public void update(SysRole sysRole) throws NoSuchMethodException, SecurityException, IllegalAccessException, IllegalArgumentException, InvocationTargetException;
	public List<SysRole> list();
	public List<SysRole> load(String roleId);
	public Page pageList(int pageIndex, int pageSize, SysRole sysRole) throws NoSuchMethodException, SecurityException, IllegalAccessException, IllegalArgumentException, InvocationTargetException;
	public void codeCheck(SysRole sysRole) throws NoSuchMethodException, SecurityException, IllegalAccessException, IllegalArgumentException, InvocationTargetException;
}
