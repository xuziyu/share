package com.barter.share.framework.dbutil;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

import com.barter.share.framework.exception.DbException;



/**
 * 
 * 功能描述:数据库连接类
 * @author Administrator
 * @version 1.0
 * 创建日期:2017年5月12日
 */

public class DbConnection {
	private static Properties prop = new Properties();

	//******线程变量,针对每个线程会存储一个连接对象
	private static ThreadLocal<Connection> threadLocalConnection = new ThreadLocal<Connection>();

	static {
		try {
			InputStream resourceAsStream = Thread.currentThread().getContextClassLoader()
					.getResourceAsStream("jdbc.properties");
			if (resourceAsStream != null)
				prop.load(resourceAsStream);
			else
				prop.load(DbConnection.class.getResourceAsStream("/config/jdbc.properties"));

			String driver = prop.getProperty("driver");
			Class.forName(driver);

		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("在classpath下没有找到jdbc.properties文件，系统退出");
			System.exit(0);
		}
	}

	public DbConnection() {
	}

	public static synchronized Connection getConnection() {
		Connection conn = threadLocalConnection.get(); // *****先从当前线程上取出连接实例

		if (null == conn) { 
			try {

				String url = prop.getProperty("url");
				String user = prop.getProperty("user");
				String password = prop.getProperty("password");

				conn = DriverManager.getConnection(url, user, password);
				threadLocalConnection.set(conn); // *****把它绑定到当前线程上
			} catch (Exception e) {
				throw new DbException(e.getMessage(), e);
			}
		}
		return conn;
	}


	public static synchronized void beginTransaction() throws DbException {
		Connection connection = threadLocalConnection.get();
		if (connection != null) {
			try {
				connection.setAutoCommit(false); // 把事务提交方式改为手工提交
			} catch (SQLException e) {
				throw new DbException("开户事务时出现异常", e);
			}
		}
	}

	/** 回滚并关闭连接 */
	public static synchronized void rollback() throws DbException {
		Connection connection = threadLocalConnection.get();
		if (connection != null) {
			try {
				connection.rollback();
			} catch (SQLException e) {
				throw new DbException("回滚事务时出现异常", e);
			}
		}
	}

	/** 提交事务 */
	public static synchronized void commit() throws DbException {
		Connection connection = threadLocalConnection.get();
		if (connection != null) {
			try {
				connection.commit(); // 提交事务
			} catch (SQLException e) {
				e.printStackTrace();
				throw new DbException("提交事务时出现异常", e);
			}
		}
	}

	public static synchronized void close() throws DbException {
		Connection connection = threadLocalConnection.get();
		if (connection != null) {
			try {
				connection.close();
				threadLocalConnection.remove();//*****从线程变量中删除connection
			} catch (SQLException e) {
				e.printStackTrace();
				System.out.println("关闭连接时出现异常");
			}
		}
	}
}
