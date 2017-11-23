package com.barter.share.bas.dao.imp;

import java.math.BigDecimal;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.barter.share.bas.dao.IPchStockinDetail;
import com.barter.share.bas.entity.PchStockinDetail;
import com.barter.share.bas.vo.PchStockVo;
import com.barter.share.framework.dao.basDao;
import com.barter.share.framework.entity.Page;
import com.barter.share.framework.exception.DbException;
import com.barter.share.framework.exception.ValidateException;
import com.barter.share.framework.util.StringUtil;

/**
 * 
 * @author Administrator
 *   xubo 
 */

public class PchStockinDetailImp extends basDao implements IPchStockinDetail {
	/**
	 * 新增存进数据库
	 */
	public PchStockinDetail insert(PchStockinDetail  pchStockinDetail){
		
		PreparedStatement preparedStatement=null;
		try {	
			StringBuffer sql =new StringBuffer("insert into pch_stockin_detail");
			sql.append("(stockin_detail_id,stockin_id,product_sku_id,name,amount,price,money_real,remark)");
			sql.append("value(?,?,?,?,?,?,?,?)");
			preparedStatement=super.getConnection().prepareStatement(sql.toString());
			int index=1;
			preparedStatement.setObject(index++,  pchStockinDetail.getStockinDetailId());
			preparedStatement.setObject(index++,  pchStockinDetail.getStockinId());
			preparedStatement.setObject(index++,  pchStockinDetail.getProductSkuId());
			preparedStatement.setObject(index++,  pchStockinDetail.getName());
			preparedStatement.setObject(index++,  pchStockinDetail.getAmount());
			preparedStatement.setObject(index++,  pchStockinDetail.getPrice());
			preparedStatement.setObject(index++,  pchStockinDetail.getMoneyReal());
			preparedStatement.setObject(index++,  pchStockinDetail.getRemark());
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
		return  pchStockinDetail;
	}
	/**
	 * 更新
	 */
	public PchStockinDetail update(PchStockinDetail  pchStockinDetail){
		PreparedStatement preparedStatement=null;
		try {
			StringBuffer str = new StringBuffer(
					"update  pch_stockin_detail set stockin_id=?,product_sku_id=?,name=?,amount=?,price=?,money_real=?,remark=? where stockin_detail_id= ?");
			preparedStatement = super.getConnection().prepareStatement(
					str.toString());
			int index = 1;
		
			preparedStatement.setObject(index++,   pchStockinDetail.getStockinId());
			preparedStatement.setObject(index++,   pchStockinDetail.getProductSkuId());
			preparedStatement.setObject(index++,   pchStockinDetail.getName());
			preparedStatement.setObject(index++,   pchStockinDetail.getAmount());
			preparedStatement.setObject(index++,   pchStockinDetail.getPrice());
			preparedStatement.setObject(index++,   pchStockinDetail.getMoneyReal());
			preparedStatement.setObject(index++,   pchStockinDetail.getRemark());
			preparedStatement.setObject(index++,   pchStockinDetail.getStockinDetailId());
			
		
			int rowCount = preparedStatement.executeUpdate();
			if (rowCount == 0) {
				throw new DbException("数据不存在:" +   pchStockinDetail.getStockinDetailId());
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
		return    pchStockinDetail;
	}
	/**
	 * 删除
	 */
	public void delete(String id){
		PreparedStatement preparedStatement = null;
		try {
			StringBuffer sql = new StringBuffer(
					"delete from  pch_stockin_detail where stockin_detail_id=?");
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
	 * 查找
	 */
	public PchStockinDetail load(String id){
		
		PreparedStatement prepareStatement = null;
		ResultSet resultSet = null;
		try {
			StringBuffer sql =new StringBuffer("select * from pch_stockin_detail  where stockin_detail_id = ?");
			prepareStatement =super.getConnection().prepareStatement(sql.toString());
			prepareStatement.setObject(1, id);
			
			resultSet = prepareStatement.executeQuery();
			if (resultSet.next()) {
				PchStockinDetail pchStockinDetail=new PchStockinDetail();
				pchStockinDetail.setStockinDetailId((String)resultSet.getObject("stockin_detail_id"));
				//System.out.println(resultSet.getObject("stockinDetailId"));
				pchStockinDetail.setStockinId((String)resultSet.getObject("stockin_id"));
				pchStockinDetail.setProductSkuId((String)resultSet.getObject("product_sku_id"));
				pchStockinDetail.setName((String)resultSet.getObject("name"));
				pchStockinDetail.setAmount((BigDecimal)resultSet.getObject("amount"));
				pchStockinDetail.setPrice((BigDecimal)resultSet.getObject("price"));
				pchStockinDetail.setMoneyReal((BigDecimal)resultSet.getObject("money_real"));
				pchStockinDetail.setRemark((String)resultSet.getObject("remark"));
				return pchStockinDetail;
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
	 * 分页那结果集
	 */
	public List<PchStockinDetail> pageResult(int pageIndex, int pageSize,String name){
		
		List<PchStockinDetail > list=new ArrayList<PchStockinDetail>();
		PreparedStatement prepareStatement = null;
		ResultSet resultSet=null;
		try {
	
			StringBuffer sql=new StringBuffer("select pch_stockin_detail.* ,pch_stockin.supplier_id,bas_product_sku.bar_code ");
			sql.append(" FROM pch_stockin_detail");
			sql.append(" INNER JOIN pch_stockin");
			sql.append(" ON pch_stockin_detail.stockin_id=pch_stockin.stockin_id");
			sql.append(" INNER JOIN bas_product_sku");
			sql.append(" ON pch_stockin_detail.product_sku_id=bas_product_sku.product_sku_id");
            sql.append(" where 1=1");

			if(!StringUtil.isEmpty( name)){
				sql.append(" and name like ?");
			}
			sql.append(" order by stockin_detail_id desc");
			sql.append(" limit " + pageIndex * pageSize + "," + pageSize);
			
			prepareStatement=super.getConnection().prepareStatement(sql.toString());
			int index=1;
		
			if(!StringUtil.isEmpty(name)){
				prepareStatement.setObject(index++,"%"+name+"%");
			}
			//System.out.println(sql.toString());
			resultSet=prepareStatement.executeQuery();
			
			while(resultSet.next()){
				
				PchStockVo pchStockVo=new PchStockVo();
				//PchStockinDetail pchStockinDetail=new PchStockinDetail();
				pchStockVo.setStockinDetailId((String)resultSet.getObject("stockin_detail_id"));
				//System.out.println(resultSet.getObject("stockinDetailId"));
				pchStockVo.setStockinId((String)resultSet.getObject("stockin_id"));
				pchStockVo.setProductSkuId((String)resultSet.getObject("product_sku_id"));
				pchStockVo.setName((String)resultSet.getObject("name"));
				pchStockVo.setAmount((BigDecimal)resultSet.getObject("amount"));
				pchStockVo.setPrice((BigDecimal)resultSet.getObject("price"));
				pchStockVo.setMoneyReal((BigDecimal)resultSet.getObject("money_real"));
				pchStockVo.setRemark((String)resultSet.getObject("remark"));
				pchStockVo.setSupplierid((String)resultSet.getObject("supplier_id"));
				pchStockVo.setBascode((String)resultSet.getObject("bar_code"));
				list.add(pchStockVo);
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
	 * 总数
	 */
	public int pageRowCount(int pageSize, String name){
		int count = 0;
		PreparedStatement prepareStatement = null;
		ResultSet resultSet = null;
		try { 
			StringBuffer sql =new StringBuffer("select count(stockin_detail_id) from pch_stockin_detail where 1=1");
			if(!StringUtil.isEmpty(name)){
				sql.append(" and name like ?");
			}
			
			prepareStatement=super.getConnection().prepareStatement(sql.toString());
			int index=1;
			if(!StringUtil.isEmpty(name)){
				prepareStatement.setObject(index++, "%"+name+"%");
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
	 * 分页查询
	 */
	
	public Page pageList(int pageIndex, int pageSize, String name){
		Page page = new Page();
		int rowCount = pageRowCount(pageSize, name);
		int pageCount = (rowCount - 1) / pageSize + 1;

		if (pageIndex < 0) {
			pageIndex = 0;
		}

		if (pageIndex > pageCount) {
			pageIndex = pageCount;
		}

		List<PchStockinDetail> result = pageResult(pageIndex, pageSize, name);
      
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
	 * 检查
	 */
	public void validateUnique4Code(PchStockinDetail  pchStockinDetail){
		int count = 0;

		PreparedStatement prepareStatement = null;
		ResultSet resultSet = null;
		try {
			StringBuffer sql=new StringBuffer("select count(stockin_detail_id) from pch_stockin_detail where name like ?");
             //System.out.println(pchStockin.getStockinId()+"20202020202202");
			if(pchStockinDetail.getStockinDetailId()!= null){	
				sql.append(" and stockin_detail_id <> ?");
			}
			

			prepareStatement = getConnection().prepareStatement(sql.toString());
			
			prepareStatement.setObject(1, pchStockinDetail.getName());
			
			if(pchStockinDetail.getStockinDetailId() != null){
				prepareStatement.setObject(2,pchStockinDetail.getStockinDetailId());
			}

			
			resultSet = prepareStatement.executeQuery();

			if (resultSet.next()) {
				count = ((Number) resultSet.getObject(1)).intValue();
			}

			if(count != 0){
				throw new ValidateException("名称:"+pchStockinDetail.getName()) ;
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
	 * 查询
	 */
	public List<PchStockinDetail>list (){
		List<PchStockinDetail> list=new ArrayList<PchStockinDetail>();
		PreparedStatement prepareStatement = null;
		ResultSet resultSet=null;
		try {
			StringBuilder str=new StringBuilder("select * from pch_stockin_detail  where 1=1");
			str.append("");
			
			prepareStatement = getConnection().prepareStatement(str.toString());
			
			resultSet=prepareStatement.executeQuery();
			while(resultSet.next()){
				PchStockinDetail pchStockinDetail=new PchStockinDetail();
				pchStockinDetail.setStockinDetailId((String)resultSet.getObject("stockin_detail_id"));
				//System.out.println(resultSet.getObject("stockinDetailId"));
				pchStockinDetail.setStockinId((String)resultSet.getObject("stockin_id"));
				pchStockinDetail.setProductSkuId((String)resultSet.getObject("product_sku_id"));
				pchStockinDetail.setName((String)resultSet.getObject("name"));
				pchStockinDetail.setAmount((BigDecimal)resultSet.getObject("amount"));
				pchStockinDetail.setPrice((BigDecimal)resultSet.getObject("price"));
				pchStockinDetail.setMoneyReal((BigDecimal)resultSet.getObject("money_real"));
				pchStockinDetail.setRemark((String)resultSet.getObject("remark"));
				list.add(pchStockinDetail);
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
}
