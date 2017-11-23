package com.barter.share.bas.service.imp;

import java.lang.reflect.InvocationTargetException;
import java.util.List;

import com.barter.share.bas.dao.IBasDictDetailVoDao;
import com.barter.share.bas.dao.imp.BasDictDetailVoDao;
import com.barter.share.bas.service.IBasDictDetailVoService;
import com.barter.share.bas.vo.BasDictDetailVo;
import com.barter.share.framework.entity.Page;

public class BasDictDetailVoService implements IBasDictDetailVoService {
	IBasDictDetailVoDao iBasDictDetailVoDao = new BasDictDetailVoDao();
	@Override
	public void insert(BasDictDetailVo basDictDetailVo) throws NoSuchMethodException, SecurityException,
			IllegalAccessException, IllegalArgumentException, InvocationTargetException {
		
	}

	@Override
	public void delete(String dictDetailId) {
		
	}

	@Override
	public void update(BasDictDetailVo basDictDetailVo) throws NoSuchMethodException, SecurityException,
			IllegalAccessException, IllegalArgumentException, InvocationTargetException {
		
	}

	@Override
	public List<BasDictDetailVo> list() {
		return null;
	}

	@Override
	public List<BasDictDetailVo> load(String dictDetailId) {
		return null;
	}

	@Override
	public Page pageList(int pageIndex, int pageSize, BasDictDetailVo basDictDetailVo) throws NoSuchMethodException,
			SecurityException, IllegalAccessException, IllegalArgumentException, InvocationTargetException {
		return iBasDictDetailVoDao.pageList(pageIndex, pageSize, basDictDetailVo);
	}

	@Override
	public void codeCheck(BasDictDetailVo basDictDetailVo) throws NoSuchMethodException, SecurityException,
			IllegalAccessException, IllegalArgumentException, InvocationTargetException {
		
	}

}
