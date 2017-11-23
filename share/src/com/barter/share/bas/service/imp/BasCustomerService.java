package com.barter.share.bas.service.imp;

import com.barter.share.bas.dao.IBasCustomerDao;
import com.barter.share.bas.dao.imp.BasCustomerDao;
import com.barter.share.bas.entity.BasCustomer;
import com.barter.share.bas.service.IBasCustomerService;

public class BasCustomerService implements IBasCustomerService{
	IBasCustomerDao iBasCustomerDao = new BasCustomerDao();
	@Override
	public BasCustomer basCustomer(String customerId) {
		// TODO Auto-generated method stub
		return iBasCustomerDao.basCustomer(customerId);
	}

}
