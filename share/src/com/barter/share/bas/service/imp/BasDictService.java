package com.barter.share.bas.service.imp;

import java.lang.reflect.InvocationTargetException;
import java.util.List;

import com.barter.share.bas.dao.IBasDictDao;
import com.barter.share.bas.dao.imp.BasDictDao;
import com.barter.share.bas.entity.BasDict;
import com.barter.share.bas.service.IBasDictService;
import com.barter.share.framework.entity.Page;

public class BasDictService implements IBasDictService {
	IBasDictDao iBasDictDao = new BasDictDao();
	@Override
	public void insert(BasDict basDict) throws NoSuchMethodException, SecurityException, IllegalAccessException,
			IllegalArgumentException, InvocationTargetException {
		iBasDictDao.insert(basDict);
	}

	@Override
	public void delete(String dictId) {
		iBasDictDao.delete(dictId);
	}

	@Override
	public void update(BasDict basDict) throws NoSuchMethodException, SecurityException, IllegalAccessException,
			IllegalArgumentException, InvocationTargetException {
		iBasDictDao.update(basDict);
	}
	@Override
	public List<BasDict> list() {
		return iBasDictDao.list();
	}
	@Override
	public List<BasDict> load(String dictId) {
		return iBasDictDao.load(dictId);
	}

	@Override
	public Page pageList(int pageIndex, int pageSize, BasDict basDict) throws NoSuchMethodException, SecurityException,
			IllegalAccessException, IllegalArgumentException, InvocationTargetException {
		return iBasDictDao.pageList(pageIndex, pageSize, basDict);
	}

	@Override
	public void codeCheck(BasDict basDict) throws NoSuchMethodException, SecurityException, IllegalAccessException,
			IllegalArgumentException, InvocationTargetException {
		iBasDictDao.validateUnique4Code(basDict);
	}

}
