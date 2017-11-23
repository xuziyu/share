package com.barter.share.bas.service.imp;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.barter.share.bas.entity.SysEmployee;
import com.barter.share.bas.entity.SysEmployeeRole;
import com.barter.share.bas.service.ISysemployeeRoleService;
import com.barter.share.framework.dao.BaseDao;
import com.barter.share.framework.dbutil.DbConnection;
import com.barter.share.framework.util.StringUtil;

public class SysemployeeRoleServiceIMP extends BaseDao implements ISysemployeeRoleService {

	@Override
	public void insert(HttpServletRequest request, HttpServletResponse response) {
		PreparedStatement preparedStatement;
		try {
			String sql = "insert into sys_employee_role (employee_role_id,role_id,employee_id";
			sql+=")values(?,?,?)";
			System.out.println("updateOne sql:" + sql);
			System.out.println("updateOne sql param:" );
			DbConnection emp=new DbConnection();
			preparedStatement = emp.getConnection().prepareStatement(sql);
			preparedStatement.setObject(1, request.getParameter("employeeRoleId"));
			preparedStatement.setObject(2, request.getParameter("roleId"));
			preparedStatement.setObject(3, request.getParameter("employeeId"));
			System.out.println(request.getParameter("employeeId"));
			int row = preparedStatement.executeUpdate();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}


	@Override
	public List<SysEmployeeRole> AdminList(int pageIndex,int pageSize,String code,String name) {	
		StringBuffer sql=new StringBuffer("select * from sys_employee_role where 1=1 ");	
		Object[] objects=new Object[1];
		int i=0;
		if(!StringUtil.isEmpty(code)){
			sql.append(" and employee_id = ?");
			objects[i]=code;
		}
		sql.append( " order by employee_id asc ") ;
		sql.append(" limit " + pageIndex * pageSize + "," + pageSize);
		System.out.println("list sql:" + sql);
		List<SysEmployeeRole> list =query(sql, objects, SysEmployeeRole.class);
		System.out.println(list.size());
		System.out.println("查询结果"+pageCount(null, null));
		return list;
	}


	@Override
	public int pageCount(String code, String name) {
		StringBuffer sql=new StringBuffer("select * from sys_employee_role where 1=1 ");	
		Object[] objects=new Object[1];
		int i=0;
		if(!StringUtil.isEmpty(code)){
			sql.append(" and employee_id = ?");
			objects[i]=code;
			i++;
		}
		List<SysEmployeeRole> list =query(sql, objects, SysEmployeeRole.class);
		return query(sql, objects, SysEmployeeRole.class).size();
	}


	@Override
	public void update(HttpServletRequest request, HttpServletResponse response) {
		SysEmployee sysEmployee=new SysEmployee();
		PreparedStatement preparedStatement;
		try {
			String sql = "update sys_employee_role set employee_role_id=?,role_id=?";
			sql+="where employee_id = ?";
			System.out.println("updateOne sql:" + sql);
			System.out.println("updateOne sql param:" );
			DbConnection emp=new DbConnection();
			preparedStatement = emp.getConnection().prepareStatement(sql);
			preparedStatement.setObject(1, request.getParameter("employeeRoleId"));
			preparedStatement.setObject(2, request.getParameter("roleId"));
			preparedStatement.setObject(3, request.getParameter("employeeId"));
			int row = preparedStatement.executeUpdate();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}


	@Override
	public void delete(HttpServletRequest request, HttpServletResponse response) {
		PreparedStatement preparedStatement;
		String sql="delete from sys_employee_role where employee_role_id=?";
		DbConnection emp=new DbConnection();
		try {
			preparedStatement=emp.getConnection().prepareStatement(sql);
			preparedStatement.setObject(1, request.getParameter("employeeRoleId"));
			int row = preparedStatement.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
