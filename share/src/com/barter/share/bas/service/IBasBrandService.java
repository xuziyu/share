package com.barter.share.bas.service;

import java.lang.reflect.InvocationTargetException;
import java.util.List;

import com.barter.share.bas.entity.BasBrand;
import com.barter.share.framework.entity.Page;
/**
 * 品牌 增删 改查
 * @author Administrator
 *
 */
public interface IBasBrandService {
	public void insert(BasBrand basBrand) throws NoSuchMethodException, SecurityException, IllegalAccessException, IllegalArgumentException, InvocationTargetException;
	public void delete(String basBrandId);
	public void update(BasBrand basBrand) throws NoSuchMethodException, SecurityException, IllegalAccessException, IllegalArgumentException, InvocationTargetException;
	public List<BasBrand> list();
	public List<BasBrand> load(String basBrandId);
	public Page pageList(int pageIndex, int pageSize, BasBrand basBrand) throws NoSuchMethodException, SecurityException, IllegalAccessException, IllegalArgumentException, InvocationTargetException;
	public void codeCheck(BasBrand basBrand) throws NoSuchMethodException, SecurityException, IllegalAccessException, IllegalArgumentException, InvocationTargetException;
}
