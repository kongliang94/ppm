package cn.panasonic.ppm.base.dao;

import java.io.Serializable;
import java.util.Collection;
import java.util.Set;

import cn.panasonic.ppm.query.BaseQuery;
import cn.panasonic.ppm.query.PageResult;

public interface BaseDao<T>{
	
	public T getEntryById(Serializable id);
	
	public Set<T> getEntriesByIds(Serializable[] ids);
	
	public Collection<T> findEntries();
	
	public void saveEntry(T t);
	
	public void updateEntry(T t);
	
	public void deleteEntry(Serializable id);
	
	public void deleteEntriesByIds(Serializable[] ids);
	
	/**
	 * 分页查询
	 * @param baseQuery
	 * @return
	 */
	public PageResult<T> findPageResult(final BaseQuery baseQuery);
	/**
	 * 统计符合条件的条数
	 * @param baseQuery
	 * @return
	 */
	public int getCount(final BaseQuery baseQuery);
}
