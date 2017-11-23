package com.barter.share.bas.service;

import java.lang.reflect.InvocationTargetException;
import java.util.List;

import com.barter.share.bas.entity.BasSkuSize;
import com.barter.share.framework.entity.Page;

public interface IBasSkuSizeService {
	public void insert(BasSkuSize basSkuSize) throws NoSuchMethodException, SecurityException, IllegalAccessException, IllegalArgumentException, InvocationTargetException;
	public void delete(String skuSizeId);
	public void update(BasSkuSize basSkuSize) throws NoSuchMethodException, SecurityException, IllegalAccessException, IllegalArgumentException, InvocationTargetException;
	public List<BasSkuSize> list();
	public List<BasSkuSize> load(String skuSizeId);
	public Page pageList(int pageIndex, int pageSize, BasSkuSize basSkuSize) throws NoSuchMethodException, SecurityException, IllegalAccessException, IllegalArgumentException, InvocationTargetException;
	public void codeCheck(BasSkuSize basSkuSize) throws NoSuchMethodException, SecurityException, IllegalAccessException, IllegalArgumentException, InvocationTargetException;
}
