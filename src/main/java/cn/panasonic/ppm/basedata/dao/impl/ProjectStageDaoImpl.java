package cn.panasonic.ppm.basedata.dao.impl;

import java.sql.SQLException;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.orm.hibernate3.HibernateCallback;
import org.springframework.stereotype.Repository;

import cn.panasonic.ppm.base.dao.impl.BaseDaoImpl;
import cn.panasonic.ppm.basedata.dao.ProjectStageDao;
import cn.panasonic.ppm.domain.basedata.ProjectStage;
import cn.panasonic.ppm.domain.basedata.User;

@Repository("projectStageDao")
public class ProjectStageDaoImpl extends BaseDaoImpl<ProjectStage> implements ProjectStageDao{

	@Override
	public Long getStageCount() {
		
		return this.hibernateTemplate.execute(new HibernateCallback<Long>() {

			@Override
			public Long doInHibernate(Session session) throws HibernateException,
					SQLException {
				String hql = "select count(*) from ProjectStage as stage";
				Query query = session.createQuery(hql);
				return  (Long) query.uniqueResult(); 
			}
		});
	}
	
}
