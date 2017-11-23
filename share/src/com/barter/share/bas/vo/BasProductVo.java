package com.barter.share.bas.vo;

import java.math.BigDecimal;

public class BasProductVo {
	private String productId;
	private String code;
	private String name;
	private String brandId;
	private String categoryBigId;
	private String categorySmallId;
	private String productPlace;
	private BigDecimal marketYear;
	private BigDecimal marketSeason;
	private String fashionElement;
	private String fabric;
	private String stereotype;
	private BigDecimal grossWeight;
	private String brandName;
	private String bigName;
	private String smallName;
	public void setProductId(String productId){
		this.productId=productId;
	}
	public String getProductId(){
		return productId;
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
	public void setBrandId(String brandId){
		this.brandId=brandId;
	}
	public String getBrandId(){
		return brandId;
	}
	public void setCategoryBigId(String categoryBigId){
		this.categoryBigId=categoryBigId;
	}
	public String getCategoryBigId(){
		return categoryBigId;
	}
	public void setCategorySmallId(String categorySmallId){
		this.categorySmallId=categorySmallId;
	}
	public String getCategorySmallId(){
		return categorySmallId;
	}
	public void setProductPlace(String productPlace){
		this.productPlace=productPlace;
	}
	public String getProductPlace(){
		return productPlace;
	}
	public void setMarketYear(BigDecimal marketYear){
		this.marketYear=marketYear;
	}
	public BigDecimal getMarketYear(){
		return marketYear;
	}
	public void setMarketSeason(BigDecimal marketSeason){
		this.marketSeason=marketSeason;
	}
	public BigDecimal getMarketSeason(){
		return marketSeason;
	}
	public void setFashionElement(String fashionElement){
		this.fashionElement=fashionElement;
	}
	public String getFashionElement(){
		return fashionElement;
	}
	public void setFabric(String fabric){
		this.fabric=fabric;
	}
	public String getFabric(){
		return fabric;
	}
	public void setStereotype(String stereotype){
		this.stereotype=stereotype;
	}
	public String getStereotype(){
		return stereotype;
	}
	public void setGrossWeight(BigDecimal grossWeight){
		this.grossWeight=grossWeight;
	}
	public BigDecimal getGrossWeight(){
		return grossWeight;
	}
	public String getBrandName() {
		return brandName;
	}
	public void setBrandName(String brandName) {
		this.brandName = brandName;
	}
	public String getBigName() {
		return bigName;
	}
	public void setBigName(String bigName) {
		this.bigName = bigName;
	}
	public String getSmallName() {
		return smallName;
	}
	public void setSmallName(String smallName) {
		this.smallName = smallName;
	}
	
}
