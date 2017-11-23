package com.barter.share.bas.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.barter.share.bas.entity.SysEmployee;

public interface AdminManege{
	public abstract void insert(HttpServletRequest request, HttpServletResponse response);
	/**
	 * @param pageIndex查询第几页要+1
	 * @param pageSize查询页数多少要-10
	 * @param code
	 * @param name
	 * @return
	 */
	public abstract List<SysEmployee> AdminList(int pageIndex,int pageSize,String code,String name);
	public abstract int pageCount(String code,String name);
	public abstract void update(HttpServletRequest request, HttpServletResponse response);
	public abstract void delete(HttpServletRequest request, HttpServletResponse response);
}
