package com.barter.share.bas.vo;

import java.math.BigDecimal;

public class ProductSkuVO {

	private String name;
	private BigDecimal priceReal;
	private String productSkuId;
	private String productId;
	private String skuColorId;
	private String skuSizeId;
	
	public String getSkuColorId() {
		return skuColorId;
	}
	public void setSkuColorId(String skuColorId) {
		this.skuColorId = skuColorId;
	}
	public String getSkuSizeId() {
		return skuSizeId;
	}
	public void setSkuSizeId(String skuSizeId) {
		this.skuSizeId = skuSizeId;
	}
	public String getProductSkuId() {
		return productSkuId;
	}
	public void setProductSkuId(String productSkuId) {
		this.productSkuId = productSkuId;
	}
	public String getProductId() {
		return productId;
	}
	public void setProductId(String productId) {
		this.productId = productId;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public BigDecimal getPriceReal() {
		return priceReal;
	}
	public void setPriceReal(BigDecimal priceReal) {
		this.priceReal = priceReal;
	}
}
