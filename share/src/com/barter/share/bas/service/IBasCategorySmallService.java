package com.barter.share.bas.service;

import java.lang.reflect.InvocationTargetException;
import java.util.List;

import com.barter.share.bas.entity.BasCategorySmall;
import com.barter.share.framework.entity.Page;

public interface IBasCategorySmallService {
	public void insert(BasCategorySmall basCategorySmall) throws NoSuchMethodException, SecurityException, IllegalAccessException, IllegalArgumentException, InvocationTargetException;
	public void delete(String categorySmallId);
	public void update(BasCategorySmall basCategorySmall) throws NoSuchMethodException, SecurityException, IllegalAccessException, IllegalArgumentException, InvocationTargetException;
	public List<BasCategorySmall> list();
	public List<BasCategorySmall> load(String categorySmallId);
	public Page pageList(int pageIndex, int pageSize, BasCategorySmall basCategorySmall) throws NoSuchMethodException, SecurityException, IllegalAccessException, IllegalArgumentException, InvocationTargetException;
	public void codeCheck(BasCategorySmall basCategorySmall) throws NoSuchMethodException, SecurityException, IllegalAccessException, IllegalArgumentException, InvocationTargetException;
}
