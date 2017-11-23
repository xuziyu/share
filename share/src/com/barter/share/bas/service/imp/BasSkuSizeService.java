package com.barter.share.bas.service.imp;

import java.lang.reflect.InvocationTargetException;
import java.util.List;

import com.barter.share.bas.dao.IBasSkuSizeDao;
import com.barter.share.bas.dao.imp.BasSkuSizeDao;
import com.barter.share.bas.entity.BasSkuSize;
import com.barter.share.bas.service.IBasSkuSizeService;
import com.barter.share.framework.entity.Page;

public class BasSkuSizeService implements IBasSkuSizeService {
	IBasSkuSizeDao iBasSkuSizeDao = new BasSkuSizeDao();
	@Override
	public void insert(BasSkuSize basSkuSize) throws NoSuchMethodException, SecurityException, IllegalAccessException,
			IllegalArgumentException, InvocationTargetException {
		iBasSkuSizeDao.insert(basSkuSize);
	}

	@Override
	public void delete(String skuSizeId) {
		iBasSkuSizeDao.delete(skuSizeId);
	}

	@Override
	public void update(BasSkuSize basSkuSize) throws NoSuchMethodException, SecurityException, IllegalAccessException,
			IllegalArgumentException, InvocationTargetException {
		iBasSkuSizeDao.update(basSkuSize);
	}
	@Override
	public List<BasSkuSize> list() {
		return iBasSkuSizeDao.list();
	}
	@Override
	public List<BasSkuSize> load(String skuSizeId) {
		return iBasSkuSizeDao.load(skuSizeId);
	}

	@Override
	public Page pageList(int pageIndex, int pageSize, BasSkuSize basSkuSize) throws NoSuchMethodException,
			SecurityException, IllegalAccessException, IllegalArgumentException, InvocationTargetException {
		return iBasSkuSizeDao.pageList(pageIndex, pageSize, basSkuSize);
	}

	@Override
	public void codeCheck(BasSkuSize basSkuSize) throws NoSuchMethodException, SecurityException,
			IllegalAccessException, IllegalArgumentException, InvocationTargetException {
		iBasSkuSizeDao.validateUnique4Code(basSkuSize);
	}

}
