package com.barter.share.bas.service;

import java.lang.reflect.InvocationTargetException;
import java.util.List;

import com.barter.share.bas.entity.BasProduct;
import com.barter.share.bas.vo.BasProductFrontVo;
import com.barter.share.bas.vo.FabricVo;
import com.barter.share.bas.vo.FashionElementVo;
import com.barter.share.bas.vo.GrossWeightVo;
import com.barter.share.bas.vo.PlaceVo;
import com.barter.share.bas.vo.StereotypeVo;
import com.barter.share.framework.entity.Page;

public interface IBasProductService {
	public void insert(BasProduct basProduct) throws NoSuchMethodException, SecurityException, IllegalAccessException, IllegalArgumentException, InvocationTargetException;
	public void delete(String productId);
	public void update(BasProduct basProduct) throws NoSuchMethodException, SecurityException, IllegalAccessException, IllegalArgumentException, InvocationTargetException;
	public List<BasProduct> list();
	public List<BasProduct> load(String productId);
	public Page pageList(int pageIndex, int pageSize, BasProduct basProduct) throws NoSuchMethodException, SecurityException, IllegalAccessException, IllegalArgumentException, InvocationTargetException;
	public void codeCheck(BasProduct basProduct) throws NoSuchMethodException, SecurityException, IllegalAccessException, IllegalArgumentException, InvocationTargetException;
	public Page frontPageList(int pageIndex , int pageSize,String priceMin ,String priceMax , String orderBy , BasProductFrontVo basProductFrontVo) throws NoSuchMethodException, SecurityException, IllegalAccessException, IllegalArgumentException, InvocationTargetException;;
	public List<PlaceVo> place();
	public List<FashionElementVo> fashionElement();
	public List<FabricVo> fabric();
	public List<StereotypeVo> stereotype();
	public List<GrossWeightVo> grossWeight();
}
