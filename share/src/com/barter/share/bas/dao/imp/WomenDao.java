package com.barter.share.bas.dao.imp;

import java.util.List;

import com.barter.share.bas.dao.IWomenDao;
import com.barter.share.bas.entity.BasBrand;
import com.barter.share.bas.entity.BasCategoryBig;
import com.barter.share.bas.entity.BasCategorySmall;
import com.barter.share.bas.vo.WomenVo;
import com.barter.share.framework.dao.BaseDao;

public class WomenDao extends BaseDao implements IWomenDao {

	@Override
	public List<BasBrand> adBrand() {
		StringBuffer sql = new StringBuffer("SELECT * FROM bas_brand WHERE 1=1 ");
		sql.append("order by code desc ");
		sql.append("limit 1,16 ");
		return super.query(sql, null, BasBrand.class);
	}

	@Override
	public List<WomenVo> adProduct() {
		StringBuffer sql = new StringBuffer("SELECT bas_product_sku.* ,bas_file_upload.full_path AS full_path ");
		sql.append("FROM bas_product_sku ");
		sql.append("INNER JOIN bas_file_upload ");
		sql.append("ON bas_file_upload.file_upload_id = bas_product_sku.pic_middle_file_id ");
		sql.append("limit 0,6 ");
		return super.query(sql, null, WomenVo.class);
	}

	@Override
	public List<BasCategoryBig> navBig() {
		StringBuffer sql = new StringBuffer("SELECT * FROM bas_category_big WHERE 1=1");
		sql.append(" limit 0,5 ");
		return super.query(sql, null, BasCategoryBig.class);
	}

	@Override
	public List<BasCategorySmall> navSmall() {
		StringBuffer sql = new StringBuffer("SELECT * FROM bas_category_small WHERE 1=1 ");
		return super.query(sql, null, BasCategorySmall.class);
	}

}
