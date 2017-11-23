package com.barter.share.bas.service.imp;

import java.lang.reflect.InvocationTargetException;
import java.util.List;

import com.barter.share.bas.dao.IBasCategorySmallVoDao;
import com.barter.share.bas.dao.imp.BasCategorySmallVoDao;
import com.barter.share.bas.service.IBasCategorySmallVoService;
import com.barter.share.bas.vo.BasCategorySmallVo;
import com.barter.share.framework.entity.Page;

public class BasCategorySmallVoService implements IBasCategorySmallVoService {
	IBasCategorySmallVoDao iBasCategorySmallVoDao = new BasCategorySmallVoDao();
	@Override
	public void insert(BasCategorySmallVo basCategorySmallVo) throws NoSuchMethodException, SecurityException,
			IllegalAccessException, IllegalArgumentException, InvocationTargetException {
		
	}

	@Override
	public void delete(String categorySmallId) {
		
	}

	@Override
	public void update(BasCategorySmallVo basCategorySmallVo) throws NoSuchMethodException, SecurityException,
			IllegalAccessException, IllegalArgumentException, InvocationTargetException {
		
	}

	@Override
	public List<BasCategorySmallVo> list() {
		return null;
	}

	@Override
	public List<BasCategorySmallVo> load(String categorySmallId) {
		return null;
	}

	@Override
	public Page pageList(int pageIndex, int pageSize, BasCategorySmallVo basCategorySmallVo)
			throws NoSuchMethodException, SecurityException, IllegalAccessException, IllegalArgumentException,
			InvocationTargetException {
		return iBasCategorySmallVoDao.pageList(pageIndex, pageSize, basCategorySmallVo);
	}

	@Override
	public void codeCheck(BasCategorySmallVo basCategorySmallVo) throws NoSuchMethodException, SecurityException,
			IllegalAccessException, IllegalArgumentException, InvocationTargetException {
		
	}

}
