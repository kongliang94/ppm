package cn.panasonic.ppm.base.service;

import java.io.Serializable;
import java.util.Collection;

import cn.panasonic.ppm.query.BaseQuery;
import cn.panasonic.ppm.query.PageResult;

public interface BaseService<T> {

	public PageResult<T> getPageResult(final BaseQuery baseQuery);
	public void saveEntry(T t);
	public void updateEntry(T t);
	public T getEntryById(Serializable id);
	public void deleteEntryById(Serializable id);
	public void deleteEntriesByIds(Serializable[] ids);
	public Collection<T> getEntries();
}
