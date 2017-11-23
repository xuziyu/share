package com.barter.share.bas.dao.imp;

import java.math.BigDecimal;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.barter.share.bas.dao.ILoginDao;
import com.barter.share.bas.entity.BasCustomer;
import com.barter.share.bas.entity.SysEmployee;
import com.barter.share.framework.dbutil.DbConnection;
import com.barter.share.framework.exception.DbException;

public class LoginDao implements ILoginDao{

	@Override
	public BasCustomer customerLogin(int id) {
		PreparedStatement prepareStatement = null;
		ResultSet resultSet = null;
		try {
			StringBuffer sql = new StringBuffer("select * from bas_customer where customer_id = ?");
			System.out.println("load sql:" + sql);
			System.out.println("load sql param id:" + id);
			prepareStatement = DbConnection.getConnection().prepareStatement(sql.toString());
			prepareStatement.setObject(1, id);
			resultSet = prepareStatement.executeQuery();
			if (resultSet.next()) {
				BasCustomer basCustomer = new BasCustomer();
				basCustomer.setCustomerId((String) resultSet.getObject("customer_id"));
				basCustomer.setCode((String)resultSet.getObject("code"));
				basCustomer.setName((String)resultSet.getObject("name"));
				basCustomer.setGender((String)resultSet.getObject("gender"));
				basCustomer.setPassword((String)resultSet.getObject("password"));
				basCustomer.setNeedRecvMoney((BigDecimal)resultSet.getObject("need_recv_money"));
				basCustomer.setContactName((String)resultSet.getObject("contact_name"));
				basCustomer.setContactMobile((String)resultSet.getObject("contact_mobile"));
				basCustomer.setAddress((String)resultSet.getObject("address"));
				return basCustomer;
			} else {
				throw new DbException("数据不存在:" + id);
			}
		} catch (Exception ex) {
			ex.printStackTrace();
			throw new DbException(ex.getMessage(), ex);
		} finally {
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

	@Override
	public SysEmployee employeeLogin(int id) {
		PreparedStatement prepareStatement = null;
		ResultSet resultSet = null;
		try {
			StringBuffer sql = new StringBuffer("select * from bas_customer where customer_id = ?");
			System.out.println("load sql:" + sql);
			System.out.println("load sql param id:" + id);
			prepareStatement = DbConnection.getConnection().prepareStatement(sql.toString());
			prepareStatement.setObject(1, id);
			resultSet = prepareStatement.executeQuery();
			if (resultSet.next()) {
				
				return null;
			} else {
				throw new DbException("数据不存在:" + id);
			}
		} catch (Exception ex) {
			ex.printStackTrace();
			throw new DbException(ex.getMessage(), ex);
		} finally {
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
