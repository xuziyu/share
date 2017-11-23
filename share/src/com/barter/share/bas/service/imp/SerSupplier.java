package com.barter.share.bas.service.imp;

import java.lang.reflect.InvocationTargetException;
import java.util.List;

import com.barter.share.bas.dao.IBasSupplierDao;
import com.barter.share.bas.dao.imp.BasSupplierDao;
import com.barter.share.bas.entity.BasCustomer;
import com.barter.share.bas.entity.BasSupplier;
import com.barter.share.bas.service.ISerSupplier;
import com.barter.share.framework.entity.Page;


public class SerSupplier implements ISerSupplier {
	IBasSupplierDao iBasSupplierDao = new BasSupplierDao();
	@Override
	public void insert(BasSupplier Supplier) throws NoSuchMethodException, SecurityException, IllegalAccessException, IllegalArgumentException, InvocationTargetException {
		iBasSupplierDao.insert(Supplier);
	}

	@Override
	public void delete(String SupplierId) {
		iBasSupplierDao.delete(SupplierId);
	}

	@Override
	public void update(BasSupplier Supplier) throws NoSuchMethodException, SecurityException, IllegalAccessException, IllegalArgumentException, InvocationTargetException {
		iBasSupplierDao.update(Supplier);
	}
	
	@Override
	public List<BasSupplier> list() {
		return iBasSupplierDao.list();
	}
	@Override
	public List<BasSupplier> load(String SupplierId) {
		return iBasSupplierDao.load(SupplierId);
	}

	@Override
	public Page pageList(int pageIndex, int pageSize, BasSupplier Supplier) throws NoSuchMethodException, SecurityException, IllegalAccessException, IllegalArgumentException, InvocationTargetException {
		return iBasSupplierDao.pageList(pageIndex, pageSize, Supplier);
	}

	@Override
	public void codeCheck(BasSupplier Supplier) throws NoSuchMethodException, SecurityException, IllegalAccessException, IllegalArgumentException, InvocationTargetException {
		iBasSupplierDao.validateUnique4Code(Supplier);
	}

}
