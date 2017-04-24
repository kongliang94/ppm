package cn.panasonic.ppm.basedata.service.impl;

import java.io.Serializable;
import java.util.Collection;
import java.util.Set;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import cn.panasonic.ppm.base.dao.BaseDao;
import cn.panasonic.ppm.base.service.impl.BaseServiceImpl;
import cn.panasonic.ppm.basedata.dao.ProjectValueDao;
import cn.panasonic.ppm.basedata.service.ProjectValueService;
import cn.panasonic.ppm.domain.basedata.ProjectValue;


@Service("projectValueService")
public class ProjectValueServiceImpl extends BaseServiceImpl<ProjectValue> implements ProjectValueService{


	@Resource(name="projectValueDao")
	private ProjectValueDao projectValueDao;
	@Override
	public BaseDao getBaseDao() {
		// TODO Auto-generated method stub
		return this.projectValueDao;
	}

}
