package cn.panasonic.ppm.basedata;

import org.junit.Test;

import cn.panasonic.ppm.basedata.dao.DepartmentDao;
import cn.panasonic.ppm.query.basedata.DepartmentQuery;

public class BaseDaoTest extends SpringUtils{
	@Test
	public void testBaseDao_Count(){
		DepartmentDao dao=(DepartmentDao) context.getBean("departmentDao");
		DepartmentQuery baseQuery = new DepartmentQuery();
		//baseQuery.setName("44");
		int count = dao.getCount(baseQuery);
		System.out.println(count);
	}
}
