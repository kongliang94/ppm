package cn.panasonic.ppm.business.service.impl;

import java.util.Collection;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import cn.panasonic.ppm.base.dao.BaseDao;
import cn.panasonic.ppm.base.service.impl.BaseServiceImpl;
import cn.panasonic.ppm.business.dao.ProjectDao;
import cn.panasonic.ppm.business.service.ProjectService;
import cn.panasonic.ppm.domain.business.Project;
import cn.panasonic.ppm.query.BaseQuery;
import cn.panasonic.ppm.query.PageResult;

@Service("projectService")
public class ProjectServiceImpl extends BaseServiceImpl<Project> implements ProjectService{

	@Resource(name="projectDao")
	private ProjectDao projectDao;
	@Override
	public BaseDao getBaseDao() {
		return this.projectDao;
	}
	@Override
	public Collection<Project> getProjectsNeedUser() {
		
		return this.projectDao.getProjectsNeedUser();
	}
	@Override
	public Collection<Project> getProjectsNeedNum() {
		return this.projectDao.getProjectsNeedNum();
	}
	@Override
	public Collection<Project> getProjectsNeedApprove(String onlynum) {
		return this.projectDao.getProjectsNeedApprove(onlynum);
	}
	@Override
	public Collection<Project> getOwnProjects(String username) {
		
		return this.projectDao.getOwnProjects(username);
	}
	@Override
	public PageResult<Project> getPageResult(BaseQuery baseQuery){
		return this.projectDao.getPageResult(baseQuery);
	}

}
