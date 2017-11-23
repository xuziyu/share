package com.barter.share.bas.service;

import java.lang.reflect.InvocationTargetException;
import java.util.List;

import com.barter.share.bas.vo.CrtCartVo;
import com.barter.share.framework.entity.Page;

public interface ICrtCartVoService {
	public void insert(CrtCartVo crtCartVo) throws NoSuchMethodException, SecurityException, IllegalAccessException, IllegalArgumentException, InvocationTargetException;
	public void delete(String cartId);
	public void update(CrtCartVo crtCartVo) throws NoSuchMethodException, SecurityException, IllegalAccessException, IllegalArgumentException, InvocationTargetException;
	public List<CrtCartVo> list();
	public List<CrtCartVo> load(String cartId);
	public Page pageList(int pageIndex, int pageSize, CrtCartVo crtCartVo) throws NoSuchMethodException, SecurityException, IllegalAccessException, IllegalArgumentException, InvocationTargetException;
	public void codeCheck(CrtCartVo crtCartVo) throws NoSuchMethodException, SecurityException, IllegalAccessException, IllegalArgumentException, InvocationTargetException;
}
