package com.barter.share.bas.service;

import java.util.List;

import com.barter.share.bas.vo.CartVo;

public interface ICrtCartFrontService {
	public List<CartVo> pageList(String customerId);
	public void delete(String cartId);
	public void insert(String cartId,String customerId,String skuId ,String date);
}
