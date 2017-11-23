package com.barter.share.bas.dao.imp;

import java.lang.reflect.InvocationTargetException;
import java.util.List;

import com.barter.share.bas.dao.IBasSupplierDao;
import com.barter.share.bas.entity.BasSupplier;
import com.barter.share.framework.dao.BaseDao;
import com.barter.share.framework.entity.Page;
import com.barter.share.framework.exception.ValidateException;
import com.barter.share.framework.util.StringUtil;

public class BasSupplierDao extends BaseDao implements IBasSupplierDao{

	@Override
	public void insert(BasSupplier Supplier) throws NoSuchMethodException, SecurityException, IllegalAccessException, IllegalArgumentException, InvocationTargetException {
		StringBuffer sql = new StringBuffer("insert into bas_supplier(supplier_id,code,name,need_pay_money,contact_name,contact_mobile,address) value");
		sql.append("(?,?,?,?,?,?,?)");
		Object [] paramsValue = StringUtil.reflectValue(Supplier);
		super.update(sql, paramsValue);
	}


	@Override
	public void delete(String SupplierId) {
		StringBuffer sql = new StringBuffer("delete from bas_supplier where ");
		sql.append("Supplier_id = ?");
		Object [] paramsValue = {SupplierId};
		super.update(sql, paramsValue);	
	}


	@Override
	public void update(BasSupplier Supplier) throws NoSuchMethodException, SecurityException, IllegalAccessException, IllegalArgumentException, InvocationTargetException {
		StringBuffer sql = new StringBuffer("update bas_supplier set ");
		sql.append("code = ? ,name = ? ,need_pay_money = ? ,contact_name = ? ,contact_mobile = ? ,address = ? where ");
		sql.append("supplier_id = ?");
		Object [] paramsValue =StringUtil.leftOne(StringUtil.reflectValue(Supplier));
		super.update(sql, paramsValue);
	}
	
	
	@Override
	public List<BasSupplier> list() {
		StringBuffer sql = new StringBuffer("SELECT * FROM bas_supplier WHERE 1=1");
		return super.query(sql, null, BasSupplier.class);
	}

	@Override
	public List<BasSupplier> load(String SupplierId) {
		StringBuffer sql = new StringBuffer("SELECT * FROM bas_supplier WHERE 1=1");
		sql.append(" AND supplier_id = ?");
		Object [] paramsValue ={SupplierId};
		return super.query(sql, paramsValue, BasSupplier.class);
	}
	

	@Override
	public Page pageList(int pageIndex, int pageSize, BasSupplier Supplier) throws NoSuchMethodException, SecurityException, IllegalAccessException, IllegalArgumentException, InvocationTargetException {
		Page page = new Page();
		int rowCount = 0;
		rowCount = pageRowCount(Supplier);
		//
		int pageCount = (rowCount - 1) / pageSize + 1;

		if (pageIndex < 0) {
			pageIndex = 0;
		}

		if (pageIndex > pageCount) {
			pageIndex = pageCount;
		}
		List result = pageResult(pageIndex, pageSize, Supplier);
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
	public List<BasSupplier> pageResult(int pageIndex, int pageSize, BasSupplier Supplier) throws NoSuchMethodException, SecurityException, IllegalAccessException, IllegalArgumentException, InvocationTargetException {
		StringBuffer sql = new StringBuffer("SELECT * FROM bas_supplier WHERE 1=1");
		Object [] paramsValue =StringUtil.reflectValue(Supplier);
		Object [] paramsValueTrim =new Object[paramsValue.length];
		String [] sqlAppend ={" AND supplier_id LIKE ?"," AND code LIKE ?",
				" AND name LIKE ?"," AND need_recv_money LIKE ?",
				" AND contact_name LIKE ?",
				" AND contact_mobile LIKE ?"," AND address LIKE ?"};
		if (Supplier!=null) {
			int valueIndex =0;
			for (int i = 0; i < paramsValue.length; i++) {
				if (!StringUtil.isEmpty(paramsValue[i])) {
					sql.append(sqlAppend[i]);
					paramsValueTrim[valueIndex] = "%"+paramsValue[i]+"%";
					valueIndex++;
				}
			}
		}
		sql.append(" order by code asc");
		sql.append(" limit " + pageIndex * pageSize + "," + pageSize);
		return super.query(sql, paramsValueTrim, BasSupplier.class);
	}

	@Override
	public int pageRowCount(BasSupplier Supplier) throws NoSuchMethodException, SecurityException, IllegalAccessException, IllegalArgumentException, InvocationTargetException {
		StringBuffer sql = new StringBuffer("SELECT COUNT(supplier_id) FROM bas_supplier WHERE 1=1");
		Object [] paramsValue =StringUtil.reflectValue(Supplier);
		Object [] paramsValueTrim =new Object[paramsValue.length];
		String [] sqlAppend ={" AND supplier_id LIKE ?"," AND code LIKE ?",
				" AND name LIKE ?"," AND need_pay_money LIKE ?",
				" AND contact_name LIKE ?",
				" AND contact_mobile LIKE ?"," AND address LIKE ?"};
		if (Supplier!=null) {
			int valueIndex =0;
			for (int i = 0; i < paramsValue.length; i++) {
				if (!StringUtil.isEmpty(paramsValue[i])) {
					sql.append(sqlAppend[i]);
					paramsValueTrim[valueIndex] = "%"+paramsValue[i]+"%";
					valueIndex++;
				}
			}
		}
		return super.resultRowCount(sql, paramsValueTrim);
	}

	@Override
	public void validateUnique4Code(BasSupplier Supplier) throws NoSuchMethodException, SecurityException, IllegalAccessException, IllegalArgumentException, InvocationTargetException {
		StringBuffer sql = new StringBuffer("SELECT COUNT(supplier_id) FROM bas_supplier WHERE 1=1");
		Object [] paramsValue =StringUtil.reflectValue(Supplier);
		Object [] paramsValueTrim =new Object[paramsValue.length];
		String [] sqlAppend ={" AND supplier_id LIKE ?"," AND code LIKE ?",
				" AND name LIKE ?"," AND need_pay_money LIKE ?",
				" AND contact_name LIKE ?",
				" AND contact_mobile LIKE ?"," AND address LIKE ?"};
		if (Supplier!=null) {
			int valueIndex =0;
			for (int i = 0; i < paramsValue.length; i++) {
				if (!StringUtil.isEmpty(paramsValue[i])) {
					sql.append(sqlAppend[i]);
					paramsValueTrim[valueIndex] = "%"+paramsValue[i]+"%";
					valueIndex++;
				}
			}
		}
		int count =super.resultRowCount(sql, paramsValueTrim);
		if (count==1) {
			throw new ValidateException("编号重复:" + Supplier.getCode());
		}
	}
	
	
}
