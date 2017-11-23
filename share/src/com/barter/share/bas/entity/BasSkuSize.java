package com.barter.share.bas.entity;

   /**
    * bas_sku_size 实体类
    * 2017年09月29日12时33分45秒  Lu Xiang
    */ 


public class BasSkuSize{
	private String skuSizeId;
	private String code;
	private String name;
	private String descr;
	public void setSkuSizeId(String skuSizeId){
		this.skuSizeId=skuSizeId;
	}
	public String getSkuSizeId(){
		return skuSizeId;
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
	public void setDescr(String descr){
		this.descr=descr;
	}
	public String getDescr(){
		return descr;
	}
}

