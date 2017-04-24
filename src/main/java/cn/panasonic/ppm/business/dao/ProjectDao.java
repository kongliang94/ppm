package cn.panasonic.ppm.business.dao;

import java.util.Collection;

import cn.panasonic.ppm.base.dao.BaseDao;
import cn.panasonic.ppm.domain.business.Project;
import cn.panasonic.ppm.query.BaseQuery;
import cn.panasonic.ppm.query.PageResult;

public interface ProjectDao extends BaseDao<Project>{
	
	/**
	 * 需要制定审批人
	 * @return
	 */
	public Collection<Project> getProjectsNeedUser();
	
	/**
	 * 需要制定项目编号的
	 * @return
	 */
	public Collection<Project> getProjectsNeedNum();  
	
	/**
	 * 需要审批的项目
	 * @param onlynum
	 * @return
	 */
	public Collection<Project> getProjectsNeedApprove(final String onlynum);
	
	/**
	 * 个人的项目
	 * @param username 
	 * @return
	 */
	public Collection<Project> getOwnProjects(final String username); 
	/**
	 * 全部项目
	 * @param baseQuery
	 * @return
	 */
	public PageResult<Project> getPageResult(final BaseQuery baseQuery);
	/**
	 * 条件查询的项目
	 * @return
	 */
	public Collection<Project> getProjectsByNameAndSelectId();
}
