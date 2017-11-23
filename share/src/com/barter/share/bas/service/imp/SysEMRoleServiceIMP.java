package com.barter.share.bas.service.imp;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.barter.share.bas.entity.SysEmployeeManegeVO;
import com.barter.share.bas.entity.SysEmployeeRole;
import com.barter.share.bas.service.ISysEMeRoleService;
import com.barter.share.framework.dao.BaseDao;
import com.barter.share.framework.dbutil.DbConnection;
import com.barter.share.framework.util.StringUtil;

public class SysEMRoleServiceIMP extends BaseDao implements ISysEMeRoleService {

	@Override
	public void insert(HttpServletRequest request, HttpServletResponse response) {		
	}
	
	@Override
	public List<SysEmployeeManegeVO> AdminList(int pageIndex,int pageSize,String code,String name) {	
		StringBuffer sql=new StringBuffer("SELECT a.employee_id,a.role_id,b.module_id,c.code,c.enabled,c.menu_url,e.name,c.name,d.name,d.code,f.name from sys_employee_role as a ");	
		sql.append("left join sys_role_menu as b on a.role_id = b.role_id ");
		sql.append("left JOIN sys_menu as c on b.menu_id= c.menu_id ");
		sql.append("left JOIN sys_module as d on b.module_id=d.module_id ");
		sql.append("left JOIN sys_role as e on a.role_id=e.role_id ");
		sql.append("left join sys_employee as f on a.employee_id=f.employee_id where 1=1 ");
		int i=0;
		if(!StringUtil.isEmpty(code)){
			sql.append(" and a.employee_id ="+code);
		}
		PreparedStatement preparedStatement;
		DbConnection emp=new DbConnection();
		List<SysEmployeeManegeVO> list=new ArrayList<SysEmployeeManegeVO>();
		try {
			preparedStatement=emp.getConnection().prepareStatement(sql.toString());
			ResultSet resultSet=preparedStatement.executeQuery();
			while (resultSet.next()) {
			
					SysEmployeeManegeVO sysEmployeeManegeVO=new SysEmployeeManegeVO();
					System.out.println("链接查询结果"+resultSet.getObject("d.name"));
					sysEmployeeManegeVO.setEmployeeId((String)resultSet.getObject("a.employee_id"));
					sysEmployeeManegeVO.setRoleId((String)resultSet.getObject("a.role_id"));
					sysEmployeeManegeVO.setModuleId((String)resultSet.getObject("b.module_id"));
					sysEmployeeManegeVO.setmenuCode((String)resultSet.getObject("c.code"));
					sysEmployeeManegeVO.setEnabled((BigDecimal)resultSet.getObject("c.enabled"));
					sysEmployeeManegeVO.setMenuUrl((String)resultSet.getObject("c.menu_url"));
					sysEmployeeManegeVO.setjiaosename((String)resultSet.getObject("f.name"));
					sysEmployeeManegeVO.setmenuName((String)resultSet.getObject("c.name"));
					sysEmployeeManegeVO.setRoleName(((String)resultSet.getObject("e.name")));
					sysEmployeeManegeVO.setmoduleName((String)resultSet.getObject("d.name"));
					sysEmployeeManegeVO.setmoduleCode((String)resultSet.getObject("d.code"));
					list.add(sysEmployeeManegeVO);
					System.out.println("添VO成功一个"+resultSet.getObject("f.name"));	
				
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println("查询结果"+pageCount(null, null));
		return list;
	}


	@Override
	public int pageCount(String code, String name) {
		StringBuffer sql=new StringBuffer("select * from sys_employee_role where 1=1 ");	
		Object[] objects=new Object[1];
		int i=0;
		if(!StringUtil.isEmpty(code)){
			sql.append(" and code = ?");
			objects[i]=code;
			i++;
		}
		List<SysEmployeeRole> list =query(sql, objects, SysEmployeeRole.class);
		return query(sql, objects, SysEmployeeRole.class).size();
	}


	@Override
	public void update(HttpServletRequest request, HttpServletResponse response) {
	
	}


	@Override
	public void delete(HttpServletRequest request, HttpServletResponse response) {
		StringBuffer sql=new StringBuffer("delte a.employee_id,a.role_id,b.module_id,c.code,c.enabled,c.menu_url,e.name,c.name,d.name,d.code,f.name from sys_employee_role as a ");	
		sql.append("left join sys_role_menu as b on a.role_id = b.role_id ");
		sql.append("left JOIN sys_menu as c on b.menu_id= c.menu_id ");
		sql.append("left JOIN sys_module as d on b.module_id=d.module_id ");
		sql.append("left JOIN sys_role as e on a.role_id=e.role_id ");
		sql.append("left join sys_employee as f on a.employee_id=f.employee_id where 1=1 ");
		PreparedStatement preparedStatement;
		DbConnection emp=new DbConnection();
		try {
			preparedStatement=emp.getConnection().prepareStatement(sql.toString());
			ResultSet resultSet=preparedStatement.executeQuery();
			int id=0;
			while (resultSet.next()) {
				if(!resultSet.getObject("a.employee_id").equals(id)){
					SysEmployeeManegeVO sysEmployeeManegeVO=new SysEmployeeManegeVO();
					System.out.println("链接查询结果"+resultSet.getObject("d.name"));
					sysEmployeeManegeVO.setEmployeeId((String)resultSet.getObject("a.employee_id"));
					sysEmployeeManegeVO.setRoleId((String)resultSet.getObject("a.role_id"));
					sysEmployeeManegeVO.setModuleId((String)resultSet.getObject("b.module_id"));
					sysEmployeeManegeVO.setmenuCode((String)resultSet.getObject("c.code"));
					sysEmployeeManegeVO.setEnabled((BigDecimal)resultSet.getObject("c.enabled"));
					sysEmployeeManegeVO.setMenuUrl((String)resultSet.getObject("c.menu_url"));
					sysEmployeeManegeVO.setjiaosename((String)resultSet.getObject("f.name"));
					sysEmployeeManegeVO.setmenuName((String)resultSet.getObject("c.name"));
					sysEmployeeManegeVO.setRoleName(((String)resultSet.getObject("e.name")));
					sysEmployeeManegeVO.setmoduleName((String)resultSet.getObject("d.name"));
					sysEmployeeManegeVO.setmoduleCode((String)resultSet.getObject("d.code"));
					
					System.out.println("添VO成功一个"+resultSet.getObject("f.name"));	
				}else {
					
				}
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println("查询结果"+pageCount(null, null));

}
}
