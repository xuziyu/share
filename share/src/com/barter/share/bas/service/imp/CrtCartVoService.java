package com.barter.share.bas.service.imp;

import java.lang.reflect.InvocationTargetException;
import java.util.List;

import com.barter.share.bas.dao.ICrtCartVoDao;
import com.barter.share.bas.dao.imp.CrtCartVoDao;
import com.barter.share.bas.service.ICrtCartVoService;
import com.barter.share.bas.vo.CrtCartVo;
import com.barter.share.framework.entity.Page;

public class CrtCartVoService implements ICrtCartVoService {
	ICrtCartVoDao iCrtCartVoDao = new CrtCartVoDao();
	@Override
	public void insert(CrtCartVo crtCartVo) throws NoSuchMethodException, SecurityException, IllegalAccessException,
			IllegalArgumentException, InvocationTargetException {
		
	}

	@Override
	public void delete(String cartId) {

	}

	@Override
	public void update(CrtCartVo crtCartVo) throws NoSuchMethodException, SecurityException, IllegalAccessException,
			IllegalArgumentException, InvocationTargetException {

	}

	@Override
	public List<CrtCartVo> list() {
		return null;
	}

	@Override
	public List<CrtCartVo> load(String cartId) {
		return null;
	}

	@Override
	public Page pageList(int pageIndex, int pageSize, CrtCartVo crtCartVo) throws NoSuchMethodException,
			SecurityException, IllegalAccessException, IllegalArgumentException, InvocationTargetException {
		return iCrtCartVoDao.pageList(pageIndex, pageSize, crtCartVo);
	}

	@Override
	public void codeCheck(CrtCartVo crtCartVo) throws NoSuchMethodException, SecurityException, IllegalAccessException,
			IllegalArgumentException, InvocationTargetException {

	}

}
