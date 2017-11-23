package com.barter.share.framework.dbutil;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

import com.barter.share.framework.exception.DbException;




public class ServiceInvocationHandler implements InvocationHandler {
	private Object target;

	public ServiceInvocationHandler(Object target) {
		this.target = target;
	}

	@Override
	public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
		try {
			
			DbConnection.getConnection();
			DbConnection.beginTransaction();

			Object result = method.invoke(target, args);

			DbConnection.commit();
			return result;
		} catch (Exception ex) {
			ex.printStackTrace();

			DbConnection.rollback();
			throw new DbException(ex.getMessage(), ex);
		} finally {
			DbConnection.close();
		}
		

	}

}
