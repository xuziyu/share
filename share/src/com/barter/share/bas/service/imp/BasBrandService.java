package com.barter.share.bas.service.imp;

import java.lang.reflect.InvocationTargetException;
import java.util.List;

import com.barter.share.bas.dao.IBasBrandDao;
import com.barter.share.bas.dao.imp.BasBrandDao;
import com.barter.share.bas.entity.BasBrand;
import com.barter.share.bas.service.IBasBrandService;
import com.barter.share.framework.entity.Page;

public class BasBrandService implements IBasBrandService {

	IBasBrandDao iBasBrandDao = new BasBrandDao();
	@Override
	public void insert(BasBrand basBrand) throws NoSuchMethodException, SecurityException, IllegalAccessException, IllegalArgumentException, InvocationTargetException {
		iBasBrandDao.insert(basBrand);
	}

	@Override
	public void delete(String basBrandId) {
		iBasBrandDao.delete(basBrandId);
	}

	@Override
	public void update(BasBrand basBrand) throws NoSuchMethodException, SecurityException, IllegalAccessException, IllegalArgumentException, InvocationTargetException {
		iBasBrandDao.update(basBrand);
	}
	
	@Override
	public List<BasBrand> list() {
		return iBasBrandDao.list();
	}
	
	@Override
	public List<BasBrand> load(String basBrandId) {
		return iBasBrandDao.load(basBrandId);
	}

	@Override
	public Page pageList(int pageIndex, int pageSize, BasBrand basBrand) throws NoSuchMethodException, SecurityException, IllegalAccessException, IllegalArgumentException, InvocationTargetException {
		return iBasBrandDao.pageList(pageIndex, pageSize, basBrand);
	}

	@Override
	public void codeCheck(BasBrand basBrand) throws NoSuchMethodException, SecurityException, IllegalAccessException, IllegalArgumentException, InvocationTargetException {
		iBasBrandDao.validateUnique4Code(basBrand);
	}

}
