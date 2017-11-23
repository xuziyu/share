package com.barter.share.bas.dao;

import java.lang.reflect.InvocationTargetException;
import java.util.List;

import com.barter.share.bas.entity.BasCategorySmall;
import com.barter.share.framework.entity.Page;

/**
 * 
 * @author 卢翔
 *
 */
public interface IBasCategorySmallDao {
	public void insert(BasCategorySmall basCategorySmall) throws NoSuchMethodException, SecurityException, IllegalAccessException, IllegalArgumentException, InvocationTargetException;
	public void delete(String categorySmallId);
	public void update(BasCategorySmall basCategorySmall) throws NoSuchMethodException, SecurityException, IllegalAccessException, IllegalArgumentException, InvocationTargetException;
	public List<BasCategorySmall> list();
	public List<BasCategorySmall> load(String categorySmallId);
	public List<BasCategorySmall> pageResult(int pageIndex, int pageSize, BasCategorySmall basCategorySmall) throws NoSuchMethodException, SecurityException, IllegalAccessException, IllegalArgumentException, InvocationTargetException;
	public int pageRowCount(BasCategorySmall basCategorySmall) throws NoSuchMethodException, SecurityException, IllegalAccessException, IllegalArgumentException, InvocationTargetException;
	public Page pageList(int pageIndex, int pageSize, BasCategorySmall basCategorySmall) throws NoSuchMethodException, SecurityException, IllegalAccessException, IllegalArgumentException, InvocationTargetException;
	public void validateUnique4Code(BasCategorySmall basCategorySmall) throws NoSuchMethodException, SecurityException, IllegalAccessException, IllegalArgumentException, InvocationTargetException;
}
