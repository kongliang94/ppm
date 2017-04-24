package cn.panasonic.ppm.business.dao.impl;

import java.sql.SQLException;
import java.util.Collection;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.orm.hibernate3.HibernateCallback;
import org.springframework.stereotype.Repository;

import cn.panasonic.ppm.base.dao.impl.BaseDaoImpl;
import cn.panasonic.ppm.business.dao.FileDao;
import cn.panasonic.ppm.domain.business.ResultFile;
@Repository("fileDao")
public class FileDaoImpl extends BaseDaoImpl<ResultFile> implements FileDao{

	@Override
	public Collection<ResultFile> getFilesByOnlynum(final String onlynum) {
		
		return this.hibernateTemplate.execute(new HibernateCallback<Collection<ResultFile>>() {

			@Override
			public Collection<ResultFile> doInHibernate(Session session)
					throws HibernateException, SQLException {
				String hql = "from ResultFile as resultfile where resultfile.onlynum=?";
				Query query = session.createQuery(hql);
				query.setParameter(0,onlynum);
				return query.list();
			}
			
		});
	}

	@Override
	public Collection<ResultFile> getFilesByOnlynumAndStageId(final String onlynum,
			final Long stageId) {
		
		return this.hibernateTemplate.execute(new HibernateCallback<Collection<ResultFile>>() {

			@Override
			public Collection<ResultFile> doInHibernate(Session session)
					throws HibernateException, SQLException {
				String hql = "from ResultFile as resultfile where resultfile.onlynum=? and resultfile.stageId=?";
				Query query = session.createQuery(hql);
				query.setParameter(0,onlynum);
				query.setParameter(1,stageId);
				return query.list();
			}
			
		});
	}

}
