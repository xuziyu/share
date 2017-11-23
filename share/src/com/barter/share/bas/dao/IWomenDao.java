package com.barter.share.bas.dao;

import java.util.List;

import com.barter.share.bas.entity.BasBrand;
import com.barter.share.bas.entity.BasCategoryBig;
import com.barter.share.bas.entity.BasCategorySmall;

import com.barter.share.bas.vo.WomenVo;

public interface IWomenDao {
	public List<BasBrand> adBrand();
	public List<WomenVo> adProduct();
	public List<BasCategoryBig> navBig();
	public List<BasCategorySmall> navSmall();
}
