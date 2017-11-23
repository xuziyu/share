package com.barter.share.bas.dao;

import java.util.List;

import com.barter.share.bas.entity.SalOrderDetailReview;
import com.barter.share.framework.entity.Page;

public interface ISalOrderDetailReviewDao {

	public void insert(SalOrderDetailReview salOrderDetailReview);
	public void update(SalOrderDetailReview salOrderDetailReview);
	public void delete(String orderDetailReviewId);
	// 查询
	public List<SalOrderDetailReview> list(SalOrderDetailReview salOrderDetailReview);
	// 查询单个对象
	public SalOrderDetailReview load(int id);
	// 分页查询的结果集
	public List<SalOrderDetailReview> pageResult(int pageIndex, int pageSize, String orderDetailId, String orderId);
	// 分页查询
	public Page pageList(int pageIndex, int pageSize, String orderDetailId, String orderId);
	// 分页查询记录总数
	public int pageRowCount(String orderDetailId, String orderId);


}
