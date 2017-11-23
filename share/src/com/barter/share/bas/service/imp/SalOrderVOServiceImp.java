package com.barter.share.bas.service.imp;

import java.util.List;

import com.barter.share.bas.dao.ISalOrderVODao;
import com.barter.share.bas.dao.imp.SalOrderVODao;
import com.barter.share.bas.service.ISalOrederVOService;
import com.barter.share.bas.vo.SalOrderVO;
import com.barter.share.framework.entity.Page;

public class SalOrderVOServiceImp implements ISalOrederVOService{

	ISalOrderVODao iSalOrderVO =  new SalOrderVODao();
	@Override
	public void insert(SalOrderVO salOrderVO) {

		iSalOrderVO.insert(salOrderVO);
	}
	@Override
	public SalOrderVO load(String customerId) {
		return iSalOrderVO.load(customerId);
	}
	@Override
	public void delete(String orderId, String orderDetailId) {

		iSalOrderVO.delete(orderId, orderDetailId);
	}
	@Override
	public List<SalOrderVO> list(SalOrderVO salOrderVO) {
		return iSalOrderVO.list(salOrderVO);
	}
	@Override
	public SalOrderVO load(String orderId, String customerId) {
		return null;
	}
	@Override
	public List<SalOrderVO> pageResult(int pageIndex, int pageSize, String customerId, String orderId) {
		return iSalOrderVO.pageResult(pageIndex, pageSize, customerId, orderId);
	}
	@Override
	public Page pageList(int pageIndex, int pageSize, String customerId, String orderId) {
		return iSalOrderVO.pageList(pageIndex, pageSize, customerId, orderId);
	}
	@Override
	public int pageRowCount(String customerId) {
		return iSalOrderVO.pageRowCount(customerId);
	}
	@Override
	public List<SalOrderVO> loadnotpay(int pageIndex, int pageSize, String customerId) {
		return iSalOrderVO.loadnotpay(pageIndex, pageSize, customerId);
	}
	@Override
	public List<SalOrderVO> loadnotarrive(int pageIndex, int pageSize, String customerId) {
		return iSalOrderVO.loadnotarrive(pageIndex, pageSize, customerId);
	}
	@Override
	public List<SalOrderVO> loadnocomment(int pageIndex, int pageSize, String customerId) {
		return iSalOrderVO.loadnocomment(pageIndex, pageSize, customerId);
	}
	@Override
	public Page pagenotpay(int pageIndex, int pageSize, String customerId) {
		return iSalOrderVO.pagenotpay(pageIndex, pageSize, customerId);
	}
	@Override
	public Page pagenotarrive(int pageIndex, int pageSize, String customerId) {
		return iSalOrderVO.pagenotarrive(pageIndex, pageSize, customerId);
	}
	@Override
	public Page pagenocomment(int pageIndex, int pageSize, String customerId) {
		return iSalOrderVO.pagenocomment(pageIndex, pageSize, customerId);
	}


	
}
