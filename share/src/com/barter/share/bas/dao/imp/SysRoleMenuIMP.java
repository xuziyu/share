package com.barter.share.bas.dao.imp;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Random;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.barter.share.bas.dao.ISysEmployeeRole;
import com.barter.share.bas.entity.SysEmployee;
import com.barter.share.bas.entity.SysEmployeeManegeVO;
import com.barter.share.framework.dbutil.DbConnection;

public class SysRoleMenuIMP implements ISysEmployeeRole {

	@Override
	public void update(HttpServletRequest request, HttpServletResponse response) {
		SysEmployee sysEmployee=new SysEmployee();
		PreparedStatement preparedStatement;
		try {
			String sql = "update sys_employee set organization_id=?,code=? ,name=?, password=?,";
			sql+="birth=?,on_job_status=?,descr=?,head_photo_file_id=?,delete_status=?,gender=?where employee_id = ?";
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
		String sql="delete from sys_role_menu where role_id=?";
		DbConnection emp=new DbConnection();
		try {
			preparedStatement=emp.getConnection().prepareStatement(sql);
			HttpSession session=request.getSession();
			SysEmployeeManegeVO list= (SysEmployeeManegeVO)session.getAttribute("s_list");
			preparedStatement.setObject(1, list.getRoleId());
			int row = preparedStatement.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	public void insert(HttpServletRequest request, HttpServletResponse response) {
		PreparedStatement preparedStatement;
		try {
			String sql = "insert into sys_employee (organization_id,code,name, password,";
			sql+="birth,on_job_status,descr,head_photo_file_id,delete_status,employee_id)values(?,?,?,?,?,?,?,?,?,?)";
			System.out.println("updateOne sql:" + sql);
			System.out.println("updateOne sql param:" );
			DbConnection emp=new DbConnection();
			Random random=new Random();
			int id =random.nextInt(900);
			preparedStatement = emp.getConnection().prepareStatement(sql);
			preparedStatement.setObject(1, request.getParameter("organizationId"));
			preparedStatement.setObject(2, request.getParameter("code"));
			preparedStatement.setObject(3, request.getParameter("name"));
			preparedStatement.setObject(4, request.getParameter("password"));
			preparedStatement.setObject(5, request.getParameter("birth"));
			preparedStatement.setObject(6, request.getParameter("onJobStatus"));
			preparedStatement.setObject(7, request.getParameter("descr"));
			preparedStatement.setObject(8, request.getParameter("headPhotoFileId"));
			preparedStatement.setObject(9, request.getParameter("deleteStatus"));		
			preparedStatement.setObject(10,id);	
			System.out.println(request.getParameter("employeeId"));
			int row = preparedStatement.executeUpdate();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
