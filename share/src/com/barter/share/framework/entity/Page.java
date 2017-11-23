package com.barter.share.framework.entity;

import java.util.ArrayList;
import java.util.List;

/**
 * 
 * 功能描述:分页对象
 * 
 * @author Administrator
 * @version 1.0 创建日期:2017年5月12日
 */
public class Page {
	private int pageSize;// 每页记录数
	private int pageIndex;// 当前页,下标从0开始
	private int rowCount;// 总记录数
	private int pageCount;// 总页数

	private List result = new ArrayList();// 查询结果
	
	private boolean hasPrior ;
	private boolean hasNext ;

	/**
	 * 获取每页记录数
	 * 
	 * @return
	 */
	public int getPageSize() {
		return pageSize;
	}

	/**
	 * 设置每页记录数
	 * 
	 * @payram pageSize
	 */
	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}

	/**
	 * 获取当前页
	 * 
	 * @return
	 */
	public int getPageIndex() {
		return pageIndex;
	}

	/**
	 * 设置当前页
	 * 
	 * @param pageIndex
	 */
	public void setPageIndex(int pageIndex) {
		this.pageIndex = pageIndex;
	}

	/**
	 * 获取总页数
	 * 
	 * @return
	 */
	public int getPageCount() {
		return pageCount;
	}

	/**
	 * 设置总页数
	 * 
	 * @param pageCount
	 */
	public void setPageCount(int pageCount) {
		this.pageCount = pageCount;
	}

	/**
	 * 获取总记录数
	 * 
	 * @return
	 */
	public int getRowCount() {
		return rowCount;
	}

	/**
	 * 设置总记录数
	 * 
	 * @param rowCount
	 */
	public void setRowCount(int rowCount) {
		this.rowCount = rowCount;
	}

	/**
	 * 获取结果集
	 * 
	 * @return
	 */
	public List getResult() {
		return result;
	}

	/**
	 * 设置结果集
	 * 
	 * @param result
	 */
	public void setResult(List result) {
		this.result = result;
	}

	/**
	 * 返回是否有上页
	 * @return
	 */
	public boolean isHasPrior() {
		return hasPrior;
	}

	/**
	 * 设置是否有上页
	 * @param hasPrior
	 */
	public void setHasPrior(boolean hasPrior) {
		this.hasPrior = hasPrior;
	}

	/**
	 * 返回是否有下页
	 * @return
	 */
	public boolean isHasNext() {
		return hasNext;
	}

	/**
	 *  设置是否有下页
	 * @param hasNext
	 */
	public void setHasNext(boolean hasNext) {
		this.hasNext = hasNext;
	}

}
