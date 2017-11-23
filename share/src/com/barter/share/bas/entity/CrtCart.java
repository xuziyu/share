package com.barter.share.bas.entity;
import java.util.Date;

   /**
    * crt_cart 实体类
    * 2017年09月29日12时34分00秒  Lu Xiang
    */ 


public class CrtCart{
	private String cartId;
	private String customerId;
	private String productSkuId;
	private Date createDate;
	public void setCartId(String cartId){
		this.cartId=cartId;
	}
	public String getCartId(){
		return cartId;
	}
	public void setCustomerId(String customerId){
		this.customerId=customerId;
	}
	public String getCustomerId(){
		return customerId;
	}
	public void setProductSkuId(String productSkuId){
		this.productSkuId=productSkuId;
	}
	public String getProductSkuId(){
		return productSkuId;
	}
	public void setCreateDate(Date createDate){
		this.createDate=createDate;
	}
	public Date getCreateDate(){
		return createDate;
	}
}

