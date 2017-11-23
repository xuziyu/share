package com.barter.share.bas.vo;

import java.math.BigDecimal;

public class BasProductSkuVo{
	private String productSkuId;
	private String productId;
	private String skuColorId;
	private String skuSizeId;
	private String barCode;
	private BigDecimal priceReal;
	private BigDecimal priceOld;
	private BigDecimal priceCost;
	private BigDecimal pricePlanPurchase;
	private BigDecimal amountStock;
	private BigDecimal amountInit;
	private BigDecimal amountMinStock;
	private BigDecimal amountMaxStock;
	private String picOriFileId;
	private String picBigFileId;
	private String picMiddleFileId;
	private String picSmallFileId;
	private BigDecimal productDefaultType;
	private String productName;
	private String colorName;
	private String sizeName;
	private String picpath;
	public void setProductSkuId(String productSkuId){
		this.productSkuId=productSkuId;
	}
	public String getProductSkuId(){
		return productSkuId;
	}
	public void setProductId(String productId){
		this.productId=productId;
	}
	public String getProductId(){
		return productId;
	}
	public void setSkuColorId(String skuColorId){
		this.skuColorId=skuColorId;
	}
	public String getSkuColorId(){
		return skuColorId;
	}
	public void setSkuSizeId(String skuSizeId){
		this.skuSizeId=skuSizeId;
	}
	public String getSkuSizeId(){
		return skuSizeId;
	}
	public void setBarCode(String barCode){
		this.barCode=barCode;
	}
	public String getBarCode(){
		return barCode;
	}
	public void setPriceReal(BigDecimal priceReal){
		this.priceReal=priceReal;
	}
	public BigDecimal getPriceReal(){
		return priceReal;
	}
	public void setPriceOld(BigDecimal priceOld){
		this.priceOld=priceOld;
	}
	public BigDecimal getPriceOld(){
		return priceOld;
	}
	public void setPriceCost(BigDecimal priceCost){
		this.priceCost=priceCost;
	}
	public BigDecimal getPriceCost(){
		return priceCost;
	}
	public void setPricePlanPurchase(BigDecimal pricePlanPurchase){
		this.pricePlanPurchase=pricePlanPurchase;
	}
	public BigDecimal getPricePlanPurchase(){
		return pricePlanPurchase;
	}
	public void setAmountStock(BigDecimal amountStock){
		this.amountStock=amountStock;
	}
	public BigDecimal getAmountStock(){
		return amountStock;
	}
	public void setAmountInit(BigDecimal amountInit){
		this.amountInit=amountInit;
	}
	public BigDecimal getAmountInit(){
		return amountInit;
	}
	public void setAmountMinStock(BigDecimal amountMinStock){
		this.amountMinStock=amountMinStock;
	}
	public BigDecimal getAmountMinStock(){
		return amountMinStock;
	}
	public void setAmountMaxStock(BigDecimal amountMaxStock){
		this.amountMaxStock=amountMaxStock;
	}
	public BigDecimal getAmountMaxStock(){
		return amountMaxStock;
	}
	public void setPicOriFileId(String picOriFileId){
		this.picOriFileId=picOriFileId;
	}
	public String getPicOriFileId(){
		return picOriFileId;
	}
	public void setPicBigFileId(String picBigFileId){
		this.picBigFileId=picBigFileId;
	}
	public String getPicBigFileId(){
		return picBigFileId;
	}
	public void setPicMiddleFileId(String picMiddleFileId){
		this.picMiddleFileId=picMiddleFileId;
	}
	public String getPicMiddleFileId(){
		return picMiddleFileId;
	}
	public void setPicSmallFileId(String picSmallFileId){
		this.picSmallFileId=picSmallFileId;
	}
	public String getPicSmallFileId(){
		return picSmallFileId;
	}
	public void setProductDefaultType(BigDecimal productDefaultType){
		this.productDefaultType=productDefaultType;
	}
	public BigDecimal getProductDefaultType(){
		return productDefaultType;
	}
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	public String getColorName() {
		return colorName;
	}
	public void setColorName(String colorName) {
		this.colorName = colorName;
	}
	public String getSizeName() {
		return sizeName;
	}
	public void setSizeName(String sizeName) {
		this.sizeName = sizeName;
	}
	public String getPicpath() {
		return picpath;
	}
	public void setPicpath(String picpath) {
		this.picpath = picpath;
	}
}
