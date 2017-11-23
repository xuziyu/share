package com.barter.share.bas.dao;

import java.lang.reflect.InvocationTargetException;
import java.util.List;

import com.barter.share.bas.entity.SysRoleMenu;
import com.barter.share.bas.vo.SysRoleMenuVo;
import com.barter.share.framework.entity.Page;

public interface ISysRoleMenuDao {
	public void insert(SysRoleMenu sysRoleMenu) throws NoSuchMethodException, SecurityException, IllegalAccessException, IllegalArgumentException, InvocationTargetException;
	public void delete(String roleMenuId);
	public void update(SysRoleMenu sysRoleMenu) throws NoSuchMethodException, SecurityException, IllegalAccessException, IllegalArgumentException, InvocationTargetException;
	public List<SysRoleMenu> list();
	public List<SysRoleMenu> load(String roleMenuId);
	public List<SysRoleMenuVo> pageResult(int pageIndex, int pageSize, SysRoleMenuVo sysRoleMenuVo) throws NoSuchMethodException, SecurityException, IllegalAccessException, IllegalArgumentException, InvocationTargetException;
	public int pageRowCount(SysRoleMenuVo sysRoleMenuVo) throws NoSuchMethodException, SecurityException, IllegalAccessException, IllegalArgumentException, InvocationTargetException;
	public Page pageList(int pageIndex, int pageSize, SysRoleMenuVo sysRoleMenuVo) throws NoSuchMethodException, SecurityException, IllegalAccessException, IllegalArgumentException, InvocationTargetException;
	public void validateUnique4Code(SysRoleMenu sysRoleMenu) throws NoSuchMethodException, SecurityException, IllegalAccessException, IllegalArgumentException, InvocationTargetException;
}
