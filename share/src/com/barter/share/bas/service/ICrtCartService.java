package com.barter.share.bas.service;

import java.lang.reflect.InvocationTargetException;
import java.util.List;

import com.barter.share.bas.entity.CrtCart;
import com.barter.share.framework.entity.Page;

public interface ICrtCartService {
	public void insert(CrtCart crtCart) throws NoSuchMethodException, SecurityException, IllegalAccessException, IllegalArgumentException, InvocationTargetException;
	public void delete(String cartId);
	public void update(CrtCart crtCart) throws NoSuchMethodException, SecurityException, IllegalAccessException, IllegalArgumentException, InvocationTargetException;
	public List<CrtCart> list();
	public List<CrtCart> load(String cartId);
	public Page pageList(int pageIndex, int pageSize, CrtCart crtCart) throws NoSuchMethodException, SecurityException, IllegalAccessException, IllegalArgumentException, InvocationTargetException;
	public void codeCheck(CrtCart crtCart) throws NoSuchMethodException, SecurityException, IllegalAccessException, IllegalArgumentException, InvocationTargetException;
}
