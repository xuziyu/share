package com.barter.share.bas.dao.imp;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.omg.CORBA.PUBLIC_MEMBER;

import sun.security.util.Password;

import com.barter.share.bas.entity.Customer;
import com.barter.share.framework.dao.BaseDao;
import com.barter.share.framework.dao.basDao;
import com.barter.share.framework.exception.DbException;
import com.barter.share.framework.exception.ValidateException;
import com.barter.share.framework.util.StringUtil;
import com.sun.corba.se.spi.orbutil.fsm.Guard.Result;



public class CustomerImp extends basDao{
	
	public Customer insert(Customer customer){
		PreparedStatement preparedStatement=null;
		StringBuffer sql=new StringBuffer("insert into bas_customer ");
		sql.append("(customer_id,name,password,contact_name)");
		sql.append("value(?,?,?,?)");
		try {
			preparedStatement=super.getConnection().prepareStatement(sql.toString());
			int index=1;
			preparedStatement.setObject(index++, customer.getId());
			preparedStatement.setObject(index++, customer.getName());
			preparedStatement.setObject(index++, customer.getPassword());
			preparedStatement.setObject(index++, customer.getTelephone());
			int row =preparedStatement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			if(preparedStatement!=null){
				try {
					preparedStatement.close();
				} catch (Exception e2) {
					e2.printStackTrace();
				}
			}
			closeConnection();
		}
		
		return customer;
	}
	public void load(String id){
	   int count=0;
		PreparedStatement preparedStatement=null;
		ResultSet resultSet=null;
		try {
			StringBuffer sql=new StringBuffer("select count(name) from bas_customer where name = ?");
			preparedStatement=super.getConnection().prepareStatement(sql.toString());
		
			preparedStatement.setObject(1, id);
			resultSet=preparedStatement.executeQuery();
			if(resultSet.next()){
				count=((Number)resultSet.getObject(1)).intValue();
			}
			if(count!=0){
				throw new ValidateException("名字已经存在");
			}
			
		} catch (Exception e) {
			e.printStackTrace();
			throw new ValidateException("名字已经存在");
		}finally{
			if(resultSet !=null){
				try {
					resultSet.close();
				} catch (Exception e2) {
					e2.printStackTrace();
				}
			}
			if(preparedStatement !=null){
				try {
					preparedStatement.close();
				} catch (Exception e2) {
					e2.printStackTrace();
				}
			}
			closeConnection();
		}
		
	}

	public void list(String tele){
		   int count=0;
			PreparedStatement preparedStatement=null;
			ResultSet resultSet=null;
			try {
				StringBuffer sql=new StringBuffer("select contact_mobile from bas_customer");
				preparedStatement=super.getConnection().prepareStatement(sql.toString());
			
				preparedStatement.setObject(1, tele);
			    resultSet=preparedStatement.executeQuery();
				if(resultSet.next()){
					count=((Number)resultSet.getObject(1)).intValue();
				}
				if(count!=0){
					throw new ValidateException("此电话号码已经存在");
				}
				
			} catch (Exception e) {
				e.printStackTrace();
			}finally{
				if(resultSet !=null){
					try {
						resultSet.close();
					} catch (Exception e2) {
						e2.printStackTrace();
					}
				}
				if(preparedStatement !=null){
					try {
						preparedStatement.close();
					} catch (Exception e2) {
						e2.printStackTrace();
					}
				}
				closeConnection();
			}
			
		}
	public Customer llist(String code){
		   //int count=0;
			PreparedStatement preparedStatement=null;
			ResultSet resultSet=null;
			try {
				StringBuffer sql=new StringBuffer("SELECT customer_id , code , name , password FROM bas_customer where code = ?");
				
				preparedStatement=super.getConnection().prepareStatement(sql.toString());
			     
				preparedStatement.setObject(1, code);
				resultSet=preparedStatement.executeQuery();
				Customer customer = new Customer();
				if(resultSet.next()){
					customer.setId((String)resultSet.getObject(1));
					customer.setCode((String)resultSet.getObject(2));
					customer.setName((String)resultSet.getObject(3));
					customer.setPassword((String)resultSet.getObject(4));
				}
				return customer;
			} catch (Exception e) {
				e.printStackTrace();
				throw new DbException();
			}finally{
				if(resultSet !=null){
					try {
						resultSet.close();
					} catch (Exception e2) {
						e2.printStackTrace();
					}
				}
				if(preparedStatement !=null){
					try {
						preparedStatement.close();
					} catch (Exception e2) {
						e2.printStackTrace();
					}
				}
				closeConnection();
			}
			
		}
	

}
