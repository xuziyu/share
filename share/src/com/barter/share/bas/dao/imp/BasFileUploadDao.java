package com.barter.share.bas.dao.imp;

import java.lang.reflect.InvocationTargetException;
import java.util.List;

import com.barter.share.bas.dao.IBasFileUploadDao;
import com.barter.share.bas.entity.BasFileUpload;
import com.barter.share.framework.dao.BaseDao;
import com.barter.share.framework.entity.Page;
import com.barter.share.framework.exception.ValidateException;
import com.barter.share.framework.util.StringUtil;

public class BasFileUploadDao extends BaseDao implements IBasFileUploadDao {

	@Override
	public void insert(BasFileUpload basFileUpload) throws NoSuchMethodException, SecurityException,
			IllegalAccessException, IllegalArgumentException, InvocationTargetException {
		StringBuffer sql = new StringBuffer("INSERT INTO bas_file_upload (file_upload_id, file_spec, full_path, short_name, ext_name, file_size) VALUES ");
		sql.append("(?, ?, ?, ?, ?, ?)");
		Object [] paramsValue =StringUtil.reflectValue(basFileUpload);
		super.update(sql, paramsValue);
	}

	@Override
	public void delete(String fileUploadId) {
		StringBuffer sql = new StringBuffer("DELETE FROM bas_file_upload WHERE file_upload_id = ?");
		Object [] paramsValue ={fileUploadId};
		super.update(sql, paramsValue);
	}

	@Override
	public void update(BasFileUpload basFileUpload) throws NoSuchMethodException, SecurityException,
			IllegalAccessException, IllegalArgumentException, InvocationTargetException {
		StringBuffer sql = new StringBuffer("UPDATE bas_file_upload SET file_spec = ? , full_path = ? , short_name = ? , ext_name = ? , file_size = ? WHERE file_upload_id = ?");
		Object [] paramsValue =StringUtil.leftOne(StringUtil.reflectValue(basFileUpload));
		super.update(sql, paramsValue);
	}

	@Override
	public List<BasFileUpload> list() {
		StringBuffer sql = new StringBuffer("SELECT * FROM bas_file_upload");
		Object [] paramsValue =null;
		return super.query(sql, paramsValue, BasFileUpload.class);
	}

	@Override
	public List<BasFileUpload> load(String fileUploadId) {
		StringBuffer sql = new StringBuffer("SELECT * FROM bas_file_upload WHERE 1 = 1 AND file_upload_id = ?");
		Object [] paramsValue ={fileUploadId};
		return super.query(sql, paramsValue, BasFileUpload.class);
	}

	@Override
	public List<BasFileUpload> pageResult(int pageIndex, int pageSize, BasFileUpload basFileUpload)
			throws NoSuchMethodException, SecurityException, IllegalAccessException, IllegalArgumentException,
			InvocationTargetException {
		StringBuffer sql = new StringBuffer("SELECT * FROM bas_file_upload WHERE 1 = 1");
		Object [] paramsValue = StringUtil.reflectValue(basFileUpload);
		Object [] paramsValueTrim =new Object[paramsValue.length];
		String [] sqlAppend ={" and file_upload_id like ?"," and file_spec like ?"," and full_path like ?"," and short_name like ?"," and ext_name like ?"," and file_size like ?"};
		if (basFileUpload!=null) {
			int valueIndex =0;
			for (int i = 0; i < paramsValue.length; i++) {
				if (!StringUtil.isEmpty(paramsValue[i])) {
					sql.append(sqlAppend[i]);
					paramsValueTrim[valueIndex] = "%"+paramsValue[i]+"%";
					valueIndex++;
				}
			}
		}
		sql.append(" order by file_upload_id desc");
		sql.append(" limit " + pageIndex * pageSize + "," + pageSize);
		return super.query(sql, paramsValueTrim, BasFileUpload.class);
	}

	@Override
	public int pageRowCount(BasFileUpload basFileUpload) throws NoSuchMethodException, SecurityException,
			IllegalAccessException, IllegalArgumentException, InvocationTargetException {
		StringBuffer sql = new StringBuffer("SELECT COUNT(file_upload_id) FROM bas_file_upload WHERE 1 = 1");
		Object [] paramsValue = StringUtil.reflectValue(basFileUpload);
		Object [] paramsValueTrim =new Object[paramsValue.length];
		String [] sqlAppend ={" and file_upload_id like ?"," and file_spec like ?"," and full_path like ?"," and short_name like ?"," and ext_name like ?"," and file_size like ?"};
		if (basFileUpload!=null) {
			int valueIndex =0;
			for (int i = 0; i < paramsValue.length; i++) {
				if (!StringUtil.isEmpty(paramsValue[i])) {
					System.out.println(sqlAppend[i]);
					System.out.println(paramsValue[i]);
					sql.append(sqlAppend[i]);
					paramsValueTrim[valueIndex] = "%"+paramsValue[i]+"%";
					valueIndex++;
				}
			}
		}
		return super.resultRowCount(sql, paramsValueTrim);
	}

	@Override
	public Page pageList(int pageIndex, int pageSize, BasFileUpload basFileUpload) throws NoSuchMethodException,
			SecurityException, IllegalAccessException, IllegalArgumentException, InvocationTargetException {
		Page page = new Page();
		int rowCount =0;
		//获得 查询结果的行数
		rowCount = pageRowCount(basFileUpload);
		int pageCount = (rowCount - 1) / pageSize + 1;

		if (pageIndex < 0) {
			pageIndex = 0;
		}

		if (pageIndex > pageCount) {
			pageIndex = pageCount;
		}
		//把查询到的 实体对象数组   存到  result 并作为属性 给  page对象
		List result = pageResult(pageIndex, pageSize,basFileUpload);
		page.setPageSize(pageSize);
		page.setPageIndex(pageIndex);
		page.setPageCount(pageCount);
		page.setRowCount(rowCount);
		page.setResult(result);
		if (pageIndex == 0) {
			page.setHasPrior(false);
		} else {
			page.setHasPrior(true);
		}

		if (pageIndex >= pageCount - 1) {
			page.setHasNext(false);
		} else {
			page.setHasNext(true);
		}
		return page;
	}

	@Override
	public void validateUnique4Code(BasFileUpload basFileUpload) throws NoSuchMethodException, SecurityException,
			IllegalAccessException, IllegalArgumentException, InvocationTargetException {
		StringBuffer sql = new StringBuffer("select count(file_upload_id) from bas_file_upload where short_name = ? and ext_name = ?");
		String [] paramsValue = {basFileUpload.getShortName(),basFileUpload.getExtName()};
		int count = super.resultRowCount(sql, paramsValue);
		if (count>=1) {
			throw new ValidateException("名字重复"+basFileUpload.getShortName()+"."+basFileUpload.getExtName());
		}
		
	}

	@Override
	public List<BasFileUpload> loadOri() {
		StringBuffer sql = new StringBuffer("SELECT * FROM bas_file_upload WHERE file_spec = 0");
		return query(sql, null, BasFileUpload.class);
	}

	@Override
	public List<BasFileUpload> loadBig() {
		StringBuffer sql = new StringBuffer("SELECT * FROM bas_file_upload WHERE file_spec = 1");
		return query(sql, null, BasFileUpload.class);
	}

	@Override
	public List<BasFileUpload> loadMid() {
		StringBuffer sql = new StringBuffer("SELECT * FROM bas_file_upload WHERE file_spec = 2");
		return query(sql, null, BasFileUpload.class);
	}

	@Override
	public List<BasFileUpload> loadSmall() {
		StringBuffer sql = new StringBuffer("SELECT * FROM bas_file_upload WHERE file_spec = 3");
		return query(sql, null, BasFileUpload.class);
	}
	
}
