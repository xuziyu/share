package com.barter.share.bas.vo;

import java.math.BigDecimal;

public class BasDictDetailVo{
	private String dictDetailId;
	private String dictId;
	private String optionCode;
	private String optionLabel;
	private BigDecimal seqNum;
	private String dictCode;
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
	
	public String getDictCode() {
		return dictCode;
	}

	public void setDictCode(String dictCode) {
		this.dictCode = dictCode;
	}
	
}
