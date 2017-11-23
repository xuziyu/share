package com.barter.share.bas.dao;

import java.util.List;

import com.barter.share.bas.entity.PchStockinDetail;
import com.barter.share.framework.entity.Page;



public interface IPchStockinDetail {
	
	public PchStockinDetail insert(PchStockinDetail  pchStockinDetail);
	public PchStockinDetail update(PchStockinDetail  pchStockinDetail);
	public void delete(String id);
	public PchStockinDetail load(String id) ;
	public List<PchStockinDetail> pageResult(int pageIndex, int pageSize,String name);
	public int pageRowCount(int pageSize, String name);
	public Page pageList(int pageIndex, int pageSize, String name);
	public void validateUnique4Code(PchStockinDetail  pchStockinDetail);
	public List<PchStockinDetail>list ();

}
