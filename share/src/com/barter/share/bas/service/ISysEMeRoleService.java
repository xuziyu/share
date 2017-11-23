package com.barter.share.bas.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.barter.share.bas.entity.SysEmployeeManegeVO;

public interface ISysEMeRoleService{
	public abstract void insert(HttpServletRequest request, HttpServletResponse response);
	public abstract List<SysEmployeeManegeVO> AdminList(int pageIndex,int pageSize,String code,String name);
	public abstract int pageCount(String code,String name);
	public abstract void update(HttpServletRequest request, HttpServletResponse response);
	public abstract void delete(HttpServletRequest request, HttpServletResponse response);
}
