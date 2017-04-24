package cn.panasonic.ppm.basedata.dao.impl;

import org.springframework.stereotype.Repository;

import cn.panasonic.ppm.base.dao.impl.BaseDaoImpl;
import cn.panasonic.ppm.basedata.dao.ProjectValueDao;
import cn.panasonic.ppm.domain.basedata.ProjectValue;

@Repository("projectValueDao")
public class ProjectValueDaoImpl extends BaseDaoImpl<ProjectValue> implements ProjectValueDao{

}
