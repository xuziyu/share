package com.barter.share.bas.service.imp;

import java.lang.reflect.InvocationTargetException;
import java.util.List;

import com.barter.share.bas.dao.IBasProductDao;
import com.barter.share.bas.dao.imp.BasProductDao;
import com.barter.share.bas.entity.BasProduct;
import com.barter.share.bas.service.IBasProductService;
import com.barter.share.bas.vo.BasProductFrontVo;
import com.barter.share.bas.vo.FabricVo;
import com.barter.share.bas.vo.FashionElementVo;
import com.barter.share.bas.vo.GrossWeightVo;
import com.barter.share.bas.vo.PlaceVo;
import com.barter.share.bas.vo.StereotypeVo;
import com.barter.share.framework.entity.Page;

public class BasProductService implements IBasProductService {
	IBasProductDao iBasProductDao = new BasProductDao();
	@Override
	public void insert(BasProduct basProduct) throws NoSuchMethodException, SecurityException, IllegalAccessException,
			IllegalArgumentException, InvocationTargetException {
		iBasProductDao.insert(basProduct);
	}

	@Override
	public void delete(String productId) {
		iBasProductDao.delete(productId);
	}

	@Override
	public void update(BasProduct basProduct) throws NoSuchMethodException, SecurityException, IllegalAccessException,
			IllegalArgumentException, InvocationTargetException {
		iBasProductDao.update(basProduct);
	}
	@Override
	public List<BasProduct> list() {
		return iBasProductDao.list();
	}
	@Override
	public List<BasProduct> load(String productId) {
		return iBasProductDao.load(productId);
	}
	
	@Override
	public Page pageList(int pageIndex, int pageSize, BasProduct basProduct) throws NoSuchMethodException,
			SecurityException, IllegalAccessException, IllegalArgumentException, InvocationTargetException {
		return iBasProductDao.pageList(pageIndex, pageSize, basProduct);
	}

	@Override
	public void codeCheck(BasProduct basProduct) throws NoSuchMethodException, SecurityException,
			IllegalAccessException, IllegalArgumentException, InvocationTargetException {
		iBasProductDao.validateUnique4Code(basProduct);
	}

	@Override
	public Page frontPageList(int pageIndex, int pageSize,String priceMin ,String priceMax , String orderBy, BasProductFrontVo basProductFrontVo)
			throws NoSuchMethodException, SecurityException, IllegalAccessException, IllegalArgumentException,
			InvocationTargetException {
		return iBasProductDao.frontPageList(pageIndex, pageSize,priceMin ,priceMax , orderBy, basProductFrontVo);
	}

	@Override
	public List<PlaceVo> place() {
		return iBasProductDao.place();
	}

	@Override
	public List<FashionElementVo> fashionElement() {
		return iBasProductDao.fashionElement();
	}

	@Override
	public List<FabricVo> fabric() {
		return iBasProductDao.fabric();
	}

	@Override
	public List<StereotypeVo> stereotype() {
		return iBasProductDao.stereotype();
	}

	@Override
	public List<GrossWeightVo> grossWeight() {
		return iBasProductDao.grossWeight();
	}
	
}
