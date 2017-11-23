package com.barter.share.bas.entity;

import java.math.BigDecimal;

   /**
    * pch_stockin_detail 实体类
    * 2017年09月29日12时34分16秒  xubo
    */ 


public class PchStockinDetail{
	private String stockinDetailId;
	private String stockinId;
	private String productSkuId;
	private String name;
	private BigDecimal amount;
	private BigDecimal price;
	private BigDecimal moneyReal;
	private String remark;
	public void setStockinDetailId(String stockinDetailId){
		this.stockinDetailId=stockinDetailId;
	}
	public String getStockinDetailId(){
		return stockinDetailId;
	}
	public void setStockinId(String stockinId){
		this.stockinId=stockinId;
	}
	public String getStockinId(){
		return stockinId;
	}
	public void setProductSkuId(String productSkuId){
		this.productSkuId=productSkuId;
	}
	public String getProductSkuId(){
		return productSkuId;
	}
	public void setName(String name){
		this.name=name;
	}
	public String getName(){
		return name;
	}

	public BigDecimal getAmount() {
		return amount;
	}
	public void setAmount(BigDecimal amount) {
		this.amount = amount;
	}
	public BigDecimal getPrice() {
		return price;
	}
	public void setPrice(BigDecimal price) {
		this.price = price;
	}
	public BigDecimal getMoneyReal() {
		return moneyReal;
	}
	public void setMoneyReal(BigDecimal moneyReal) {
		this.moneyReal = moneyReal;
	}
	public void setRemark(String remark){
		this.remark=remark;
	}
	public String getRemark(){
		return remark;
	}
}

