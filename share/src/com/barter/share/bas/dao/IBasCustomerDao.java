package com.barter.share.bas.dao;

import java.lang.reflect.InvocationTargetException;
import java.util.List;

import com.barter.share.bas.entity.BasCustomer;
import com.barter.share.framework.entity.Page;




public interface IBasCustomerDao {
	public void insert(BasCustomer customer) throws NoSuchMethodException, SecurityException, IllegalAccessException, IllegalArgumentException, InvocationTargetException;

	public void delete(String customerId);

	public void update(BasCustomer customer) throws NoSuchMethodException, SecurityException, IllegalAccessException, IllegalArgumentException, InvocationTargetException;

	public List<BasCustomer> list();

	public List<BasCustomer> load(String customerId);

	public Page pageList(int pageIndex, int pageSize, BasCustomer customer) throws NoSuchMethodException, SecurityException, IllegalAccessException, IllegalArgumentException, InvocationTargetException;

	public List<BasCustomer> pageResult(int pageIndex, int pageSize, BasCustomer customer) throws NoSuchMethodException, SecurityException, IllegalAccessException, IllegalArgumentException, InvocationTargetException;

	public BasCustomer basCustomer(String customerId);
	
	public int pageRowCount(BasCustomer customer) throws NoSuchMethodException, SecurityException, IllegalAccessException, IllegalArgumentException, InvocationTargetException;
	
	public void validateUnique4Code(BasCustomer customer) throws NoSuchMethodException, SecurityException, IllegalAccessException, IllegalArgumentException, InvocationTargetException;
}
