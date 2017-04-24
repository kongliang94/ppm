package cn.panasonic.ppm.base.service.impl;

import java.io.Serializable;
import java.util.Collection;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cn.panasonic.ppm.base.dao.BaseDao;
import cn.panasonic.ppm.base.service.BaseService;
import cn.panasonic.ppm.query.BaseQuery;
import cn.panasonic.ppm.query.PageResult;

public abstract class BaseServiceImpl<T> implements BaseService<T>{

	public abstract BaseDao getBaseDao();//这里baseDao无法注入，子类继承实现
	@Override
	public PageResult<T> getPageResult(BaseQuery baseQuery) {
		
		return this.getBaseDao().findPageResult(baseQuery);
	}

	@Transactional
	public void saveEntry(T t) {
		this.getBaseDao().saveEntry(t);
	}

	@Transactional
	public void updateEntry(T t) {
		this.getBaseDao().updateEntry(t);
	}

	@Override
	public T getEntryById(Serializable id) {		
		return (T) this.getBaseDao().getEntryById(id);
	}

	@Transactional
	public void deleteEntryById(Serializable id) {
		this.getBaseDao().deleteEntry(id);
	}

	@Transactional
	public void deleteEntriesByIds(Serializable[] ids) {
		this.getBaseDao().deleteEntriesByIds(ids);
	}

	@Override
	public Collection<T> getEntries() {
		return this.getBaseDao().findEntries();
	}

}
