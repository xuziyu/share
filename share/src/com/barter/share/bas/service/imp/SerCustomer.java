package com.barter.share.bas.service.imp;

import java.lang.reflect.InvocationTargetException;
import java.util.List;

import com.barter.share.bas.dao.IBasCustomerDao;
import com.barter.share.bas.dao.imp.BasCustomerDao;
import com.barter.share.bas.entity.BasCustomer;
import com.barter.share.bas.service.ISerCustomer;
import com.barter.share.framework.entity.Page;


public class SerCustomer implements ISerCustomer {
	IBasCustomerDao iBasCustomerDao = new BasCustomerDao();
	@Override
	public void insert(BasCustomer customer) throws NoSuchMethodException, SecurityException, IllegalAccessException, IllegalArgumentException, InvocationTargetException {
		iBasCustomerDao.insert(customer);
	}

	@Override
	public void delete(String customerId) {
		iBasCustomerDao.delete(customerId);
	}

	@Override
	public void update(BasCustomer customer) throws NoSuchMethodException, SecurityException, IllegalAccessException, IllegalArgumentException, InvocationTargetException {
		iBasCustomerDao.update(customer);
	}
	
	@Override
	public List<BasCustomer> list() {
		return iBasCustomerDao.list();
	}

	@Override
	public List<BasCustomer> load(String customerId) {
		return iBasCustomerDao.load(customerId);
	}

	@Override
	public Page pageList(int pageIndex, int pageSize, BasCustomer customer) throws NoSuchMethodException, SecurityException, IllegalAccessException, IllegalArgumentException, InvocationTargetException {
		return iBasCustomerDao.pageList(pageIndex, pageSize, customer);
	}

	@Override
	public void codeCheck(BasCustomer customer) throws NoSuchMethodException, SecurityException, IllegalAccessException, IllegalArgumentException, InvocationTargetException {
		iBasCustomerDao.validateUnique4Code(customer);
	}

}
