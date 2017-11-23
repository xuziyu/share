package com.barter.share.bas.entity;
import java.math.BigDecimal;
import java.util.Date;

   /**
    * sal_order_detail_review 实体类
    * 2017年09月29日12时34分41秒  Lu Xiang
    */ 


public class SalOrderDetailReview {
	private String orderDetailReviewId;
	private String orderDetailId;
	private BigDecimal reviewGrade;
	private String content;
	private Date createDate;
	public void setOrderDetailReviewId(String orderDetailReviewId){
		this.orderDetailReviewId=orderDetailReviewId;
	}
	public String getOrderDetailReviewId(){
		return orderDetailReviewId;
	}
	public void setOrderDetailId(String orderDetailId){
		this.orderDetailId=orderDetailId;
	}
	public String getOrderDetailId(){
		return orderDetailId;
	}
	public void setReviewGrade(BigDecimal reviewGrade){
		this.reviewGrade=reviewGrade;
	}
	public BigDecimal getReviewGrade(){
		return reviewGrade;
	}
	public void setContent(String content){
		this.content=content;
	}
	public String getContent(){
		return content;
	}
	public void setCreateDate(Date createDate){
		this.createDate=createDate;
	}
	public Date getCreateDate(){
		return createDate;
	}
}

