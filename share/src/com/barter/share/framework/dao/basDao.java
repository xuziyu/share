package com.barter.share.framework.dao;

import java.sql.Connection;

import com.barter.share.framework.dbutil.DbConnection;

public class basDao {
	protected DbConnection dbConnection = new DbConnection() ;
	
	protected Connection getConnection(){
		return dbConnection.getConnection() ;
	}
	
	
	protected void closeConnection(){
		dbConnection.close() ;
	}

}
