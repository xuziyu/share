package com.barter.share.bas.entity;

   /**
    * bas_category_small 实体类
    * 2017年09月29日12时32分29秒  Lu Xiang
    */ 


public class BasCategorySmall{
	private String categorySmallId;
	private String categoryBigId;
	private String name;
	private String descr;
	public void setCategorySmallId(String categorySmallId){
		this.categorySmallId=categorySmallId;
	}
	public String getCategorySmallId(){
		return categorySmallId;
	}
	public void setCategoryBigId(String categoryBigId){
		this.categoryBigId=categoryBigId;
	}
	public String getCategoryBigId(){
		return categoryBigId;
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

