package com.barter.share.bas.entity;

import java.math.BigDecimal;

/**
    * sys_module 实体类
    * 2017年09月29日12时35分07秒  Lu Xiang
    */ 


public class SysModule{
	private String moduleId;
	private String code;
	private String name;
	private BigDecimal enabled;
	public String getModuleId() {
		return moduleId;
	}
	public void setModuleId(String moduleId) {
		this.moduleId = moduleId;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public BigDecimal getEnabled() {
		return enabled;
	}
	public void setEnabled(BigDecimal enabled) {
		this.enabled = enabled;
	}
	
}

