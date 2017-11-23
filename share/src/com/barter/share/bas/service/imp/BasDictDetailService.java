package com.barter.share.bas.service.imp;

import java.lang.reflect.InvocationTargetException;
import java.util.List;

import com.barter.share.bas.dao.IBasDictDetailDao;
import com.barter.share.bas.dao.imp.BasDictDetailDao;
import com.barter.share.bas.entity.BasDictDetail;
import com.barter.share.bas.service.IBasDictDetailService;
import com.barter.share.framework.entity.Page;

public class BasDictDetailService implements IBasDictDetailService {
	IBasDictDetailDao iBasDictDetailDao = new BasDictDetailDao();
	@Override
	public void insert(BasDictDetail basDictDetail) throws NoSuchMethodException, SecurityException,
			IllegalAccessException, IllegalArgumentException, InvocationTargetException {
		iBasDictDetailDao.insert(basDictDetail);
	}

	@Override
	public void delete(String dictDetailId) {
		iBasDictDetailDao.delete(dictDetailId);
	}

	@Override
	public void update(BasDictDetail basDictDetail) throws NoSuchMethodException, SecurityException,
			IllegalAccessException, IllegalArgumentException, InvocationTargetException {
		iBasDictDetailDao.update(basDictDetail);
	}
	
	@Override
	public List<BasDictDetail> list() {
		return iBasDictDetailDao.list();
	}

	@Override
	public List<BasDictDetail> load(String dictDetailId) {
		return iBasDictDetailDao.load(dictDetailId);
	}

	@Override
	public Page pageList(int pageIndex, int pageSize, BasDictDetail basDictDetail) throws NoSuchMethodException,
			SecurityException, IllegalAccessException, IllegalArgumentException, InvocationTargetException {
		return iBasDictDetailDao.pageList(pageIndex, pageSize, basDictDetail);
	}

	@Override
	public void codeCheck(BasDictDetail basDictDetail) throws NoSuchMethodException, SecurityException,
			IllegalAccessException, IllegalArgumentException, InvocationTargetException {
		iBasDictDetailDao.validateUnique4Code(basDictDetail);
	}

}
