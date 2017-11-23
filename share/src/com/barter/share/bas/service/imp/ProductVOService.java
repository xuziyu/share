package com.barter.share.bas.service.imp;

import com.barter.share.bas.dao.imp.BasProductSkuVoDao2;
import com.barter.share.bas.service.IProductVOService;
import com.barter.share.bas.vo.ProductSkuVO;

public class ProductVOService implements IProductVOService{
	BasProductSkuVoDao2 basProductSkuVoDao2 = new BasProductSkuVoDao2();
	@Override
	public ProductSkuVO salorder(String productSkuId) {
		return basProductSkuVoDao2.salorder(productSkuId);
	}

	
}
