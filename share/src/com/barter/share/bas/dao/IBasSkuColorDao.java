package com.barter.share.bas.dao;

import java.lang.reflect.InvocationTargetException;
import java.util.List;

import com.barter.share.bas.entity.BasSkuColor;
import com.barter.share.framework.entity.Page;

public interface IBasSkuColorDao {
	public void insert(BasSkuColor basSkuColor) throws NoSuchMethodException, SecurityException, IllegalAccessException, IllegalArgumentException, InvocationTargetException;
	public void delete(String skuColorId);
	public void update(BasSkuColor basSkuColor) throws NoSuchMethodException, SecurityException, IllegalAccessException, IllegalArgumentException, InvocationTargetException;
	public List<BasSkuColor> list();
	public List<BasSkuColor> load(String skuColorId);
	public List<BasSkuColor> pageResult(int pageIndex, int pageSize, BasSkuColor basSkuColor) throws NoSuchMethodException, SecurityException, IllegalAccessException, IllegalArgumentException, InvocationTargetException;
	public int pageRowCount(BasSkuColor basSkuColor) throws NoSuchMethodException, SecurityException, IllegalAccessException, IllegalArgumentException, InvocationTargetException;
	public Page pageList(int pageIndex, int pageSize, BasSkuColor basSkuColor) throws NoSuchMethodException, SecurityException, IllegalAccessException, IllegalArgumentException, InvocationTargetException;
	public void validateUnique4Code(BasSkuColor basSkuColor) throws NoSuchMethodException, SecurityException, IllegalAccessException, IllegalArgumentException, InvocationTargetException;
}
