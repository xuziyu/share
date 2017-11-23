package com.barter.share.bas.service;

import java.util.List;

import com.barter.share.bas.entity.BasBrand;
import com.barter.share.bas.entity.BasCategoryBig;
import com.barter.share.bas.entity.BasCategorySmall;
import com.barter.share.bas.vo.WomenVo;

public interface IWomenService {
	public List<BasBrand> adBrand();
	public List<WomenVo> adProduct();
	public List<BasCategoryBig> navBig();
	public List<BasCategorySmall> navSmall();
}
