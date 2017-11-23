package com.barter.share.bas.dao;

import java.lang.reflect.InvocationTargetException;
import java.util.List;

import com.barter.share.bas.vo.BasCategorySmallVo;
import com.barter.share.framework.entity.Page;

public interface IBasCategorySmallVoDao {
	public void insert(BasCategorySmallVo basCategorySmallVo) throws NoSuchMethodException, SecurityException, IllegalAccessException, IllegalArgumentException, InvocationTargetException;
	public void delete(String categorySmallId);
	public void update(BasCategorySmallVo basCategorySmallVo) throws NoSuchMethodException, SecurityException, IllegalAccessException, IllegalArgumentException, InvocationTargetException;
	public List<BasCategorySmallVo> list();
	public List<BasCategorySmallVo> load(String categorySmallId);
	public List<BasCategorySmallVo> pageResult(int pageIndex, int pageSize, BasCategorySmallVo basCategorySmallVo) throws NoSuchMethodException, SecurityException, IllegalAccessException, IllegalArgumentException, InvocationTargetException;
	public int pageRowCount(BasCategorySmallVo basCategorySmallVo) throws NoSuchMethodException, SecurityException, IllegalAccessException, IllegalArgumentException, InvocationTargetException;
	public Page pageList(int pageIndex, int pageSize, BasCategorySmallVo basCategorySmallVo) throws NoSuchMethodException, SecurityException, IllegalAccessException, IllegalArgumentException, InvocationTargetException;
	public void validateUnique4Code(BasCategorySmallVo basCategorySmallVo) throws NoSuchMethodException, SecurityException, IllegalAccessException, IllegalArgumentException, InvocationTargetException;
}
