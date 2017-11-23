package com.barter.share.bas.entity;

import java.math.BigDecimal;

/**
    * bas_dict_detail 实体类
    * 2017年09月29日12时32分54秒  Lu Xiang
    */ 


public class BasDictDetail{
	private String dictDetailId;
	private String dictId;
	private String optionCode;
	private String optionLabel;
	private BigDecimal seqNum;
	public void setDictDetailId(String dictDetailId){
		this.dictDetailId=dictDetailId;
	}
	public String getDictDetailId(){
		return dictDetailId;
	}
	public void setDictId(String dictId){
		this.dictId=dictId;
	}
	public String getDictId(){
		return dictId;
	}
	public void setOptionCode(String optionCode){
		this.optionCode=optionCode;
	}
	public String getOptionCode(){
		return optionCode;
	}
	public void setOptionLabel(String optionLabel){
		this.optionLabel=optionLabel;
	}
	public String getOptionLabel(){
		return optionLabel;
	}
	public void setSeqNum(BigDecimal seqNum){
		this.seqNum=seqNum;
	}
	public BigDecimal getSeqNum(){
		return seqNum;
	}
}

