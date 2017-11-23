package com.barter.share.bas.entity;
import java.math.BigDecimal;
import java.util.Date;

   /**
    * pch_stockin 实体类
    * 2017年09月29日12时34分08秒  Lu Xiang
    */ 


public class PchStockin{
	
	private String stockinId;
	private String supplierId;
	private Date purchaseDate;
	private BigDecimal tatalMoney;
	private BigDecimal thisPayMoney;
	private String createEmployeeId;
	private Date createDatetime;
	private BigDecimal billStatus;
	private BigDecimal payStatus;
	
	
	
	public BigDecimal getBillStatus() {
		return billStatus;
	}
	public void setBillStatus(BigDecimal billStatus) {
		this.billStatus = billStatus;
	}
	public BigDecimal getPayStatus() {
		return payStatus;
	}
	public void setPayStatus(BigDecimal payStatus) {
		this.payStatus = payStatus;
	}
	public void setStockinId(String stockinId){
		this.stockinId=stockinId;
	}
	public String getStockinId(){
		return stockinId;
	}
	public void setSupplierId(String supplierId){
		this.supplierId=supplierId;
	}
	public String getSupplierId(){
		return supplierId;
	}
	public void setPurchaseDate(Date purchaseDate){
		this.purchaseDate=purchaseDate;
	}
	public Date getPurchaseDate(){
		return purchaseDate;
	}
	
	
	public BigDecimal getTatalMoney() {
		return tatalMoney;
	}
	public void setTatalMoney(BigDecimal tatalMoney) {
		this.tatalMoney = tatalMoney;
	}
	public BigDecimal getThisPayMoney() {
		return thisPayMoney;
	}
	public void setThisPayMoney(BigDecimal thisPayMoney) {
		this.thisPayMoney = thisPayMoney;
	}
	public void setCreateEmployeeId(String createEmployeeId){
		this.createEmployeeId=createEmployeeId;
	}
	public String getCreateEmployeeId(){
		return createEmployeeId;
	}
	public void setCreateDatetime(Date createDatetime){
		this.createDatetime=createDatetime;
	}
	public Date getCreateDatetime(){
		return createDatetime;
	}
}

