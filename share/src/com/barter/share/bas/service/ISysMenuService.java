package com.barter.share.bas.service;

import java.lang.reflect.InvocationTargetException;
import java.util.List;

import com.barter.share.bas.entity.SysMenu;
import com.barter.share.bas.vo.SysMenuUrlVo;
import com.barter.share.bas.vo.SysMenuVo;
import com.barter.share.framework.entity.Page;

public interface ISysMenuService {
	public void insert(SysMenu sysMenu) throws NoSuchMethodException, SecurityException, IllegalAccessException, IllegalArgumentException, InvocationTargetException;
	public void delete(String menuId);
	public void update(SysMenu sysMenu) throws NoSuchMethodException, SecurityException, IllegalAccessException, IllegalArgumentException, InvocationTargetException;
	public List<SysMenu> list();
	public List<SysMenu> load(String menuId);
	public Page pageList(int pageIndex, int pageSize, SysMenuVo sysMenuVo) throws NoSuchMethodException, SecurityException, IllegalAccessException, IllegalArgumentException, InvocationTargetException;
	public void codeCheck(SysMenu sysMenu) throws NoSuchMethodException, SecurityException, IllegalAccessException, IllegalArgumentException, InvocationTargetException;
	public List<SysMenuUrlVo> loadUrl(String employeeId);
}
