package com.barter.share.bas.service;

import java.lang.reflect.InvocationTargetException;
import java.util.List;

import com.barter.share.bas.entity.BasCustomer;
import com.barter.share.bas.entity.BasSupplier;
import com.barter.share.framework.entity.Page;

public interface ISerSupplier {
	public void insert(BasSupplier Supplier) throws NoSuchMethodException, SecurityException, IllegalAccessException, IllegalArgumentException, InvocationTargetException;
	public void delete(String SupplierId);
	public void update(BasSupplier Supplier) throws NoSuchMethodException, SecurityException, IllegalAccessException, IllegalArgumentException, InvocationTargetException;
	public List<BasSupplier> load(String SupplierId);
	public List<BasSupplier> list();
	public Page pageList(int pageIndex, int pageSize, BasSupplier Supplier) throws NoSuchMethodException, SecurityException, IllegalAccessException, IllegalArgumentException, InvocationTargetException;
	public void codeCheck(BasSupplier Supplier) throws NoSuchMethodException, SecurityException, IllegalAccessException, IllegalArgumentException, InvocationTargetException;
}
