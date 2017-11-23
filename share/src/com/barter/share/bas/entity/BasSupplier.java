package com.barter.share.bas.entity;

import java.math.BigDecimal;

/**
    * bas_supplier 实体类
    * 2017年09月29日12时33分53秒  Lu Xiang
    */ 


public class BasSupplier{
	private String supplierId;
	private String code;
	private String name;
	private BigDecimal needPayMoney;
	private String contactName;
	private String contactMobile;
	private String address;
	public void setSupplierId(String supplierId){
		this.supplierId=supplierId;
	}
	public String getSupplierId(){
		return supplierId;
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
	public void setNeedPayMoney(BigDecimal needPayMoney){
		this.needPayMoney=needPayMoney;
	}
	public BigDecimal getNeedPayMoney(){
		return needPayMoney;
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

