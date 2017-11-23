package com.barter.share.bas.service.imp;

import java.lang.reflect.InvocationTargetException;
import java.util.List;

import com.barter.share.bas.dao.IBasProductSkuDao;
import com.barter.share.bas.dao.imp.BasProductSkuDao;
import com.barter.share.bas.entity.BasProductSku;
import com.barter.share.bas.service.IBasProductSkuService;
import com.barter.share.framework.entity.Page;

public class BasProductSkuService implements IBasProductSkuService {
	IBasProductSkuDao iBasProductSkuDao = new BasProductSkuDao();
	@Override
	public void insert(BasProductSku basProductSku) throws NoSuchMethodException, SecurityException,
			IllegalAccessException, IllegalArgumentException, InvocationTargetException {
		iBasProductSkuDao.insert(basProductSku);
	}

	@Override
	public void delete(String productSkuId) {
		iBasProductSkuDao.delete(productSkuId);
	}

	@Override
	public void update(BasProductSku basProductSku) throws NoSuchMethodException, SecurityException,
			IllegalAccessException, IllegalArgumentException, InvocationTargetException {
		iBasProductSkuDao.update(basProductSku);
	}
	@Override
	public List<BasProductSku> list() {
		return iBasProductSkuDao.list();
	}
	@Override
	public List<BasProductSku> load(String productSkuId) {
		return iBasProductSkuDao.load(productSkuId);
	}

	@Override
	public Page pageList(int pageIndex, int pageSize, BasProductSku basProductSku) throws NoSuchMethodException,
			SecurityException, IllegalAccessException, IllegalArgumentException, InvocationTargetException {
		return iBasProductSkuDao.pageList(pageIndex, pageSize, basProductSku);
	}

	@Override
	public void codeCheck(BasProductSku basProductSku) throws NoSuchMethodException, SecurityException,
			IllegalAccessException, IllegalArgumentException, InvocationTargetException {
		iBasProductSkuDao.validateUnique4Code(basProductSku);
	}

}
