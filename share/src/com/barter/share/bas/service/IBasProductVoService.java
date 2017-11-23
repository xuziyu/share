package com.barter.share.bas.service;

import java.lang.reflect.InvocationTargetException;
import java.util.List;

import com.barter.share.bas.vo.BasProductVo;
import com.barter.share.framework.entity.Page;

public interface IBasProductVoService {
	public void insert(BasProductVo basProductVo) throws NoSuchMethodException, SecurityException, IllegalAccessException, IllegalArgumentException, InvocationTargetException;
	public void delete(String productId);
	public void update(BasProductVo basProductVo) throws NoSuchMethodException, SecurityException, IllegalAccessException, IllegalArgumentException, InvocationTargetException;
	public List<BasProductVo> list();
	public List<BasProductVo> load(String productId);
	public Page pageList(int pageIndex, int pageSize, BasProductVo basProductVo) throws NoSuchMethodException, SecurityException, IllegalAccessException, IllegalArgumentException, InvocationTargetException;
	public void codeCheck(BasProductVo basProductVo) throws NoSuchMethodException, SecurityException, IllegalAccessException, IllegalArgumentException, InvocationTargetException;
}
