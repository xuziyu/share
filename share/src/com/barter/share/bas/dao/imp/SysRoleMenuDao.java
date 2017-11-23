package com.barter.share.bas.dao.imp;

import java.lang.reflect.InvocationTargetException;
import java.util.List;

import com.barter.share.bas.dao.ISysRoleMenuDao;
import com.barter.share.bas.entity.SysRoleMenu;
import com.barter.share.bas.vo.SysRoleMenuVo;
import com.barter.share.framework.dao.BaseDao;
import com.barter.share.framework.entity.Page;
import com.barter.share.framework.util.StringUtil;

public class SysRoleMenuDao extends BaseDao implements ISysRoleMenuDao {

	@Override
	public void insert(SysRoleMenu sysRoleMenu) throws NoSuchMethodException, SecurityException, IllegalAccessException,
			IllegalArgumentException, InvocationTargetException {
		StringBuffer sql = new StringBuffer("INSERT INTO sys_role_menu (role_menu_id, role_id, module_id, menu_id) VALUES (?, ?, ?, ?)");
		Object [] paramsValue =StringUtil.reflectValue(sysRoleMenu);
		super.update(sql, paramsValue);
	}

	@Override
	public void delete(String roleMenuId) {
		StringBuffer sql = new StringBuffer("DELETE FROM `sys_role_menu` WHERE role_menu_id = ?");
		Object [] paramsValue ={roleMenuId};
		super.update(sql, paramsValue);
	}

	@Override
	public void update(SysRoleMenu sysRoleMenu) throws NoSuchMethodException, SecurityException, IllegalAccessException,
			IllegalArgumentException, InvocationTargetException {
		StringBuffer sql = new StringBuffer("UPDATE sys_role_menu SET role_id = ? , module_id = ? , menu_id = ? WHERE role_menu_id = ?");
		Object [] paramsValue =StringUtil.leftOne(StringUtil.reflectValue(sysRoleMenu));
		super.update(sql, paramsValue);
	}

	@Override
	public List<SysRoleMenu> list() {
		StringBuffer sql = new StringBuffer("SELECT * FROM sys_role_menu");
		Object [] paramsValue =null;
		return super.query(sql, paramsValue, SysRoleMenu.class);
	}

	@Override
	public List<SysRoleMenu> load(String roleMenuId) {
		StringBuffer sql = new StringBuffer("SELECT * FROM sys_role_menu WHERE 1 = 1 AND role_menu_id = ?");
		Object [] paramsValue ={roleMenuId};
		return super.query(sql, paramsValue, SysRoleMenu.class);
	}

	@Override
	public List<SysRoleMenuVo> pageResult(int pageIndex, int pageSize, SysRoleMenuVo sysRoleMenuVo)
			throws NoSuchMethodException, SecurityException, IllegalAccessException, IllegalArgumentException,
			InvocationTargetException {
		StringBuffer sql = new StringBuffer("SELECT sys_role_menu.* , sys_role.name AS role_name , sys_module.name AS module_name , sys_menu.name AS menu_name ");
		sql.append("FROM sys_role_menu ");
		sql.append("INNER JOIN sys_role ");
		sql.append("ON sys_role.role_id = sys_role_menu.role_id ");
		sql.append("INNER JOIN sys_module ");
		sql.append("ON sys_module.module_id = sys_role_menu.module_id ");
		sql.append("INNER JOIN sys_menu ");
		sql.append("ON sys_menu.menu_id = sys_role_menu.menu_id ");
		sql.append("WHERE 1 = 1");
		Object [] paramsValue = StringUtil.reflectValue(sysRoleMenuVo);
		Object [] paramsValueTrim =new Object[paramsValue.length];
		String [] sqlAppend ={" AND sys_role_menu.role_menu_id like ?"," and sys_role_menu.role_id like ?",
				" and sys_role_menu.module_id like ?"," and sys_role_menu.menu_id LIKE ?"," AND sys_role.name LIKE ?",
				" AND sys_module.name LIKE ?"," AND sys_menu.name LIKE ?"};
		if (sysRoleMenuVo!=null) {
			int valueIndex =0;
			for (int i = 0; i < paramsValue.length; i++) {
				if (!StringUtil.isEmpty(paramsValue[i])) {
					sql.append(sqlAppend[i]);
					paramsValueTrim[valueIndex] = "%"+paramsValue[i]+"%";
					valueIndex++;
				}
			}
		}
		sql.append(" order by sys_role_menu.role_menu_id desc");
		sql.append(" limit " + pageIndex * pageSize + "," + pageSize);
		return super.query(sql, paramsValueTrim, SysRoleMenuVo.class);
	}

	@Override
	public int pageRowCount(SysRoleMenuVo sysRoleMenuVo) throws NoSuchMethodException, SecurityException,
			IllegalAccessException, IllegalArgumentException, InvocationTargetException {
		StringBuffer sql = new StringBuffer("SELECT COUNT(sys_role_menu.role_menu_id) ");
		sql.append("FROM sys_role_menu ");
		sql.append("INNER JOIN sys_role ");
		sql.append("ON sys_role.role_id = sys_role_menu.role_id ");
		sql.append("INNER JOIN sys_module ");
		sql.append("ON sys_module.module_id = sys_role_menu.module_id ");
		sql.append("INNER JOIN sys_menu ");
		sql.append("ON sys_menu.menu_id = sys_role_menu.menu_id ");
		sql.append("WHERE 1 = 1");
		Object [] paramsValue = StringUtil.reflectValue(sysRoleMenuVo);
		Object [] paramsValueTrim =new Object[paramsValue.length];
		String [] sqlAppend ={" AND sys_role_menu.role_menu_id like ?"," and sys_role_menu.role_id like ?",
				" and sys_role_menu.module_id like ?"," and sys_role_menu.menu_id LIKE ?"," AND sys_role.name LIKE ?",
				" AND sys_module.name LIKE ?"," AND sys_menu.name LIKE ?"};
		if (sysRoleMenuVo!=null) {
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
	public Page pageList(int pageIndex, int pageSize, SysRoleMenuVo sysRoleMenuVo) throws NoSuchMethodException,
			SecurityException, IllegalAccessException, IllegalArgumentException, InvocationTargetException {
		Page page = new Page();
		int rowCount =0;
		//获得 查询结果的行数
		rowCount = pageRowCount(sysRoleMenuVo);
		int pageCount = (rowCount - 1) / pageSize + 1;

		if (pageIndex < 0) {
			pageIndex = 0;
		}

		if (pageIndex > pageCount) {
			pageIndex = pageCount;
		}
		//把查询到的 实体对象数组   存到  result 并作为属性 给  page对象
		List result = pageResult(pageIndex, pageSize,sysRoleMenuVo);
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
	public void validateUnique4Code(SysRoleMenu sysRoleMenu) throws NoSuchMethodException, SecurityException,
			IllegalAccessException, IllegalArgumentException, InvocationTargetException {
//		StringBuffer sql = new StringBuffer("SELECT COUNT(category_big_id) FROM bas_category_big WHERE name = ?");
//		Object [] paramsValueTrim ={sysRoleMenu.getMenuId()};
//		int count =super.resultRowCount(sql, paramsValueTrim);
//		if (count==1) {
//			throw new ValidateException("名称重复:" + sysRoleMenu.getMenuId());
//		}
	}

}
