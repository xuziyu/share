package com.barter.share.bas.dao;

import java.lang.reflect.InvocationTargetException;
import java.util.List;

import com.barter.share.bas.vo.BasProductSkuVo;
import com.barter.share.framework.entity.Page;

public interface IBasProductSkuVoDao {
	public void insert(BasProductSkuVo basProductSkuVo) throws NoSuchMethodException, SecurityException, IllegalAccessException, IllegalArgumentException, InvocationTargetException;
	public void delete(String productSkuId);
	public void update(BasProductSkuVo basProductSkuVo) throws NoSuchMethodException, SecurityException, IllegalAccessException, IllegalArgumentException, InvocationTargetException;
	public List<BasProductSkuVo> list();
	public List<BasProductSkuVo> load(String productSkuId);
	public List<BasProductSkuVo> pageResult(int pageIndex, int pageSize, BasProductSkuVo basProductSkuVo) throws NoSuchMethodException, SecurityException, IllegalAccessException, IllegalArgumentException, InvocationTargetException;
	public int pageRowCount(BasProductSkuVo basProductSkuVo) throws NoSuchMethodException, SecurityException, IllegalAccessException, IllegalArgumentException, InvocationTargetException;
	public Page pageList(int pageIndex, int pageSize, BasProductSkuVo basProductSkuVo) throws NoSuchMethodException, SecurityException, IllegalAccessException, IllegalArgumentException, InvocationTargetException;
	public void validateUnique4Code(BasProductSkuVo basProductSkuVo) throws NoSuchMethodException, SecurityException, IllegalAccessException, IllegalArgumentException, InvocationTargetException;
}
