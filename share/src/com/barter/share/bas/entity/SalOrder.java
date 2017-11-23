package com.barter.share.bas.entity;
import java.math.BigDecimal;
import java.util.Date;

   /**
    * sal_order 实体类
    * 2017年09月29日12时34分27秒  Lu Xiang
    */ 


public class SalOrder{
	private String orderId;
	private String customerId;
	private String orderCode;
	private BigDecimal tatalMoney;
	private BigDecimal discountRate;
	private BigDecimal actualTatalMoney;
	private BigDecimal payStatus;
	private Date payDate;
	private Date createDatetime;
	public void setOrderId(String orderId){
		this.orderId=orderId;
	}
	public String getOrderId(){
		return orderId;
	}
	public void setCustomerId(String customerId){
		this.customerId=customerId;
	}
	public String getCustomerId(){
		return customerId;
	}
	public void setOrderCode(String orderCode){
		this.orderCode=orderCode;
	}
	public String getOrderCode(){
		return orderCode;
	}
	public void setTatalMoney(BigDecimal tatalMoney){
		this.tatalMoney=tatalMoney;
	}
	public BigDecimal getTatalMoney(){
		return tatalMoney;
	}
	public void setDiscountRate(BigDecimal discountRate){
		this.discountRate=discountRate;
	}
	public BigDecimal getDiscountRate(){
		return discountRate;
	}
	public void setActualTatalMoney(BigDecimal actualTatalMoney){
		this.actualTatalMoney=actualTatalMoney;
	}
	public BigDecimal getActualTatalMoney(){
		return actualTatalMoney;
	}
	public void setPayStatus(BigDecimal payStatus){
		this.payStatus=payStatus;
	}
	public BigDecimal getPayStatus(){
		return payStatus;
	}
	public void setPayDate(Date payDate){
		this.payDate=payDate;
	}
	public Date getPayDate(){
		return payDate;
	}
	public void setCreateDatetime(Date createDatetime){
		this.createDatetime=createDatetime;
	}
	public Date getCreateDatetime(){
		return createDatetime;
	}
}

