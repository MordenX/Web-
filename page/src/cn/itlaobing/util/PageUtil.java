package cn.itlaobing.util;

public class PageUtil {
	// ҳ��
	private int pageCount;
	// ��ǰҳ��
	private int pageIndex = 1;
	// ���м�¼��
	private int recordCount;
	// ҳ���С,Ĭ��ÿҳ20��
	private int pageSize = 5;

	/**
	 * ��ȡ��ҳ����������ҳ���Ǽ�������ģ���˶��ⲻ�ṩset����
	 */
	public int getPageCount() {
		this.pageCount = (recordCount - 1) / pageSize+1;
		return this.pageCount;
	}

	/**
	 * ��ȡ��ǰҳ����Nҳ��ֵΪN
	 */
	public int getPageIndex() {
		return pageIndex;
	}

	/**
	 * ���õ�ǰҳ����Nҳ��ֵΪN
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
	 * ��ȡ��¼����
	 */
	public int getRecordCount() {
		return recordCount;
	}

	/**
	 * ���ü�¼����
	 */
	public void setRecordCount(int recordCount) {
		this.recordCount = recordCount;
	}

	/**
	 * ��ȡÿҳ��С
	 */
	public int getPageSize() {
		return pageSize;
	}

	/**
	 * ����ÿҳ��С
	 */
	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}
}
