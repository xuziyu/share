package com.barter.share.bas.dao.imp;

import java.lang.reflect.InvocationTargetException;
import java.util.List;

import com.barter.share.bas.dao.ICrtCartDao;
import com.barter.share.bas.entity.CrtCart;
import com.barter.share.framework.dao.BaseDao;
import com.barter.share.framework.entity.Page;
import com.barter.share.framework.util.StringUtil;

public class CrtCartDao extends BaseDao implements ICrtCartDao {

	@Override
	public void insert(CrtCart crtCart) throws NoSuchMethodException, SecurityException, IllegalAccessException,
			IllegalArgumentException, InvocationTargetException {
		StringBuffer sql = new StringBuffer("INSERT INTO crt_cart (cart_id, customer_id, product_sku_id, create_date) VALUES (?, ?, ?, ?)");
		Object [] paramsValue =StringUtil.reflectValue(crtCart);
		super.update(sql, paramsValue);
	}

	@Override
	public void delete(String cartId) {
		StringBuffer sql = new StringBuffer("DELETE FROM crt_cart WHERE cart_id = ?");
		Object [] paramsValue ={cartId};
		super.update(sql, paramsValue);
	}

	@Override
	public void update(CrtCart crtCart) throws NoSuchMethodException, SecurityException, IllegalAccessException,
			IllegalArgumentException, InvocationTargetException {
		StringBuffer sql = new StringBuffer("UPDATE crt_cart SET customer_id = ? , product_sku_id = ? , create_date = ? WHERE cart_id = ?");
		Object [] paramsValue =StringUtil.leftOne(StringUtil.reflectValue(crtCart));
		super.update(sql, paramsValue);
	}

	@Override
	public List<CrtCart> list() {
		StringBuffer sql = new StringBuffer("SELECT * FROM crt_cart");
		Object [] paramsValue =null;
		return super.query(sql, paramsValue, CrtCart.class);
	}

	@Override
	public List<CrtCart> load(String cartId) {
		StringBuffer sql = new StringBuffer("SELECT * FROM crt_cart WHERE 1 = 1 AND cart_id = ?");
		Object [] paramsValue ={cartId};
		return super.query(sql, paramsValue, CrtCart.class);
	}

	@Override
	public List<CrtCart> pageResult(int pageIndex, int pageSize, CrtCart crtCart) throws NoSuchMethodException,
			SecurityException, IllegalAccessException, IllegalArgumentException, InvocationTargetException {
		StringBuffer sql = new StringBuffer("SELECT * FROM crt_cart WHERE 1 = 1");
		Object [] paramsValue = StringUtil.reflectValue(crtCart);
		Object [] paramsValueTrim =new Object[paramsValue.length];
		String [] sqlAppend ={" AND cart_id LIKE ?"," AND customer_id like ?"," and product_sku_id like ?"," and create_date like ?"};
		if (crtCart!=null) {
			int valueIndex =0;
			for (int i = 0; i < paramsValue.length; i++) {
				if (!StringUtil.isEmpty(paramsValue[i])) {
					sql.append(sqlAppend[i]);
					paramsValueTrim[valueIndex] = "%"+paramsValue[i]+"%";
					valueIndex++;
				}
			}
		}
		sql.append(" order by cart_id desc");
		sql.append(" limit " + pageIndex * pageSize + "," + pageSize);
		return super.query(sql, paramsValueTrim, CrtCart.class);
	}

	@Override
	public int pageRowCount(CrtCart crtCart) throws NoSuchMethodException, SecurityException, IllegalAccessException,
			IllegalArgumentException, InvocationTargetException {
		StringBuffer sql = new StringBuffer("SELECT COUNT(cart_id) FROM crt_cart WHERE 1 = 1");
		Object [] paramsValue = StringUtil.reflectValue(crtCart);
		Object [] paramsValueTrim =new Object[paramsValue.length];
		String [] sqlAppend ={" AND cart_id LIKE ?"," AND customer_id like ?"," and product_sku_id like ?"," and create_date like ?"};
		if (crtCart!=null) {
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
	public Page pageList(int pageIndex, int pageSize, CrtCart crtCart) throws NoSuchMethodException, SecurityException,
			IllegalAccessException, IllegalArgumentException, InvocationTargetException {
		Page page = new Page();
		int rowCount =0;
		//获得 查询结果的行数
		rowCount = pageRowCount(crtCart);
		int pageCount = (rowCount - 1) / pageSize + 1;

		if (pageIndex < 0) {
			pageIndex = 0;
		}

		if (pageIndex > pageCount) {
			pageIndex = pageCount;
		}
		//把查询到的 实体对象数组   存到  result 并作为属性 给  page对象
		List result = pageResult(pageIndex, pageSize,crtCart);
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
	public void validateUnique4Code(CrtCart crtCart) throws NoSuchMethodException, SecurityException,
			IllegalAccessException, IllegalArgumentException, InvocationTargetException {
		
	}

}
