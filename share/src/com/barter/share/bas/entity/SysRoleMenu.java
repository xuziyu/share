package com.barter.share.bas.entity;

   /**
    * sys_role_menu 实体类
    * 2017年09月29日12时35分27秒  Lu Xiang
    */ 


public class SysRoleMenu{
	private String roleMenuId;
	private String roleId;
	private String moduleId;
	private String menuId;
	public void setRoleMenuId(String roleMenuId){
		this.roleMenuId=roleMenuId;
	}
	public String getRoleMenuId(){
		return roleMenuId;
	}
	public void setRoleId(String roleId){
		this.roleId=roleId;
	}
	public String getRoleId(){
		return roleId;
	}
	public void setModuleId(String moduleId){
		this.moduleId=moduleId;
	}
	public String getModuleId(){
		return moduleId;
	}
	public void setMenuId(String menuId){
		this.menuId=menuId;
	}
	public String getMenuId(){
		return menuId;
	}
}

