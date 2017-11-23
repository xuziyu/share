package com.barter.share.bas.dao.imp;

import java.math.BigDecimal;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;

import com.barter.share.bas.dao.ISalOrderDetailDao;
import com.barter.share.bas.entity.SalOrderDetail;
import com.barter.share.framework.dao.BaseDao;
import com.barter.share.framework.dbutil.DbConnection;
import com.barter.share.framework.entity.Page;
import com.barter.share.framework.exception.DbException;
import com.barter.share.framework.util.StringUtil;

public class SalOrderDetailDao extends BaseDao implements ISalOrderDetailDao {
	@Override
	public void insert(SalOrderDetail salOrderDetail) {

		PreparedStatement prepareStatement = null;
		ResultSet resultSet = null;
		try {
			StringBuffer sql = new StringBuffer();
			sql.append("insert into sal_order_detail (order_detail_id,order_id,product_sku_id,order_detail_code,"
					+ "name,amount,price,remark,stock_out_status,stock_out_date,logistics_status,logistics_arrive_date,"
					+ "logistics_sign_date,review_status)values(?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
			System.out.println("insert sql:" + sql);
			System.out.println("insert sql param:" + salOrderDetail.toString());
			prepareStatement = DbConnection.getConnection().prepareStatement(sql.toString());
			prepareStatement.setObject(1, salOrderDetail.getOrderDetailId());
			prepareStatement.setObject(2, salOrderDetail.getOrderId());
			prepareStatement.setObject(3, salOrderDetail.getProductSkuId());
			prepareStatement.setObject(4, salOrderDetail.getOrderDetailCode());
			prepareStatement.setObject(5, salOrderDetail.getName());
			prepareStatement.setObject(6, salOrderDetail.getAmount());
			prepareStatement.setObject(7, salOrderDetail.getPrice());
			prepareStatement.setObject(8, salOrderDetail.getRemark());
			prepareStatement.setObject(9, salOrderDetail.getStockOutStatus());
			prepareStatement.setObject(10, salOrderDetail.getStockOutDate());
			prepareStatement.setObject(11, salOrderDetail.getLogisticsStatus());
			prepareStatement.setObject(12, salOrderDetail.getLogisticsArriveDate());
			prepareStatement.setObject(13, salOrderDetail.getLogisticsSignDate());
			prepareStatement.setObject(14, salOrderDetail.getReviewStatus());
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
	public void update(SalOrderDetail salOrderDetail) {
		PreparedStatement prepareStatement = null;
		try {
			StringBuffer sql = new StringBuffer(
					"update sal_order_detail set order_id = ?,product_sku_id = ?,order_detail_code = ?,"
							+ "name = ?,amount = ?,price = ?,remark = ?,stock_out_status = ?,stock_out_date = ?,logistics_status = ?,logistics_arrive_date = ?,"
							+ "logistics_sign_date = ?,review_status = ? where order_detail_id = ? ");
			System.out.println("updateOne sql:" + sql);
			System.out.println("updateOne sql param:" + salOrderDetail.toString());
			prepareStatement = DbConnection.getConnection().prepareStatement(sql.toString());
			prepareStatement.setObject(1, salOrderDetail.getOrderId());
			prepareStatement.setObject(2, salOrderDetail.getProductSkuId());
			prepareStatement.setObject(3, salOrderDetail.getOrderDetailCode());
			prepareStatement.setObject(4, salOrderDetail.getName());
			prepareStatement.setObject(5, salOrderDetail.getAmount());
			prepareStatement.setObject(6, salOrderDetail.getPrice());
			prepareStatement.setObject(7, salOrderDetail.getRemark());
			prepareStatement.setObject(8, salOrderDetail.getStockOutStatus());
			prepareStatement.setObject(9, salOrderDetail.getStockOutDate());
			prepareStatement.setObject(10, salOrderDetail.getLogisticsStatus());
			prepareStatement.setObject(11, salOrderDetail.getLogisticsArriveDate());
			prepareStatement.setObject(12, salOrderDetail.getLogisticsSignDate());
			prepareStatement.setObject(13, salOrderDetail.getReviewStatus());
			prepareStatement.setObject(14, salOrderDetail.getOrderDetailId());
			int row = prepareStatement.executeUpdate();
			if (row == 0)
				throw new DbException("订单不存在:" + salOrderDetail.getOrderDetailId());
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
	public void delete(String orderDetailId) {
		StringBuffer sql = new StringBuffer(" delete from sal_order_detail where order_detail_id = ? ");
		Object[] paramsValue = { orderDetailId };
		super.update(sql, paramsValue);
	}

	@Override
	public List<SalOrderDetail> list(SalOrderDetail salOrderDetail) {
		return null;
	}

	@Override
	public SalOrderDetail load(String orderDetailId, String orderId) {
		PreparedStatement prepareStatement = null;
		ResultSet resultSet = null;
		SalOrderDetail salOrderDetail = new SalOrderDetail();
		System.out.println("LOAD");
		try {
			StringBuffer sql = new StringBuffer("select * from sal_order_detail where 1=1");
			System.out.println("load sql:" + sql);
			
			if (!StringUtil.isEmpty(orderDetailId)) {
				sql.append(" and order_detail_id = ?");
				prepareStatement = DbConnection.getConnection().prepareStatement(sql.toString());
				prepareStatement.setObject(1, orderDetailId);
				resultSet = prepareStatement.executeQuery();
				while (resultSet.next()) {
					salOrderDetail.setOrderDetailId((String) resultSet.getObject("order_detail_id"));
					System.out.println(resultSet.getObject("order_detail_id"));
					salOrderDetail.setOrderId((String) resultSet.getObject("order_id"));
					salOrderDetail.setProductSkuId((String) resultSet.getObject("product_sku_id"));
					salOrderDetail.setOrderDetailCode((String) resultSet.getObject("order_detail_code"));
					salOrderDetail.setName((String) resultSet.getObject("name"));
					salOrderDetail.setAmount((BigDecimal) (resultSet.getObject("amount")));
					salOrderDetail.setPrice((BigDecimal) resultSet.getObject("price"));
					salOrderDetail.setRemark((String) resultSet.getObject("remark"));
					salOrderDetail.setStockOutStatus((BigDecimal) resultSet.getObject("stock_out_status"));
					salOrderDetail.setStockOutDate((Date) resultSet.getObject("stock_out_date"));
					salOrderDetail.setLogisticsStatus((BigDecimal) resultSet.getObject("logistics_status"));
					salOrderDetail.setLogisticsArriveDate((Date) resultSet.getObject("logistics_arrive_date"));
					salOrderDetail.setLogisticsSignDate((Date) resultSet.getObject("logistics_sign_date"));
					salOrderDetail.setReviewStatus((BigDecimal) resultSet.getObject("review_status"));
				}
			} else if (!StringUtil.isEmpty(orderId)) {
				sql.append(" and order_id  = ?");
				prepareStatement = DbConnection.getConnection().prepareStatement(sql.toString());
				prepareStatement.setObject(1, orderId);
				resultSet = prepareStatement.executeQuery();
				while (resultSet.next()) {
					salOrderDetail.setOrderDetailId((String) resultSet.getObject("order_detail_id"));
					System.out.println(resultSet.getObject("order_detail_id"));
					salOrderDetail.setOrderId((String) resultSet.getObject("order_id"));
					salOrderDetail.setProductSkuId((String) resultSet.getObject("product_sku_id"));
					salOrderDetail.setOrderDetailCode((String) resultSet.getObject("order_detail_code"));
					salOrderDetail.setName((String) resultSet.getObject("name"));
					salOrderDetail.setAmount((BigDecimal) (resultSet.getObject("amount")));
					salOrderDetail.setPrice((BigDecimal) resultSet.getObject("price"));
					salOrderDetail.setRemark((String) resultSet.getObject("remark"));
					salOrderDetail.setStockOutStatus((BigDecimal) resultSet.getObject("stock_out_status"));
					salOrderDetail.setStockOutDate((Date) resultSet.getObject("stock_out_date"));
					salOrderDetail.setLogisticsStatus((BigDecimal) resultSet.getObject("logistics_status"));
					salOrderDetail.setLogisticsArriveDate((Date) resultSet.getObject("logistics_arrive_date"));
					salOrderDetail.setLogisticsSignDate((Date) resultSet.getObject("logistics_sign_date"));
					salOrderDetail.setReviewStatus((BigDecimal) resultSet.getObject("review_status"));
				}
			} else {
				throw new DbException("数据不存在:" + orderDetailId + orderId);
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
		return salOrderDetail;
	}

	@Override
	public List<SalOrderDetail> pageResult(int pageIndex, int pageSize, String orderDetailId, String orderId) {
		List<SalOrderDetail> salOrderDetails = null;
		Object[] paramsValue = new Object[2];
		int paramsIndex = 0;
		StringBuffer sql = new StringBuffer(" select * from sal_order_detail where 1=1 ");
		if (!StringUtil.isEmpty(orderDetailId)) {
			sql.append(" and order_detail_id = ?");
			paramsValue[paramsIndex] = orderDetailId;
			paramsIndex++;
		}
		if (!StringUtil.isEmpty(orderId)) {
			sql.append(" and order_id  = ?");
			paramsValue[paramsIndex] = orderId;
			paramsIndex++;
		}
		sql.append(" order by order_detail_id asc");
		sql.append(" limit " + pageIndex * pageSize + "," + pageSize);
		salOrderDetails = super.query(sql, paramsValue, SalOrderDetail.class);
		return salOrderDetails;
	}

	@Override
	public Page pageList(int pageIndex, int pageSize, String orderDetailId, String orderId) {
		Page page = new Page();
		int rowCount = pageRowCount(orderDetailId, orderId);
		int pageCount = (rowCount - 1) / pageSize + 1;
		if (pageIndex < 0) {
			pageIndex = 0;
		}
		if (pageIndex > pageCount) {
			pageIndex = pageCount;
		}
		List result = pageResult(pageIndex, pageSize, orderDetailId, orderId);
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
	public int pageRowCount(String orderDetailId, String orderId) {
		Object[] paramsValue = new Object[2];
		int paramsIndex = 0;
		StringBuffer sql = new StringBuffer(" select * from sal_order_detail where 1=1 ");
		if (!StringUtil.isEmpty(orderDetailId)) {
			sql.append(" and order_detail_id = ?");
			paramsValue[paramsIndex] = orderDetailId;
			paramsIndex++;
		}
		if (!StringUtil.isEmpty(orderId)) {
			sql.append(" and order_id  = ?");
			paramsValue[paramsIndex] = orderId;
			paramsIndex++;
		}
		int count = super.query(sql, paramsValue, SalOrderDetail.class).size();
		return count;
	}

}
