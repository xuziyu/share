package com.barter.share.bas.dao.imp;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;
import java.util.Random;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.barter.share.bas.entity.SysEmployee;
import com.barter.share.bas.service.AdminManege;
import com.barter.share.framework.dao.BaseDao;
import com.barter.share.framework.dbutil.DbConnection;
import com.barter.share.framework.util.StringUtil;

public class AdminManegeImp extends  BaseDao implements AdminManege{

	@Override
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


	@Override
	public List<SysEmployee> AdminList(int pageIndex,int pageSize,String code,String name) {	
		StringBuffer sql=new StringBuffer("select * from sys_employee where 1=1 ");	
		Object[] objects=new Object[2];
		int i=0;
		if(!StringUtil.isEmpty(code)){
			sql.append(" and code = ?");
			objects[i]=code;
			i++;
		}
		if(!StringUtil.isEmpty(name)){
			sql.append(" and name = ?");
			objects[i]=name;
		}
		sql.append( " order by employee_id asc ") ;
		sql.append(" limit " + pageIndex * pageSize + "," + pageSize);
		System.out.println("list sql:" + sql);
		System.out.println("list sql param:{code:" + code+",name:" + name +"}");
		List<SysEmployee> list =query(sql, objects, SysEmployee.class);
		System.out.println(list.size());
		System.out.println("查询结果"+pageCount(null, null));
		return list;
	}


	@Override
	public int pageCount(String code, String name) {
		StringBuffer sql=new StringBuffer("select * from sys_employee where 1=1 ");	
		Object[] objects=new Object[2];
		int i=0;
		if(!StringUtil.isEmpty(code)){
			sql.append(" and code = ?");
			objects[i]=code;
			i++;
		}
		if(!StringUtil.isEmpty(name)){
			sql.append(" and name = ?");
			objects[i]=name;
		}
		List<SysEmployee> list =query(sql, objects, SysEmployee.class);
		return query(sql, objects, SysEmployee.class).size();
	}


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
			preparedStatement.setObject(10, request.getParameter("gender"));
			preparedStatement.setObject(5, request.getParameter("birth"));
			preparedStatement.setObject(6, request.getParameter("onJobStatus"));
			preparedStatement.setObject(7, request.getParameter("descr"));
			preparedStatement.setObject(8, request.getParameter("headPhotoFileId"));
			preparedStatement.setObject(9, request.getParameter("deleteStatus"));
			preparedStatement.setObject(11, request.getParameter("employeeId"));
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
		String sql="delete from sys_employee where employee_id=?";
		DbConnection emp=new DbConnection();
		try {
			preparedStatement=emp.getConnection().prepareStatement(sql);
			preparedStatement.setObject(1, request.getParameter("employeeId"));
			int row = preparedStatement.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
