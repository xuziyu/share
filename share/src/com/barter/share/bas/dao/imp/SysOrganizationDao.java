package com.barter.share.bas.dao.imp;

import java.lang.reflect.InvocationTargetException;
import java.util.List;

import com.barter.share.bas.dao.ISysOrganizationDao;
import com.barter.share.bas.entity.SysOrganization;
import com.barter.share.bas.vo.SysOrganizationVo;
import com.barter.share.framework.dao.BaseDao;
import com.barter.share.framework.entity.Page;
import com.barter.share.framework.exception.ValidateException;
import com.barter.share.framework.util.StringUtil;

public class SysOrganizationDao extends BaseDao implements ISysOrganizationDao {

	@Override
	public void insert(SysOrganization sysOrganization) throws NoSuchMethodException, SecurityException,
			IllegalAccessException, IllegalArgumentException, InvocationTargetException {
		StringBuffer sql = new StringBuffer("INSERT INTO sys_organization (organization_id, code, name, parent_organization_id) VALUES (?, ?, ?, ?)");
		Object [] paramsValue =StringUtil.reflectValue(sysOrganization);
		super.update(sql, paramsValue);
	}

	@Override
	public void delete(String organizationId) {
		StringBuffer sql = new StringBuffer("DELETE FROM sys_organization WHERE organization_id = ?");
		Object [] paramsValue ={organizationId};
		super.update(sql, paramsValue);
	}

	@Override
	public void update(SysOrganization sysOrganization) throws NoSuchMethodException, SecurityException,
			IllegalAccessException, IllegalArgumentException, InvocationTargetException {
		StringBuffer sql = new StringBuffer("UPDATE sys_organization SET code = ? , name = ? , parent_organization_id = ? WHERE organization_id = ?");
		Object [] paramsValue =StringUtil.leftOne(StringUtil.reflectValue(sysOrganization));
		super.update(sql, paramsValue);
	}

	@Override
	public List<SysOrganization> list() {
		StringBuffer sql = new StringBuffer("SELECT * FROM sys_organization");
		Object [] paramsValue =null;
		return super.query(sql, paramsValue, SysOrganization.class);
	}

	@Override
	public List<SysOrganization> load(String organizationId) {
		StringBuffer sql = new StringBuffer("SELECT * FROM sys_organization WHERE 1 = 1 AND organization_id = ?");
		Object [] paramsValue ={organizationId};
		return super.query(sql, paramsValue, SysOrganization.class);
	}

	@Override
	public List<SysOrganizationVo> pageResult(int pageIndex, int pageSize, SysOrganizationVo sysOrganizationVo)
			throws NoSuchMethodException, SecurityException, IllegalAccessException, IllegalArgumentException,
			InvocationTargetException {
		StringBuffer sql = new StringBuffer("SELECT  sys_organization_child.* , sys_organization_parent.name AS parent_name ");
		sql.append("FROM sys_organization AS sys_organization_child ");
		sql.append("INNER JOIN sys_organization AS sys_organization_parent ");
		sql.append("ON sys_organization_child.parent_organization_id = sys_organization_parent.organization_id ");
		sql.append("WHERE 1 = 1");
		Object [] paramsValue = StringUtil.reflectValue(sysOrganizationVo);
		Object [] paramsValueTrim =new Object[paramsValue.length];
		String [] sqlAppend ={" AND organization_id like ?"," and code like ?",
				" and name like ?"," and parent_organization_id LIKE ?",
				" AND sys_organization_parent.organization_id LIKE ?"};
		if (sysOrganizationVo!=null) {
			int valueIndex =0;
			for (int i = 0; i < paramsValue.length; i++) {
				if (!StringUtil.isEmpty(paramsValue[i])) {
					sql.append(sqlAppend[i]);
					paramsValueTrim[valueIndex] = "%"+paramsValue[i]+"%";
					valueIndex++;
				}
			}
		}
		sql.append(" order by sys_organization_child.organization_id desc");
		sql.append(" limit " + pageIndex * pageSize + "," + pageSize);
		return super.query(sql, paramsValueTrim, SysOrganizationVo.class);
	}

	@Override
	public int pageRowCount(SysOrganizationVo sysOrganizationVo) throws NoSuchMethodException, SecurityException,
			IllegalAccessException, IllegalArgumentException, InvocationTargetException {
		StringBuffer sql = new StringBuffer("SELECT COUNT(sys_organization_child.organization_id) ");
		sql.append("FROM sys_organization AS sys_organization_child ");
		sql.append("INNER JOIN sys_organization AS sys_organization_parent ");
		sql.append("ON sys_organization_child.parent_organization_id = sys_organization_parent.organization_id ");
		sql.append("WHERE 1 = 1");
		Object [] paramsValue = StringUtil.reflectValue(sysOrganizationVo);
		Object [] paramsValueTrim =new Object[paramsValue.length];
		String [] sqlAppend ={" AND organization_id like ?"," and code like ?",
				" and name like ?"," and parent_organization_id LIKE ?",
				" AND sys_organization_parent.organization_id LIKE ?"};
		if (sysOrganizationVo!=null) {
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
	public Page pageList(int pageIndex, int pageSize, SysOrganizationVo sysOrganizationVo) throws NoSuchMethodException,
			SecurityException, IllegalAccessException, IllegalArgumentException, InvocationTargetException {
		Page page = new Page();
		int rowCount =0;
		//获得 查询结果的行数
		rowCount = pageRowCount(sysOrganizationVo);
		int pageCount = (rowCount - 1) / pageSize + 1;

		if (pageIndex < 0) {
			pageIndex = 0;
		}

		if (pageIndex > pageCount) {
			pageIndex = pageCount;
		}
		//把查询到的 实体对象数组   存到  result 并作为属性 给  page对象
		List result = pageResult(pageIndex, pageSize,sysOrganizationVo);
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
	public void validateUnique4Code(SysOrganization sysOrganization) throws NoSuchMethodException, SecurityException,
			IllegalAccessException, IllegalArgumentException, InvocationTargetException {
		StringBuffer sql = new StringBuffer("SELECT COUNT(organization_id) FROM sys_organization WHERE code = ?");
		Object [] paramsValueTrim ={sysOrganization.getCode()};
		int count =super.resultRowCount(sql, paramsValueTrim);
		if (count==1) {
			throw new ValidateException("编码重复:" + sysOrganization.getCode());
		}
	}

}
