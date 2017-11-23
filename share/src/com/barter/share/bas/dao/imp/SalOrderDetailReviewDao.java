package com.barter.share.bas.dao.imp;

import java.math.BigDecimal;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;

import com.barter.share.bas.dao.ISalOrderDetailReviewDao;
import com.barter.share.bas.entity.SalOrderDetailReview;
import com.barter.share.framework.dao.BaseDao;
import com.barter.share.framework.dbutil.DbConnection;
import com.barter.share.framework.entity.Page;
import com.barter.share.framework.exception.DbException;
import com.barter.share.framework.util.StringUtil;

public class SalOrderDetailReviewDao extends BaseDao implements ISalOrderDetailReviewDao{

	@Override
	public void insert(SalOrderDetailReview salOrderDetailReview) {
		PreparedStatement prepareStatement = null;
		ResultSet resultSet = null;
		try {
			StringBuffer sql = new StringBuffer("insert into sal_order_detail_review (order_detail_review_id,order_detail_id"
					+ ",review_grade,content,create_date)values(?,?,?,?,now())") ;
			System.out.println("insert sql:" + sql);
			System.out.println("insert sql param:" + salOrderDetailReview.toString());
			prepareStatement = DbConnection.getConnection().prepareStatement(sql.toString());
			prepareStatement.setObject(1, salOrderDetailReview.getOrderDetailReviewId());
			prepareStatement.setObject(2, salOrderDetailReview.getOrderDetailId());
			prepareStatement.setObject(3, salOrderDetailReview.getReviewGrade());
			prepareStatement.setObject(4, salOrderDetailReview.getContent());
//			prepareStatement.setObject(5, salOrderDetailReview.getCreateDate());
			prepareStatement.executeUpdate();
		} catch (Exception ex) {
			ex.printStackTrace();
			throw new DbException(ex.getMessage(), ex);
		} finally {
			if (resultSet != null) {
				try {
					resultSet.close();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
			if (prepareStatement != null) {
				try {
					prepareStatement.close();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}
	}

	@Override
	public void update(SalOrderDetailReview salOrderDetailReview) {
		PreparedStatement prepareStatement = null;
		try {
			StringBuffer sql =new StringBuffer("update sal_order_detail_review set order_detail_id = ?,"
					+ "review_grade = ?,content = ?,create_date = ? where order_detail_review_id = ?") ;
			System.out.println("updateOne sql:" + sql);
			System.out.println("updateOne sql param:" + salOrderDetailReview.toString());
			prepareStatement = DbConnection.getConnection().prepareStatement(sql.toString());
			prepareStatement.setObject(5, salOrderDetailReview.getOrderDetailReviewId());
			prepareStatement.setObject(1, salOrderDetailReview.getOrderDetailId());
			prepareStatement.setObject(2, salOrderDetailReview.getReviewGrade());
			prepareStatement.setObject(3, salOrderDetailReview.getContent());
			prepareStatement.setObject(4, salOrderDetailReview.getCreateDate());
			int row = prepareStatement.executeUpdate();
			if (row == 0)
				throw new DbException("订单不存在:" + salOrderDetailReview.getOrderDetailReviewId());
		} catch (Exception ex) {
			ex.printStackTrace();
			throw new DbException(ex.getMessage(), ex);
		} finally {
			if (prepareStatement != null) {
				try {
					prepareStatement.close();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}		
	}

	@Override
	public void delete(String orderDetailReviewId) {
		StringBuffer sql = new StringBuffer(" delete from sal_order_detail_review where order_detail_review_id = ? ");
		Object[] paramsValue = { orderDetailReviewId };
		super.update(sql, paramsValue);		
	}

	@Override
	public List<SalOrderDetailReview> list(SalOrderDetailReview salOrderDetailReview) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public SalOrderDetailReview load(int id) {
		PreparedStatement prepareStatement = null;
		ResultSet resultSet = null;
		try {
			StringBuffer sql =new StringBuffer("select * from sal_order_detail_review where order_detail_id = ?") ;
			 System.out.println("load sql:" + sql);
			System.out.println("load sql param id:" + id);
			prepareStatement = DbConnection.getConnection().prepareStatement(sql.toString());
			prepareStatement.setObject(1, id);
			resultSet = prepareStatement.executeQuery();
			if (resultSet.next()) {
				SalOrderDetailReview salOrderDetailReview =new SalOrderDetailReview();
				salOrderDetailReview.setOrderDetailReviewId((String)resultSet.getObject("order_detail_review_id"));
				System.out.println(resultSet.getObject("order_detail_review_id"));
				salOrderDetailReview.setOrderDetailId((String)resultSet.getObject("order_detail_id"));
				salOrderDetailReview.setReviewGrade((BigDecimal)(resultSet.getObject("review_grade")));
				salOrderDetailReview.setContent((String)resultSet.getObject("content"));
				salOrderDetailReview.setCreateDate((Date)resultSet.getObject("create_date"));
				return salOrderDetailReview;
			} else {
				throw new DbException("数据不存在:" + id);
			}
		} catch (Exception ex) {
			ex.printStackTrace();
			throw new DbException(ex.getMessage(), ex);
		} finally {
			if (resultSet != null) {
				try {
					resultSet.close();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}

			if (prepareStatement != null) {
				try {
					prepareStatement.close();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}
	
	}

	@Override
	public List<SalOrderDetailReview> pageResult(int pageIndex, int pageSize, String orderDetailReviewId,
			String orderDetailId) {
		List<SalOrderDetailReview> salOrderDetailReviews  = null;
		Object[] paramsValue = new Object[2];
		int paramsIndex = 0;
		StringBuffer sql = new StringBuffer(" select * from sal_order_detail_review where 1=1 ");
		if (!StringUtil.isEmpty(orderDetailReviewId)) {
			sql.append(" and order_detail_review_id = ?");
			paramsValue[paramsIndex] = orderDetailReviewId;
			paramsIndex++;
		}
		if (!StringUtil.isEmpty(orderDetailId)) {
			sql.append(" and order_detail_id = ?");
			paramsValue[paramsIndex] = orderDetailId ;
			paramsIndex++;
		}
		sql.append(" order by order_detail_review_id asc");
		sql.append(" limit " + pageIndex * pageSize + "," + pageSize);
		salOrderDetailReviews = super.query(sql, paramsValue, SalOrderDetailReview.class);
		return salOrderDetailReviews;
	}

	@Override
	public Page pageList(int pageIndex, int pageSize, String orderDetailReviewId, String orderDetailId) {

		Page page = new Page();
		int rowCount = pageRowCount(orderDetailReviewId, orderDetailId);
		int pageCount = (rowCount - 1) / pageSize + 1;
		if (pageIndex < 0) {
			pageIndex = 0;
		}
		if (pageIndex > pageCount) {
			pageIndex = pageCount;
		}
		List result = pageResult(pageIndex, pageSize, orderDetailReviewId, orderDetailId);
		page.setResult(result);
		page.setRowCount(rowCount);
		page.setPageIndex(pageIndex);
		page.setPageSize(pageSize);
		page.setPageCount(pageCount);
		if (pageIndex == 0) {
			page.setHasPrior(false);
		} else {
			page.setHasPrior(true);
		}

		if (pageIndex >= pageCount - 1) {
			page.setHasNext(false);
		} else {
			page.setHasNext(true);
		}
		return page;
	}

	@Override
	public int pageRowCount(String orderDetailReviewId, String orderDetailId) {
		StringBuffer sql = new StringBuffer(" select * from sal_order_detail_review  where 1=1 ");
		int paramsIndex = 0;
		Object[] paramsValue = new Object[2];
		if (!StringUtil.isEmpty(orderDetailReviewId)) {
			sql.append(" and order_detail_review_id = ? ");
			paramsValue[paramsIndex] = orderDetailReviewId;
			paramsIndex++;
		}
		if (!StringUtil.isEmpty(orderDetailId)) {
			sql.append(" and order_detail_id = ? ");
			paramsValue[paramsIndex] = orderDetailId;
			paramsIndex++;
		}
		int count = super.query(sql, paramsValue, SalOrderDetailReview.class).size();
		return count;
	}

	

}
