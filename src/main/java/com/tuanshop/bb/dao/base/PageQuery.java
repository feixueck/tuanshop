package com.tuanshop.bb.dao.base;

import java.util.Collections;
import java.util.Date;
import java.util.List;

/**
 * @Type PageQuery
 * @Desc 分页查询
 * @author zuoshaui
 */
public class PageQuery<T> {

	/**
	 * 执行所有查询语句后返回的结果集,与DAO中的listByQuery的返回值对应
	 */
	protected List<T> dataList;

	/** 默认每页显示的记录数 */
	public static final int DEFAULT_PAGE_SIZE = 20;

	/** 每页最多显示的记录数 */
	public static final int MAX_PAGE_SIZE = 200;

	/**
	 * 一页大小
	 */
	protected int pageSize;
	/**
	 * 起始位置
	 */ 
	protected int startPos;
	/**
	 * 总记录数
	 */
	protected int totalRecord;
	/**
	 * 当前页数，从 1开始，1代表第一页
	 */
	protected int pageIndex = 1;

	/**
	 * 总页数
	 */
	protected int totalPage;

	/**
	 * 获取一页的记录数
	 * 
	 * @return
	 */
	public int getPageSize() {
		if (pageSize < 1) {
			pageSize = DEFAULT_PAGE_SIZE;
		}
		return pageSize;
	}

	/**
	 * 设置一页的记录数
	 * 
	 * @param pageSize
	 */
	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}

	/**
	 * 总记录数
	 * 
	 * @return
	 */
	public int getTotalRecord() {
		return totalRecord;
	}

	/**
	 * 设置总的记录数。计算出总页数
	 * 
	 * @param totalRecord
	 */
	public void setTotalRecord(int totalRecord) {
		this.totalPage = (totalRecord + getPageSize() - 1) / getPageSize();
		this.totalRecord = totalRecord;
	}

	/**
	 * 得到当前查询的第几页
	 * 
	 * @return
	 */
	public int getPageIndex() {
		if (pageIndex < 1) {
			pageIndex = 1;
		} else if (pageIndex > getTotalPage()) {
			pageIndex = getTotalPage();
		}
		return pageIndex;
	}

	/**
	 * 是否有下页
	 * 
	 * @return
	 */
	public boolean hasNextPage() {
		if (pageIndex < getTotalPage()) {
			return true;
		} else {
			return false;
		}
	}

	/**
	 * 设置当前页面
	 * 
	 * @param pageIndex
	 */
	public void setPageIndex(int pageIndex) {
		this.pageIndex = pageIndex;
	}

	public int getStartPos() {
		return (getPageIndex() - 1) * getPageSize();
	}

	public void setStartPos(int startPos) {
		this.startPos = (getPageIndex() - 1) * getPageSize();
	}

	public int getEndPos() {
		if (getPageIndex() * getPageSize() < getTotalRecord()) {
			return getPageIndex() * getPageSize();
		} else {
			return getTotalRecord();
		}
	}

	/**
	 * 得到总页数
	 * 
	 * @return
	 */
	public int getTotalPage() {
		return totalPage;
	}

	public List<T> getDataList() {
		if (dataList == null) {
			return Collections.<T> emptyList();
		} else {
			return dataList;
		}
	}

	public void setDataList(List<T> module) {
		this.dataList = module;
	}

	/**
	 * 创建时间开始,
	 */
	private Date createdStart;
	/**
	 * 创建时间结束
	 */
	private Date createdEnd;

	/**
	 * @return the createdStart
	 */
	public Date getCreatedStart() {
		return createdStart;
	}

	/**
	 * @param createdStart
	 *            the createdStart to set
	 */
	public void setCreatedStart(Date createdStart) {
		this.createdStart = createdStart;
	}

	/**
	 * @return the createdEnd
	 */
	public Date getCreatedEnd() {
		return createdEnd;
	}

	/**
	 * @param createdEnd
	 *            the createdEnd to set
	 */
	public void setCreatedEnd(Date createdEnd) {
		this.createdEnd = createdEnd;
	}

}
