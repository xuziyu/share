package com.barter.share.bas.dao;

import java.lang.reflect.InvocationTargetException;
import java.util.List;

import com.barter.share.bas.vo.BasProductSkuVo;
import com.barter.share.bas.vo.ProductSkuVO;
import com.barter.share.framework.entity.Page;

public interface IBasProductSkuVoDao2 {
	public void insert(BasProductSkuVo basProductSkuVo) throws NoSuchMethodException, SecurityException, IllegalAccessException, IllegalArgumentException, InvocationTargetException;
	public void delete(String productSkuId);
	public void update(BasProductSkuVo basProductSkuVo) throws NoSuchMethodException, SecurityException, IllegalAccessException, IllegalArgumentException, InvocationTargetException;
	public List<BasProductSkuVo> color(String productId);
	public List<BasProductSkuVo> size(String productId);
	public List<BasProductSkuVo> load(String productId);
	public List<BasProductSkuVo> pageResult(int pageIndex, int pageSize, BasProductSkuVo basProductSkuVo) throws NoSuchMethodException, SecurityException, IllegalAccessException, IllegalArgumentException, InvocationTargetException;
	public int pageRowCount(BasProductSkuVo basProductSkuVo) throws NoSuchMethodException, SecurityException, IllegalAccessException, IllegalArgumentException, InvocationTargetException;
	public Page pageList(int pageIndex, int pageSize, BasProductSkuVo basProductSkuVo) throws NoSuchMethodException, SecurityException, IllegalAccessException, IllegalArgumentException, InvocationTargetException;
	
	
	public void validateUnique4Code(BasProductSkuVo basProductSkuVo) throws NoSuchMethodException, SecurityException, IllegalAccessException, IllegalArgumentException, InvocationTargetException;

	public ProductSkuVO salorder(String productSkuId);
}
