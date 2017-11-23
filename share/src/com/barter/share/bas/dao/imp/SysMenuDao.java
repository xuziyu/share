package com.barter.share.bas.dao.imp;

import java.lang.reflect.InvocationTargetException;
import java.util.List;

import com.barter.share.bas.dao.ISysMenuDao;
import com.barter.share.bas.entity.SysMenu;
import com.barter.share.bas.vo.SysMenuUrlVo;
import com.barter.share.bas.vo.SysMenuVo;
import com.barter.share.framework.dao.BaseDao;
import com.barter.share.framework.entity.Page;
import com.barter.share.framework.exception.ValidateException;
import com.barter.share.framework.util.StringUtil;

public class SysMenuDao extends BaseDao implements ISysMenuDao {

	@Override
	public void insert(SysMenu sysMenu) throws NoSuchMethodException, SecurityException, IllegalAccessException,
			IllegalArgumentException, InvocationTargetException {
		StringBuffer sql = new StringBuffer("INSERT INTO sys_menu (menu_id, module_id, code, name, enabled, menu_url) VALUES (?, ?, ?, ?, ?, ?)");
		Object [] paramsValue =StringUtil.reflectValue(sysMenu);
		super.update(sql, paramsValue);
	}

	@Override
	public void delete(String menuId) {
		StringBuffer sql = new StringBuffer("DELETE FROM sys_menu WHERE menu_id = ?");
		Object [] paramsValue ={menuId};
		super.update(sql, paramsValue);
	}

	@Override
	public void update(SysMenu sysMenu) throws NoSuchMethodException, SecurityException, IllegalAccessException,
			IllegalArgumentException, InvocationTargetException {
		StringBuffer sql = new StringBuffer("UPDATE sys_menu SET module_id = ? , code = ? , name = ? , enabled = ? , menu_url = ? WHERE menu_id = ?");
		Object [] paramsValue =StringUtil.leftOne(StringUtil.reflectValue(sysMenu));
		super.update(sql, paramsValue);
	}

	@Override
	public List<SysMenu> list() {
		StringBuffer sql = new StringBuffer("SELECT * FROM sys_menu");
		Object [] paramsValue =null;
		return super.query(sql, paramsValue, SysMenu.class);
	}

	@Override
	public List<SysMenu> load(String menuId) {
		StringBuffer sql = new StringBuffer("SELECT * FROM sys_menu WHERE 1 = 1 AND menu_id = ?");
		Object [] paramsValue ={menuId};
		return super.query(sql, paramsValue, SysMenu.class);
	}

	@Override
	public List<SysMenuVo> pageResult(int pageIndex, int pageSize, SysMenuVo sysMenuVo) throws NoSuchMethodException,
			SecurityException, IllegalAccessException, IllegalArgumentException, InvocationTargetException {
		StringBuffer sql = new StringBuffer("SELECT sys_menu.* , sys_menu.name AS module_name ");
		sql.append("FROM sys_menu ");
		sql.append("INNER JOIN sys_module 	");
		sql.append("ON sys_module.module_id = sys_menu.module_id ");
		sql.append("WHERE 1 = 1");
		Object [] paramsValue = StringUtil.reflectValue(sysMenuVo);
		Object [] paramsValueTrim =new Object[paramsValue.length];
		String [] sqlAppend ={" AND sys_menu.menu_id like ?"," and sys_menu.module_id like ?",
				" and sys_menu.code like ?"," and sys_menu.name like ?",
				" and sys_menu.enabled like ?"," and sys_menu.menu_url LIKE ?"," AND sys_module.name LIKE ?"};
		if (sysMenuVo!=null) {
			int valueIndex =0;
			for (int i = 0; i < paramsValue.length; i++) {
				if (!StringUtil.isEmpty(paramsValue[i])) {
					sql.append(sqlAppend[i]);
					paramsValueTrim[valueIndex] = "%"+paramsValue[i]+"%";
					valueIndex++;
				}
			}
		}
		sql.append(" order by sys_menu.menu_id desc");
		sql.append(" limit " + pageIndex * pageSize + "," + pageSize);
		return super.query(sql, paramsValueTrim, SysMenuVo.class);
	}

	@Override
	public int pageRowCount(SysMenuVo sysMenuVo) throws NoSuchMethodException, SecurityException,
			IllegalAccessException, IllegalArgumentException, InvocationTargetException {
		StringBuffer sql = new StringBuffer("SELECT COUNT(sys_menu.menu_id) ");
		sql.append("FROM sys_menu ");
		sql.append("INNER JOIN sys_module 	");
		sql.append("ON sys_module.module_id = sys_menu.module_id ");
		sql.append("WHERE 1 = 1");
		Object [] paramsValue = StringUtil.reflectValue(sysMenuVo);
		Object [] paramsValueTrim =new Object[paramsValue.length];
		String [] sqlAppend ={" AND sys_menu.menu_id like ?"," and sys_menu.module_id like ?",
				" and sys_menu.code like ?"," and sys_menu.name like ?",
				" and sys_menu.enabled like ?"," and sys_menu.menu_url LIKE ?"," AND sys_module.name LIKE ?"};
		if (sysMenuVo!=null) {
			int valueIndex =0;
			for (int i = 0; i < paramsValue.length; i++) {
				if (!StringUtil.isEmpty(paramsValue[i])) {
					sql.append(sqlAppend[i]);
					paramsValueTrim[valueIndex] = "%"+paramsValue[i]+"%";
					valueIndex++;
				}
			}
		}
		return super.resultRowCount(sql, paramsValueTrim);
	}

	@Override
	public Page pageList(int pageIndex, int pageSize, SysMenuVo sysMenuVo) throws NoSuchMethodException,
			SecurityException, IllegalAccessException, IllegalArgumentException, InvocationTargetException {
		Page page = new Page();
		int rowCount =0;
		//获得 查询结果的行数
		rowCount = pageRowCount(sysMenuVo);
		int pageCount = (rowCount - 1) / pageSize + 1;

		if (pageIndex < 0) {
			pageIndex = 0;
		}

		if (pageIndex > pageCount) {
			pageIndex = pageCount;
		}
		//把查询到的 实体对象数组   存到  result 并作为属性 给  page对象
		List result = pageResult(pageIndex, pageSize,sysMenuVo);
		page.setPageSize(pageSize);
		page.setPageIndex(pageIndex);
		page.setPageCount(pageCount);
		page.setRowCount(rowCount);
		page.setResult(result);
		if (pageIndex == 0) {
			page.setHasPrior(false);
		} else {
			page.setHasPrior(true);
		}

		if (pageIndex >= pageCount - 1) {
			page.setHasNext(false);
		} else {
			page.setHasNext(true);
		}
		return page;
	}

	@Override
	public void validateUnique4Code(SysMenu sysMenu) throws NoSuchMethodException, SecurityException,
			IllegalAccessException, IllegalArgumentException, InvocationTargetException {
		StringBuffer sql = new StringBuffer("SELECT COUNT(menu_id) FROM sys_menu WHERE code = ?");
		Object [] paramsValueTrim ={sysMenu.getCode()};
		int count =super.resultRowCount(sql, paramsValueTrim);
		if (count==1) {
			throw new ValidateException("编码重复:" + sysMenu.getCode());
		}
	}

	@Override
	public List<SysMenuUrlVo> loadUrl(String employeeId) {
		StringBuffer sql = new StringBuffer("SELECT sys_employee.employee_id , sys_employee.name AS employee_name, sys_role.name AS role_name , sys_module.name AS module_name , sys_menu.name AS menu_name, sys_menu.menu_url ");
		sql.append("FROM sys_employee ");
		sql.append("INNER JOIN sys_employee_role ");
		sql.append("ON sys_employee_role.employee_id = sys_employee.employee_id ");
		sql.append("INNER JOIN sys_role_menu ");
		sql.append("ON sys_role_menu.role_id = sys_employee_role.role_id ");
		sql.append("INNER JOIN sys_menu ");
		sql.append("ON sys_menu.menu_id = sys_role_menu.menu_id ");
		sql.append("INNER JOIN sys_role ");
		sql.append("ON sys_role.role_id = sys_role_menu.role_id ");
		sql.append("INNER JOIN sys_module ");
		sql.append("ON sys_module.module_id = sys_role_menu.module_id ");
		sql.append("WHERE sys_employee.employee_id = ?");
		String [] paramsValue ={employeeId};
		return query(sql, paramsValue, SysMenuUrlVo.class);
	}
	
}
