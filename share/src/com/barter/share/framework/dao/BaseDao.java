package com.barter.share.framework.dao;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

import com.barter.share.framework.dbutil.DbConnection;
import com.barter.share.framework.exception.DbException;
import com.barter.share.framework.util.StringUtil;




public class BaseDao {
	private PreparedStatement preparedStatement = null;
	private ResultSet resultSet = null;
	
	/*
	 * 查询
	 */
	public <T>List<T> query(StringBuffer sql ,Object [] paramsValue,Class<T> clazz){
		List<T> list = new ArrayList<>();
		T t = null;
		Connection connection = DbConnection.getConnection();
		try {
			preparedStatement = connection.prepareStatement(sql.toString());
			int count = preparedStatement.getParameterMetaData().getParameterCount();
			if (paramsValue!=null&&paramsValue.length>0) {
				int paramsIndex=0;
				
				for (int i = 0; i < count; i++) {
					if (!StringUtil.objectFromString(paramsValue[i])) {
						preparedStatement.setObject(paramsIndex+1, paramsValue[paramsIndex]);
						paramsIndex++;
					}
				}
			}
			resultSet = preparedStatement.executeQuery();
			ResultSetMetaData resultSetMetaData = resultSet.getMetaData();
			int columnCount = resultSetMetaData.getColumnCount();
			Method [] method = clazz.getMethods();
			Field [] fields = clazz.getDeclaredFields();
			String[] colNames = new String[fields.length]; 
			
			while(resultSet.next()){
				try {
					t=clazz.newInstance();
					for (int i = 0; i < fields.length; i++) {
						Field field =fields[i];
						String colName=field.getName().substring(0, 1).toUpperCase()+field.getName().substring(1);
						colNames[i] = colName;
					}
					//循环生成set方法   并调用该set方法
					for (int i = 0; i < columnCount; i++) {
						//得到set方法
						String methodName = "set"+colNames[i];
						//得到第i+1列的别名
						String columnName = resultSetMetaData.getColumnLabel(i+1);
						String columnType = resultSetMetaData.getColumnTypeName(i+1).toLowerCase();
						//获得对应的java类型
						String javaType = StringUtil.sqlType2JavaType(columnType);
						for(Method method2 :method){
							if (methodName.equals(method2.getName())) {
								try {
									//通过反射来调用实体中的set方法
									if ("BigDecimal".equals(javaType)) {
										Object value = resultSet.getObject(columnName);
										method2.invoke(t, value);
									}else if ("Double".equals(javaType)) {
										Object value = resultSet.getObject(columnName);
										method2.invoke(t, value);
									}else if ("Date".equals(javaType)) {
										Date value = (Date)resultSet.getObject(columnName);
										method2.invoke(t, value);
									}else if ("Boolean".equals(javaType)) {
										Object value = resultSet.getObject(columnName);
										method2.invoke(t, value);
									}else if ("Float".equals(javaType)) {
										Object value = resultSet.getObject(columnName);
										method2.invoke(t, value);
									}else if ("String".equals(javaType)) {
										Object value = resultSet.getObject(columnName);
										method2.invoke(t, value);
									}
								} catch (IllegalArgumentException e) {
									e.printStackTrace();
								} catch (InvocationTargetException e) {
									e.printStackTrace();
								}
							}
						}
					}
					
					list.add(t);
				} catch (InstantiationException e) {
					e.printStackTrace();
					throw new DbException("InstantiationException"+e);
				} catch (IllegalAccessException e) {
					e.printStackTrace();
					throw new DbException("IllegalAccessException"+e);
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
			throw new DbException("SQLException"+e);
		}finally {
			if (resultSet!=null) {
				try {
					resultSet.close();
				} catch (SQLException e) {
					e.printStackTrace();
					throw new DbException("SQLException resultSet.close();"+e);
				}
			}
			if (preparedStatement!=null) {
				try {
					preparedStatement.close();
				} catch (SQLException e) {
					e.printStackTrace();
					throw new DbException("SQLException preparedStatement.close();"+e);
				}
			}
		}
		return list;
	}
	
	/*
	 * 删除、插入、修改
	 */
	public void update(StringBuffer sql ,Object [] paramsValue){
		Connection connection = DbConnection.getConnection();
		try {
			preparedStatement = connection.prepareStatement(sql.toString());
			int count = preparedStatement.getParameterMetaData().getParameterCount();
			if (paramsValue!=null&&paramsValue.length>0) {
				for (int i = 0; i < count; i++) {
					preparedStatement.setObject(i+1, paramsValue[i]);
				}
			}
			preparedStatement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
			throw new DbException("SQLException connection.prepareStatement(sql.toString());"+e);
		}finally {
			if (resultSet!=null) {
				try {
					resultSet.close();
				} catch (SQLException e) {
					e.printStackTrace();
					throw new DbException("SQLException resultSet.close();"+e);
				}
			}
			if (preparedStatement!=null) {
				try {
					preparedStatement.close();
				} catch (SQLException e) {
					e.printStackTrace();
					throw new DbException("SQLException preparedStatement.close();"+e);
				}
			}
		}
	}
	/**
	 * 查询结果的总行数
	 */
	
	public int resultRowCount(StringBuffer sql,Object [] paramsValue){
		int count =0;
		Connection connection = DbConnection.getConnection();
		try {
			preparedStatement = connection.prepareStatement(sql.toString());
			int parameterCount =preparedStatement.getParameterMetaData().getParameterCount();
			if (paramsValue!=null&&paramsValue.length>0) {
				int paramsIndex = 0;
				for (int i = 0; i < parameterCount; i++) {
					if (!StringUtil.objectFromString(paramsValue[i])) {
						preparedStatement.setObject(paramsIndex+1, paramsValue[paramsIndex]);
						paramsIndex++;
					}
				}
			}
			resultSet = preparedStatement.executeQuery();
			while(resultSet.next()){
				count = ((Number) resultSet.getObject(1)).intValue();
			}
		} catch (SQLException e) {
			e.printStackTrace();
			throw new DbException("prepareStatement创建失败", e);
		}finally {
			if (resultSet!=null) {
				try {
					resultSet.close();
				} catch (SQLException e) {
					e.printStackTrace();
					throw new DbException("SQLException resultSet.close();"+e);
				}
			}
			if (preparedStatement!=null) {
				try {
					preparedStatement.close();
				} catch (SQLException e) {
					e.printStackTrace();
					throw new DbException("SQLException preparedStatement.close();"+e);
				}
			}
		}
		return count;
	}
}
