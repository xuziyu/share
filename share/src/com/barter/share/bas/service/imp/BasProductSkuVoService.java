package com.barter.share.bas.service.imp;

import java.lang.reflect.InvocationTargetException;
import java.util.List;

import com.barter.share.bas.dao.IBasProductSkuVoDao;
import com.barter.share.bas.dao.imp.BasProductSkuVoDao;
import com.barter.share.bas.service.IBasProductSkuVoService;
import com.barter.share.bas.vo.BasProductSkuVo;
import com.barter.share.framework.entity.Page;

public class BasProductSkuVoService implements IBasProductSkuVoService {
	IBasProductSkuVoDao iBasProductSkuVoDao = new BasProductSkuVoDao();
	@Override
	public void insert(BasProductSkuVo basProductSkuVo) throws NoSuchMethodException, SecurityException,
			IllegalAccessException, IllegalArgumentException, InvocationTargetException {
		
	}

	@Override
	public void delete(String productSkuId) {
		
	}

	@Override
	public void update(BasProductSkuVo basProductSkuVo) throws NoSuchMethodException, SecurityException,
			IllegalAccessException, IllegalArgumentException, InvocationTargetException {
		
	}

	@Override
	public List<BasProductSkuVo> list() {
		return null;
	}

	@Override
	public List<BasProductSkuVo> load(String productSkuId) {
		return null;
	}

	@Override
	public Page pageList(int pageIndex, int pageSize, BasProductSkuVo basProductSkuVo) throws NoSuchMethodException,
			SecurityException, IllegalAccessException, IllegalArgumentException, InvocationTargetException {
		return iBasProductSkuVoDao.pageList(pageIndex, pageSize, basProductSkuVo);
	}

	@Override
	public void codeCheck(BasProductSkuVo basProductSkuVo) throws NoSuchMethodException, SecurityException,
			IllegalAccessException, IllegalArgumentException, InvocationTargetException {
		
	}

}
