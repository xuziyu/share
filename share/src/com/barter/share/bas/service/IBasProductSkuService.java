package com.barter.share.bas.service;

import java.lang.reflect.InvocationTargetException;
import java.util.List;

import com.barter.share.bas.entity.BasProductSku;
import com.barter.share.framework.entity.Page;

public interface IBasProductSkuService {
	public void insert(BasProductSku basProductSku) throws NoSuchMethodException, SecurityException, IllegalAccessException, IllegalArgumentException, InvocationTargetException;
	public void delete(String productSkuId);
	public void update(BasProductSku basProductSku) throws NoSuchMethodException, SecurityException, IllegalAccessException, IllegalArgumentException, InvocationTargetException;
	public List<BasProductSku> list();
	public List<BasProductSku> load(String productSkuId);
	public Page pageList(int pageIndex, int pageSize, BasProductSku basProductSku) throws NoSuchMethodException, SecurityException, IllegalAccessException, IllegalArgumentException, InvocationTargetException;
	public void codeCheck(BasProductSku basProductSku) throws NoSuchMethodException, SecurityException, IllegalAccessException, IllegalArgumentException, InvocationTargetException;
}
