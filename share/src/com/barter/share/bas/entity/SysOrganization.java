package com.barter.share.bas.entity;

   /**
    * sys_organization 实体类
    * 2017年09月29日12时35分14秒  Lu Xiang
    */ 


public class SysOrganization{
	private String organizationId;
	private String code;
	private String name;
	private String parentOrganizationId;
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
	public void setParentOrganizationId(String parentOrganizationId){
		this.parentOrganizationId=parentOrganizationId;
	}
	public String getParentOrganizationId(){
		return parentOrganizationId;
	}
}

