package com.barter.share.bas.entity;
import java.math.BigDecimal;
import java.util.Date;

   /**
    * sal_order_detail 实体类
    * 2017年09月29日12时34分35秒  Lu Xiang
    */ 


public class SalOrderDetail{
	private String orderDetailId;
	private String orderId;
	private String productSkuId;
	private String orderDetailCode;
	private String name;
	private BigDecimal amount;
	private BigDecimal price;
	private String remark;
	private BigDecimal stockOutStatus;
	private Date stockOutDate;
	private BigDecimal logisticsStatus;
	private Date logisticsArriveDate;
	private Date logisticsSignDate;
	private BigDecimal reviewStatus;
	public void setOrderDetailId(String orderDetailId){
		this.orderDetailId=orderDetailId;
	}
	public String getOrderDetailId(){
		return orderDetailId;
	}
	public void setOrderId(String orderId){
		this.orderId=orderId;
	}
	public String getOrderId(){
		return orderId;
	}
	public void setProductSkuId(String productSkuId){
		this.productSkuId=productSkuId;
	}
	public String getProductSkuId(){
		return productSkuId;
	}
	public void setOrderDetailCode(String orderDetailCode){
		this.orderDetailCode=orderDetailCode;
	}
	public String getOrderDetailCode(){
		return orderDetailCode;
	}
	public void setName(String name){
		this.name=name;
	}
	public String getName(){
		return name;
	}
	public void setAmount(BigDecimal amount){
		this.amount=amount;
	}
	public BigDecimal getAmount(){
		return amount;
	}
	public void setPrice(BigDecimal price){
		this.price=price;
	}
	public BigDecimal getPrice(){
		return price;
	}
	public void setRemark(String remark){
		this.remark=remark;
	}
	public String getRemark(){
		return remark;
	}
	public void setStockOutStatus(BigDecimal stockOutStatus){
		this.stockOutStatus=stockOutStatus;
	}
	public BigDecimal getStockOutStatus(){
		return stockOutStatus;
	}
	public void setStockOutDate(Date stockOutDate){
		this.stockOutDate=stockOutDate;
	}
	public Date getStockOutDate(){
		return stockOutDate;
	}
	public void setLogisticsStatus(BigDecimal logisticsStatus){
		this.logisticsStatus=logisticsStatus;
	}
	public BigDecimal getLogisticsStatus(){
		return logisticsStatus;
	}
	public void setLogisticsArriveDate(Date logisticsArriveDate){
		this.logisticsArriveDate=logisticsArriveDate;
	}
	public Date getLogisticsArriveDate(){
		return logisticsArriveDate;
	}
	public void setLogisticsSignDate(Date logisticsSignDate){
		this.logisticsSignDate=logisticsSignDate;
	}
	public Date getLogisticsSignDate(){
		return logisticsSignDate;
	}
	public void setReviewStatus(BigDecimal reviewStatus){
		this.reviewStatus=reviewStatus;
	}
	public BigDecimal getReviewStatus(){
		return reviewStatus;
	}
}

