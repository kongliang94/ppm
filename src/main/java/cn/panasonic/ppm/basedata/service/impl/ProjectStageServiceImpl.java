package cn.panasonic.ppm.basedata.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import cn.panasonic.ppm.base.dao.BaseDao;
import cn.panasonic.ppm.base.service.impl.BaseServiceImpl;
import cn.panasonic.ppm.basedata.dao.ProjectStageDao;
import cn.panasonic.ppm.basedata.service.ProjectStageService;
import cn.panasonic.ppm.domain.basedata.ProjectStage;

@Service("projectStageService")
public  class ProjectStageServiceImpl extends BaseServiceImpl<ProjectStage> implements ProjectStageService{

	@Resource(name="projectStageDao")
	private ProjectStageDao projectStageDao;
	@Override
	public BaseDao getBaseDao() {
		
		return this.projectStageDao;
	}
	@Override
	public Long getStageCount() {
		
		return this.projectStageDao.getStageCount();//获取阶段的总数
	}

}
