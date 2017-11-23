package com.barter.share.bas.dao;

import java.util.List;

import com.barter.share.bas.entity.SysEmployee;

public interface IAdminLoginDao {
	public List<SysEmployee> load(String code);
}
