package com.barter.share.bas.service.imp;

import java.util.List;

import com.barter.share.bas.dao.ISalOrderDetailReviewDao;
import com.barter.share.bas.dao.imp.SalOrderDetailReviewDao;
import com.barter.share.bas.entity.SalOrderDetailReview;
import com.barter.share.bas.service.ISalOrderDetailReviewService;
import com.barter.share.framework.entity.Page;

public class SalOrderDetailReviewServiceImp implements ISalOrderDetailReviewService {

	ISalOrderDetailReviewDao iSalOrderDetailReviewDao = new SalOrderDetailReviewDao();
	@Override
	public void insert(SalOrderDetailReview salOrderDetailReview) {
		iSalOrderDetailReviewDao.insert(salOrderDetailReview);
	}

	@Override
	public void update(SalOrderDetailReview salOrderDetailReview) {
		iSalOrderDetailReviewDao.update(salOrderDetailReview);
	}

	@Override
	public void delete(String orderDetailReviewId) {

		iSalOrderDetailReviewDao.delete(orderDetailReviewId);
	}

	@Override
	public List<SalOrderDetailReview> list(SalOrderDetailReview salOrderDetailReview) {
		return iSalOrderDetailReviewDao.list(salOrderDetailReview);
	}

	@Override
	public SalOrderDetailReview load(int id) {
		return iSalOrderDetailReviewDao.load(id);
	}

	@Override
	public List<SalOrderDetailReview> pageResult(int pageIndex, int pageSize, String orderDetailId, String orderId) {
		return iSalOrderDetailReviewDao.pageResult(pageIndex, pageSize, orderDetailId, orderId);
	}

	@Override
	public Page pageList(int pageIndex, int pageSize, String orderDetailId, String orderId) {
		return iSalOrderDetailReviewDao.pageList(pageIndex, pageSize, orderDetailId, orderId);
	}

	@Override
	public int pageRowCount(String orderDetailId, String orderId) {
		return iSalOrderDetailReviewDao.pageRowCount(orderDetailId, orderId);
	}

}
