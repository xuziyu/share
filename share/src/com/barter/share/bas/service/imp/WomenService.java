package com.barter.share.bas.service.imp;

import java.util.List;

import com.barter.share.bas.dao.IWomenDao;
import com.barter.share.bas.dao.imp.WomenDao;
import com.barter.share.bas.entity.BasBrand;
import com.barter.share.bas.entity.BasCategoryBig;
import com.barter.share.bas.entity.BasCategorySmall;
import com.barter.share.bas.service.IWomenService;
import com.barter.share.bas.vo.WomenVo;

public class WomenService implements IWomenService{
	IWomenDao iWomeenDao = new WomenDao();

	@Override
	public List<BasBrand> adBrand() {

		return iWomeenDao.adBrand();
	}

	@Override
	public List<WomenVo> adProduct() {
		return iWomeenDao.adProduct();
	}

	@Override
	public List<BasCategoryBig> navBig() {
		// TODO Auto-generated method stub
		return iWomeenDao.navBig();
	}

	@Override
	public List<BasCategorySmall> navSmall() {
		return iWomeenDao.navSmall();
	}

}
