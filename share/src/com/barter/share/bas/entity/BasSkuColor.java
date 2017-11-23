package com.barter.share.bas.entity;

   /**
    * bas_sku_color 实体类
    * 2017年09月29日12时33分39秒  Lu Xiang
    */ 


public class BasSkuColor{
	private String skuColorId;
	private String code;
	private String name;
	private String descr;
	private String rgb;
	public void setSkuColorId(String skuColorId){
		this.skuColorId=skuColorId;
	}
	public String getSkuColorId(){
		return skuColorId;
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
	public void setRgb(String rgb){
		this.rgb=rgb;
	}
	public String getRgb(){
		return rgb;
	}
}

