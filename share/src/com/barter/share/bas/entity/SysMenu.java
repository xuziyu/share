package com.barter.share.bas.entity;

import java.math.BigDecimal;

/**
    * sys_menu 实体类
    * 2017年09月29日12时35分01秒  Lu Xiang
    */ 


public class SysMenu{
	private String menuId;
	private String moduleId;
	private String code;
	private String name;
	private BigDecimal enabled;
	private String menuUrl;
	public void setMenuId(String menuId){
		this.menuId=menuId;
	}
	public String getMenuId(){
		return menuId;
	}
	public void setModuleId(String moduleId){
		this.moduleId=moduleId;
	}
	public String getModuleId(){
		return moduleId;
	}
	public void setCode(String code){
		this.code=code;
	}
	public String getCode(){
		return code;
	}
	public void setName(String name){
		this.name=name;
	}
	public String getName(){
		return name;
	}
	public void setEnabled(BigDecimal enabled){
		this.enabled=enabled;
	}
	public BigDecimal getEnabled(){
		return enabled;
	}
	public void setMenuUrl(String menuUrl){
		this.menuUrl=menuUrl;
	}
	public String getMenuUrl(){
		return menuUrl;
	}
}

