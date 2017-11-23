package com.barter.share.bas.vo;

import com.barter.share.bas.entity.PchStockin;

public class PchVo extends PchStockin {
	private String name;
	private String code;
	
	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}
