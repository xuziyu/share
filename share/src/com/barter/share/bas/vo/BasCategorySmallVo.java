package com.barter.share.bas.vo;

public class BasCategorySmallVo{
	private String categorySmallId;
	private String categoryBigId;
	private String name;
	private String descr;
	private String bigName;
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
	public String getBigName() {
		return bigName;
	}
	public void setBigName(String bigName) {
		this.bigName = bigName;
	}
}
