package com.barter.share.bas.service;

import java.lang.reflect.InvocationTargetException;
import java.util.List;

import com.barter.share.bas.vo.BasDictDetailVo;
import com.barter.share.framework.entity.Page;

public interface IBasDictDetailVoService {
	public void insert(BasDictDetailVo basDictDetailVo) throws NoSuchMethodException, SecurityException, IllegalAccessException, IllegalArgumentException, InvocationTargetException;
	public void delete(String dictDetailId);
	public void update(BasDictDetailVo basDictDetailVo) throws NoSuchMethodException, SecurityException, IllegalAccessException, IllegalArgumentException, InvocationTargetException;
	public List<BasDictDetailVo> list();
	public List<BasDictDetailVo> load(String dictDetailId);
	public Page pageList(int pageIndex, int pageSize, BasDictDetailVo basDictDetailVo) throws NoSuchMethodException, SecurityException, IllegalAccessException, IllegalArgumentException, InvocationTargetException;
	public void codeCheck(BasDictDetailVo basDictDetailVo) throws NoSuchMethodException, SecurityException, IllegalAccessException, IllegalArgumentException, InvocationTargetException;
}
