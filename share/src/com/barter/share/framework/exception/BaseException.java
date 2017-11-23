package com.barter.share.framework.exception;

/**
 * 
 * 功能描述:系统异常基类
 * @author Administrator
 * @version 1.0
 * 创建日期:2017年5月12日
 */
public class BaseException extends RuntimeException{

	public BaseException() {
		super();
	}

	public BaseException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

	public BaseException(String message, Throwable cause) {
		super(message, cause);
	}

	public BaseException(String message) {
		super(message);
	}

	public BaseException(Throwable cause) {
		super(cause);
	}

}
