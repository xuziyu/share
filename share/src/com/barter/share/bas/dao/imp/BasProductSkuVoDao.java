package com.barter.share.bas.dao.imp;

import java.lang.reflect.InvocationTargetException;
import java.util.List;

import com.barter.share.bas.dao.IBasProductSkuVoDao;
import com.barter.share.bas.vo.BasProductSkuVo;
import com.barter.share.framework.dao.BaseDao;
import com.barter.share.framework.entity.Page;
import com.barter.share.framework.util.StringUtil;

public class BasProductSkuVoDao extends BaseDao implements IBasProductSkuVoDao {

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
	public List<BasProductSkuVo> list() {
		return null;
	}

	@Override
	public List<BasProductSkuVo> load(String productSkuId) {
		return null;
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
		sql.append(" order by bas_product_sku.bar_code asc");
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

}
