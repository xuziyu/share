package com.barter.share.bas.dao;

import java.lang.reflect.InvocationTargetException;
import java.util.List;

import com.barter.share.bas.entity.BasFileUpload;
import com.barter.share.framework.entity.Page;

public interface IBasFileUploadDao {
	public void insert(BasFileUpload basFileUpload) throws NoSuchMethodException, SecurityException, IllegalAccessException, IllegalArgumentException, InvocationTargetException;
	public void delete(String fileUploadId);
	public void update(BasFileUpload basFileUpload) throws NoSuchMethodException, SecurityException, IllegalAccessException, IllegalArgumentException, InvocationTargetException;
	public List<BasFileUpload> list();
	public List<BasFileUpload> load(String fileUploadId);
	public List<BasFileUpload> pageResult(int pageIndex, int pageSize, BasFileUpload basFileUpload) throws NoSuchMethodException, SecurityException, IllegalAccessException, IllegalArgumentException, InvocationTargetException;
	public int pageRowCount(BasFileUpload basFileUpload) throws NoSuchMethodException, SecurityException, IllegalAccessException, IllegalArgumentException, InvocationTargetException;
	public Page pageList(int pageIndex, int pageSize, BasFileUpload basFileUpload) throws NoSuchMethodException, SecurityException, IllegalAccessException, IllegalArgumentException, InvocationTargetException;
	public void validateUnique4Code(BasFileUpload basFileUpload) throws NoSuchMethodException, SecurityException, IllegalAccessException, IllegalArgumentException, InvocationTargetException;
	public List<BasFileUpload> loadOri();
	public List<BasFileUpload> loadBig();
	public List<BasFileUpload> loadMid();
	public List<BasFileUpload> loadSmall();
}
