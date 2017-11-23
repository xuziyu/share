package com.barter.share.bas.service;

import java.util.List;

import com.barter.share.bas.entity.SysEmployee;

public interface IAdminLoginService {
	public List<SysEmployee> load(String code);
}
