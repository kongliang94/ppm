package cn.panasonic.ppm.basedata.dao.impl;

import java.sql.SQLException;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.orm.hibernate3.HibernateCallback;
import org.springframework.stereotype.Repository;

import cn.panasonic.ppm.base.dao.impl.BaseDaoImpl;
import cn.panasonic.ppm.basedata.dao.UserDao;
import cn.panasonic.ppm.domain.basedata.User;

@Repository("userDao")
public class UserDaoImpl extends BaseDaoImpl<User> implements UserDao{

	@Override
	public User getUserByName(final String logonname) {
		
		return this.hibernateTemplate.execute(new HibernateCallback<User>() {

			@Override
			public User doInHibernate(Session session) throws HibernateException,
					SQLException {
				String hql = "from User as user where user.logonname=?";
				Query query = session.createQuery(hql);
				query.setString(0, logonname);
				List<User> list= query.list();    //返回的是一个集合
				return list.get(0);
			}
		});
	}
	public Long getUserCountByName(final String logonname,final String logonpwd) {
		
		return this.hibernateTemplate.execute(new HibernateCallback<Long>() {

			@Override
			public Long doInHibernate(Session session) throws HibernateException,
					SQLException {
				String hql = "select count(logonname) from User as user where user.logonname=? and user.logonpwd=?";
				Query query = session.createQuery(hql);
				query.setString(0, logonname);
				query.setString(1, logonpwd);
				return (Long) query.uniqueResult();
			}
		});
	}
	@Override
	public boolean checkLogin(String logonname, String logonpwd) {
		boolean flag=false;
		Long count=getUserCountByName(logonname, logonpwd);
		if(count>0){		
				flag=true;
		}
		return flag;
	}

}
