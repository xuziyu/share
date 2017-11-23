package com.barter.share.bas.dao;

import java.lang.reflect.InvocationTargetException;
import java.util.List;

import com.barter.share.bas.entity.SysMenu;
import com.barter.share.bas.vo.SysMenuUrlVo;
import com.barter.share.bas.vo.SysMenuVo;
import com.barter.share.framework.entity.Page;

public interface ISysMenuDao {
	public void insert(SysMenu sysMenu) throws NoSuchMethodException, SecurityException, IllegalAccessException, IllegalArgumentException, InvocationTargetException;
	public void delete(String menuId);
	public void update(SysMenu sysMenu) throws NoSuchMethodException, SecurityException, IllegalAccessException, IllegalArgumentException, InvocationTargetException;
	public List<SysMenu> list();
	public List<SysMenu> load(String menuId);
	public List<SysMenuVo> pageResult(int pageIndex, int pageSize, SysMenuVo sysMenuVo) throws NoSuchMethodException, SecurityException, IllegalAccessException, IllegalArgumentException, InvocationTargetException;
	public int pageRowCount(SysMenuVo sysMenuVo) throws NoSuchMethodException, SecurityException, IllegalAccessException, IllegalArgumentException, InvocationTargetException;
	public Page pageList(int pageIndex, int pageSize, SysMenuVo sysMenuVo) throws NoSuchMethodException, SecurityException, IllegalAccessException, IllegalArgumentException, InvocationTargetException;
	public void validateUnique4Code(SysMenu sysMenu) throws NoSuchMethodException, SecurityException, IllegalAccessException, IllegalArgumentException, InvocationTargetException;
	public List<SysMenuUrlVo> loadUrl(String employeeId);
}
