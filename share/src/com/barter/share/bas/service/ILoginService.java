package com.barter.share.bas.service;

import com.barter.share.bas.entity.BasCustomer;
import com.barter.share.bas.entity.SysEmployee;

public interface ILoginService {

	public BasCustomer customerLogin(int id);

	public SysEmployee employeeLogin(int id);
}
