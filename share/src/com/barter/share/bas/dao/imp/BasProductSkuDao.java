package com.barter.share.bas.dao.imp;

import java.lang.reflect.InvocationTargetException;
import java.util.List;

import com.barter.share.bas.dao.IBasProductSkuDao;
import com.barter.share.bas.entity.BasProductSku;
import com.barter.share.framework.dao.BaseDao;
import com.barter.share.framework.entity.Page;
import com.barter.share.framework.exception.ValidateException;
import com.barter.share.framework.util.StringUtil;

public class BasProductSkuDao extends BaseDao implements IBasProductSkuDao {

	@Override
	public void insert(BasProductSku basProductSku) throws NoSuchMethodException, SecurityException, IllegalAccessException, IllegalArgumentException, InvocationTargetException {
		StringBuffer sql = new StringBuffer("INSERT INTO bas_product_sku ");
		sql.append("(product_sku_id, product_id, sku_color_id, sku_size_id, bar_code, price_real,");
		sql.append(" price_old, price_cost, price_plan_purchase, amount_stock, amount_init, amount_min_stock,");
		sql.append(" amount_max_stock, pic_ori_file_id, pic_big_file_id,");
		sql.append("pic_middle_file_id, pic_small_file_id, product_default_type) VALUES ");
		sql.append("(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
		Object [] paramsValue =StringUtil.reflectValue(basProductSku);
		super.update(sql, paramsValue);

	}

	@Override
	public void delete(String productSkuId) {
		StringBuffer sql = new StringBuffer("DELETE FROM bas_product_sku WHERE product_sku_id = ?");
		Object [] paramsValue ={productSkuId};
		super.update(sql, paramsValue);
	}

	@Override
	public void update(BasProductSku basProductSku) throws NoSuchMethodException, SecurityException, IllegalAccessException, IllegalArgumentException, InvocationTargetException {
		StringBuffer sql = new StringBuffer("UPDATE bas_product_sku SET product_id = ?,");
		sql.append("sku_color_id = ?, sku_size_id = ?, bar_code = ?, price_real = ?,");
		sql.append("price_old = ?, price_cost = ?, price_plan_purchase = ?, amount_stock = ?,");
		sql.append("amount_init = ?, amount_min_stock = ?, amount_max_stock = ?,");
		sql.append("pic_ori_file_id = ?, pic_big_file_id = ?, pic_middle_file_id = ?,");
		sql.append("pic_small_file_id = ?, product_default_type = ? WHERE product_sku_id = ?");
		Object [] paramsValue =StringUtil.leftOne(StringUtil.reflectValue(basProductSku));
		System.out.println(paramsValue.length);
		super.update(sql, paramsValue);
	}

	@Override
	public List<BasProductSku> list() {
		StringBuffer sql = new StringBuffer("SELECT * FROM bas_product_sku");
		Object [] paramsValue =null;
		return super.query(sql, paramsValue, BasProductSku.class);
	}

	@Override
	public List<BasProductSku> load(String productSkuId) {
		StringBuffer sql = new StringBuffer("SELECT * FROM bas_product_sku WHERE product_sku_id = ?");
		Object [] paramsValue ={productSkuId};
		return super.query(sql, paramsValue, BasProductSku.class);
	}

	@Override
	public List<BasProductSku> pageResult(int pageIndex, int pageSize, BasProductSku basProductSku) throws NoSuchMethodException, SecurityException, IllegalAccessException, IllegalArgumentException, InvocationTargetException {
		StringBuffer sql = new StringBuffer("SELECT * FROM bas_product_sku WHERE 1 = 1");
		Object [] paramsValue = StringUtil.reflectValue(basProductSku);
		Object [] paramsValueTrim =new Object[paramsValue.length];
		String [] sqlAppend ={" AND product_sku_id LIKE ?"," AND product_id LIKE ?"," AND sku_color_id LIKE ?",
				" AND sku_size_id LIKE ?"," AND bar_code LIKE ?"," AND price_real LIKE ?"," AND price_old LIKE ?",
				" AND price_cost LIKE ?"," AND price_plan_purchase LIKE ?"," AND amount_stock LIKE ?"," AND amount_init LIKE ?",
				" AND amount_min_stock LIKE ?"," AND amount_max_stock LIKE ?"," AND pic_ori_file_id LIKE ?"," AND pic_big_file_id LIKE ?",
				" AND pic_middle_file_id LIKE ?"," AND pic_small_file_id LIKE ?"," AND product_default_type LIKE ?"};
		if (basProductSku!=null) {
			int valueIndex =0;
			for (int i = 0; i < paramsValue.length; i++) {
				if (!StringUtil.isEmpty(paramsValue[i])) {
					sql.append(sqlAppend[i]);
					paramsValueTrim[valueIndex] = "%"+paramsValue[i]+"%";
					valueIndex++;
				}
			}
		}
		sql.append(" order by product_sku_id desc");
		sql.append(" limit " + pageIndex * pageSize + "," + pageSize);
		return super.query(sql, paramsValueTrim, BasProductSku.class);
	}

	@Override
	public int pageRowCount(BasProductSku basProductSku) throws NoSuchMethodException, SecurityException, IllegalAccessException, IllegalArgumentException, InvocationTargetException {
		StringBuffer sql = new StringBuffer("SELECT COUNT(product_sku_id) FROM bas_product_sku WHERE 1 = 1");
		Object [] paramsValue = StringUtil.reflectValue(basProductSku);
		Object [] paramsValueTrim =new Object[paramsValue.length];
		String [] sqlAppend ={" AND product_sku_id LIKE ?"," AND product_id LIKE ?"," AND sku_color_id LIKE ?",
				" AND sku_size_id LIKE ?"," AND bar_code LIKE ?"," AND price_real LIKE ?"," AND price_old LIKE ?",
				" AND price_cost LIKE ?"," AND price_plan_purchase LIKE ?"," AND amount_stock LIKE ?"," AND amount_init LIKE ?",
				" AND amount_min_stock LIKE ?"," AND amount_max_stock LIKE ?"," AND pic_ori_file_id LIKE ?"," AND pic_big_file_id LIKE ?",
				" AND pic_middle_file_id LIKE ?"," AND pic_small_file_id LIKE ?"," AND product_default_type LIKE ?"};
		if (basProductSku!=null) {
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
	public Page pageList(int pageIndex, int pageSize, BasProductSku basProductSku) throws NoSuchMethodException, SecurityException, IllegalAccessException, IllegalArgumentException, InvocationTargetException {
		Page page = new Page();
		int rowCount =0;
		//获得 查询结果的行数
		rowCount = pageRowCount(basProductSku);
		int pageCount = (rowCount - 1) / pageSize + 1;

		if (pageIndex < 0) {
			pageIndex = 0;
		}

		if (pageIndex > pageCount) {
			pageIndex = pageCount;
		}
		//把查询到的 实体对象数组   存到  result 并作为属性 给  page对象
		List result = pageResult(pageIndex, pageSize,basProductSku);
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
	public void validateUnique4Code(BasProductSku basProductSku) throws NoSuchMethodException, SecurityException, IllegalAccessException, IllegalArgumentException, InvocationTargetException {
		StringBuffer sql = new StringBuffer("SELECT COUNT(product_sku_id) FROM bas_product_sku WHERE bar_code = ?");
		Object [] paramsValueTrim ={basProductSku.getBarCode()};

		int count =super.resultRowCount(sql, paramsValueTrim);
		if (count==1) {
			throw new ValidateException("条码重复:" + basProductSku.getBarCode());
		}
	}

}
