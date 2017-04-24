package cn.panasonic.ppm.base.dao.impl;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.sql.SQLException;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.Map.Entry;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.metadata.ClassMetadata;
import org.springframework.orm.hibernate3.HibernateCallback;
import org.springframework.orm.hibernate3.HibernateTemplate;

import cn.panasonic.ppm.base.dao.BaseDao;
import cn.panasonic.ppm.query.BaseQuery;
import cn.panasonic.ppm.query.PageResult;

public class BaseDaoImpl<T> implements BaseDao<T> {

	private final Class classt;
	
	private ClassMetadata classMetadata;//元数据
	public BaseDaoImpl(){
		ParameterizedType type= (ParameterizedType) this.getClass().getGenericSuperclass();
		this.classt=(Class) type.getActualTypeArguments()[0];
	}
	
	@PostConstruct
	public void init(){
		this.classMetadata=this.hibernateTemplate.getSessionFactory().getClassMetadata(this.classt);
	}
	
	@Resource(name="hibernateTemplate")
	public HibernateTemplate hibernateTemplate;
	@Override
	public T getEntryById(Serializable id) {		
		return (T) this.hibernateTemplate.get(this.classt, id);
	}

	@Override
	public Collection<T> findEntries() {
		return this.hibernateTemplate.find("from "+this.classt.getSimpleName());
	}

	@Override
	public void saveEntry(T t) {
		this.hibernateTemplate.save(t);
	}

	@Override
	public void updateEntry(T t) {
		this.hibernateTemplate.update(t);
	}

	@Override
	public void deleteEntry(Serializable id) {	
		this.hibernateTemplate.delete(getEntryById(id));
	}

	@Override
	public void deleteEntriesByIds(Serializable[] ids) {
		StringBuffer sb=new StringBuffer();
		for (int i = 0; i < ids.length; i++) {
			if(i==ids.length-1){
				sb.append(ids[i]);
			}else {
				sb.append(ids[i]+",");
			}
		}
		
		StringBuffer hql=new StringBuffer();
		hql.append("from "+this.classt.getSimpleName());
		hql.append(" where "+this.classMetadata.getIdentifierPropertyName());
		hql.append(" in("+sb.toString());
		hql.append(")");
		
		List<T> entryList=this.hibernateTemplate.find(hql.toString());
		this.hibernateTemplate.deleteAll(entryList);
	}

	@Override
	public PageResult<T> findPageResult(final BaseQuery baseQuery) {
		return this.hibernateTemplate.execute(new HibernateCallback<PageResult<T>>() {

			@Override
			public PageResult<T> doInHibernate(Session session)
					throws HibernateException, SQLException {
				int totalRows=getCount(baseQuery);
				PageResult<T> pageResult=new PageResult<T>(baseQuery.getCurrentPage(), baseQuery.getPageSize(), totalRows);
				StringBuffer hql=new StringBuffer();
				hql.append("from "+classt.getSimpleName());
				hql.append(" where 1=1 ");
				
				//获取所有的查询条件
				Map<String, Object> keyValues = baseQuery.buildWhere();
				
				/**
				 * 拼接where条件的过程
				 */
				for (Entry<String, Object> entry : keyValues.entrySet()) {
					hql.append("and "+entry.getKey()+"=:"+entry.getKey());
				}
				
				Query query=session.createQuery(hql.toString());
				/**
				 * 把where条件中的参数传递值的过程
				 */
				for (Entry<String, Object> entry : keyValues.entrySet()) {
					query.setParameter(entry.getKey(), entry.getValue());
				}
				
				//设置当前页的第一行在集合中的位置
				int firstResult=(pageResult.getCurrentPage()-1)*pageResult.getPageSize();
				//设置每页显示的最多的行数
				int maxResult = baseQuery.getPageSize();
				//用hibernate的方式设置分页
				query.setFirstResult(firstResult).setMaxResults(maxResult);
				//返回分页后的结果集
				List<T> rows = query.list();
				pageResult.setRows(rows);
				return pageResult;
			}
		});
	}

	@Override
	public int getCount(final BaseQuery baseQuery) {
		return this.hibernateTemplate.execute(new HibernateCallback<Integer>() {

			@Override
			public Integer doInHibernate(Session session) throws HibernateException,
					SQLException {
				StringBuffer hql=new StringBuffer();
				hql.append("select count("+classMetadata.getIdentifierPropertyName()+") from "+classt.getSimpleName());
				hql.append(" where 1=1 ");
				
				//获取所有的查询条件
				Map<String, Object> keyValues = baseQuery.buildWhere();
				
				/**
				 * 拼接where条件的过程
				 */
				for (Entry<String, Object> entry : keyValues.entrySet()) {
					hql.append("and "+entry.getKey()+"=:"+entry.getKey());
				}
				
				Query query=session.createQuery(hql.toString());
				/**
				 * 把where条件中的参数传递值的过程
				 */
				for (Entry<String, Object> entry : keyValues.entrySet()) {
					query.setParameter(entry.getKey(), entry.getValue());
				}
				Long count  = (Long)query.uniqueResult();
				return count.intValue();
			}
		});
	}

	@Override
	public Set<T> getEntriesByIds(Serializable[] ids) {
		StringBuffer sb=new StringBuffer();
		for (int i = 0; i < ids.length; i++) {
			if(i==ids.length-1){
				sb.append(ids[i]);
			}else {
				sb.append(ids[i]+",");
			}
		}
		
		StringBuffer hql=new StringBuffer();
		hql.append("from "+this.classt.getSimpleName());
		hql.append(" where "+this.classMetadata.getIdentifierPropertyName());
		hql.append(" in("+sb.toString());
		hql.append(")");
		List<T> entryList=this.hibernateTemplate.find(hql.toString());
		return new HashSet<T>(entryList);
	}

}
