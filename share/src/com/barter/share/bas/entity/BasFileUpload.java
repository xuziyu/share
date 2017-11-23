package com.barter.share.bas.entity;

import java.math.BigDecimal;

/**
    * bas_file_upload 实体类
    * 2017年09月29日12时33分02秒  Lu Xiang
    */ 


public class BasFileUpload{
	private String fileUploadId;
	private BigDecimal fileSpec;
	private String fullPath;
	private String shortName;
	private String extName;
	private BigDecimal fileSize;
	public void setFileUploadId(String fileUploadId){
		this.fileUploadId=fileUploadId;
	}
	public String getFileUploadId(){
		return fileUploadId;
	}
	public void setFileSpec(BigDecimal fileSpec){
		this.fileSpec=fileSpec;
	}
	public BigDecimal getFileSpec(){
		return fileSpec;
	}
	public void setFullPath(String fullPath){
		this.fullPath=fullPath;
	}
	public String getFullPath(){
		return fullPath;
	}
	public void setShortName(String shortName){
		this.shortName=shortName;
	}
	public String getShortName(){
		return shortName;
	}
	public void setExtName(String extName){
		this.extName=extName;
	}
	public String getExtName(){
		return extName;
	}
	public void setFileSize(BigDecimal fileSize){
		this.fileSize=fileSize;
	}
	public BigDecimal getFileSize(){
		return fileSize;
	}
}

