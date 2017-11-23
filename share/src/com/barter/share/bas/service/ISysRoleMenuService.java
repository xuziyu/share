package com.barter.share.bas.service;

import java.lang.reflect.InvocationTargetException;
import java.util.List;

import com.barter.share.bas.entity.SysRoleMenu;
import com.barter.share.bas.vo.SysRoleMenuVo;
import com.barter.share.framework.entity.Page;

public interface ISysRoleMenuService {
	public void insert(SysRoleMenu sysRoleMenu) throws NoSuchMethodException, SecurityException, IllegalAccessException, IllegalArgumentException, InvocationTargetException;
	public void delete(String roleMenuId);
	public void update(SysRoleMenu sysRoleMenu) throws NoSuchMethodException, SecurityException, IllegalAccessException, IllegalArgumentException, InvocationTargetException;
	public List<SysRoleMenu> list();
	public List<SysRoleMenu> load(String roleMenuId);
	public Page pageList(int pageIndex, int pageSize, SysRoleMenuVo sysRoleMenuVo) throws NoSuchMethodException, SecurityException, IllegalAccessException, IllegalArgumentException, InvocationTargetException;
	public void codeCheck(SysRoleMenu sysRoleMenu) throws NoSuchMethodException, SecurityException, IllegalAccessException, IllegalArgumentException, InvocationTargetException;
}
