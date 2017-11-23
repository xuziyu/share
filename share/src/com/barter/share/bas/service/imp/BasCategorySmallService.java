package com.barter.share.bas.service.imp;

import java.lang.reflect.InvocationTargetException;
import java.util.List;

import com.barter.share.bas.dao.IBasCategorySmallDao;
import com.barter.share.bas.dao.imp.BasCategorySmallDao;
import com.barter.share.bas.entity.BasCategorySmall;
import com.barter.share.bas.service.IBasCategorySmallService;
import com.barter.share.framework.entity.Page;

public class BasCategorySmallService implements IBasCategorySmallService {
	IBasCategorySmallDao iBasCategorySmallDao = new BasCategorySmallDao();
	@Override
	public void insert(BasCategorySmall basCategorySmall) throws NoSuchMethodException, SecurityException,
			IllegalAccessException, IllegalArgumentException, InvocationTargetException {
		iBasCategorySmallDao.insert(basCategorySmall);
	}

	@Override
	public void delete(String categorySmallId) {
		iBasCategorySmallDao.delete(categorySmallId);
	}

	@Override
	public void update(BasCategorySmall basCategorySmall) throws NoSuchMethodException, SecurityException,
			IllegalAccessException, IllegalArgumentException, InvocationTargetException {
		iBasCategorySmallDao.update(basCategorySmall);
	}
	
	@Override
	public List<BasCategorySmall> list() {
		return iBasCategorySmallDao.list();
	}

	@Override
	public List<BasCategorySmall> load(String categorySmallId) {
		return iBasCategorySmallDao.load(categorySmallId);
	}

	@Override
	public Page pageList(int pageIndex, int pageSize, BasCategorySmall basCategorySmall) throws NoSuchMethodException,
			SecurityException, IllegalAccessException, IllegalArgumentException, InvocationTargetException {
		return iBasCategorySmallDao.pageList(pageIndex, pageSize, basCategorySmall);
	}

	@Override
	public void codeCheck(BasCategorySmall basCategorySmall) throws NoSuchMethodException, SecurityException,
			IllegalAccessException, IllegalArgumentException, InvocationTargetException {
		iBasCategorySmallDao.validateUnique4Code(basCategorySmall);
	}

}
