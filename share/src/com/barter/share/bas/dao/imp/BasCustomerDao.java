package com.barter.share.bas.dao.imp;

import java.lang.reflect.InvocationTargetException;
import java.math.BigDecimal;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;

import com.barter.share.bas.dao.IBasCustomerDao;
import com.barter.share.bas.entity.BasCustomer;
import com.barter.share.framework.dao.BaseDao;
import com.barter.share.framework.dbutil.DbConnection;
import com.barter.share.framework.entity.Page;
import com.barter.share.framework.exception.DbException;
import com.barter.share.framework.exception.ValidateException;
import com.barter.share.framework.util.StringUtil;

public class BasCustomerDao extends BaseDao implements IBasCustomerDao{

	@Override
	public void insert(BasCustomer customer) throws NoSuchMethodException, SecurityException, IllegalAccessException, IllegalArgumentException, InvocationTargetException {
		StringBuffer sql = new StringBuffer("insert into bas_customer(customer_id,code,name,gender,password,need_recv_money,contact_name,contact_mobile,address) value");
		sql.append("(?,?,?,?,?,?,?,?,?)");
		Object [] paramsValue = StringUtil.reflectValue(customer);
		super.update(sql, paramsValue);
	}


	@Override
	public void delete(String customerId) {
		StringBuffer sql = new StringBuffer("delete from bas_customer where ");
		sql.append("customer_id = ?");
		Object [] paramsValue = {customerId};
		super.update(sql, paramsValue);	
	}


	@Override
	public void update(BasCustomer customer) throws NoSuchMethodException, SecurityException, IllegalAccessException, IllegalArgumentException, InvocationTargetException {
		StringBuffer sql = new StringBuffer("update bas_customer set");
		sql.append(" code = ? ,name = ? ,gender = ? ,password = ? ,need_recv_money = ? ,contact_name = ? ,contact_mobile = ? ,address = ? Where ");
		sql.append("customer_id = ?");
		Object [] paramsValue =StringUtil.leftOne(StringUtil.reflectValue(customer));
		super.update(sql, paramsValue);
	}

	@Override
	public List<BasCustomer> list() {
		StringBuffer sql = new StringBuffer("SELECT * FROM bas_customer WHERE 1=1");
		return super.query(sql, null, BasCustomer.class);
	}

	@Override
	public List<BasCustomer> load(String customerId) {
		StringBuffer sql = new StringBuffer("SELECT * FROM bas_customer WHERE 1=1");
		sql.append(" AND customer_id = ?");
		Object [] paramsValue ={customerId};
		return super.query(sql, paramsValue, BasCustomer.class);
	}
	

	@Override
	public Page pageList(int pageIndex, int pageSize, BasCustomer customer) throws NoSuchMethodException, SecurityException, IllegalAccessException, IllegalArgumentException, InvocationTargetException {
		Page page = new Page();
		int rowCount = 0;
		rowCount = pageRowCount(customer);
		//
		int pageCount = (rowCount - 1) / pageSize + 1;

		if (pageIndex < 0) {
			pageIndex = 0;
		}

		if (pageIndex > pageCount) {
			pageIndex = pageCount;
		}
		List result = pageResult(pageIndex, pageSize, customer);
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
	public List<BasCustomer> pageResult(int pageIndex, int pageSize, BasCustomer customer) throws NoSuchMethodException, SecurityException, IllegalAccessException, IllegalArgumentException, InvocationTargetException {
		StringBuffer sql = new StringBuffer("SELECT * FROM bas_customer WHERE 1=1");
		Object [] paramsValue =StringUtil.reflectValue(customer);
		Object [] paramsValueTrim =new Object[paramsValue.length];
		String [] sqlAppend ={" AND customer_id LIKE ?"," AND code LIKE ?",
				" AND name LIKE ?","  AND gender LIKE ?"," AND password LIKE ?",
				" AND need_recv_money LIKE ?"," AND contact_name LIKE ?",
				" AND contact_mobile LIKE ?"," AND address LIKE ?"};
		if (customer!=null) {
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
		return super.query(sql, paramsValueTrim, BasCustomer.class);
	}

	@Override
	public int pageRowCount(BasCustomer customer) throws NoSuchMethodException, SecurityException, IllegalAccessException, IllegalArgumentException, InvocationTargetException {
		StringBuffer sql = new StringBuffer("SELECT COUNT(customer_id) FROM bas_customer WHERE 1 = 1");
		Object [] paramsValue = StringUtil.reflectValue(customer);
		Object [] paramsValueTrim =new Object[paramsValue.length];
		String [] sqlAppend ={" AND customer_id LIKE ?"," AND code LIKE ?",
				" AND name LIKE ?","  AND gender LIKE ?"," AND password LIKE ?",
				" AND need_recv_money LIKE ?"," AND contact_name LIKE ?",
				" AND contact_mobile LIKE ?"," AND address LIKE ?"};
		if (customer!=null) {
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
	public void validateUnique4Code(BasCustomer customer) throws NoSuchMethodException, SecurityException, IllegalAccessException, IllegalArgumentException, InvocationTargetException {
		StringBuffer sql = new StringBuffer("SELECT COUNT(customer_id) FROM bas_customer WHERE 1=1");
		Object [] paramsValue =StringUtil.reflectValue(customer);
		Object [] paramsValueTrim =new Object[paramsValue.length];
		String [] sqlAppend ={" AND customer_id LIKE ?"," AND code LIKE ?",
				" AND name LIKE ?","  AND gender LIKE ?"," AND password LIKE ?",
				" AND need_recv_money LIKE ?"," AND contact_name LIKE ?",
				" AND contact_mobile LIKE ?"," AND address LIKE ?"};
		if (customer!=null) {
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
			throw new ValidateException("编号重复:" + customer.getCode());
		}
	}


	@Override
	public BasCustomer basCustomer(String customerId) {
		PreparedStatement prepareStatement = null;
		ResultSet resultSet = null;
		try{
			StringBuffer sql = new StringBuffer("select * from bas_customer where customer_id = ?");
			System.out.println("load sql:" + sql);
			System.out.println("load sql param id:" + customerId);
			prepareStatement = DbConnection.getConnection().prepareStatement(sql.toString());
			prepareStatement.setObject(1, customerId);
			resultSet = prepareStatement.executeQuery();
			if(resultSet.next()){
				BasCustomer basCustomer = new BasCustomer();
				basCustomer.setCustomerId((String)resultSet.getObject("customer_id"));
				basCustomer.setCode((String)resultSet.getObject("code"));
				basCustomer.setName((String)resultSet.getObject("name"));
				basCustomer.setGender((String)resultSet.getObject("gender"));
				basCustomer.setContactName((String)resultSet.getObject("contact_name"));
				basCustomer.setPassword((String)resultSet.getObject("password"));
				basCustomer.setContactMobile((String)resultSet.getObject("contact_mobile"));
				basCustomer.setAddress((String)resultSet.getObject("address"));
				basCustomer.setNeedRecvMoney((BigDecimal)resultSet.getObject("need_recv_money"));
				return basCustomer;
			}else {
				throw new DbException("数据不存在:" + customerId);
			}
		}catch(Exception ex){
			ex.printStackTrace();
			throw new DbException(ex.getMessage(), ex);
		}finally {
			if (resultSet != null) {
				try {
					resultSet.close();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}

			if (prepareStatement != null) {
				try {
					prepareStatement.close();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}
	}
	
	
}
