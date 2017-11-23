package com.barter.share.bas.service.imp;

import java.lang.reflect.InvocationTargetException;
import java.math.BigDecimal;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import com.barter.share.bas.dao.IBasProductVoDao;
import com.barter.share.bas.dao.imp.BasProductVoDao;
import com.barter.share.bas.service.IBasProductVoService2;
import com.barter.share.bas.vo.BasProductSkuVo;
import com.barter.share.bas.vo.BasProductVo;
import com.barter.share.framework.dbutil.DbConnection;
import com.barter.share.framework.entity.Page;
import com.barter.share.framework.util.StringUtil;

public class BasProductVoService2 implements IBasProductVoService2 {
	IBasProductVoDao iBasProductVoDao = new BasProductVoDao();
	@Override
	public void insert(BasProductVo basProductVo) throws NoSuchMethodException, SecurityException,
			IllegalAccessException, IllegalArgumentException, InvocationTargetException {
		
	}

	@Override
	public void delete(String productId) {
		
	}

	@Override
	public void update(BasProductVo basProductVo) throws NoSuchMethodException, SecurityException,
			IllegalAccessException, IllegalArgumentException, InvocationTargetException {
		
	}

	@Override
	public List<BasProductVo> list() {
		return null;
	}

	@Override
	public BasProductVo load(String productId) {
		StringBuffer sql = new StringBuffer("SELECT bas_product.* , bas_brand.name AS brand_name , bas_category_big.name AS big_name , bas_category_small.name AS small_name ");
		DbConnection connection=new DbConnection();
		PreparedStatement preparedStatement;
		sql.append("FROM bas_product ");
		sql.append("INNER JOIN bas_brand ");
		sql.append("ON bas_product.brand_id = bas_brand.brand_id ");
		sql.append("INNER JOIN bas_category_big ");
		sql.append("ON bas_category_big.category_big_id = bas_product.category_big_id ");
		sql.append("INNER JOIN bas_category_small ");
		sql.append("ON bas_category_small.category_small_id = bas_product.category_small_id ");
		sql.append("WHERE 1 = 1 and bas_product.product_id= ");
		sql.append("'"+productId+"'");
		BasProductVo basProductSkuVo=new BasProductVo();
		try {
			preparedStatement=connection.getConnection().prepareStatement(sql.toString());
			System.out.println("准备执行where");
			System.out.println(productId);
//			preparedStatement.setString(1, productSkuId);
			System.out.println("准备过where");
			ResultSet resultSet=preparedStatement.executeQuery();
			while(resultSet.next()){
				
				basProductSkuVo.setBigName((String)resultSet.getObject("big_name"));
				basProductSkuVo.setBrandId((String)resultSet.getObject("brand_id"));
				basProductSkuVo.setBrandName((String)resultSet.getObject("brand_name"));
				basProductSkuVo.setCategoryBigId((String)resultSet.getObject("category_big_id"));
				basProductSkuVo.setCategorySmallId((String)resultSet.getObject("category_small_id"));
				basProductSkuVo.setCode((String)resultSet.getObject("code"));System.out.println(resultSet.getObject("code"));
				basProductSkuVo.setFabric((String)resultSet.getObject("fabric"));
				basProductSkuVo.setFashionElement((String)resultSet.getObject("fashion_element"));
				basProductSkuVo.setGrossWeight((BigDecimal)resultSet.getObject("gross_weight"));
				basProductSkuVo.setMarketSeason((BigDecimal)resultSet.getObject("market_season"));
				basProductSkuVo.setMarketYear((BigDecimal)resultSet.getObject("market_year"));
				basProductSkuVo.setName((String)resultSet.getObject("name"));
				basProductSkuVo.setProductId((String)resultSet.getObject("product_id"));
				basProductSkuVo.setProductPlace((String)resultSet.getObject("product_place"));
				basProductSkuVo.setSmallName((String)resultSet.getObject("small_name"));
				basProductSkuVo.setStereotype((String)resultSet.getObject("stereotype"));
			}
		
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return basProductSkuVo;
	}

	@Override
	public Page pageList(int pageIndex, int pageSize, BasProductVo basProductVo) throws NoSuchMethodException,
			SecurityException, IllegalAccessException, IllegalArgumentException, InvocationTargetException {
		return iBasProductVoDao.pageList(pageIndex, pageSize, basProductVo);
	}

	@Override
	public void codeCheck(BasProductVo basProductVo) throws NoSuchMethodException, SecurityException,
			IllegalAccessException, IllegalArgumentException, InvocationTargetException {
		
	}

}
