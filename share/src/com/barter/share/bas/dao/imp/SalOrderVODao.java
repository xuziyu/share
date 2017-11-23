package com.barter.share.bas.dao.imp;

import java.math.BigDecimal;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Date;
import java.util.List;

import com.barter.share.bas.dao.ISalOrderVODao;
import com.barter.share.bas.entity.SalOrder;
import com.barter.share.bas.entity.SalOrderDetailReview;
import com.barter.share.bas.vo.SalOrderVO;
import com.barter.share.framework.dao.BaseDao;
import com.barter.share.framework.dbutil.DbConnection;
import com.barter.share.framework.entity.Page;
import com.barter.share.framework.exception.DbException;
import com.barter.share.framework.util.StringUtil;

public class SalOrderVODao extends BaseDao implements ISalOrderVODao {

	@Override
	public void insert(SalOrderVO salOrderVO) {
		PreparedStatement prepareStatementSalOrder = null;
		ResultSet resultSet = null;
		PreparedStatement preparedStatementSalOrderDetail = null;
		PreparedStatement preparedStatementSalOrderDetailReview = null;
		try {
			StringBuffer salOrderSql = new StringBuffer();
			salOrderSql.append("insert into sal_order(order_id,order_code,tatal_money,discount_rate,"
					+ "actual_tatal_money,pay_status,pay_date,create_datetime) values(?,?,?,?,?,?,?,now())");
			System.out.println("insert sql:" + salOrderSql);
			prepareStatementSalOrder = DbConnection.getConnection().prepareStatement(salOrderSql.toString());
			prepareStatementSalOrder.setObject(1, salOrderVO.getOrderId());
			// prepareStatementSalOrder.setObject(2,
			// salOrderVO.getCustomerId());
			prepareStatementSalOrder.setObject(2, salOrderVO.getOrderCode());
			prepareStatementSalOrder.setObject(3, salOrderVO.getTatalMoney());
			prepareStatementSalOrder.setObject(4, salOrderVO.getDiscountRate());
			prepareStatementSalOrder.setObject(5, salOrderVO.getActualTatalMoney());
			prepareStatementSalOrder.setObject(6, salOrderVO.getPayStatus());
			prepareStatementSalOrder.setObject(7, salOrderVO.getPayDate());
			prepareStatementSalOrder.executeUpdate();

			StringBuffer salOrderDetail = new StringBuffer(
					"insert into sal_order_detail(order_id,order_detail_id,order_detail_code)values(?,?,?)");
			preparedStatementSalOrderDetail = DbConnection.getConnection().prepareStatement(salOrderDetail.toString());
			preparedStatementSalOrderDetail.setObject(1, salOrderVO.getOrderId());
			preparedStatementSalOrderDetail.setObject(2, salOrderVO.getOrderDetailId());
			preparedStatementSalOrderDetail.setObject(3, salOrderVO.getOrderDetailCode());
			preparedStatementSalOrderDetail.executeUpdate();

			StringBuffer salOrderDetailReview = new StringBuffer(
					"insert into sal_order_detail_review(order_detail_review_id,order_detail_id)values(?,?)");
			preparedStatementSalOrderDetailReview = DbConnection.getConnection()
					.prepareStatement(salOrderDetailReview.toString());
			preparedStatementSalOrderDetailReview.setObject(1, StringUtil.generateUUID());
			preparedStatementSalOrderDetailReview.setObject(2, salOrderVO.getOrderDetailId());
			preparedStatementSalOrderDetailReview.executeUpdate();

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
			if (prepareStatementSalOrder != null) {
				try {
					prepareStatementSalOrder.close();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
			if (preparedStatementSalOrderDetail != null) {
				try {
					preparedStatementSalOrderDetail.close();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
			if (preparedStatementSalOrderDetailReview != null) {
				try {
					preparedStatementSalOrderDetailReview.close();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}
	}

	@Override
	public SalOrderVO load(String customerId) {
		PreparedStatement prepareStatement = null;
		ResultSet resultSet = null;
		try {
			StringBuffer sql = new StringBuffer(
					" SELECT sal_order.* , sal_order_detail.* , sal_order_detail_review.* ,");
			sql.append(
					" sal_order_detail.order_id as order_id , sal_order_detail_review.order_detail_id as order_detail_id");
			sql.append(" from sal_order");
			sql.append(" INNER JOIN sal_order_detail");
			sql.append(" on sal_order.order_id=sal_order_detail.order_id");
			sql.append(" INNER JOIN sal_order_detail_review");
			sql.append(" on sal_order_detail.order_detail_id=sal_order_detail_review.order_detail_id");
			sql.append(" where 1=1 and sal_order.customer_id = ");
			sql.append("'" + customerId + "'");
			System.out.println("load sql:" + sql);
			System.out.println("load sql param id:" + customerId);
			prepareStatement = DbConnection.getConnection().prepareStatement(sql.toString());
			resultSet = prepareStatement.executeQuery();
			if (resultSet.next()) {
				SalOrderVO salOrderVO = new SalOrderVO();
				salOrderVO.setOrderId((String) resultSet.getObject("order_id"));
				salOrderVO.setCustomerId((String) resultSet.getObject("customer_id"));
				salOrderVO.setOrderCode((String) resultSet.getObject("order_code"));
				salOrderVO.setTatalMoney((BigDecimal) (resultSet.getObject("tatal_money")));
				salOrderVO.setDiscountRate((BigDecimal) resultSet.getObject("discount_rate"));
				salOrderVO.setActualTatalMoney((BigDecimal) resultSet.getObject("actual_tatal_money"));
				salOrderVO.setPayStatus((BigDecimal) resultSet.getObject("pay_status"));
				salOrderVO.setPayDate((Date) resultSet.getObject("pay_date"));
				salOrderVO.setCreateDatetime((Date) resultSet.getObject("create_datetime"));
				salOrderVO.setOrderDetailReviewId((String) resultSet.getObject("order_detail_review_id"));
				System.out.println(resultSet.getObject("order_detail_review_id"));
				salOrderVO.setOrderDetailId((String) resultSet.getObject("order_detail_id"));
				salOrderVO.setReviewGrade((BigDecimal) (resultSet.getObject("review_grade")));
				salOrderVO.setContent((String) resultSet.getObject("content"));
				salOrderVO.setCreateDate((Date) resultSet.getObject("create_date"));
				System.out.println(resultSet.getObject("order_detail_id"));
				salOrderVO.setProductSkuId((String) resultSet.getObject("product_sku_id"));
				salOrderVO.setOrderDetailCode((String) resultSet.getObject("order_detail_code"));
				salOrderVO.setName((String) resultSet.getObject("name"));
				salOrderVO.setAmount((BigDecimal) (resultSet.getObject("amount")));
				salOrderVO.setPrice((BigDecimal) resultSet.getObject("price"));
				salOrderVO.setRemark((String) resultSet.getObject("remark"));
				salOrderVO.setStockOutStatus((BigDecimal) resultSet.getObject("stock_out_status"));
				salOrderVO.setStockOutDate((Date) resultSet.getObject("stock_out_date"));
				salOrderVO.setLogisticsStatus((BigDecimal) resultSet.getObject("logistics_status"));
				salOrderVO.setLogisticsArriveDate((Date) resultSet.getObject("logistics_arrive_date"));
				salOrderVO.setLogisticsSignDate((Date) resultSet.getObject("logistics_sign_date"));
				salOrderVO.setReviewStatus((BigDecimal) resultSet.getObject("review_status"));
				return salOrderVO;
			} else {
				throw new DbException("数据不存在:" + customerId);
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
	public void delete(String orderId, String orderDetailId) {
		StringBuffer sql1 = new StringBuffer(" delete from sal_order where order_id = ? ");
		Object[] paramsValue1 = { orderId };
		super.update(sql1, paramsValue1);
		StringBuffer sql2 = new StringBuffer(" delete from sal_order_detail where order_detail_id = ? ");
		Object[] paramsValue2 = { orderDetailId };
		super.update(sql2, paramsValue2);
		StringBuffer sql3 = new StringBuffer(" delete from sal_order_detail_review where order_detail_id = ? ");
		Object[] paramsValue3 = { orderDetailId };
		super.update(sql3, paramsValue3);
	}

	@Override
	public List<SalOrderVO> list(SalOrderVO salOrderVO) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public SalOrderVO load(String orderId, String customerId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<SalOrderVO> pageResult(int pageIndex, int pageSize, String customerId, String orderId) {
		List<SalOrderVO> salOrderVO = null;
		Object[] paramsValue = new Object[2];
		int paramsIndex = 0;
		StringBuffer sql = new StringBuffer("SELECT sal_order.* , sal_order_detail.order_detail_id , sal_order_detail.product_sku_id , sal_order_detail.order_detail_code , sal_order_detail.name , sal_order_detail.amount , sal_order_detail.price ,");
		sql.append(" sal_order_detail.remark , sal_order_detail.stock_out_status , sal_order_detail.stock_out_date , sal_order_detail_review.order_detail_review_id , sal_order_detail_review.review_grade , sal_order_detail_review.content , sal_order_detail_review.create_date ");
		sql.append("from sal_order");
		sql.append(" INNER JOIN sal_order_detail");
		sql.append(" on sal_order.order_id=sal_order_detail.order_id");
		sql.append(" INNER JOIN sal_order_detail_review");
		sql.append(" on sal_order_detail.order_detail_id=sal_order_detail_review.order_detail_id");
		sql.append(" where 1=1");
		if (!StringUtil.isEmpty(customerId)) {
			sql.append(" and sal_order.customer_id = ?");
			paramsValue[paramsIndex] = customerId;
			paramsIndex++;
		}
		if (!StringUtil.isEmpty(orderId)) {
			sql.append(" and sal_order.order_id = ?");
			paramsValue[paramsIndex] = orderId;
			paramsIndex++;
		}
		sql.append(" order by create_datetime desc ");
		sql.append(" limit " + pageIndex * pageSize + "," + pageSize);
		salOrderVO = super.query(sql, paramsValue, SalOrderVO.class);
		return salOrderVO;
	}

	@Override
	public Page pageList(int pageIndex, int pageSize, String customerId, String orderId) {
		Page page = new Page();
		int rowCount = pageRowCount(customerId);
		int pageCount = (rowCount - 1) / pageSize + 1;
		if (pageIndex < 0) {
			pageIndex = 0;
		}
		if (pageIndex > pageCount) {
			pageIndex = pageCount;
		}
		List result = pageResult(pageIndex, pageSize, customerId, orderId);
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
	public int pageRowCount(String customerId) {
		StringBuffer sql = new StringBuffer("SELECT sal_order.* , sal_order_detail.order_detail_id , sal_order_detail.product_sku_id , sal_order_detail.order_detail_code , sal_order_detail.name , sal_order_detail.amount , sal_order_detail.price ,");
		sql.append(" sal_order_detail.remark , sal_order_detail.stock_out_status , sal_order_detail.stock_out_date , sal_order_detail_review.order_detail_review_id , sal_order_detail_review.review_grade , sal_order_detail_review.content , sal_order_detail_review.create_date ");
		sql.append("from sal_order");
		sql.append(" INNER JOIN sal_order_detail");
		sql.append(" on sal_order.order_id=sal_order_detail.order_id");
		sql.append(" INNER JOIN sal_order_detail_review");
		sql.append(" on sal_order_detail.order_detail_id=sal_order_detail_review.order_detail_id");
		sql.append(" where 1=1");
		int paramsIndex = 0;
		Object[] paramsValue = new Object[2];
		if (!StringUtil.isEmpty(customerId)) {
			sql.append(" and sal_order.customer_id = ?");
			paramsValue[paramsIndex] = customerId;
			paramsIndex++;
		}
		int count = super.query(sql, paramsValue, SalOrderVO.class).size();
		return count;
	}

	@Override
	public List<SalOrderVO> loadnotpay(int pageIndex, int pageSize, String customerId) {
		List<SalOrderVO> salOrderVOs = null;
		Object[] paramsValue = new Object[1];
		int paramsIndex = 0;
		StringBuffer sql = new StringBuffer("SELECT sal_order.* , sal_order_detail.order_detail_id , sal_order_detail.product_sku_id , sal_order_detail.order_detail_code , sal_order_detail.name , sal_order_detail.amount , sal_order_detail.price ,");
		sql.append(" sal_order_detail.remark , sal_order_detail.stock_out_status , sal_order_detail.stock_out_date , sal_order_detail_review.order_detail_review_id , sal_order_detail_review.review_grade , sal_order_detail_review.content , sal_order_detail_review.create_date ");
		sql.append(" from sal_order");
		sql.append(" INNER JOIN sal_order_detail");
		sql.append(" on sal_order.order_id=sal_order_detail.order_id");
		sql.append(" INNER JOIN sal_order_detail_review");
		sql.append(" on sal_order_detail.order_detail_id=sal_order_detail_review.order_detail_id");
		sql.append(" where 1=1 ");
		sql.append(" and sal_order.pay_status = 0");
		System.out.println("load sql:" + sql);
		System.out.println("load sql param id:" + customerId);
		if (!StringUtil.isEmpty(customerId)) {
			sql.append(" and sal_order.customer_id = ?");
			paramsValue[paramsIndex] = customerId;
			paramsIndex++;
		}
		sql.append(" order by create_datetime desc ");
		sql.append(" limit " + pageIndex * pageSize + "," + pageSize);
		salOrderVOs = super.query(sql, paramsValue, SalOrderVO.class);
		return salOrderVOs;

	}
	
	
	@Override
	public Page pagenotpay(int pageIndex, int pageSize, String customerId) {
		Page page = new Page();
		int rowCount = pageRowCount(customerId);
		int pageCount = (rowCount - 1) / pageSize + 1;
		if (pageIndex < 0) {
			pageIndex = 0;
		}
		if (pageIndex > pageCount) {
			pageIndex = pageCount;
		}
		List result = loadnotpay(pageIndex, pageSize, customerId);
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
	public List<SalOrderVO> loadnotarrive(int pageIndex, int pageSize, String customerId) {
		List<SalOrderVO> salOrderVOs = null;
		Object[] paramsValue = new Object[1];
		int paramsIndex = 0;
		StringBuffer sql = new StringBuffer("SELECT sal_order.* , sal_order_detail.order_detail_id , sal_order_detail.product_sku_id , sal_order_detail.order_detail_code , sal_order_detail.name , sal_order_detail.amount , sal_order_detail.price ,");
		sql.append(" sal_order_detail.remark , sal_order_detail.stock_out_status , sal_order_detail.stock_out_date , sal_order_detail_review.order_detail_review_id , sal_order_detail_review.review_grade , sal_order_detail_review.content , sal_order_detail_review.create_date ");
		sql.append(" from sal_order");
		sql.append(" INNER JOIN sal_order_detail");
		sql.append(" on sal_order.order_id=sal_order_detail.order_id");
		sql.append(" INNER JOIN sal_order_detail_review");
		sql.append(" on sal_order_detail.order_detail_id=sal_order_detail_review.order_detail_id");
		sql.append(" where 1=1");
		sql.append(" and sal_order_detail.logistics_status = 0 or sal_order_detail.logistics_status = 1");
		if (!StringUtil.isEmpty(customerId)) {
			sql.append(" and sal_order.customer_id = ?");
			paramsValue[paramsIndex] = customerId;
			paramsIndex++;
		}
		sql.append(" order by create_datetime desc ");
		sql.append(" limit " + pageIndex * pageSize + "," + pageSize);
		salOrderVOs = super.query(sql, paramsValue, SalOrderVO.class);
		return salOrderVOs;
	}

	@Override
	public Page pagenotarrive(int pageIndex, int pageSize, String customerId) {
		Page page = new Page();
		int rowCount = pageRowCount(customerId);
		int pageCount = (rowCount - 1) / pageSize + 1;
		if (pageIndex < 0) {
			pageIndex = 0;
		}
		if (pageIndex > pageCount) {
			pageIndex = pageCount;
		}
		List result = loadnotarrive(pageIndex, pageSize, customerId);
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
	public List<SalOrderVO> loadnocomment(int pageIndex, int pageSize, String customerId) {
		List<SalOrderVO> salOrderVOs = null;
		Object[] paramsValue = new Object[1];
		int paramsIndex = 0;
		StringBuffer sql = new StringBuffer("SELECT sal_order.* , sal_order_detail.order_detail_id , sal_order_detail.product_sku_id , sal_order_detail.order_detail_code , sal_order_detail.name , sal_order_detail.amount , sal_order_detail.price ,");
		sql.append(" sal_order_detail.remark , sal_order_detail.stock_out_status , sal_order_detail.stock_out_date , sal_order_detail_review.order_detail_review_id , sal_order_detail_review.review_grade , sal_order_detail_review.content , sal_order_detail_review.create_date ");
		sql.append(" from sal_order");
		sql.append(" INNER JOIN sal_order_detail");
		sql.append(" on sal_order.order_id=sal_order_detail.order_id");
		sql.append(" INNER JOIN sal_order_detail_review");
		sql.append(" on sal_order_detail.order_detail_id=sal_order_detail_review.order_detail_id");
		sql.append(" where 1=1");
		sql.append(" and sal_order_detail.review_status = 0");
		System.out.println("load sql:" + sql);
		System.out.println("load sql param id:" + customerId);
		if (!StringUtil.isEmpty(customerId)) {
			sql.append(" and sal_order.customer_id = ?");
			paramsValue[paramsIndex] = customerId;
			paramsIndex++;
		}
		sql.append(" order by create_datetime desc ");
		sql.append(" limit " + pageIndex * pageSize + "," + pageSize);
		salOrderVOs = super.query(sql, paramsValue, SalOrderVO.class);
		return salOrderVOs;
	}
	
	@Override
	public Page pagenocomment(int pageIndex, int pageSize, String customerId) {
		Page page = new Page();
		int rowCount = pageRowCount(customerId);
		int pageCount = (rowCount - 1) / pageSize + 1;
		if (pageIndex < 0) {
			pageIndex = 0;
		}
		if (pageIndex > pageCount) {
			pageIndex = pageCount;
		}
		List result = loadnocomment(pageIndex, pageSize, customerId);
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

}
