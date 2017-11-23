package com.barter.share.bas.dao.imp;

import java.lang.reflect.InvocationTargetException;
import java.util.List;

import com.barter.share.bas.dao.ICrtCartVoDao;
import com.barter.share.bas.vo.CrtCartVo;
import com.barter.share.framework.dao.BaseDao;
import com.barter.share.framework.entity.Page;
import com.barter.share.framework.util.StringUtil;

public class CrtCartVoDao extends BaseDao implements ICrtCartVoDao {

	@Override
	public void insert(CrtCartVo crtCartVo) throws NoSuchMethodException, SecurityException, IllegalAccessException,
			IllegalArgumentException, InvocationTargetException {
		
	}

	@Override
	public void delete(String cartId) {
		
	}

	@Override
	public void update(CrtCartVo crtCartVo) throws NoSuchMethodException, SecurityException, IllegalAccessException,
			IllegalArgumentException, InvocationTargetException {
		
	}

	@Override
	public List<CrtCartVo> list() {
		return null;
	}

	@Override
	public List<CrtCartVo> load(String cartId) {
		return null;
	}

	@Override
	public List<CrtCartVo> pageResult(int pageIndex, int pageSize, CrtCartVo crtCartVo) throws NoSuchMethodException,
			SecurityException, IllegalAccessException, IllegalArgumentException, InvocationTargetException {
		StringBuffer sql = new StringBuffer("SELECT crt_cart.* , bas_customer.name AS customer_name , bas_product_sku.bar_code AS bar_code ");
		sql.append("FROM crt_cart ");
		sql.append("INNER JOIN bas_customer ");
		sql.append("ON bas_customer.customer_id = crt_cart.customer_id ");
		sql.append("INNER JOIN bas_product_sku ");
		sql.append("ON bas_product_sku.product_sku_id = crt_cart.product_sku_id ");
		sql.append("WHERE 1 = 1 ");
		Object [] paramsValue = StringUtil.reflectValue(crtCartVo);
		Object [] paramsValueTrim =new Object[paramsValue.length];
		String [] sqlAppend ={" AND crt_cart.cart_id LIKE ?"," AND crt_cart.customer_id like ?",
				" and crt_cart.product_sku_id like ?"," and crt_cart.create_date like ?",
				" AND bas_customer.name LIKE ?"," AND bas_product_sku.bar_code LIKE ?"};
		if (crtCartVo!=null) {
			int valueIndex =0;
			for (int i = 0; i < paramsValue.length; i++) {
				if (!StringUtil.isEmpty(paramsValue[i])) {
					sql.append(sqlAppend[i]);
					paramsValueTrim[valueIndex] = "%"+paramsValue[i]+"%";
					valueIndex++;
				}
			}
		}
		sql.append(" order by crt_cart.cart_id desc");
		sql.append(" limit " + pageIndex * pageSize + "," + pageSize);
		return super.query(sql, paramsValueTrim, CrtCartVo.class);
	}

	@Override
	public int pageRowCount(CrtCartVo crtCartVo) throws NoSuchMethodException, SecurityException,
			IllegalAccessException, IllegalArgumentException, InvocationTargetException {
		StringBuffer sql = new StringBuffer("SELECT COUNT(crt_cart.cart_id) FROM crt_cart WHERE 1 = 1 ");
		Object [] paramsValue = StringUtil.reflectValue(crtCartVo);
		Object [] paramsValueTrim =new Object[paramsValue.length];
		String [] sqlAppend ={" AND crt_cart.cart_id LIKE ?"," AND crt_cart.customer_id like ?",
				" and crt_cart.product_sku_id like ?"," and crt_cart.create_date like ?",
				" AND bas_customer.name LIKE ?"," AND bas_product_sku.bar_code LIKE ?"};
		if (crtCartVo!=null) {
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
	public Page pageList(int pageIndex, int pageSize, CrtCartVo crtCartVo) throws NoSuchMethodException,
			SecurityException, IllegalAccessException, IllegalArgumentException, InvocationTargetException {
		Page page = new Page();
		int rowCount =0;
		//获得 查询结果的行数
		rowCount = pageRowCount(crtCartVo);
		int pageCount = (rowCount - 1) / pageSize + 1;

		if (pageIndex < 0) {
			pageIndex = 0;
		}

		if (pageIndex > pageCount) {
			pageIndex = pageCount;
		}
		//把查询到的 实体对象数组   存到  result 并作为属性 给  page对象
		List result = pageResult(pageIndex, pageSize,crtCartVo);
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
	public void validateUnique4Code(CrtCartVo crtCartVo) throws NoSuchMethodException, SecurityException,
			IllegalAccessException, IllegalArgumentException, InvocationTargetException {
		
	}

}
