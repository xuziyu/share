package com.barter.share.bas.dao;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface ISysEmployeeRole {
	public abstract void update(HttpServletRequest request, HttpServletResponse response);
	public abstract void delete(HttpServletRequest request, HttpServletResponse response);
	public abstract void insert(HttpServletRequest request, HttpServletResponse response);
}
