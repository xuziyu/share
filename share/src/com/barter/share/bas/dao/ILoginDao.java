package com.barter.share.bas.dao;

import com.barter.share.bas.entity.BasCustomer;
import com.barter.share.bas.entity.SysEmployee;

public interface ILoginDao {

	public BasCustomer customerLogin(int id);
	
	public SysEmployee employeeLogin(int id);
}
