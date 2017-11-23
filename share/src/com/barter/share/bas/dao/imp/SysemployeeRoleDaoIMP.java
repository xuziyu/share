package com.barter.share.bas.dao.imp;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.barter.share.bas.dao.ISysemployeeRoleDao;
import com.barter.share.bas.entity.SysEmployee;
import com.barter.share.framework.dbutil.DbConnection;

public class SysemployeeRoleDaoIMP implements ISysemployeeRoleDao {

	@Override
	public void insert(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub

	}

	@Override
	public List<SysEmployee> AdminList(int pageIndex, int pageSize, String code, String name) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int pageCount(String code, String name) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void update(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub

	}

	@Override
	public void delete(HttpServletRequest request, HttpServletResponse response) {
		PreparedStatement preparedStatement;
		String sql="delete from sys_employee_role where role_id=? and employee_id=?";
		DbConnection emp=new DbConnection();
		try {
			preparedStatement=emp.getConnection().prepareStatement(sql);
			preparedStatement.setObject(1, request.getParameter("roleId"));
			preparedStatement.setObject(2, request.getParameter("employeeId"));
			int row = preparedStatement.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
