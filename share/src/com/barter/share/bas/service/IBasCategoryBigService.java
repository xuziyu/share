package com.barter.share.bas.service;

import java.lang.reflect.InvocationTargetException;
import java.util.List;

import com.barter.share.bas.entity.BasCategoryBig;
import com.barter.share.framework.entity.Page;

public interface IBasCategoryBigService {
	public void insert(BasCategoryBig basCategoryBig) throws NoSuchMethodException, SecurityException, IllegalAccessException, IllegalArgumentException, InvocationTargetException;
	public void delete(String categoryBigId);
	public void update(BasCategoryBig basCategoryBig) throws NoSuchMethodException, SecurityException, IllegalAccessException, IllegalArgumentException, InvocationTargetException;
	public List<BasCategoryBig> list();
	public List<BasCategoryBig> load(String categoryBigId);
	public Page pageList(int pageIndex, int pageSize, BasCategoryBig basCategoryBig) throws NoSuchMethodException, SecurityException, IllegalAccessException, IllegalArgumentException, InvocationTargetException;
	public void codeCheck(BasCategoryBig basCategoryBig) throws NoSuchMethodException, SecurityException, IllegalAccessException, IllegalArgumentException, InvocationTargetException;
}
