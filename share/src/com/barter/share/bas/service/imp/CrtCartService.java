package com.barter.share.bas.service.imp;

import java.lang.reflect.InvocationTargetException;
import java.util.List;

import com.barter.share.bas.dao.ICrtCartDao;
import com.barter.share.bas.dao.imp.CrtCartDao;
import com.barter.share.bas.entity.CrtCart;
import com.barter.share.bas.service.ICrtCartService;
import com.barter.share.framework.entity.Page;

public class CrtCartService implements ICrtCartService {
	ICrtCartDao iCrtCartDao = new CrtCartDao();
	@Override
	public void insert(CrtCart crtCart) throws NoSuchMethodException, SecurityException, IllegalAccessException,
			IllegalArgumentException, InvocationTargetException {
		iCrtCartDao.insert(crtCart);
	}

	@Override
	public void delete(String cartId) {
		iCrtCartDao.delete(cartId);
	}

	@Override
	public void update(CrtCart crtCart) throws NoSuchMethodException, SecurityException, IllegalAccessException,
			IllegalArgumentException, InvocationTargetException {
		iCrtCartDao.update(crtCart);
	}
	@Override
	public List<CrtCart> list() {
		return iCrtCartDao.list();
	}
	@Override
	public List<CrtCart> load(String cartId) {
		return iCrtCartDao.load(cartId);
	}

	@Override
	public Page pageList(int pageIndex, int pageSize, CrtCart crtCart) throws NoSuchMethodException, SecurityException,
			IllegalAccessException, IllegalArgumentException, InvocationTargetException {
		return iCrtCartDao.pageList(pageIndex, pageSize, crtCart);
	}

	@Override
	public void codeCheck(CrtCart crtCart) throws NoSuchMethodException, SecurityException, IllegalAccessException,
			IllegalArgumentException, InvocationTargetException {
		iCrtCartDao.validateUnique4Code(crtCart);
	}

}
