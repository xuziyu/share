package com.barter.share.bas.service.imp;

import java.lang.reflect.InvocationTargetException;
import java.util.List;

import com.barter.share.bas.dao.ISalOrderDetailDao;
import com.barter.share.bas.dao.imp.SalOrderDetailDao;
import com.barter.share.bas.entity.SalOrder;
import com.barter.share.bas.entity.SalOrderDetail;
import com.barter.share.bas.service.ISalOrderDetailService;
import com.barter.share.framework.entity.Page;

public class SalOrderDetailServiceImp implements ISalOrderDetailService {
	ISalOrderDetailDao  iSalOrderDetailDao = new SalOrderDetailDao();

	@Override
	public void insert(SalOrderDetail salOrderDetail) {
		iSalOrderDetailDao.insert(salOrderDetail);
	}

	@Override
	public void update(SalOrderDetail salOrderDetail) {
		iSalOrderDetailDao.update(salOrderDetail);
	}

	@Override
	public void delete(String orderDetailId) {

		iSalOrderDetailDao.delete(orderDetailId);
	}

	@Override
	public List<SalOrderDetail> list(SalOrderDetail salOrderDetail) {
		return iSalOrderDetailDao.list(salOrderDetail);
	}

	@Override
	public SalOrderDetail load(String orderDetailId,String orderId) {
		return iSalOrderDetailDao.load(orderDetailId, orderId);
	}

	@Override
	public List<SalOrderDetail> pageResult(int pageIndex, int pageSize, String orderDetailId, String orderId) {
		return iSalOrderDetailDao.pageResult(pageIndex, pageSize, orderDetailId, orderId);
	}

	@Override
	public Page pageList(int pageIndex, int pageSize, String orderDetailId, String orderId) {
		return iSalOrderDetailDao.pageList(pageIndex, pageSize, orderDetailId, orderId);
	}

	@Override
	public int pageRowCount(String orderDetailId, String orderId) {
		return pageRowCount(orderDetailId, orderId);
	}
	

}
