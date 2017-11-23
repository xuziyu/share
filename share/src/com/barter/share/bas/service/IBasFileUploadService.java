package com.barter.share.bas.service;

import java.lang.reflect.InvocationTargetException;
import java.util.List;

import com.barter.share.bas.entity.BasFileUpload;
import com.barter.share.framework.entity.Page;

public interface IBasFileUploadService {
	public void insert(BasFileUpload basFileUpload) throws NoSuchMethodException, SecurityException, IllegalAccessException, IllegalArgumentException, InvocationTargetException;
	public void delete(String fileUploadId);
	public void update(BasFileUpload basFileUpload) throws NoSuchMethodException, SecurityException, IllegalAccessException, IllegalArgumentException, InvocationTargetException;
	public List<BasFileUpload> list();
	public List<BasFileUpload> load(String fileUploadId);
	public Page pageList(int pageIndex, int pageSize, BasFileUpload basFileUpload) throws NoSuchMethodException, SecurityException, IllegalAccessException, IllegalArgumentException, InvocationTargetException;
	public void codeCheck(BasFileUpload basFileUpload) throws NoSuchMethodException, SecurityException, IllegalAccessException, IllegalArgumentException, InvocationTargetException;
	public List<BasFileUpload> loadOri();
	public List<BasFileUpload> loadBig();
	public List<BasFileUpload> loadMid();
	public List<BasFileUpload> loadSmall();
}
