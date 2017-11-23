package com.barter.share.bas.entity;

   /**
    * bas_dict 实体类
    * 2017年09月29日12时32分45秒  Lu Xiang
    */ 


public class BasDict{
	private String dictId;
	private String dictCode;
	private String dictLabel;
	public void setDictId(String dictId){
		this.dictId=dictId;
	}
	public String getDictId(){
		return dictId;
	}
	public void setDictCode(String dictCode){
		this.dictCode=dictCode;
	}
	public String getDictCode(){
		return dictCode;
	}
	public void setDictLabel(String dictLabel){
		this.dictLabel=dictLabel;
	}
	public String getDictLabel(){
		return dictLabel;
	}
}

