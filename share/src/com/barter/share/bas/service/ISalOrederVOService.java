package com.barter.share.bas.service;

import java.lang.reflect.InvocationTargetException;
import java.util.List;

import com.barter.share.bas.entity.SalOrder;
import com.barter.share.bas.vo.SalOrderVO;
import com.barter.share.framework.entity.Page;

public interface ISalOrederVOService {

	public void insert(SalOrderVO salOrderVO);

	public SalOrderVO load(String customerId);

	public void delete(String orderId, String orderDetailId);

	public List<SalOrderVO> list(SalOrderVO salOrderVO);
	
	public List<SalOrderVO> loadnotpay(int pageIndex, int pageSize,String customerId);

	public List<SalOrderVO> loadnotarrive(int pageIndex, int pageSize,String customerId);

	public List<SalOrderVO> loadnocomment(int pageIndex, int pageSize,String customerId);

	// 查询单个对象
	public SalOrderVO load(String customerId , String orderId);

	// 分页查询的结果集
	public List<SalOrderVO> pageResult(int pageIndex, int pageSize, String customerId, String orderId);

	// 分页查询
	public Page pageList(int pageIndex, int pageSize, String customerId, String orderId);

	public Page pagenotpay(int pageIndex, int pageSize, String customerId);

	public Page pagenotarrive(int pageIndex, int pageSize, String customerId);

	public Page pagenocomment(int pageIndex, int pageSize, String customerId);
	// 分页查询记录总数
	public int pageRowCount(String customerId);
	
	
}
