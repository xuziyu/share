package com.barter.share.bas.dao;

import java.lang.reflect.InvocationTargetException;
import java.util.List;

import com.barter.share.bas.entity.BasSkuSize;
import com.barter.share.framework.entity.Page;

public interface IBasSkuSizeDao {
	public void insert(BasSkuSize basSkuSize) throws NoSuchMethodException, SecurityException, IllegalAccessException, IllegalArgumentException, InvocationTargetException;
	public void delete(String skuSizeId);
	public void update(BasSkuSize basSkuSize) throws NoSuchMethodException, SecurityException, IllegalAccessException, IllegalArgumentException, InvocationTargetException;
	public List<BasSkuSize> list();
	public List<BasSkuSize> load(String skuSizeId);
	public List<BasSkuSize> pageResult(int pageIndex, int pageSize, BasSkuSize basSkuSize) throws NoSuchMethodException, SecurityException, IllegalAccessException, IllegalArgumentException, InvocationTargetException;
	public int pageRowCount(BasSkuSize basSkuSize) throws NoSuchMethodException, SecurityException, IllegalAccessException, IllegalArgumentException, InvocationTargetException;
	public Page pageList(int pageIndex, int pageSize, BasSkuSize basSkuSize) throws NoSuchMethodException, SecurityException, IllegalAccessException, IllegalArgumentException, InvocationTargetException;
	public void validateUnique4Code(BasSkuSize basSkuSize) throws NoSuchMethodException, SecurityException, IllegalAccessException, IllegalArgumentException, InvocationTargetException;
}
