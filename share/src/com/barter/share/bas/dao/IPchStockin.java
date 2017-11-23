package com.barter.share.bas.dao;

import java.util.List;

import com.barter.share.bas.entity.PchStockin;
import com.barter.share.framework.entity.Page;














public  interface  IPchStockin {
	
	public PchStockin insert(PchStockin  pchStockin);
	public PchStockin update(PchStockin  pchStockin);
	public void delete(String id);
	public PchStockin load(String id) ;
	public List<PchStockin> pageResult(int pageIndex, int pageSize,String createEmployeeId);
	public int pageRowCount(int pageSize, String createEmployeeId);
	public Page pageList(int pageIndex, int pageSize, String createEmployeeId);
	public void validateUnique4Code(PchStockin  pchStockin);
	public List<PchStockin>list ();
	/* 
	   public List<BasCustomer> selectAll();
	   public List<BasCustomer> select(String customerId);
	   public List<BasCustomer> selectCustomerPage(int pageIndex, int pageSize, String code, String name);
	   
	   */
}
