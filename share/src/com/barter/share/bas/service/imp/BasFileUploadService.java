package com.barter.share.bas.service.imp;

import java.lang.reflect.InvocationTargetException;
import java.util.List;

import com.barter.share.bas.dao.IBasFileUploadDao;
import com.barter.share.bas.dao.imp.BasFileUploadDao;
import com.barter.share.bas.entity.BasFileUpload;
import com.barter.share.bas.service.IBasFileUploadService;
import com.barter.share.framework.entity.Page;

public class BasFileUploadService implements IBasFileUploadService {
	IBasFileUploadDao iBasFileUploadDao = new BasFileUploadDao();
	@Override
	public void insert(BasFileUpload basFileUpload) throws NoSuchMethodException, SecurityException,
			IllegalAccessException, IllegalArgumentException, InvocationTargetException {
		iBasFileUploadDao.insert(basFileUpload);
	}

	@Override
	public void delete(String fileUploadId) {
		iBasFileUploadDao.delete(fileUploadId);
	}

	@Override
	public void update(BasFileUpload basFileUpload) throws NoSuchMethodException, SecurityException,
			IllegalAccessException, IllegalArgumentException, InvocationTargetException {
		iBasFileUploadDao.update(basFileUpload);
	}
	@Override
	public List<BasFileUpload> list() {
		return iBasFileUploadDao.list();
	}
	@Override
	public List<BasFileUpload> load(String fileUploadId) {
		return iBasFileUploadDao.load(fileUploadId);
	}

	@Override
	public Page pageList(int pageIndex, int pageSize, BasFileUpload basFileUpload) throws NoSuchMethodException,
			SecurityException, IllegalAccessException, IllegalArgumentException, InvocationTargetException {
		return iBasFileUploadDao.pageList(pageIndex, pageSize, basFileUpload);
	}

	@Override
	public void codeCheck(BasFileUpload basFileUpload) throws NoSuchMethodException, SecurityException,
			IllegalAccessException, IllegalArgumentException, InvocationTargetException {
		iBasFileUploadDao.validateUnique4Code(basFileUpload);
	}

	@Override
	public List<BasFileUpload> loadOri() {
		return iBasFileUploadDao.loadOri();
	}

	@Override
	public List<BasFileUpload> loadBig() {
		return iBasFileUploadDao.loadBig();
	}

	@Override
	public List<BasFileUpload> loadMid() {
		return iBasFileUploadDao.loadMid();
	}

	@Override
	public List<BasFileUpload> loadSmall() {
		return iBasFileUploadDao.loadSmall();
	}
	
}
