package com.barter.share.bas.service;

import java.lang.reflect.InvocationTargetException;
import java.util.List;

import com.barter.share.bas.entity.SalOrder;
import com.barter.share.bas.entity.SalOrderDetail;
import com.barter.share.framework.entity.Page;

public interface ISalOrderDetailService {


	public void insert(SalOrderDetail salOrderDetail);

	public void update(SalOrderDetail salOrderDetail);
	
	public void delete(String orderDetailId);
	
	public List<SalOrderDetail> list(SalOrderDetail salOrderDetail);
	// 查询单个对象
	public SalOrderDetail load(String orderDetailId,String orderId);
	// 分页查询的结果集
	public List<SalOrderDetail> pageResult(int pageIndex, int pageSize, String orderDetailId, String orderId);
	// 分页查询
	public Page pageList(int pageIndex, int pageSize, String orderDetailId, String orderId);
	// 分页查询记录总数
	public int pageRowCount(String orderDetailId, String orderId);
}
