package com.barter.share.bas.service;

import java.lang.reflect.InvocationTargetException;
import java.util.List;

import com.barter.share.bas.entity.BasDict;
import com.barter.share.framework.entity.Page;

public interface IBasDictService {
	public void insert(BasDict basDict) throws NoSuchMethodException, SecurityException, IllegalAccessException, IllegalArgumentException, InvocationTargetException;
	public void delete(String dictId);
	public void update(BasDict basDict) throws NoSuchMethodException, SecurityException, IllegalAccessException, IllegalArgumentException, InvocationTargetException;
	public List<BasDict> list();
	public List<BasDict> load(String dictId);
	public Page pageList(int pageIndex, int pageSize, BasDict basDict) throws NoSuchMethodException, SecurityException, IllegalAccessException, IllegalArgumentException, InvocationTargetException;
	public void codeCheck(BasDict basDict) throws NoSuchMethodException, SecurityException, IllegalAccessException, IllegalArgumentException, InvocationTargetException;
}
