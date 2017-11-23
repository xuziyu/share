package com.barter.share.bas.dao;

import java.lang.reflect.InvocationTargetException;
import java.util.List;

import com.barter.share.bas.entity.CrtCart;
import com.barter.share.framework.entity.Page;

public interface ICrtCartDao {
	public void insert(CrtCart crtCart) throws NoSuchMethodException, SecurityException, IllegalAccessException, IllegalArgumentException, InvocationTargetException;
	public void delete(String cartId);
	public void update(CrtCart crtCart) throws NoSuchMethodException, SecurityException, IllegalAccessException, IllegalArgumentException, InvocationTargetException;
	public List<CrtCart> list();
	public List<CrtCart> load(String cartId);
	public List<CrtCart> pageResult(int pageIndex, int pageSize, CrtCart crtCart) throws NoSuchMethodException, SecurityException, IllegalAccessException, IllegalArgumentException, InvocationTargetException;
	public int pageRowCount(CrtCart crtCart) throws NoSuchMethodException, SecurityException, IllegalAccessException, IllegalArgumentException, InvocationTargetException;
	public Page pageList(int pageIndex, int pageSize, CrtCart crtCart) throws NoSuchMethodException, SecurityException, IllegalAccessException, IllegalArgumentException, InvocationTargetException;
	public void validateUnique4Code(CrtCart crtCart) throws NoSuchMethodException, SecurityException, IllegalAccessException, IllegalArgumentException, InvocationTargetException;
}
