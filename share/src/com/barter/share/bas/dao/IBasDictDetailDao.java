package com.barter.share.bas.dao;

import java.lang.reflect.InvocationTargetException;
import java.util.List;

import com.barter.share.bas.entity.BasDictDetail;
import com.barter.share.framework.entity.Page;

public interface IBasDictDetailDao {
	public void insert(BasDictDetail basDictDetail) throws NoSuchMethodException, SecurityException, IllegalAccessException, IllegalArgumentException, InvocationTargetException;
	public void delete(String dictDetailId);
	public void update(BasDictDetail basDictDetail) throws NoSuchMethodException, SecurityException, IllegalAccessException, IllegalArgumentException, InvocationTargetException;
	public List<BasDictDetail> list();
	public List<BasDictDetail> load(String dictDetailId);
	public List<BasDictDetail> pageResult(int pageIndex, int pageSize, BasDictDetail basDictDetail) throws NoSuchMethodException, SecurityException, IllegalAccessException, IllegalArgumentException, InvocationTargetException;
	public int pageRowCount(BasDictDetail basDictDetail) throws NoSuchMethodException, SecurityException, IllegalAccessException, IllegalArgumentException, InvocationTargetException;
	public Page pageList(int pageIndex, int pageSize, BasDictDetail basDictDetail) throws NoSuchMethodException, SecurityException, IllegalAccessException, IllegalArgumentException, InvocationTargetException;
	public void validateUnique4Code(BasDictDetail basDictDetail) throws NoSuchMethodException, SecurityException, IllegalAccessException, IllegalArgumentException, InvocationTargetException;
}
