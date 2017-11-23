package com.barter.share.bas.entity;

import java.math.BigDecimal;

/**
    * bas_customer 实体类
    * 2017年09月29日12时32分36秒  Lu Xiang
    */ 


public class BasCustomer{
	private String customerId;
	private String code;
	private String name;
	private String gender;
	private String password;
	private BigDecimal needRecvMoney;
	private String contactName;
	private String contactMobile;
	private String address;
	public void setCustomerId(String customerId){
		this.customerId=customerId;
	}
	public String getCustomerId(){
		return customerId;
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
	public void setGender(String gender){
		this.gender=gender;
	}
	public String getGender(){
		return gender;
	}
	public void setPassword(String password){
		this.password=password;
	}
	public String getPassword(){
		return password;
	}
	public void setNeedRecvMoney(BigDecimal needRecvMoney){
		this.needRecvMoney=needRecvMoney;
	}
	public BigDecimal getNeedRecvMoney(){
		return needRecvMoney;
	}
	public void setContactName(String contactName){
		this.contactName=contactName;
	}
	public String getContactName(){
		return contactName;
	}
	public void setContactMobile(String contactMobile){
		this.contactMobile=contactMobile;
	}
	public String getContactMobile(){
		return contactMobile;
	}
	public void setAddress(String address){
		this.address=address;
	}
	public String getAddress(){
		return address;
	}
}

