package com.barter.share.bas.vo;

import java.math.BigDecimal;
import java.util.Date;

public class SalOrderVO {

	private String orderId;
	private String customerId;
	private String orderCode;
	private BigDecimal tatalMoney;
	private BigDecimal discountRate;
	private BigDecimal actualTatalMoney;
	private BigDecimal payStatus;
	private Date payDate;
	private Date createDatetime;
	private String orderDetailId;
	private String productSkuId;
	private String orderDetailCode;
	private String name;
	private BigDecimal amount;
	private BigDecimal price;
	private String remark;
	private BigDecimal stockOutStatus;
	private Date stockOutDate;
	private String orderDetailReviewId;
	private BigDecimal reviewGrade;
	private String content;
	private Date createDate;
	
	
	public String getOrderDetailReviewId() {
		return orderDetailReviewId;
	}
	public void setOrderDetailReviewId(String orderDetailReviewId) {
		this.orderDetailReviewId = orderDetailReviewId;
	}
	public BigDecimal getReviewGrade() {
		return reviewGrade;
	}
	public void setReviewGrade(BigDecimal reviewGrade) {
		this.reviewGrade = reviewGrade;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public Date getCreateDate() {
		return createDate;
	}
	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}
	public String getOrderId() {
		return orderId;
	}
	public void setOrderId(String orderId) {
		this.orderId = orderId;
	}
	public String getCustomerId() {
		return customerId;
	}
	public void setCustomerId(String customerId) {
		this.customerId = customerId;
	}
	public String getOrderCode() {
		return orderCode;
	}
	public void setOrderCode(String orderCode) {
		this.orderCode = orderCode;
	}
	public BigDecimal getTatalMoney() {
		return tatalMoney;
	}
	public void setTatalMoney(BigDecimal tatalMoney) {
		this.tatalMoney = tatalMoney;
	}
	public BigDecimal getDiscountRate() {
		return discountRate;
	}
	public void setDiscountRate(BigDecimal discountRate) {
		this.discountRate = discountRate;
	}
	public BigDecimal getActualTatalMoney() {
		return actualTatalMoney;
	}
	public void setActualTatalMoney(BigDecimal actualTatalMoney) {
		this.actualTatalMoney = actualTatalMoney;
	}
	public BigDecimal getPayStatus() {
		return payStatus;
	}
	public void setPayStatus(BigDecimal payStatus) {
		this.payStatus = payStatus;
	}
	public Date getPayDate() {
		return payDate;
	}
	public void setPayDate(Date payDate) {
		this.payDate = payDate;
	}
	public Date getCreateDatetime() {
		return createDatetime;
	}
	public void setCreateDatetime(Date createDatetime) {
		this.createDatetime = createDatetime;
	}
	public String getOrderDetailId() {
		return orderDetailId;
	}
	public void setOrderDetailId(String orderDetailId) {
		this.orderDetailId = orderDetailId;
	}
	public String getProductSkuId() {
		return productSkuId;
	}
	public void setProductSkuId(String productSkuId) {
		this.productSkuId = productSkuId;
	}
	public String getOrderDetailCode() {
		return orderDetailCode;
	}
	public void setOrderDetailCode(String orderDetailCode) {
		this.orderDetailCode = orderDetailCode;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
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
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
	public BigDecimal getStockOutStatus() {
		return stockOutStatus;
	}
	public void setStockOutStatus(BigDecimal stockOutStatus) {
		this.stockOutStatus = stockOutStatus;
	}
	public Date getStockOutDate() {
		return stockOutDate;
	}
	public void setStockOutDate(Date stockOutDate) {
		this.stockOutDate = stockOutDate;
	}
	public BigDecimal getLogisticsStatus() {
		return logisticsStatus;
	}
	public void setLogisticsStatus(BigDecimal logisticsStatus) {
		this.logisticsStatus = logisticsStatus;
	}
	public Date getLogisticsArriveDate() {
		return logisticsArriveDate;
	}
	public void setLogisticsArriveDate(Date logisticsArriveDate) {
		this.logisticsArriveDate = logisticsArriveDate;
	}
	public Date getLogisticsSignDate() {
		return logisticsSignDate;
	}
	public void setLogisticsSignDate(Date logisticsSignDate) {
		this.logisticsSignDate = logisticsSignDate;
	}
	public BigDecimal getReviewStatus() {
		return reviewStatus;
	}
	public void setReviewStatus(BigDecimal reviewStatus) {
		this.reviewStatus = reviewStatus;
	}
	private BigDecimal logisticsStatus;
	private Date logisticsArriveDate;
	private Date logisticsSignDate;
	private BigDecimal reviewStatus;
}
