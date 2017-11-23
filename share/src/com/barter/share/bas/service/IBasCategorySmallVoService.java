package com.barter.share.bas.service;

import java.lang.reflect.InvocationTargetException;
import java.util.List;

import com.barter.share.bas.vo.BasCategorySmallVo;
import com.barter.share.framework.entity.Page;

public interface IBasCategorySmallVoService {
	public void insert(BasCategorySmallVo basCategorySmallVo) throws NoSuchMethodException, SecurityException, IllegalAccessException, IllegalArgumentException, InvocationTargetException;
	public void delete(String categorySmallId);
	public void update(BasCategorySmallVo basCategorySmallVo) throws NoSuchMethodException, SecurityException, IllegalAccessException, IllegalArgumentException, InvocationTargetException;
	public List<BasCategorySmallVo> list();
	public List<BasCategorySmallVo> load(String categorySmallId);
	public Page pageList(int pageIndex, int pageSize, BasCategorySmallVo basCategorySmallVo) throws NoSuchMethodException, SecurityException, IllegalAccessException, IllegalArgumentException, InvocationTargetException;
	public void codeCheck(BasCategorySmallVo basCategorySmallVo) throws NoSuchMethodException, SecurityException, IllegalAccessException, IllegalArgumentException, InvocationTargetException;
}
