package com.barter.share.bas.dao;

import java.lang.reflect.InvocationTargetException;
import java.util.List;

import com.barter.share.bas.entity.BasSupplier;
import com.barter.share.framework.entity.Page;

public interface IBasSupplierDao {
		public void insert(BasSupplier supplier) throws NoSuchMethodException, SecurityException, IllegalAccessException, IllegalArgumentException, InvocationTargetException;

		public void delete(String supplierId);

		public void update(BasSupplier supplier) throws NoSuchMethodException, SecurityException, IllegalAccessException, IllegalArgumentException, InvocationTargetException;

		public List<BasSupplier> list();

		public List<BasSupplier> load(String supplierId);

		public Page pageList(int pageIndex, int pageSize, BasSupplier supplier) throws NoSuchMethodException, SecurityException, IllegalAccessException, IllegalArgumentException, InvocationTargetException;

		public List<BasSupplier> pageResult(int pageIndex, int pageSize, BasSupplier supplier) throws NoSuchMethodException, SecurityException, IllegalAccessException, IllegalArgumentException, InvocationTargetException;

		public int pageRowCount(BasSupplier supplier) throws NoSuchMethodException, SecurityException, IllegalAccessException, IllegalArgumentException, InvocationTargetException;
		public void validateUnique4Code(BasSupplier supplier) throws NoSuchMethodException, SecurityException, IllegalAccessException, IllegalArgumentException, InvocationTargetException;
	}
	   
	   
