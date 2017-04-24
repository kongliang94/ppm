package cn.panasonic.ppm.business.dao.impl;

import java.sql.SQLException;
import java.util.Collection;

import org.hibernate.HibernateException;
import org.hibernate.LockMode;
import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.orm.hibernate3.HibernateCallback;
import org.springframework.stereotype.Repository;

import cn.panasonic.ppm.base.dao.impl.BaseDaoImpl;
import cn.panasonic.ppm.business.dao.ApproveDao;
import cn.panasonic.ppm.domain.business.Approve;

@Repository("approveDao")
public class ApproveDaoImpl extends BaseDaoImpl<Approve> implements ApproveDao{

	@Override
	public Collection<Approve> getApprovesByOnlynumAndStage(final String onlynum,
			final Long stageId) {
		return this.hibernateTemplate.execute(new HibernateCallback<Collection<Approve>>() {

			@Override
			public Collection<Approve> doInHibernate(Session session)
					throws HibernateException, SQLException {
				String hql = "from Approve as approve where approve.onlynum=? and approve.stageId=?";
				Query query = session.createQuery(hql);
				query.setParameter(0,onlynum);
				query.setParameter(1,stageId);
				query.setLockMode( "approve" ,LockMode.UPGRADE);//悲观锁
				return query.list();
				
			}
		});
	}

	@Override
	public Collection<Approve> getApprovesByUserIdAndStatus(final Long userId) {
		return this.hibernateTemplate.execute(new HibernateCallback<Collection<Approve>>() {

			@Override
			public Collection<Approve> doInHibernate(Session session)
					throws HibernateException, SQLException {
				String hql = "from Approve as approve where approve.user.uid=? and approve.status=?";
				Query query = session.createQuery(hql);
				query.setParameter(0,userId);
				query.setParameter(1,false);
				return query.list();
				
			}
		});
	}

	@Override
	public Approve getApprovesByOnumAnduIdAndStatus(final String onlynum,
			final Long userId) {
		
		return this.hibernateTemplate.execute(new HibernateCallback<Approve>() {

			@Override
			public Approve doInHibernate(Session session)
					throws HibernateException, SQLException {
				String hql = "from Approve as approve where approve.userId=? and approve.status=? and approve.onlynum=?";
				Query query = session.createQuery(hql);
				query.setParameter(0,userId);
				query.setParameter(1,false);
				query.setParameter(2, onlynum);
				 
				return (Approve) query.list().get(0);
				
			}
		});
	}

	@Override
	public Approve getApprovesByOnumAnduIdAndsId(final String onlynum, final Long userId,
			final Long stageId) {
		return this.hibernateTemplate.execute(new HibernateCallback<Approve>() {

			@Override
			public Approve doInHibernate(Session session)
					throws HibernateException, SQLException {
				String hql = "from Approve as approve where approve.user.uid=? and approve.onlynum=? and approve.stageId=?";
				Query query = session.createQuery(hql);
				query.setParameter(0,userId);
				query.setParameter(1, onlynum);
				query.setParameter(2,stageId);
				return (Approve) query.list().get(0);
				
			}
		});
	}

}
