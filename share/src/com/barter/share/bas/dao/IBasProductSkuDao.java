package com.barter.share.bas.dao;

import java.lang.reflect.InvocationTargetException;
import java.util.List;

import com.barter.share.bas.entity.BasProductSku;
import com.barter.share.framework.entity.Page;


/**
 * 
 * @author 卢翔
 *
 */
public interface IBasProductSkuDao {
	public void insert(BasProductSku basProductSku) throws NoSuchMethodException, SecurityException, IllegalAccessException, IllegalArgumentException, InvocationTargetException;
	public void delete(String productSkuId);
	public void update(BasProductSku basProductSku) throws NoSuchMethodException, SecurityException, IllegalAccessException, IllegalArgumentException, InvocationTargetException;
	public List<BasProductSku> list();
	public List<BasProductSku> load(String productSkuId);
	public List<BasProductSku> pageResult(int pageIndex, int pageSize ,BasProductSku basProductSku) throws NoSuchMethodException, SecurityException, IllegalAccessException, IllegalArgumentException, InvocationTargetException;
	public int pageRowCount(BasProductSku basProductSku) throws NoSuchMethodException, SecurityException, IllegalAccessException, IllegalArgumentException, InvocationTargetException;
	public Page pageList(int pageIndex, int pageSize ,BasProductSku basProductSku) throws NoSuchMethodException, SecurityException, IllegalAccessException, IllegalArgumentException, InvocationTargetException;
	public void validateUnique4Code(BasProductSku basProductSku) throws NoSuchMethodException, SecurityException, IllegalAccessException, IllegalArgumentException, InvocationTargetException;
}
