package cn.panasonic.ppm.query;

import java.util.HashMap;
import java.util.Map;

/**
 * 1、提供一个抽象方法，让子类完成实现，把具体的页面上的表单元素封装成map
 * 2、提供一个Map<String,Object>，由子类使用
 * @author KL
 *
 */
public abstract class BaseQuery {
	
	private int currentPage=1;
	
	private int pageSize=3;
	
	public int getCurrentPage() {
		return currentPage;
	}

	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
	}

	public int getPageSize() {
		return pageSize;
	}

	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}
	
	private Map<String,Object> keyValues=new HashMap<String, Object>();

	public Map<String, Object> getKeyValues() {
		return keyValues;
	}

	public void setKeyValues(Map<String, Object> keyValues) {
		this.keyValues = keyValues;
	}
	
	public abstract Map<String,Object> buildWhere();
}
