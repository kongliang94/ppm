package cn.panasonic.ppm.basedata;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.junit.Test;

import cn.panasonic.ppm.domain.business.Project;

public class SessionFactoryTest extends SpringUtils {
	@Test
	public void sessionFactoryTest(){
//		SessionFactory sessionFactory = (SessionFactory)context.getBean("sessionFactory");
//		Session session = sessionFactory.openSession();
//		Long count = (Long)session.createQuery("select count(*) from Department").uniqueResult();
//		System.out.println(count);
//		Query query=session.createQuery("from Project p1 where p1.freshDate in (select max(p.freshDate) from Project as p where 1=1 group by p.name) and p1.username='孔梁'");
//		List<Project> psList=query.list();
//		for (Project project : psList) {
//			System.out.println(project.getName());
//		}
		
		
	}
	
}
