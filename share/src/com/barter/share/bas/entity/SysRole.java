package com.barter.share.bas.entity;

   /**
    * sys_role 实体类
    * 2017年09月29日12时35分21秒  Lu Xiang
    */ 


public class SysRole{
	private String roleId;
	private String name;
	public void setRoleId(String roleId){
		this.roleId=roleId;
	}
	public String getRoleId(){
		return roleId;
	}
	public void setName(String name){
		this.name=name;
	}
	public String getName(){
		return name;
	}
}

