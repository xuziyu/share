package com.barter.share.bas.dao;

import java.lang.reflect.InvocationTargetException;
import java.util.List;

import com.barter.share.bas.entity.SysModule;
import com.barter.share.framework.entity.Page;

public interface ISysModuleDao {
	public void insert(SysModule sysModule) throws NoSuchMethodException, SecurityException, IllegalAccessException, IllegalArgumentException, InvocationTargetException;
	public void delete(String moduleId);
	public void update(SysModule sysModule) throws NoSuchMethodException, SecurityException, IllegalAccessException, IllegalArgumentException, InvocationTargetException;
	public List<SysModule> list();
	public List<SysModule> load(String moduleId);
	public List<SysModule> pageResult(int pageIndex, int pageSize, SysModule sysModule) throws NoSuchMethodException, SecurityException, IllegalAccessException, IllegalArgumentException, InvocationTargetException;
	public int pageRowCount(SysModule sysModule) throws NoSuchMethodException, SecurityException, IllegalAccessException, IllegalArgumentException, InvocationTargetException;
	public Page pageList(int pageIndex, int pageSize, SysModule sysModule) throws NoSuchMethodException, SecurityException, IllegalAccessException, IllegalArgumentException, InvocationTargetException;
	public void validateUnique4Code(SysModule sysModule) throws NoSuchMethodException, SecurityException, IllegalAccessException, IllegalArgumentException, InvocationTargetException;
}
