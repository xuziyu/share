package com.barter.share.bas.service;

import java.lang.reflect.InvocationTargetException;
import java.util.List;

import com.barter.share.bas.entity.BasSkuColor;
import com.barter.share.framework.entity.Page;

public interface IBasSkuColorService {
	public void insert(BasSkuColor basSkuColor) throws NoSuchMethodException, SecurityException, IllegalAccessException, IllegalArgumentException, InvocationTargetException;
	public void delete(String skuColorId);
	public void update(BasSkuColor basSkuColor) throws NoSuchMethodException, SecurityException, IllegalAccessException, IllegalArgumentException, InvocationTargetException;
	public List<BasSkuColor> list();
	public List<BasSkuColor> load(String skuColorId);
	public Page pageList(int pageIndex, int pageSize, BasSkuColor basSkuColor) throws NoSuchMethodException, SecurityException, IllegalAccessException, IllegalArgumentException, InvocationTargetException;
	public void codeCheck(BasSkuColor basSkuColor) throws NoSuchMethodException, SecurityException, IllegalAccessException, IllegalArgumentException, InvocationTargetException;
}
