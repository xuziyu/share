package com.barter.share.bas.service.imp;

import com.barter.share.bas.dao.ILoginDao;
import com.barter.share.bas.dao.imp.LoginDao;
import com.barter.share.bas.entity.BasCustomer;
import com.barter.share.bas.entity.SysEmployee;
import com.barter.share.bas.service.ILoginService;

public class LoginServiceImp implements ILoginService {

	ILoginDao iLoginDao = new LoginDao();
	@Override
	public BasCustomer customerLogin(int id) {
		return iLoginDao.customerLogin(id);
	}

	@Override
	public SysEmployee employeeLogin(int id) {
		return iLoginDao.employeeLogin(id);
	}

}
