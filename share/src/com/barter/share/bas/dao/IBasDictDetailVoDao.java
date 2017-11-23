package com.barter.share.bas.dao;

import java.lang.reflect.InvocationTargetException;
import java.util.List;

import com.barter.share.bas.vo.BasDictDetailVo;
import com.barter.share.framework.entity.Page;

public interface IBasDictDetailVoDao {
	public void insert(BasDictDetailVo basDictDetailVo) throws NoSuchMethodException, SecurityException, IllegalAccessException, IllegalArgumentException, InvocationTargetException;
	public void delete(String dictDetailId);
	public void update(BasDictDetailVo basDictDetailVo) throws NoSuchMethodException, SecurityException, IllegalAccessException, IllegalArgumentException, InvocationTargetException;
	public List<BasDictDetailVo> list();
	public List<BasDictDetailVo> load(String dictDetailId);
	public List<BasDictDetailVo> pageResult(int pageIndex, int pageSize, BasDictDetailVo basDictDetailVo) throws NoSuchMethodException, SecurityException, IllegalAccessException, IllegalArgumentException, InvocationTargetException;
	public int pageRowCount(BasDictDetailVo basDictDetailVo) throws NoSuchMethodException, SecurityException, IllegalAccessException, IllegalArgumentException, InvocationTargetException;
	public Page pageList(int pageIndex, int pageSize, BasDictDetailVo basDictDetailVo) throws NoSuchMethodException, SecurityException, IllegalAccessException, IllegalArgumentException, InvocationTargetException;
	public void validateUnique4Code(BasDictDetailVo basDictDetailVo) throws NoSuchMethodException, SecurityException, IllegalAccessException, IllegalArgumentException, InvocationTargetException;
}
