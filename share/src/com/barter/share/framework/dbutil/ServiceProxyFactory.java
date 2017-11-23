package com.barter.share.framework.dbutil;
import java.lang.reflect.Proxy;

import com.barter.share.framework.exception.BaseException;




public class ServiceProxyFactory {
	private ServiceProxyFactory() {

	}

	public static Object getProxyInstance(Object target) {
		ServiceInvocationHandler serviceInvocationHandler = new ServiceInvocationHandler(target);
		return Proxy.newProxyInstance(target.getClass().getClassLoader(), target.getClass().getInterfaces(),
				serviceInvocationHandler);
	}

	public static Object getProxyInstance(String className) {
		try {
			return getProxyInstance(Class.forName(className).newInstance());
		} catch (Exception e) {
			e.printStackTrace();
			throw new BaseException(e.getMessage(), e);
		}
	}
}
