package cn.panasonic.ppm.business.dao.impl;

import java.sql.SQLException;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import org.apache.struts2.ServletActionContext;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.dialect.Ingres10Dialect;
import org.springframework.orm.hibernate3.HibernateCallback;
import org.springframework.stereotype.Repository;

import cn.panasonic.ppm.base.dao.impl.BaseDaoImpl;
import cn.panasonic.ppm.business.dao.ProjectDao;
import cn.panasonic.ppm.domain.basedata.User;
import cn.panasonic.ppm.domain.business.Project;
import cn.panasonic.ppm.query.BaseQuery;
import cn.panasonic.ppm.query.PageResult;

@Repository("projectDao")
public class ProjectDaoImpl extends BaseDaoImpl<Project> implements ProjectDao{

	public PageResult<Project> getPageResult(final BaseQuery baseQuery){
		return this.hibernateTemplate.execute(new HibernateCallback<PageResult<Project>>() {

			@Override
			public PageResult<Project> doInHibernate(Session session)
					throws HibernateException, SQLException {
				int totalRows=getCount(baseQuery);
				PageResult<Project> pageResult=new PageResult<Project>(baseQuery.getCurrentPage(), baseQuery.getPageSize(), totalRows);
				StringBuffer hql=new StringBuffer();
				hql.append("from Project p1 where p1.freshDate in (select max(p.freshDate) from Project p where 1=1 group by p.onlynum) ");
				
				//获取所有的查询条件
				Map<String, Object> keyValues = baseQuery.buildWhere();
				
				/**
				 * 拼接where条件的过程
				 */
				for (Entry<String, Object> entry : keyValues.entrySet()) {
					hql.append("and "+entry.getKey()+"=:"+entry.getKey());
				}
				hql.append(" order by p1.freshDate desc");
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
				List<Project> rows = query.list();
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
				hql.append("select count(*) from Project where pid in (select  p.pid from Project p group by p.onlynum)");
				
				//获取所有的查询条件
				Map<String, Object> keyValues = baseQuery.buildWhere();
				
				/**
				 * 拼接where条件的过程
				 */
				for (Entry<String, Object> entry : keyValues.entrySet()) {
					hql.append(" and "+entry.getKey()+"=:"+entry.getKey());
				}
				
				Query query=session.createQuery(hql.toString());
				/**
				 * 把where条件中的参数传递值的过程
				 */
				for (Entry<String, Object> entry : keyValues.entrySet()) {
					query.setParameter(entry.getKey(), entry.getValue());
					System.out.println(entry.getValue());
				}
				
				
				
				Long count=(Long) query.uniqueResult();
				
				return count.intValue();
			}
		});
	}
	@Override
	public Collection<Project> getProjectsNeedUser() {
		
		return this.hibernateTemplate.execute(new HibernateCallback<Collection<Project>>() {

			@Override
			public Collection<Project> doInHibernate(Session session) throws HibernateException,
					SQLException {
				String hql = "from Project p1 " +
						"where p1.freshDate in " +
						"(select max(p.freshDate) from Project as p where 1=1 group by p.onlynum) " +
						"and p1.mark=?";//先分组在选出每组时间最大
				Query query = session.createQuery(hql);
				query.setParameter(0, false);
				List<Project> list= query.list();    //返回的是一个集合
				return list;
				
			}
		});
	}

	@Override
	public Collection<Project> getProjectsNeedNum() {
		
		return this.hibernateTemplate.execute(new HibernateCallback<Collection<Project>>() {

			@Override
			public Collection<Project> doInHibernate(Session session)
					throws HibernateException, SQLException {
				
				String hql = "from Project p1 where p1.freshDate in (select max(p.freshDate) from Project as p where 1=1 group by p.onlynum) and p1.number=?";
				Query query = session.createQuery(hql);
				query.setParameter(0,"指定人指定"); //自己设置的编号为0
				
				return query.list();    //返回的是一个集合
				
			}
		});
	}

	@Override
	public Collection<Project> getProjectsNeedApprove(final String onlynum) {
		return this.hibernateTemplate.execute(new HibernateCallback<Collection<Project>>() {

			@Override
			public Collection<Project> doInHibernate(Session session)
					throws HibernateException, SQLException {
				String hql = "from Project as p where p.status=? and p.onlynum=?";
				Query query = session.createQuery(hql);
				query.setParameter(0,1); //0为推进中，1为审批中，2为完成
				query.setParameter(1,onlynum);
				
				return query.list();    //返回的是一个集合
				
			}
		});
	}

	@Override
	public Collection<Project> getOwnProjects(final String username) {
		return this.hibernateTemplate.execute(new HibernateCallback<Collection<Project>>() {

			@Override
			public Collection<Project> doInHibernate(Session session)
					throws HibernateException, SQLException {
				String hql = "from Project as p where p.username=? and p.mark=?";
				Query query = session.createQuery(hql);
				query.setParameter(0, username);
				query.setParameter(1, true);
				
				return query.list();    //返回的是一个集合
				
			}
		});
	}

	@Override
	public Collection<Project> getProjectsByNameAndSelectId() {
		
		int selectId=Integer.parseInt(ServletActionContext.getRequest().getParameter("selectId"));
		System.out.println(selectId);
		
		return null;
	}
	
}
