package com.barter.share.bas.dao.imp;

import java.util.List;

import com.barter.share.bas.dao.ICrtCartFrontDao;
import com.barter.share.bas.vo.CartVo;
import com.barter.share.framework.dao.BaseDao;

public class CrtCartFrontDao extends BaseDao implements ICrtCartFrontDao {

	@Override
	public List<CartVo> pageList(String customerId) {
		StringBuffer sql = new StringBuffer("SELECT crt_cart.* ,bas_product.product_id , bas_product.name AS product_name , bas_sku_color.name AS color_name , bas_sku_size.name AS size_name , bas_product_sku.price_real , bas_file_upload.full_path ");
		sql.append("FROM crt_cart ");
		sql.append("INNER JOIN bas_product_sku ");
		sql.append("ON bas_product_sku.product_sku_id = crt_cart.product_sku_id ");
		sql.append("INNER JOIN bas_sku_color ");
		sql.append("ON bas_product_sku.sku_color_id = bas_sku_color.sku_color_id ");
		sql.append("INNER JOIN bas_sku_size ");
		sql.append("ON bas_sku_size.sku_size_id = bas_product_sku.sku_size_id ");
		sql.append("INNER JOIN bas_product ");
		sql.append("ON bas_product.product_id = bas_product_sku.product_id ");
		sql.append("INNER JOIN bas_file_upload ");
		sql.append("ON bas_product_sku.pic_middle_file_id = bas_file_upload.file_upload_id ");
		sql.append("WHERE 1 = 1 ");
		sql.append(" AND crt_cart.customer_id = ?");
		String [] paramsValue={customerId};
		return query(sql, paramsValue, CartVo.class);
	}

	@Override
	public void delete(String cartId) {
		StringBuffer sql = new StringBuffer("DELETE FROM crt_cart WHERE cart_id = ?");
		String [] paramsValue={cartId};
		super.update(sql, paramsValue);
	}

	@Override
	public void insert(String cartId,String customerId, String skuId ,String date) {
		StringBuffer sql = new StringBuffer("INSERT INTO crt_cart (cart_id,customer_id,product_sku_id,create_date) VALUES (?,?,?,?)");
		String [] paramsValue={cartId,customerId,skuId,date};
		super.update(sql, paramsValue);
	}
	
}
