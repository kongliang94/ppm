package cn.panasonic.ppm.basedata.dao.impl;

import org.springframework.stereotype.Repository;

import cn.panasonic.ppm.base.dao.impl.BaseDaoImpl;
import cn.panasonic.ppm.basedata.dao.DepartmentDao;
import cn.panasonic.ppm.domain.basedata.Department;

@Repository("departmentDao")
public class DepartmentDaoImpl extends BaseDaoImpl<Department> implements DepartmentDao{

}
