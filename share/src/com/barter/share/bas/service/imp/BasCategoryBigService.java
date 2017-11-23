package com.barter.share.bas.service.imp;

import java.lang.reflect.InvocationTargetException;
import java.util.List;

import com.barter.share.bas.dao.IBasCategoryBigDao;
import com.barter.share.bas.dao.imp.BasCategoryBigDao;
import com.barter.share.bas.entity.BasCategoryBig;
import com.barter.share.bas.service.IBasCategoryBigService;
import com.barter.share.framework.entity.Page;

public class BasCategoryBigService implements IBasCategoryBigService {
	IBasCategoryBigDao iBasCategoryBigDao = new BasCategoryBigDao();
	@Override
	public void insert(BasCategoryBig basCategoryBig) throws NoSuchMethodException, SecurityException,
			IllegalAccessException, IllegalArgumentException, InvocationTargetException {
		iBasCategoryBigDao.insert(basCategoryBig);
	}

	@Override
	public void delete(String categoryBigId) {
		iBasCategoryBigDao.delete(categoryBigId);
	}

	@Override
	public void update(BasCategoryBig basCategoryBig) throws NoSuchMethodException, SecurityException,
			IllegalAccessException, IllegalArgumentException, InvocationTargetException {
		iBasCategoryBigDao.update(basCategoryBig);
	}
	
	@Override
	public List<BasCategoryBig> list() {
		return iBasCategoryBigDao.list();
	}

	@Override
	public List<BasCategoryBig> load(String categoryBigId) {
		return iBasCategoryBigDao.load(categoryBigId);
	}

	@Override
	public Page pageList(int pageIndex, int pageSize, BasCategoryBig basCategoryBig) throws NoSuchMethodException,
			SecurityException, IllegalAccessException, IllegalArgumentException, InvocationTargetException {
		return iBasCategoryBigDao.pageList(pageIndex, pageSize, basCategoryBig);
	}

	@Override
	public void codeCheck(BasCategoryBig basCategoryBig) throws NoSuchMethodException, SecurityException,
			IllegalAccessException, IllegalArgumentException, InvocationTargetException {
		iBasCategoryBigDao.validateUnique4Code(basCategoryBig);
	}

}
