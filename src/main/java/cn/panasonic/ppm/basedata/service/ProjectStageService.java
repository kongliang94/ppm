package cn.panasonic.ppm.basedata.service;

import cn.panasonic.ppm.base.service.BaseService;
import cn.panasonic.ppm.domain.basedata.ProjectStage;

public interface ProjectStageService extends BaseService<ProjectStage>{

	public Long getStageCount();

}
