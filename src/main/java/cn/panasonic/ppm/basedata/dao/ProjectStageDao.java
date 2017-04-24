package cn.panasonic.ppm.basedata.dao;

import cn.panasonic.ppm.base.dao.BaseDao;
import cn.panasonic.ppm.domain.basedata.ProjectStage;

public interface ProjectStageDao extends BaseDao<ProjectStage>{
	public Long getStageCount();
}
