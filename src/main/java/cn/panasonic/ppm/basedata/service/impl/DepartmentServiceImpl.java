package cn.panasonic.ppm.basedata.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import cn.panasonic.ppm.base.dao.BaseDao;
import cn.panasonic.ppm.base.service.impl.BaseServiceImpl;
import cn.panasonic.ppm.basedata.dao.DepartmentDao;
import cn.panasonic.ppm.basedata.service.DepartmentService;
import cn.panasonic.ppm.domain.basedata.Department;

@Service("departmentService")
public class DepartmentServiceImpl extends BaseServiceImpl<Department> implements DepartmentService{

	@Resource(name="departmentDao")
	private DepartmentDao departmentDao;
	@Override
	public BaseDao getBaseDao() {
		return this.departmentDao;
	}

}
