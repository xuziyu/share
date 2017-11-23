package com.barter.share.bas.dao.imp;

import java.lang.reflect.InvocationTargetException;
import java.math.BigDecimal;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.barter.share.bas.dao.IBasProductSkuVoDao2;
import com.barter.share.bas.vo.BasProductSkuVo;
import com.barter.share.bas.vo.ProductSkuVO;
import com.barter.share.framework.dao.BaseDao;
import com.barter.share.framework.dbutil.DbConnection;
import com.barter.share.framework.entity.Page;
import com.barter.share.framework.exception.DbException;
import com.barter.share.framework.util.StringUtil;

public class BasProductSkuVoDao2 extends BaseDao implements IBasProductSkuVoDao2 {

	@Override
	public void insert(BasProductSkuVo basProductSkuVo) throws NoSuchMethodException, SecurityException,
			IllegalAccessException, IllegalArgumentException, InvocationTargetException {
		
	}

	@Override
	public void delete(String productSkuId) {
		
	}

	@Override
	public void update(BasProductSkuVo basProductSkuVo) throws NoSuchMethodException, SecurityException,
			IllegalAccessException, IllegalArgumentException, InvocationTargetException {
		
	}

	@Override
	public List<BasProductSkuVo> color(String productId) {
		List<BasProductSkuVo> productList=new ArrayList<BasProductSkuVo>();
		DbConnection connection=new DbConnection();
		PreparedStatement preparedStatement;
		StringBuffer sql = new StringBuffer("SELECT DISTINCT bas_sku_color.`name` , bas_product_sku.sku_color_id  ");
		sql.append("FROM bas_product_sku ");
		sql.append("INNER JOIN bas_product ");
		sql.append("ON bas_product.product_id = bas_product_sku.product_id ");
		sql.append("INNER JOIN bas_sku_color ");
		sql.append("ON bas_sku_color.sku_color_id = bas_product_sku.sku_color_id ");
		sql.append("INNER JOIN bas_sku_size ");
		sql.append("ON bas_sku_size.sku_size_id = bas_product_sku.sku_size_id ");
		sql.append("WHERE 1 = 1 and bas_product.product_id= ");
		sql.append("'"+productId+"'");
		
		try {
			preparedStatement=connection.getConnection().prepareStatement(sql.toString());
			System.out.println("准备执行where");
			System.out.println(productId);
//			preparedStatement.setString(1, productSkuId);
			System.out.println("准备过where");
			ResultSet resultSet=preparedStatement.executeQuery();
			while(resultSet.next()){
				BasProductSkuVo basProductSkuVo=new BasProductSkuVo();
				basProductSkuVo.setColorName((String)resultSet.getObject("name"));
				basProductSkuVo.setSkuColorId((String)resultSet.getObject("sku_color_id"));
				productList.add(basProductSkuVo);
			}
		
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return productList;
	}
	
	@Override
	public List<BasProductSkuVo> size(String productId) {
		List<BasProductSkuVo> productList=new ArrayList<BasProductSkuVo>();
		DbConnection connection=new DbConnection();
		PreparedStatement preparedStatement;
		StringBuffer sql = new StringBuffer("SELECT DISTINCT bas_sku_size.`name` , bas_sku_size.sku_size_id  ");
		sql.append("FROM bas_product_sku ");
		sql.append("INNER JOIN bas_product ");
		sql.append("ON bas_product.product_id = bas_product_sku.product_id ");
		sql.append("INNER JOIN bas_sku_color ");
		sql.append("ON bas_sku_color.sku_color_id = bas_product_sku.sku_color_id ");
		sql.append("INNER JOIN bas_sku_size ");
		sql.append("ON bas_sku_size.sku_size_id = bas_product_sku.sku_size_id ");
		sql.append("WHERE 1 = 1 and bas_product.product_id= ");
		sql.append("'"+productId+"'");
		
		try {
			preparedStatement=connection.getConnection().prepareStatement(sql.toString());
			System.out.println("准备执行where");
			System.out.println(productId);
//			preparedStatement.setString(1, productSkuId);
			System.out.println("准备过where");
			ResultSet resultSet=preparedStatement.executeQuery();
			while(resultSet.next()){
				BasProductSkuVo basProductSkuVo=new BasProductSkuVo();
				basProductSkuVo.setSkuSizeId((String)resultSet.getObject("sku_size_id"));
				basProductSkuVo.setSizeName((String)resultSet.getObject("name"));
				productList.add(basProductSkuVo);
			}
		
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return productList;
	}

	@Override
	public List<BasProductSkuVo> load(String productId) {
		List<BasProductSkuVo> productList=new ArrayList<BasProductSkuVo>();
		DbConnection connection=new DbConnection();
		PreparedStatement preparedStatement;
		StringBuffer sql = new StringBuffer("SELECT bas_product_sku.* , bas_product.name AS product_name , bas_sku_color.name AS color_name , bas_sku_size.name AS size_name ,bas_file_upload.full_path ");
		sql.append("FROM bas_product_sku ");
		sql.append("INNER JOIN bas_product ");
		sql.append("ON bas_product.product_id = bas_product_sku.product_id ");
		sql.append("INNER JOIN bas_sku_color ");
		sql.append("ON bas_sku_color.sku_color_id = bas_product_sku.sku_color_id ");
		sql.append("INNER JOIN bas_sku_size ");
		sql.append("ON bas_sku_size.sku_size_id = bas_product_sku.sku_size_id ");
		sql.append("JOIN bas_file_upload on bas_file_upload.file_upload_id = bas_product_sku.pic_middle_file_id ");
		sql.append("WHERE 1 = 1 and bas_product.product_id= ");
		sql.append("'"+productId+"'");
		
		try {
			preparedStatement=connection.getConnection().prepareStatement(sql.toString());
			System.out.println("准备执行where");
			System.out.println(productId);
//			preparedStatement.setString(1, productSkuId);
			System.out.println("准备过where");
			ResultSet resultSet=preparedStatement.executeQuery();
			while(resultSet.next()){
				BasProductSkuVo basProductSkuVo=new BasProductSkuVo();
				basProductSkuVo.setProductSkuId((String)resultSet.getObject("product_sku_id"));
				basProductSkuVo.setAmountInit((BigDecimal)resultSet.getObject("amount_init"));
				basProductSkuVo.setAmountMaxStock((BigDecimal)resultSet.getObject("amount_max_stock"));
				basProductSkuVo.setAmountMinStock((BigDecimal)resultSet.getObject("amount_min_stock"));
				basProductSkuVo.setAmountStock((BigDecimal)resultSet.getObject("amount_stock"));
				basProductSkuVo.setBarCode((String)resultSet.getObject("bar_code"));
				basProductSkuVo.setColorName((String)resultSet.getObject("color_name"));System.out.println(resultSet.getObject("color_name"));
				basProductSkuVo.setPicBigFileId((String)resultSet.getObject("pic_big_file_id"));
				basProductSkuVo.setPicMiddleFileId((String)resultSet.getObject("pic_middle_file_id"));
				basProductSkuVo.setPicOriFileId((String)resultSet.getObject("pic_ori_file_id"));
				basProductSkuVo.setPicSmallFileId((String)resultSet.getObject("pic_small_file_id"));
				basProductSkuVo.setPriceCost((BigDecimal)resultSet.getObject("price_cost"));
				basProductSkuVo.setPriceOld((BigDecimal)resultSet.getObject("price_cost"));
				basProductSkuVo.setPriceCost((BigDecimal)resultSet.getObject("price_old"));
				basProductSkuVo.setPricePlanPurchase((BigDecimal)resultSet.getObject("price_plan_purchase"));
				basProductSkuVo.setPriceReal((BigDecimal)resultSet.getObject("price_real"));
				basProductSkuVo.setProductDefaultType((BigDecimal)resultSet.getObject("product_default_type"));
				basProductSkuVo.setProductId((String)resultSet.getObject("product_id"));
				basProductSkuVo.setProductName((String)resultSet.getObject("product_name"));
				basProductSkuVo.setSkuColorId((String)resultSet.getObject("sku_color_id"));
				basProductSkuVo.setSkuSizeId((String)resultSet.getObject("sku_size_id"));
				basProductSkuVo.setSizeName((String)resultSet.getObject("size_name"));
				basProductSkuVo.setPicpath((String)resultSet.getObject("full_path"));
				productList.add(basProductSkuVo);
			}
		
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return productList;
	}

	@Override
	public List<BasProductSkuVo> pageResult(int pageIndex, int pageSize, BasProductSkuVo basProductSkuVo)
			throws NoSuchMethodException, SecurityException, IllegalAccessException, IllegalArgumentException,
			InvocationTargetException {
		StringBuffer sql = new StringBuffer("SELECT bas_product_sku.* , bas_product.name AS product_name , bas_sku_color.name AS color_name , bas_sku_size.name AS size_name ");
		sql.append("FROM bas_product_sku ");
		sql.append("INNER JOIN bas_product ");
		sql.append("ON bas_product.product_id = bas_product_sku.product_id ");
		sql.append("INNER JOIN bas_sku_color ");
		sql.append("ON bas_sku_color.sku_color_id = bas_product_sku.sku_color_id ");
		sql.append("INNER JOIN bas_sku_size ");
		sql.append("ON bas_sku_size.sku_size_id = bas_product_sku.sku_size_id ");
		sql.append("WHERE 1 = 1");
		Object [] paramsValue = StringUtil.reflectValue(basProductSkuVo);
		Object [] paramsValueTrim =new Object[paramsValue.length];
		String [] sqlAppend ={" AND bas_product_sku.product_sku_id LIKE ?"," AND bas_product_sku.product_id LIKE ?"," AND bas_product_sku.sku_color_id LIKE ?",
				" AND bas_product_sku.sku_size_id LIKE ?"," AND bas_product_sku.bar_code LIKE ?"," AND bas_product_sku.price_real LIKE ?",
				" AND bas_product_sku.price_old LIKE ?"," AND bas_product_sku.price_cost LIKE ?"," AND bas_product_sku.price_plan_purchase LIKE ?",
				" AND bas_product_sku.amount_stock LIKE ?"," AND bas_product_sku.amount_init LIKE ?"," AND bas_product_sku.amount_min_stock LIKE ?",
				" AND bas_product_sku.amount_max_stock LIKE ?"," AND bas_product_sku.pic_ori_file_id LIKE ?"," AND bas_product_sku.pic_big_file_id LIKE ?",
				" AND bas_product_sku.pic_middle_file_id LIKE ?"," AND bas_product_sku.pic_small_file_id LIKE ?"," AND bas_product_sku.product_default_type LIKE ?",
				" AND bas_product.name LIKE ?"," AND bas_sku_color.name LIKE ?"," AND bas_sku_size.name LIKE ?"};
		if (basProductSkuVo!=null) {
			int valueIndex =0;
			for (int i = 0; i < paramsValue.length; i++) {
				if (!StringUtil.isEmpty(paramsValue[i])) {
					sql.append(sqlAppend[i]);
					paramsValueTrim[valueIndex] = "%"+paramsValue[i]+"%";
					valueIndex++;
				}
			}
		}
		sql.append(" order by bas_product_sku.product_sku_id desc");
		sql.append(" limit " + pageIndex * pageSize + "," + pageSize);
		return super.query(sql, paramsValueTrim, BasProductSkuVo.class);
	}

	@Override
	public int pageRowCount(BasProductSkuVo basProductSkuVo) throws NoSuchMethodException, SecurityException,
			IllegalAccessException, IllegalArgumentException, InvocationTargetException {
		StringBuffer sql = new StringBuffer("SELECT COUNT(bas_product_sku.product_sku_id) ");
		sql.append("FROM bas_product_sku ");
		sql.append("INNER JOIN bas_product ");
		sql.append("ON bas_product.product_id = bas_product_sku.product_id ");
		sql.append("INNER JOIN bas_sku_color ");
		sql.append("ON bas_sku_color.sku_color_id = bas_product_sku.sku_color_id ");
		sql.append("INNER JOIN bas_sku_size ");
		sql.append("ON bas_sku_size.sku_size_id = bas_product_sku.sku_size_id ");
		sql.append("WHERE 1 = 1");
		Object [] paramsValue = StringUtil.reflectValue(basProductSkuVo);
		Object [] paramsValueTrim =new Object[paramsValue.length];
		String [] sqlAppend ={" AND bas_product_sku.product_sku_id LIKE ?"," AND bas_product_sku.product_id LIKE ?"," AND bas_product_sku.sku_color_id LIKE ?",
				" AND bas_product_sku.sku_size_id LIKE ?"," AND bas_product_sku.bar_code LIKE ?"," AND bas_product_sku.price_real LIKE ?",
				" AND bas_product_sku.price_old LIKE ?"," AND bas_product_sku.price_cost LIKE ?"," AND bas_product_sku.price_plan_purchase LIKE ?",
				" AND bas_product_sku.amount_stock LIKE ?"," AND bas_product_sku.amount_init LIKE ?"," AND bas_product_sku.amount_min_stock LIKE ?",
				" AND bas_product_sku.amount_max_stock LIKE ?"," AND bas_product_sku.pic_ori_file_id LIKE ?"," AND bas_product_sku.pic_big_file_id LIKE ?",
				" AND bas_product_sku.pic_middle_file_id LIKE ?"," AND bas_product_sku.pic_small_file_id LIKE ?"," AND bas_product_sku.product_default_type LIKE ?",
				" AND bas_product.name LIKE ?"," AND bas_sku_color.name LIKE ?"," AND bas_sku_size.name LIKE ?"};
		if (basProductSkuVo!=null) {
			int valueIndex =0;
			for (int i = 0; i < paramsValue.length; i++) {
				if (!StringUtil.isEmpty(paramsValue[i])) {
					sql.append(sqlAppend[i]);
					paramsValueTrim[valueIndex] = "%"+paramsValue[i]+"%";
					valueIndex++;
				}
			}
		}
		return super.resultRowCount(sql, paramsValueTrim);
	}

	@Override
	public Page pageList(int pageIndex, int pageSize, BasProductSkuVo basProductSkuVo) throws NoSuchMethodException,
			SecurityException, IllegalAccessException, IllegalArgumentException, InvocationTargetException {
		Page page = new Page();
		int rowCount =0;
		//获得 查询结果的行数
		rowCount = pageRowCount(basProductSkuVo);
		int pageCount = (rowCount - 1) / pageSize + 1;

		if (pageIndex < 0) {
			pageIndex = 0;
		}

		if (pageIndex > pageCount) {
			pageIndex = pageCount;
		}
		//把查询到的 实体对象数组   存到  result 并作为属性 给  page对象
		List result = pageResult(pageIndex, pageSize,basProductSkuVo);
		page.setPageSize(pageSize);
		page.setPageIndex(pageIndex);
		page.setPageCount(pageCount);
		page.setRowCount(rowCount);
		page.setResult(result);
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
	public void validateUnique4Code(BasProductSkuVo basProductSkuVo) throws NoSuchMethodException, SecurityException,
			IllegalAccessException, IllegalArgumentException, InvocationTargetException {
		
	}

	@Override
	public ProductSkuVO salorder(String productSkuId) {
		PreparedStatement prepareStatement = null;
		ResultSet resultSet = null;
		ProductSkuVO productSkuVO = new ProductSkuVO();
		try{
			StringBuffer sql = new StringBuffer("select bas_product_sku.price_real , bas_product.name ,bas_product_sku.product_sku_id,"
					+ "bas_product_sku.product_id , bas_product_sku.sku_color_id , bas_product_sku.sku_size_id ");
			sql.append(" from bas_product_sku");
			sql.append(" INNER JOIN bas_product");
			sql.append(" on bas_product_sku.product_id = bas_product.product_id");
			sql.append(" where bas_product_sku.product_sku_id = ");
			sql.append("'"+productSkuId+"'");
			prepareStatement = DbConnection.getConnection().prepareStatement(sql.toString());
			resultSet= prepareStatement.executeQuery();
			while(resultSet.next()){
				productSkuVO.setName((String)resultSet.getObject("name"));
				productSkuVO.setPriceReal((BigDecimal)resultSet.getObject("price_real"));
				productSkuVO.setProductId((String)resultSet.getObject("product_id"));
				productSkuVO.setProductSkuId((String)resultSet.getObject("product_sku_id"));
				productSkuVO.setSkuColorId((String)resultSet.getObject("sku_color_id"));
				productSkuVO.setSkuSizeId((String)resultSet.getObject("sku_size_id"));
			}
			return productSkuVO;
		}catch (Exception ex) {
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

}
