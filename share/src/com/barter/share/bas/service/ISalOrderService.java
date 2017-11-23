package com.barter.share.bas.service;

import java.lang.reflect.InvocationTargetException;
import java.util.List;

import com.barter.share.bas.entity.SalOrder;
import com.barter.share.bas.vo.SalOrderVO;
import com.barter.share.framework.entity.Page;

public interface ISalOrderService {
	
	public void insert(SalOrder salOrder);
	// 修改
	public void update(SalOrder salOrder);
	// 删除
	public void delete(String orderId);
	// 查询单个对象
	public SalOrder load(int id);
	// 分页查询的结果集
	public List<SalOrder> pageResult(int pageIndex, int pageSize, String orderId, String customerId);
	// 分页查询
	public Page pageList(int pageIndex, int pageSize, String orderId, String customerId);
	// 分页查询记录总数
	public int pageRowCount(String orderId, String customerId);

	public void validateUnique4Code(SalOrder salOrder) throws NoSuchMethodException, SecurityException,
			IllegalAccessException, IllegalArgumentException, InvocationTargetException;
	
	public void payState(String orderId);
}

