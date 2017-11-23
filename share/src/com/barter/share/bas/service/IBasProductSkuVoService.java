package com.barter.share.bas.service;

import java.lang.reflect.InvocationTargetException;
import java.util.List;

import com.barter.share.bas.vo.BasProductSkuVo;
import com.barter.share.framework.entity.Page;

public interface IBasProductSkuVoService {
	public void insert(BasProductSkuVo basProductSkuVo) throws NoSuchMethodException, SecurityException, IllegalAccessException, IllegalArgumentException, InvocationTargetException;
	public void delete(String productSkuId);
	public void update(BasProductSkuVo basProductSkuVo) throws NoSuchMethodException, SecurityException, IllegalAccessException, IllegalArgumentException, InvocationTargetException;
	public List<BasProductSkuVo> list();
	public List<BasProductSkuVo> load(String productSkuId);
	public Page pageList(int pageIndex, int pageSize, BasProductSkuVo basProductSkuVo) throws NoSuchMethodException, SecurityException, IllegalAccessException, IllegalArgumentException, InvocationTargetException;
	public void codeCheck(BasProductSkuVo basProductSkuVo) throws NoSuchMethodException, SecurityException, IllegalAccessException, IllegalArgumentException, InvocationTargetException;
}
