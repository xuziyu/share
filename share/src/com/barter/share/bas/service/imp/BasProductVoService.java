package com.barter.share.bas.service.imp;

import java.lang.reflect.InvocationTargetException;
import java.util.List;

import com.barter.share.bas.dao.IBasProductVoDao;
import com.barter.share.bas.dao.imp.BasProductVoDao;
import com.barter.share.bas.service.IBasProductVoService;
import com.barter.share.bas.vo.BasProductVo;
import com.barter.share.framework.entity.Page;

public class BasProductVoService implements IBasProductVoService {
	IBasProductVoDao iBasProductVoDao = new BasProductVoDao();
	@Override
	public void insert(BasProductVo basProductVo) throws NoSuchMethodException, SecurityException,
			IllegalAccessException, IllegalArgumentException, InvocationTargetException {
		
	}

	@Override
	public void delete(String productId) {
		
	}

	@Override
	public void update(BasProductVo basProductVo) throws NoSuchMethodException, SecurityException,
			IllegalAccessException, IllegalArgumentException, InvocationTargetException {
		
	}

	@Override
	public List<BasProductVo> list() {
		return null;
	}

	@Override
	public List<BasProductVo> load(String productId) {
		return null;
	}

	@Override
	public Page pageList(int pageIndex, int pageSize, BasProductVo basProductVo) throws NoSuchMethodException,
			SecurityException, IllegalAccessException, IllegalArgumentException, InvocationTargetException {
		return iBasProductVoDao.pageList(pageIndex, pageSize, basProductVo);
	}

	@Override
	public void codeCheck(BasProductVo basProductVo) throws NoSuchMethodException, SecurityException,
			IllegalAccessException, IllegalArgumentException, InvocationTargetException {
		
	}

}
