package com.barter.share.bas.dao.imp;

import java.math.BigDecimal;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;







import com.barter.share.bas.dao.IPchStockin;
import com.barter.share.bas.entity.PchStockin;
import com.barter.share.bas.vo.PchVo;
import com.barter.share.framework.dao.basDao;
import com.barter.share.framework.entity.Page;
import com.barter.share.framework.exception.DbException;
import com.barter.share.framework.exception.ValidateException;
import com.barter.share.framework.util.StringUtil;








public class PchStockiImp extends basDao implements IPchStockin {
	/**
	 * 增加
	 */
	@Override
	public PchStockin insert(PchStockin  pchStockin){
		PreparedStatement preparedStatement=null;
		try {	
			StringBuffer sql =new StringBuffer("insert into pch_stockin");
			sql.append("(stockin_id,supplier_id,purchase_date,tatal_money,this_pay_money,bill_status,pay_status,create_employee_id,create_datetime)");
			sql.append("value(?,?,?,?,?,?,?,?,?)");
			preparedStatement=super.getConnection().prepareStatement(sql.toString());
			int index=1;
			preparedStatement.setObject(index++,  pchStockin.getStockinId());
			preparedStatement.setObject(index++,  pchStockin.getSupplierId());
			preparedStatement.setObject(index++,  pchStockin.getPurchaseDate());
			preparedStatement.setObject(index++,  pchStockin.getTatalMoney());
			preparedStatement.setObject(index++,  pchStockin.getThisPayMoney());
			preparedStatement.setObject(index++,  pchStockin.getBillStatus());
			preparedStatement.setObject(index++,  pchStockin.getPayStatus());
			preparedStatement.setObject(index++,  pchStockin.getCreateEmployeeId());
			preparedStatement.setObject(index++,  pchStockin.getCreateDatetime());
			int row=preparedStatement.executeUpdate();
			
					
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			if (preparedStatement != null) {
			try {
				preparedStatement.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
			closeConnection();
		}
	 }
		return  pchStockin;
	}
	
	/**
	 * 更新
	 */
	@Override
	public PchStockin update(PchStockin  pchStockin){
		PreparedStatement preparedStatement=null;
		try {
			StringBuffer str = new StringBuffer(
					"update  pch_stockin set supplier_id=?,purchase_date=?,tatal_money=?,this_pay_money=?,bill_status=?,pay_status=?,pay_statuscreate_employee_id=?,create_datetime=? where stockin_id= ?");
			preparedStatement = super.getConnection().prepareStatement(
					str.toString());
			int index = 1;
		
			preparedStatement.setObject(index++,  pchStockin.getSupplierId());
			preparedStatement.setObject(index++,  pchStockin.getPurchaseDate());
			preparedStatement.setObject(index++,  pchStockin.getTatalMoney());
			preparedStatement.setObject(index++,  pchStockin.getThisPayMoney());
			preparedStatement.setObject(index++,  pchStockin.getBillStatus());
			preparedStatement.setObject(index++,  pchStockin.getPayStatus());
			preparedStatement.setObject(index++,  pchStockin.getCreateEmployeeId());
			preparedStatement.setObject(index++,  pchStockin.getCreateDatetime());
			preparedStatement.setObject(index++,  pchStockin.getStockinId());
			int rowCount = preparedStatement.executeUpdate();
			if (rowCount == 0) {
				throw new DbException("数据不存在:" +  pchStockin.getStockinId());
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if(preparedStatement!=null){
				try {
					preparedStatement.close();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
			closeConnection();
		}
		return   pchStockin;
	}
	/**
	 * 删除
	 */
	@Override
	public void delete(String id){
		PreparedStatement preparedStatement = null;
		try {
			StringBuffer sql = new StringBuffer(
					"delete from  pch_stockin where stockin_id=?");
			preparedStatement = super.getConnection().prepareStatement(
					sql.toString());
			int index = 1;
			preparedStatement.setObject(index++,id );
			
			int rowCount = preparedStatement.executeUpdate();
			if (rowCount != 1) {
				throw new DbException("数据不存在:" +id);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {

			if (preparedStatement != null) {
				try {
					preparedStatement.close();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
			closeConnection();
		}
		
	}
	/**
	 * chaxunsuoyou 
	 */
	public List<PchStockin> list (){
		List<PchStockin> list=new ArrayList<PchStockin>();
		PreparedStatement prepareStatement = null;
		ResultSet resultSet=null;
		try {
			StringBuilder str=new StringBuilder("select * from pch_stockin where 1=1");
			prepareStatement = getConnection().prepareStatement(str.toString());
			
			resultSet=prepareStatement.executeQuery();
			while(resultSet.next()){
				PchStockin pchStockin=new PchStockin();
				pchStockin.setStockinId((String)resultSet.getObject("stockin_id"));
				pchStockin.setSupplierId((String)resultSet.getObject("supplier_id"));
				pchStockin.setPurchaseDate((Date)resultSet.getObject("purchase_date"));
				pchStockin.setTatalMoney((BigDecimal)resultSet.getObject("tatal_money"));
				pchStockin.setThisPayMoney((BigDecimal)resultSet.getObject("this_pay_money"));
				pchStockin.setBillStatus((BigDecimal)resultSet.getObject("bill_status"));
				pchStockin.setPayStatus((BigDecimal)resultSet.getObject("pay_status"));
				pchStockin.setCreateEmployeeId((String)resultSet.getObject("create_employee_id"));
				pchStockin.setCreateDatetime((Date)resultSet.getObject("create_datetime"));
				list.add(pchStockin);
			}
			return list;
		} catch (Exception e) {
			e.printStackTrace();
			throw new DbException(e.getMessage(), e);
		}finally{
			if(resultSet!=null){
				try {
					resultSet.close();
				} catch (Exception e2) {
					e2.printStackTrace();
				}
			}
			if(prepareStatement!=null){
				try {
					prepareStatement.close();
				} catch (Exception e2) {
					e2.printStackTrace();
				}
			}
			closeConnection();
		}
	}
	
	/**
	 * 查询
	 */
	@Override
	public PchStockin load(String id){
		PreparedStatement prepareStatement = null;
		ResultSet resultSet = null;
		try {
			StringBuffer sql =new StringBuffer("select * from pch_stockin  where stockin_id = ?");
			prepareStatement =super.getConnection().prepareStatement(sql.toString());
			prepareStatement.setObject(1, id);
			
			resultSet = prepareStatement.executeQuery();
			if (resultSet.next()) {
				PchStockin  pchStockin = new PchStockin();
				pchStockin.setStockinId((String)resultSet.getObject("stockin_id"));//从数据库中获取到的信息 存进到student里面去
				pchStockin.setSupplierId((String)resultSet.getObject("supplier_id"));
				pchStockin.setPurchaseDate((Date)resultSet.getObject("purchase_date"));
				//System.out.println((String)resultSet.getObject("stockin_id"));
				
				pchStockin.setTatalMoney((BigDecimal)resultSet.getObject("tatal_money"));
				pchStockin.setThisPayMoney((BigDecimal)resultSet.getObject("this_pay_money"));
				pchStockin.setBillStatus((BigDecimal)resultSet.getObject("bill_status"));
				pchStockin.setPayStatus((BigDecimal)resultSet.getObject("pay_status"));
				pchStockin.setCreateEmployeeId((String)resultSet.getObject("create_employee_id"));
				pchStockin.setCreateDatetime((Date)resultSet.getObject("create_datetime"));
				return pchStockin;
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
			closeConnection();
		}
	}
	/**
	 * 分页查询
	 */
	@Override
	public List<PchStockin> pageResult(int pageIndex, int pageSize, String createEmployeeId){
		List<PchStockin > list=new ArrayList<PchStockin>();
		PreparedStatement prepareStatement = null;
		ResultSet resultSet=null;
		try {
			StringBuffer sql=new StringBuffer("select pch_stockin.*,bas_supplier.`name`as suppliter_name,bas_customer.`code`AS customer_code");
			sql.append(" from pch_stockin");
			sql.append(" INNER JOIN bas_supplier");
			sql.append(" ON pch_stockin.supplier_id=bas_supplier.supplier_id");
			sql.append(" INNER JOIN bas_customer");
			sql.append(" ON pch_stockin.create_employee_id=bas_customer.customer_id");
			
			sql.append(" where 1=1");
			

			if(!StringUtil.isEmpty( createEmployeeId)){
				sql.append(" and create_employee_id=?");
			}
			sql.append(" order by stockin_id desc");
			sql.append(" limit " + pageIndex * pageSize + "," + pageSize);
			
			prepareStatement=super.getConnection().prepareStatement(sql.toString());
			int index=1;
		
			if(!StringUtil.isEmpty(createEmployeeId)){
				prepareStatement.setObject(index++,createEmployeeId);
			}
			//System.out.println(sql.toString());
			resultSet=prepareStatement.executeQuery();
			
			while(resultSet.next()){
				PchVo pchVo=new PchVo();
				pchVo.setStockinId((String)resultSet.getObject("stockin_id"));
				//System.out.println(resultSet.getObject("stockin_id"));
				pchVo.setSupplierId((String)resultSet.getObject("supplier_id"));
				pchVo.setPurchaseDate((Date)resultSet.getObject("purchase_date"));
				pchVo.setTatalMoney((BigDecimal)resultSet.getObject("tatal_money"));
				pchVo.setThisPayMoney((BigDecimal)resultSet.getObject("this_pay_money"));
				pchVo.setBillStatus((BigDecimal)resultSet.getObject("bill_status"));
				pchVo.setPayStatus((BigDecimal)resultSet.getObject("pay_status"));
				pchVo.setCreateEmployeeId((String)resultSet.getObject("create_employee_id"));
				pchVo.setCreateDatetime((Date)resultSet.getObject("create_datetime"));
				pchVo.setName((String)resultSet.getObject("suppliter_name"));
				pchVo.setCode((String)resultSet.getObject("customer_code"));
				list.add(pchVo);
			}
			  return list;  
			
		} catch (Exception e) {
			throw new DbException(e.getMessage(), e);
		}finally{if (resultSet != null) {
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
		closeConnection();
	}
		
	}
	/**
	 * 页数
	 */
	@Override
	public int pageRowCount(int pageSize, String createEmployeeId){
		 int count = 0;
			PreparedStatement prepareStatement = null;
			ResultSet resultSet = null;
			try { 
				StringBuffer sql =new StringBuffer("select count(stockin_id) from pch_stockin where 1=1");
				if(!StringUtil.isEmpty(createEmployeeId)){
					sql.append(" and create_employee_id=?");
				}
				
				prepareStatement=super.getConnection().prepareStatement(sql.toString());
				int index=1;
				if(!StringUtil.isEmpty(createEmployeeId)){
					prepareStatement.setObject(index++, createEmployeeId);
				}
				
				resultSet=prepareStatement.executeQuery();
				while(resultSet.next()){				
					count=((Number)resultSet.getObject(1)).intValue();
				}
				return count;
			} catch (Exception e) {
				throw new DbException(e.getMessage(),e );
			}finally{
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
				closeConnection();
			}
	}
	/**
	 * 页面查询
	 */
	@Override
	public Page pageList(int pageIndex, int pageSize,String createEmployeeId){
		Page page = new Page();
		int rowCount = pageRowCount(pageSize, createEmployeeId);
		int pageCount = (rowCount - 1) / pageSize + 1;

		if (pageIndex < 0) {
			pageIndex = 0;
		}

		if (pageIndex > pageCount) {
			pageIndex = pageCount;
		}

		List<PchStockin> result = pageResult(pageIndex, pageSize, createEmployeeId);
        //System.out.println(result.get(0).getStockinId());
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
	
	/**
	 * 验证
	 */
	@Override
	public void validateUnique4Code(PchStockin pchStockin){
		int count = 0;

		PreparedStatement prepareStatement = null;
		ResultSet resultSet = null;
		try {
			StringBuffer sql=new StringBuffer("select count(stockin_id) from pch_stockin where this_pay_money= ?");
             //System.out.println(pchStockin.getStockinId()+"20202020202202");
			if(pchStockin.getStockinId() != null){	
				sql.append(" and stockin_id <> ?");
			}
			

			prepareStatement = getConnection().prepareStatement(sql.toString());
			
			prepareStatement.setObject(1, pchStockin.getThisPayMoney());
			
			if(pchStockin.getStockinId() != null){
				prepareStatement.setObject(2,pchStockin.getStockinId());
			}

			
			resultSet = prepareStatement.executeQuery();

			if (resultSet.next()) {
				count = ((Number) resultSet.getObject(1)).intValue();
			}

			if(count != 0){
				throw new ValidateException("员工编号出错:"+pchStockin.getCreateEmployeeId() ) ;
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

			closeConnection();
		}
		
	}
	
}




