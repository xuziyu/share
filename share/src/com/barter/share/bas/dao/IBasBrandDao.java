package com.barter.share.bas.dao;

import java.lang.reflect.InvocationTargetException;
import java.util.List;

import com.barter.share.bas.entity.BasBrand;
import com.barter.share.framework.entity.Page;
/**
 * 
 * @author 卢翔
 *
 */
public interface IBasBrandDao {

	public void insert(BasBrand basBrand) throws NoSuchMethodException, SecurityException, IllegalAccessException, IllegalArgumentException, InvocationTargetException;

	public void delete(String brandId);

	public void update(BasBrand basBrand) throws NoSuchMethodException, SecurityException, IllegalAccessException, IllegalArgumentException, InvocationTargetException;
	public List<BasBrand> list();
	public List<BasBrand> load(String brandId);
	public Page pageList(int pageIndex, int pageSize, BasBrand basBrand) throws NoSuchMethodException, SecurityException, IllegalAccessException, IllegalArgumentException, InvocationTargetException;

	public List<BasBrand> pageResult(int pageIndex, int pageSize, BasBrand basBrand) throws NoSuchMethodException, SecurityException, IllegalAccessException, IllegalArgumentException, InvocationTargetException;

	public int pageRowCount(BasBrand basBrand) throws NoSuchMethodException, SecurityException, IllegalAccessException, IllegalArgumentException, InvocationTargetException;
	
	public void validateUnique4Code(BasBrand basBrand) throws NoSuchMethodException, SecurityException, IllegalAccessException, IllegalArgumentException, InvocationTargetException;
}
