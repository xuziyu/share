package com.barter.share.bas.service.imp;

import java.lang.reflect.InvocationTargetException;
import java.util.List;

import com.barter.share.bas.dao.IBasSkuColorDao;
import com.barter.share.bas.dao.imp.BasSkuColorDao;
import com.barter.share.bas.entity.BasSkuColor;
import com.barter.share.bas.service.IBasSkuColorService;
import com.barter.share.framework.entity.Page;

public class BasSkuColorService implements IBasSkuColorService {
	IBasSkuColorDao iBasSkuColorDao = new BasSkuColorDao();
	@Override
	public void insert(BasSkuColor basSkuColor) throws NoSuchMethodException, SecurityException, IllegalAccessException,
			IllegalArgumentException, InvocationTargetException {
		iBasSkuColorDao.insert(basSkuColor);
	}

	@Override
	public void delete(String skuColorId) {
		iBasSkuColorDao.delete(skuColorId);
	}

	@Override
	public void update(BasSkuColor basSkuColor) throws NoSuchMethodException, SecurityException, IllegalAccessException,
			IllegalArgumentException, InvocationTargetException {
		iBasSkuColorDao.update(basSkuColor);
	}
	@Override
	public List<BasSkuColor> list() {
		return iBasSkuColorDao.list();
	} 
	@Override
	public List<BasSkuColor> load(String skuColorId) {
		return iBasSkuColorDao.load(skuColorId);
	}

	@Override
	public Page pageList(int pageIndex, int pageSize, BasSkuColor basSkuColor) throws NoSuchMethodException,
			SecurityException, IllegalAccessException, IllegalArgumentException, InvocationTargetException {
		return iBasSkuColorDao.pageList(pageIndex, pageSize, basSkuColor);
	}

	@Override
	public void codeCheck(BasSkuColor basSkuColor) throws NoSuchMethodException, SecurityException,
			IllegalAccessException, IllegalArgumentException, InvocationTargetException {
		iBasSkuColorDao.validateUnique4Code(basSkuColor);
	}

}
