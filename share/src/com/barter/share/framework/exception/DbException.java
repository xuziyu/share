package com.barter.share.framework.exception;

/**
 * 
 * 功能描述:数据库操作基类
 * @author Administrator
 * @version 1.0
 * 创建日期:2017年5月12日
 */
public class DbException extends BaseException {

	public DbException() {
		super();
	}

	public DbException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

	public DbException(String message, Throwable cause) {
		super(message, cause);
	}

	public DbException(String message) {
		super(message);
	}

	public DbException(Throwable cause) {
		super(cause);
	}

}
