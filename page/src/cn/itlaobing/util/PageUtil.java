package cn.itlaobing.util;

public class PageUtil {
	// 页数
	private int pageCount;
	// 当前页面
	private int pageIndex = 1;
	// 所有记录数
	private int recordCount;
	// 页面大小,默认每页20条
	private int pageSize = 5;

	/**
	 * 获取总页数，由于总页数是计算出来的，因此对外不提供set方法
	 */
	public int getPageCount() {
		this.pageCount = (recordCount - 1) / pageSize+1;
		return this.pageCount;
	}

	/**
	 * 获取当前页，第N页的值为N
	 */
	public int getPageIndex() {
		return pageIndex;
	}

	/**
	 * 设置当前页，第N页的值为N
	 */
	public void setPageIndex(int pageIndex) {
		if (pageIndex < 1) {
			this.pageIndex = 1;
		} else if (pageIndex > getPageCount()) {
			this.pageIndex = getPageCount();
		} else {
			this.pageIndex = pageIndex;
		}
	}

	/**
	 * 获取记录总数
	 */
	public int getRecordCount() {
		return recordCount;
	}

	/**
	 * 设置记录总数
	 */
	public void setRecordCount(int recordCount) {
		this.recordCount = recordCount;
	}

	/**
	 * 获取每页大小
	 */
	public int getPageSize() {
		return pageSize;
	}

	/**
	 * 设置每页大小
	 */
	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}
}
