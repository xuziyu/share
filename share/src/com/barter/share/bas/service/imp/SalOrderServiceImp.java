package com.barter.share.bas.service.imp;

import java.lang.reflect.InvocationTargetException;
import java.util.List;

import com.barter.share.bas.dao.ISalOrderDao;
import com.barter.share.bas.dao.ISalOrderVODao;
import com.barter.share.bas.dao.imp.SalOrderDao;
import com.barter.share.bas.dao.imp.SalOrderVODao;
import com.barter.share.bas.entity.SalOrder;
import com.barter.share.bas.service.ISalOrderService;
import com.barter.share.bas.vo.SalOrderVO;
import com.barter.share.framework.entity.Page;

public class SalOrderServiceImp implements ISalOrderService{
	ISalOrderDao iSalOrderDao = new SalOrderDao();
	@Override
	public void insert(SalOrder salOrder) {
		try {
			iSalOrderDao.insert(salOrder);
		} catch (NoSuchMethodException | SecurityException | IllegalAccessException | IllegalArgumentException
				| InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public void update(SalOrder salOrder) {
		iSalOrderDao.update(salOrder);
	}

	@Override
	public void delete(String orderId) {
		iSalOrderDao.delete(orderId);
	}

	@Override
	public SalOrder load(int id) {
		return iSalOrderDao.load(id);
	}

	@Override
	public List<SalOrder> pageResult(int pageIndex, int pageSize, String orderId, String customerId) {
		return iSalOrderDao.pageResult(pageIndex, pageSize, orderId, customerId);
	}

	@Override
	public Page pageList(int pageIndex, int pageSize, String orderId, String customerId) {
		return iSalOrderDao.pageList(pageIndex, pageSize, orderId, customerId);
	}

	@Override
	public int pageRowCount(String orderId, String customerId) {
		return iSalOrderDao.pageRowCount(orderId, customerId);
	}

	@Override
	public void validateUnique4Code(SalOrder salOrder) throws NoSuchMethodException, SecurityException,
			IllegalAccessException, IllegalArgumentException, InvocationTargetException {
		iSalOrderDao.validateUnique4Code(salOrder);
	}

	@Override
	public void payState(String orderId) {
		iSalOrderDao.payState(orderId);
		
	}


}
