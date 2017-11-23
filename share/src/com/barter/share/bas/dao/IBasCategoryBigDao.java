package com.barter.share.bas.dao;

import java.lang.reflect.InvocationTargetException;
import java.util.List;

import com.barter.share.bas.entity.BasCategoryBig;
import com.barter.share.framework.entity.Page;

/**
 * 
 * @author 卢翔
 *
 */
public interface IBasCategoryBigDao {
	public void insert(BasCategoryBig basCategoryBig) throws NoSuchMethodException, SecurityException, IllegalAccessException, IllegalArgumentException, InvocationTargetException;
	public void delete(String categoryBigId);
	public void update(BasCategoryBig basCategoryBig) throws NoSuchMethodException, SecurityException, IllegalAccessException, IllegalArgumentException, InvocationTargetException;
	public List<BasCategoryBig> list();
	public List<BasCategoryBig> load(String categoryBigId);
	public List<BasCategoryBig> pageResult(int pageIndex, int pageSize, BasCategoryBig basCategoryBig) throws NoSuchMethodException, SecurityException, IllegalAccessException, IllegalArgumentException, InvocationTargetException;
	public int pageRowCount(BasCategoryBig basCategoryBig) throws NoSuchMethodException, SecurityException, IllegalAccessException, IllegalArgumentException, InvocationTargetException;
	public Page pageList(int pageIndex, int pageSize, BasCategoryBig basCategoryBig) throws NoSuchMethodException, SecurityException, IllegalAccessException, IllegalArgumentException, InvocationTargetException;
	public void validateUnique4Code(BasCategoryBig basCategoryBig) throws NoSuchMethodException, SecurityException, IllegalAccessException, IllegalArgumentException, InvocationTargetException;
}
