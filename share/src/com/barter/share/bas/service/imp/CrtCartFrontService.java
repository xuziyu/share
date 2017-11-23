package com.barter.share.bas.service.imp;

import java.util.List;

import com.barter.share.bas.dao.ICrtCartFrontDao;
import com.barter.share.bas.dao.imp.CrtCartFrontDao;
import com.barter.share.bas.service.ICrtCartFrontService;
import com.barter.share.bas.vo.CartVo;

public class CrtCartFrontService implements ICrtCartFrontService {
	ICrtCartFrontDao iCrtCartFrontDao = new CrtCartFrontDao();
	@Override
	public List<CartVo> pageList(String customerId) {
		return iCrtCartFrontDao.pageList(customerId);
	}
	@Override
	public void delete(String cartId) {
		iCrtCartFrontDao.delete(cartId);
	}
	@Override
	public void insert(String cartId, String customerId, String skuId ,String date) {
		iCrtCartFrontDao.insert(cartId, customerId, skuId ,date);
	}
	
}
