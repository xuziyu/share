package com.barter.share.bas.entity;
import java.util.Date;

   /**
    * sys_employee 实体类
    * 2017年09月29日12时34分48秒  Lu Xiang
    */ 


public class SysEmployee{
	private String employeeId;
	private String organizationId;
	private String code;
	private String name;
	private String password;
	private String gender;
	private Date birth;
	private String onJobStatus;
	private String descr;
	private Integer headPhotoFileId;
	private String deleteStatus;
	public void setEmployeeId(String employeeId){
		this.employeeId=employeeId;
	}
	public String getEmployeeId(){
		return employeeId;
	}
	public void setOrganizationId(String organizationId){
		this.organizationId=organizationId;
	}
	public String getOrganizationId(){
		return organizationId;
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
	public void setPassword(String password){
		this.password=password;
	}
	public String getPassword(){
		return password;
	}
	public void setGender(String gender){
		this.gender=gender;
	}
	public String getGender(){
		return gender;
	}
	public void setBirth(Date birth){
		this.birth=birth;
	}
	public Date getBirth(){
		return birth;
	}
	public void setOnJobStatus(String onJobStatus){
		this.onJobStatus=onJobStatus;
	}
	public String getOnJobStatus(){
		return onJobStatus;
	}
	public void setDescr(String descr){
		this.descr=descr;
	}
	public String getDescr(){
		return descr;
	}
	public void setHeadPhotoFileId(Integer headPhotoFileId){
		this.headPhotoFileId=headPhotoFileId;
	}
	public Integer getHeadPhotoFileId(){
		return headPhotoFileId;
	}
	public void setDeleteStatus(String deleteStatus){
		this.deleteStatus=deleteStatus;
	}
	public String getDeleteStatus(){
		return deleteStatus;
	}
}

