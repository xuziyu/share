package com.barter.share.bas.entity;

   /**
    * sys_employee_role 实体类
    * 2017年09月29日12时34分54秒  Lu Xiang
    */ 


public class SysEmployeeRole{
	private String employeeRoleId;
	private String roleId;
	private String employeeId;
	private String menuId;
	private String moduleId;
	private String code;
	private String name;
	private Double enabled;
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
	public void setEnabled(Double enabled){
		this.enabled=enabled;
	}
	public Double getEnabled(){
		return enabled;
	}
	public void setMenuUrl(String menuUrl){
		this.menuUrl=menuUrl;
	}
	public String getMenuUrl(){
		return menuUrl;
	}
	public void setEmployeeRoleId(String employeeRoleId){
		this.employeeRoleId=employeeRoleId;
	}
	public String getEmployeeRoleId(){
		return employeeRoleId;
	}
	public void setRoleId(String roleId){
		this.roleId=roleId;
	}
	public String getRoleId(){
		return roleId;
	}
	public void setEmployeeId(String employeeId){
		this.employeeId=employeeId;
	}
	public String getEmployeeId(){
		return employeeId;
	}
	
}

