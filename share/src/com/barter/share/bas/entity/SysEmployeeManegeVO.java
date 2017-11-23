package com.barter.share.bas.entity;

import java.math.BigDecimal;

public class SysEmployeeManegeVO {
	private String moduleId;
	private String moduleCode;
	private String moduleName;
	private String menuCode;
	private String menuName;
	private BigDecimal enabled;
	private String menuUrl;
	private String roleId;
	private String roleName;
	private String jiaosename;
	private String employeeId;
	public void setRoleId(String roleId){
		this.roleId=roleId;
	}
	public String getRoleId(){
		return roleId;
	}
	public void setName(String name){
		this.jiaosename=name;
	}
	public String getName(){
		return jiaosename;
	}
	public void setmenuCode(String menuCode){
		this.menuCode=menuCode;
	}
	public String getmenuCode(){
		return menuCode;
	}
	public void setmenuName(String menuName){
		this.menuName=menuName;
	}
	public String getmenuName(){
		return menuName;
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
	public void setModuleId(String moduleId){
		this.moduleId=moduleId;
	}
	public String getModuleId(){
		return moduleId;
	}
	public void setmoduleCode(String moduleCode){
		this.moduleCode=moduleCode;
	}
	public String getmoduleCode(){
		return moduleCode;
	}
	public void setmoduleName(String moduleName){
		this.moduleName=moduleName;
	}
	public String getmoduleName(){
		return moduleName;
	}
	public String getEmployeeId() {
		return employeeId;
	}
	public void setEmployeeId(String employeeId) {
		this.employeeId = employeeId;
	}
	public String getjiaosename() {
		return jiaosename;
	}
	public void setjiaosename(String jiaosename) {
		this.jiaosename = jiaosename;
	}
	public String getRoleName() {
		return roleName;
	}
	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}
}



