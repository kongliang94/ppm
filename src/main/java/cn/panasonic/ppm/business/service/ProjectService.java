package cn.panasonic.ppm.business.service;

import java.util.Collection;

import cn.panasonic.ppm.base.service.BaseService;
import cn.panasonic.ppm.domain.business.Project;
import cn.panasonic.ppm.query.BaseQuery;
import cn.panasonic.ppm.query.PageResult;

public interface ProjectService extends BaseService<Project>{
	public Collection<Project> getProjectsNeedUser();
	
	public Collection<Project> getProjectsNeedNum();
	
	public Collection<Project> getProjectsNeedApprove(String onlynum);

	public Collection<Project> getOwnProjects(String username);
	
	
}
