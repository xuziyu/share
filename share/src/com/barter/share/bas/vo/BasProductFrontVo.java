package com.barter.share.bas.vo;

import java.math.BigDecimal;

public class BasProductFrontVo {
	private String productId;
	private String code;
	private String name;//名称
	private String brandId;//品牌
	private String categoryBigId;
	private String categorySmallId;
	private String productPlace;
	private BigDecimal marketYear;//上市年份
	private BigDecimal marketSeason;
	private String fashionElement;//流行元素
	private String fabric;
	private String stereotype;//版型
	private BigDecimal grossWeight;
	private BigDecimal priceReal;
	private BigDecimal priceOld;
	private String fullPath;
	public String getProductId() {
		return productId;
	}
	public void setProductId(String productId) {
		this.productId = productId;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getBrandId() {
		return brandId;
	}
	public void setBrandId(String brandId) {
		this.brandId = brandId;
	}
	public String getCategoryBigId() {
		return categoryBigId;
	}
	public void setCategoryBigId(String categoryBigId) {
		this.categoryBigId = categoryBigId;
	}
	public String getCategorySmallId() {
		return categorySmallId;
	}
	public void setCategorySmallId(String categorySmallId) {
		this.categorySmallId = categorySmallId;
	}
	public String getProductPlace() {
		return productPlace;
	}
	public void setProductPlace(String productPlace) {
		this.productPlace = productPlace;
	}
	public BigDecimal getMarketYear() {
		return marketYear;
	}
	public void setMarketYear(BigDecimal marketYear) {
		this.marketYear = marketYear;
	}
	public BigDecimal getMarketSeason() {
		return marketSeason;
	}
	public void setMarketSeason(BigDecimal marketSeason) {
		this.marketSeason = marketSeason;
	}
	public String getFashionElement() {
		return fashionElement;
	}
	public void setFashionElement(String fashionElement) {
		this.fashionElement = fashionElement;
	}
	public String getFabric() {
		return fabric;
	}
	public void setFabric(String fabric) {
		this.fabric = fabric;
	}
	public String getStereotype() {
		return stereotype;
	}
	public void setStereotype(String stereotype) {
		this.stereotype = stereotype;
	}
	public BigDecimal getGrossWeight() {
		return grossWeight;
	}
	public void setGrossWeight(BigDecimal grossWeight) {
		this.grossWeight = grossWeight;
	}
	public BigDecimal getPriceReal() {
		return priceReal;
	}
	public void setPriceReal(BigDecimal priceReal) {
		this.priceReal = priceReal;
	}
	public BigDecimal getPriceOld() {
		return priceOld;
	}
	public void setPriceOld(BigDecimal priceOld) {
		this.priceOld = priceOld;
	}
	public String getFullPath() {
		return fullPath;
	}
	public void setFullPath(String fullPath) {
		this.fullPath = fullPath;
	}
	
}
