package com.barter.share.bas.dao.imp;

import java.lang.reflect.InvocationTargetException;
import java.math.BigDecimal;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Date;
import java.util.List;
import com.barter.share.bas.dao.ISalOrderDao;
import com.barter.share.bas.entity.SalOrder;
import com.barter.share.bas.vo.SalOrderVO;
import com.barter.share.framework.dao.BaseDao;
import com.barter.share.framework.dbutil.DbConnection;
import com.barter.share.framework.entity.Page;
import com.barter.share.framework.exception.DbException;
import com.barter.share.framework.exception.ValidateException;
import com.barter.share.framework.util.StringUtil;

public class SalOrderDao extends BaseDao implements ISalOrderDao {

	// 新增
	@Override
	public void insert(SalOrder salOrder) throws NoSuchMethodException, SecurityException, IllegalAccessException, IllegalArgumentException, InvocationTargetException {
//		StringBuffer sql = new StringBuffer();
//		sql.append("insert into sal_order(order_id,customer_id,order_code,tatal_money,discount_rate,"
//			+ "actual_tatal_money,pay_status,pay_date,create_datetime) values(?,?,?,?,?,?,?,?,now())");
//		Object [] paramsValue =StringUtil.reflectValue(salOrder);
//		super.update(sql, paramsValue);
		PreparedStatement prepareStatementSalOrder = null;
		ResultSet resultSetSalOrder = null;
		try {
			StringBuffer salOrderSql = new StringBuffer();
			salOrderSql.append("insert into sal_order(order_id,customer_id,order_code,tatal_money,discount_rate,"
					+ "actual_tatal_money,pay_status,pay_date,create_datetime) values(?,?,?,?,?,?,?,?,now())");
			System.out.println("insert sql:" + salOrderSql);
			System.out.println("insert sql param:" + salOrder.toString());
			prepareStatementSalOrder = DbConnection.getConnection().prepareStatement(salOrderSql.toString());
			prepareStatementSalOrder.setObject(1, salOrder.getOrderId());
			prepareStatementSalOrder.setObject(2, salOrder.getCustomerId());
			prepareStatementSalOrder.setObject(3, salOrder.getOrderCode());
			prepareStatementSalOrder.setObject(4, salOrder.getTatalMoney());
			prepareStatementSalOrder.setObject(5, salOrder.getDiscountRate());
			prepareStatementSalOrder.setObject(6, salOrder.getActualTatalMoney());
			prepareStatementSalOrder.setObject(7, salOrder.getPayStatus());
			prepareStatementSalOrder.setObject(8, salOrder.getPayDate());
			int row = prepareStatementSalOrder.executeUpdate();
					
		} catch (Exception ex) {
			ex.printStackTrace();
			throw new DbException(ex.getMessage(), ex);
		} finally {
			if ( resultSetSalOrder != null) {
				try {
					 resultSetSalOrder.close();
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
		}
	}

	// 修改
	@Override
	public void update(SalOrder salOrder) {
		PreparedStatement prepareStatement = null;
		try {
			StringBuffer sql = new StringBuffer();
			sql.append("update sal_order set customer_id = ? , order_code = ?,tatal_money = ? ,"
					+ "discount_rate = ? , actual_tatal_money = ? , pay_status = ? , pay_date = ?,"
					+ "create_datetime = ?  where order_id = ?");
			System.out.println("updateOne sql:" + sql);
			System.out.println("updateOne sql param:" + salOrder.toString());
			prepareStatement = DbConnection.getConnection().prepareStatement(sql.toString());
			prepareStatement.setObject(1, salOrder.getCustomerId());
			prepareStatement.setObject(2, salOrder.getOrderCode());
			prepareStatement.setObject(3, salOrder.getTatalMoney());
			prepareStatement.setObject(4, salOrder.getDiscountRate());
			prepareStatement.setObject(5, salOrder.getActualTatalMoney());
			prepareStatement.setObject(6, salOrder.getPayStatus());
			prepareStatement.setObject(7, salOrder.getPayDate());
			prepareStatement.setObject(8, salOrder.getCreateDatetime());
			prepareStatement.setObject(9, salOrder.getOrderId());
			System.out.println(sql.toString());
			int row = prepareStatement.executeUpdate();
			if (row == 0)
				throw new DbException("订单不存在:" + salOrder.getOrderId());
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
	public void delete(String orderId) {
		StringBuffer sql = new StringBuffer(" delete from sal_order where order_id = ? ");
		Object[] paramsValue = { orderId };
		super.update(sql, paramsValue);
	}

	@Override
	// 加载单个对象
	public SalOrder load(int id) {
		PreparedStatement prepareStatement = null;
		ResultSet resultSet = null;
		try {
			StringBuffer sql = new StringBuffer("select * from sal_order where order_id = ?");
			System.out.println("load sql:" + sql);
			System.out.println("load sql param id:" + id);
			prepareStatement = DbConnection.getConnection().prepareStatement(sql.toString());
			prepareStatement.setObject(1, id);
			resultSet = prepareStatement.executeQuery();
			if (resultSet.next()) {
				SalOrder salOrder = new SalOrder();
				salOrder.setOrderId((String)resultSet.getObject("order_id"));
				salOrder.setCustomerId((String) resultSet.getObject("customer_id"));
				salOrder.setOrderCode((String) resultSet.getObject("order_code"));
				salOrder.setTatalMoney((BigDecimal) (resultSet.getObject("tatal_money")));
				salOrder.setDiscountRate((BigDecimal) resultSet.getObject("discount_rate"));
				salOrder.setActualTatalMoney((BigDecimal) resultSet.getObject("actual_tatal_money"));
				salOrder.setPayStatus((BigDecimal) resultSet.getObject("pay_status"));
				salOrder.setPayDate((Date) resultSet.getObject("pay_date"));
				salOrder.setCreateDatetime((Date) resultSet.getObject("create_datetime"));
				return salOrder;
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
	// 分页查询结果集
	public List<SalOrder> pageResult(int pageIndex, int pageSize, String orderId, String customerId) {
		List<SalOrder> salOrders = null;
		Object[] paramsValue = new Object[2];
		int paramsIndex = 0;
		StringBuffer sql = new StringBuffer(" select * from sal_order where 1=1 ");
		if (!StringUtil.isEmpty(orderId)) {
			sql.append(" and order_Id = ?");
			paramsValue[paramsIndex] = orderId;
			paramsIndex++;
		}
		if (!StringUtil.isEmpty(customerId)) {
			sql.append(" and customer_Id = ?");
			paramsValue[paramsIndex] =   customerId ;
			paramsIndex++;
		}
		sql.append(" order by order_id asc");
		sql.append(" limit " + pageIndex * pageSize + "," + pageSize);
		salOrders = super.query(sql, paramsValue, SalOrder.class);
		return salOrders;
	}

	@Override
	// 分页查询
	public Page pageList(int pageIndex, int pageSize, String orderId, String customerId) {
		Page page = new Page();
		int rowCount = pageRowCount(orderId, customerId);
		int pageCount = (rowCount - 1) / pageSize + 1;
		if (pageIndex < 0) {
			pageIndex = 0;
		}
		if (pageIndex > pageCount) {
			pageIndex = pageCount;
		}
		List result = pageResult(pageIndex, pageSize, orderId, customerId);
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
	// 分页查询记录总数
	public int pageRowCount(String orderId, String customerId) {
		StringBuffer sql = new StringBuffer(" select * from sal_order  where 1=1 ");
		int paramsIndex = 0;
		Object[] paramsValue = new Object[2];
		if (!StringUtil.isEmpty(orderId)) {
			sql.append(" and order_id = ? ");
			paramsValue[paramsIndex] = orderId;
			paramsIndex++;
		}
		if (!StringUtil.isEmpty(customerId)) {
			sql.append(" and customer_id = ? ");
			paramsValue[paramsIndex] = customerId;
			paramsIndex++;
		}
		int count = super.query(sql, paramsValue, SalOrder.class).size();
		return count;
	}

	@Override
	public void validateUnique4Code(SalOrder salOrder)  {
		int count = 0;
		PreparedStatement prepareStatement = null;
		ResultSet resultSet = null;
		try {
			StringBuffer sql = new StringBuffer("select count(order_id) from sal_order where order_code  = ?");
			if (salOrder.getOrderId() != null) {
				sql.append(" and customer_id <> ?") ;
			}
			prepareStatement =DbConnection.getConnection().prepareStatement(sql.toString());
			prepareStatement.setObject(1, salOrder.getOrderCode());
			if (salOrder.getOrderId() != null) {
				prepareStatement.setObject(2, salOrder.getCustomerId());
			}
			resultSet = prepareStatement.executeQuery();
			if (resultSet.next()) {
				count = ((Number) resultSet.getObject(1)).intValue();
			}
			if (count != 0) {
				throw new ValidateException("订单编号重复:" + salOrder.getOrderCode());
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
			DbConnection.close();
		}
	}

	@Override
	public SalOrderVO joinselect(int id) {
		PreparedStatement prepareStatement = null;
		ResultSet resultSet = null;
		try {
			StringBuffer sql = new StringBuffer("select * from sal_order where order_id = ?");
			System.out.println("load sql:" + sql);
			System.out.println("load sql param id:" + id);
			prepareStatement = DbConnection.getConnection().prepareStatement(sql.toString());
			prepareStatement.setObject(1, id);
			resultSet = prepareStatement.executeQuery();
			if (resultSet.next()) {
				SalOrderVO salOrderlVO = new SalOrderVO();
				salOrderlVO.setOrderId((String)resultSet.getObject("order_id"));
				salOrderlVO.setCustomerId((String) resultSet.getObject("customer_id"));
				salOrderlVO.setOrderCode((String) resultSet.getObject("order_code"));
				salOrderlVO.setTatalMoney((BigDecimal) (resultSet.getObject("tatal_money")));
				salOrderlVO.setDiscountRate((BigDecimal) resultSet.getObject("discount_rate"));
				salOrderlVO.setActualTatalMoney((BigDecimal) resultSet.getObject("actual_tatal_money"));
				salOrderlVO.setPayStatus((BigDecimal) resultSet.getObject("pay_status"));
				salOrderlVO.setPayDate((Date) resultSet.getObject("pay_date"));
				salOrderlVO.setCreateDatetime((Date) resultSet.getObject("create_datetime"));
				salOrderlVO.setOrderDetailId((String)resultSet.getObject("order_detail_id"));
				System.out.println(resultSet.getObject("order_detail_id"));
				salOrderlVO.setProductSkuId((String)resultSet.getObject("product_sku_id"));
				salOrderlVO.setOrderDetailCode((String)resultSet.getObject("order_detail_code"));
				salOrderlVO.setName((String)resultSet.getObject("name"));
				salOrderlVO.setAmount((BigDecimal)(resultSet.getObject("amount")));
				salOrderlVO.setPrice((BigDecimal)resultSet.getObject("price"));
				salOrderlVO.setRemark((String)resultSet.getObject("remark"));
				salOrderlVO.setStockOutStatus((BigDecimal)resultSet.getObject("stock_out_status"));
				salOrderlVO.setStockOutDate((Date)resultSet.getObject("stock_out_date"));
				salOrderlVO.setLogisticsStatus((BigDecimal)resultSet.getObject("logistics_status"));
				salOrderlVO.setLogisticsArriveDate((Date)resultSet.getObject("logistics_arrive_date"));
				salOrderlVO.setLogisticsSignDate((Date)resultSet.getObject("logistics_sign_date"));
				salOrderlVO.setReviewStatus((BigDecimal)resultSet.getObject("review_status"));
				salOrderlVO.setOrderDetailReviewId((String)resultSet.getObject("order_detail_review_id"));
				System.out.println(resultSet.getObject("order_detail_review_id"));
				salOrderlVO.setReviewGrade((BigDecimal)(resultSet.getObject("review_grade")));
				salOrderlVO.setContent((String)resultSet.getObject("content"));
				salOrderlVO.setCreateDate((Date)resultSet.getObject("create_date"));
				return salOrderlVO;				
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
	public void payState(String orderId) {
		PreparedStatement prepareStatement = null;
		try {
			StringBuffer sql = new StringBuffer();
			sql.append("update sal_order set pay_status = 1 , pay_date = now()"
					+ "where order_id = ");
			sql.append("'"+orderId+"'");
			prepareStatement = DbConnection.getConnection().prepareStatement(sql.toString());
//			prepareStatement.setObject(1, orderId );
			int row = prepareStatement.executeUpdate();
			if (row == 0)
				throw new DbException("订单不存在:" + orderId);
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
}
