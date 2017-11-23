package com.barter.share.bas.entity;

   /**
    * bas_brand 实体类
    * 2017年09月29日12时31分34秒  Lu Xiang
    */ 


public class BasBrand{
	private String brandId;
	private String code;
	private String name;
	private String slogan;
	public void setBrandId(String brandId){
		this.brandId=brandId;
	}
	public String getBrandId(){
		return brandId;
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
	public void setSlogan(String slogan){
		this.slogan=slogan;
	}
	public String getSlogan(){
		return slogan;
	}
}

