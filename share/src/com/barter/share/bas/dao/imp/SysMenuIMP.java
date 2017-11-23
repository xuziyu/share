package com.barter.share.bas.dao.imp;

import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.barter.share.bas.dao.ISysEmployeeRole;
import com.barter.share.bas.entity.SysEmployee;
import com.barter.share.framework.dbutil.DbConnection;

public class SysMenuIMP implements ISysEmployeeRole {

	@Override
	public void update(HttpServletRequest request, HttpServletResponse response) {
		SysEmployee sysEmployee=new SysEmployee();
		PreparedStatement preparedStatement;
		try {
			String sql = "update sys_menu set module_id=?,code=? ,name=?, enabled=?,";
			sql+="menu_url=?where menu_id = ?";
			System.out.println("updateOne sql:" + sql);
			System.out.println("updateOne sql param:" );
			DbConnection emp=new DbConnection();
			preparedStatement = emp.getConnection().prepareStatement(sql);
			preparedStatement.setObject(1, request.getParameter("organizationId"));
			preparedStatement.setObject(2, request.getParameter("code"));
			preparedStatement.setObject(3, request.getParameter("name"));
			preparedStatement.setObject(4, request.getParameter("password"));
			preparedStatement.setObject(5, request.getParameter("birth"));
			preparedStatement.setObject(6, request.getParameter("onJobStatus"));
			System.out.println(request.getParameter("employeeId"));
			int row = preparedStatement.executeUpdate();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public void delete(HttpServletRequest request, HttpServletResponse response) {
		PreparedStatement preparedStatement;
		String sql="delete from sys_menu where menu_id=?";
		DbConnection emp=new DbConnection();
		try {
			preparedStatement=emp.getConnection().prepareStatement(sql);
			preparedStatement.setObject(1, request.getParameter(""));
			int row = preparedStatement.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	public void insert(HttpServletRequest request, HttpServletResponse response) {
		PreparedStatement preparedStatement;
		try {
			String sql = "insert into sys_menu (module_id,code,name,enabled,menu_url)";
			sql+="values(?,?,?,?,?)";
			System.out.println("updateOne sql:" + sql);
			System.out.println("updateOne sql param:" );
			DbConnection emp=new DbConnection();
			preparedStatement = emp.getConnection().prepareStatement(sql);
			preparedStatement.setObject(1, request.getParameter("organizationId"));
			preparedStatement.setObject(2, request.getParameter("code"));
			preparedStatement.setObject(3, request.getParameter("name"));
			preparedStatement.setObject(4, request.getParameter("password"));
			preparedStatement.setObject(5, request.getParameter("birth"));
			System.out.println(request.getParameter("employeeId"));
			int row = preparedStatement.executeUpdate();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
