package com.barter.share.bas.service;

import java.lang.reflect.InvocationTargetException;
import java.util.List;

import com.barter.share.bas.entity.SysModule;
import com.barter.share.framework.entity.Page;

public interface ISysModuleService {
	public void insert(SysModule sysModule) throws NoSuchMethodException, SecurityException, IllegalAccessException, IllegalArgumentException, InvocationTargetException;
	public void delete(String moduleId);
	public void update(SysModule sysModule) throws NoSuchMethodException, SecurityException, IllegalAccessException, IllegalArgumentException, InvocationTargetException;
	public List<SysModule> list();
	public List<SysModule> load(String moduleId);
	public Page pageList(int pageIndex, int pageSize, SysModule sysModule) throws NoSuchMethodException, SecurityException, IllegalAccessException, IllegalArgumentException, InvocationTargetException;
	public void codeCheck(SysModule sysModule) throws NoSuchMethodException, SecurityException, IllegalAccessException, IllegalArgumentException, InvocationTargetException;
}
