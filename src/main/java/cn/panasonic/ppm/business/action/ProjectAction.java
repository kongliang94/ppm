package cn.panasonic.ppm.business.action;

import java.io.File;
import java.io.IOException;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javassist.expr.NewArray;

import javax.annotation.Resource;

import org.apache.commons.io.FileUtils;
import org.apache.struts2.ServletActionContext;
import org.springframework.beans.BeanUtils;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import cn.panasonic.ppm.base.action.BaseAction;
import cn.panasonic.ppm.basedata.service.DepartmentService;
import cn.panasonic.ppm.basedata.service.ProjectStageService;
import cn.panasonic.ppm.basedata.service.ProjectValueService;
import cn.panasonic.ppm.basedata.service.UserService;
import cn.panasonic.ppm.basedata.util.Json;
import cn.panasonic.ppm.business.service.ApproveService;
import cn.panasonic.ppm.business.service.FileService;
import cn.panasonic.ppm.business.service.ProjectService;
import cn.panasonic.ppm.business.util.DateUtil;
import cn.panasonic.ppm.domain.basedata.Department;
import cn.panasonic.ppm.domain.basedata.ProjectStage;
import cn.panasonic.ppm.domain.basedata.ProjectValue;
import cn.panasonic.ppm.domain.basedata.User;
import cn.panasonic.ppm.domain.business.Approve;
import cn.panasonic.ppm.domain.business.Project;
import cn.panasonic.ppm.domain.business.ResultFile;
import cn.panasonic.ppm.query.PageResult;
import cn.panasonic.ppm.query.busniess.ProjectQuery;

@Controller("projectAction")
@Scope("prototype")
public class ProjectAction extends BaseAction<Project>{

	@Resource(name="projectService")
	private ProjectService projectService;
	
	@Resource(name="departmentService")
	private DepartmentService departmentService;
	@Resource(name="userService")
	private UserService userService;
	@Resource(name="fileService")
	private FileService fileService;
	@Resource(name="approveService")
	private ApproveService approveService;
	@Resource(name="projectStageService")
	private ProjectStageService projectStageService;
	@Resource(name="projectValueService")
	private ProjectValueService projectValueService;
	private ProjectQuery projectQuery=new ProjectQuery();
	
	private static Collection<Project> projects;
	private Long did;//页面上的部门id
	private Long id; //阶段的id
	private Long vid; //难易度id
	public Long getVid() {
		return vid;
	}

	public void setVid(Long vid) {
		this.vid = vid;
	}

	public Long getUid() {
		return uid;
	}

	public void setUid(Long uid) {
		this.uid = uid;
	}
	private Long uid; //负责人id
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
	private String username;
	
	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public Long getDid() {
		return did;
	}

	public void setDid(Long did) {
		this.did = did;
	}

	
	
	
	//需要指定项目编号的项目
	public String showAppointNumPageResult(){
		Collection<Project> projects=this.projectService.getProjectsNeedNum();
		putValuetoStack("projects", projects);
		return "appointnum";
	}
	//需要指定用户的项目
	public String showAppointUserPageResult(){
		Collection<Project> projects=this.projectService.getProjectsNeedUser();
		putValuetoStack("projects", projects);
		return "appointuser";
	}
	//需要审批的项目
	public String showApproveProjectList(){
		
		User user=(User) loadSessionValue("user");
		Collection<Approve> approves=this.approveService.getApprovesByUserIdAndStatus(user.getUid());		
		projects=this.projectService.getProjectsNeedApprove("0@q.k");  //肯定为空
		for (Approve approve : approves) {			
			//System.out.println(approve.getOnlynum());
			projects.addAll(this.projectService.getProjectsNeedApprove(approve.getOnlynum()));
		}
		putValuetoStack("projects", projects);
		return "approvepro";
	}
	
	//显示自己的项目
	public String showOwnProject(){
		User user=(User) loadSessionValue("user");
		Map<String, Object> map=new HashMap<String, Object>();
		map.put("uid", user.getUid());
		projectQuery.setKeyValues(map);
		projectQuery.setCurrentPage(currentPage);
		PageResult<Project> pageResult=this.projectService.getPageResult(projectQuery);
		putValuetoStack("projects", pageResult);
		return "listAction";
	}
	//显示公司全部的项目信息
	public String showPageResult(){
		projectQuery.setCurrentPage(currentPage);
		PageResult<Project> pageResult=this.projectService.getPageResult(projectQuery);
		putValuetoStack("projects", pageResult);
		return listAction;
	}
	//新增项目
	public String addUI(){
		//部门，阶段，用户，难易度回显
		Collection<Department> departments = this.departmentService.getEntries();
		putValuetoStack("departments", departments);
		Collection<User> users=this.userService.getEntries();
		putValuetoStack("users",users);
		Collection<ProjectStage> stages=this.projectStageService.getEntries();
		putValuetoStack("stages", stages);
		Collection<ProjectValue> values=this.projectValueService.getEntries();
		putValuetoStack("values",values);
		return addUI;
	}
	//新增
	public String add(){
		Project project=new Project();	
		DateUtil dateUtil=new DateUtil();	
		BeanUtils.copyProperties(this.getModel(),project);
		project.setFreshDate(dateUtil.getCurrentTime());
		project.setStatus(0);//0为推进中，1为审批中，2为驳回
		project.setMark(false);   //是否有审批人
		project.setNumber("指定人指定");//自己设置
		/**
		 * 建立项目与阶段，用户，难易度，部门的关系
		 */
		User user=this.userService.getEntryById(uid);
		Department department=this.departmentService.getEntryById(did);
		ProjectValue value=this.projectValueService.getEntryById(vid);
		ProjectStage stage=this.projectStageService.getEntryById(id);
		project.setUser(user);
		project.setNyd(value);
		project.setDepartment(department);
		project.setStage(stage);
		project.getDepartment().getName();
		this.projectService.saveEntry(project);	
		return action2action;
	}
	
	//修改更新
	public String updateUI(){
		Project project=this.projectService.getEntryById(this.getModel().getPid());
		pushValueStack(project);
		this.did = project.getDepartment().getDid();
		this.vid=project.getNyd().getVid();
		this.uid=project.getUser().getUid();
		this.id=project.getStage().getId();
		Collection<Department> departments = this.departmentService.getEntries();
		putValuetoStack("departments", departments);
		Collection<User> users=this.userService.getEntries();
		putValuetoStack("users",users);
		Collection<ProjectValue> values=this.projectValueService.getEntries();
		putValuetoStack("values",values);
		//项目阶段不同，成果物不同
		Collection<ResultFile> results=this.fileService.getFilesByOnlynumAndStageId(project.getOnlynum(),
				project.getStage().getStageId());
		putValuetoStack("results", results);	
		Collection<Approve> approves=this.approveService.getApprovesByOnlynumAndStage(project.getOnlynum(), project.getStage().getStageId());
		putValuetoStack("approves", approves);			
		return updateUI;
	}
	
	//修改
	public String update(){
		
		DateUtil dateUtil=new DateUtil();
		Project oldProject=this.projectService.getEntryById(this.getModel().getPid());
		Department department=this.departmentService.getEntryById(did);
		User user=this.userService.getEntryById(uid);
		ProjectValue value=this.projectValueService.getEntryById(vid);
		oldProject.setDepartment(department);
		oldProject.setDescription(this.getModel().getDescription());
		oldProject.setFreshDate(dateUtil.getCurrentTime());
		oldProject.setName(this.getModel().getName());
		oldProject.setSum(this.getModel().getSum());
		oldProject.setUser(user);
		oldProject.setNyd(value);
		//oldProject.setStatus(0);
		oldProject.setRound(this.getModel().getRound());
		this.projectService.updateEntry(oldProject);
		Json json=new Json();
		
		json.setSuccess(true);
		json.setMsg("保存成功");
		
		jsonUtil(json.getMsg());
		return null;
	}
	//用户提交
	public String sumbitInfo(){
		Long pid=Long.parseLong(ServletActionContext.getRequest().getParameter("pid"));
		Project oldProject=this.projectService.getEntryById(pid);
		oldProject.setStatus(1);
		this.projectService.saveEntry(oldProject);
		return action2action;
	}
	//指定项目编号
	public String appointUI(){
		Project project=this.projectService.getEntryById(this.getModel().getPid());
		pushValueStack(project);
		
		
		Collection<ResultFile> results=this.fileService.getFilesByOnlynumAndStageId(project.getOnlynum(),
				project.getStage().getStageId());
		putValuetoStack("results", results);
		
		return "appointUI";
	}
	//指定项目编号
	public String appointnum(){
		
		String number=ServletActionContext.getRequest().getParameter("number");
		Project project=this.projectService.getEntryById(this.getModel().getPid());
		project.setNumber(number);
		this.projectService.updateEntry(project);
		Json json=new Json();
		if(project.getNumber()!=null){
			json.setSuccess(true);
			json.setMsg("提交成功");
		}else {
			json.setSuccess(false);
			json.setMsg("添加失败");
		}
		jsonUtil(json);
		return "appointaction2action";
	}
	
	
	//指定审批人
	public String appointUserUI(){
		
		Project project=this.projectService.getEntryById(this.getModel().getPid());
		pushValueStack(project);
		
		
		Collection<ResultFile> results=this.fileService.getFilesByOnlynumAndStageId(project.getOnlynum(),
				project.getStage().getStageId());
		putValuetoStack("results", results);
		Collection<User> users=this.userService.getEntries();
		putValuetoStack("users", users);
		
		Collection<Approve> approves=this.approveService.getApprovesByOnlynumAndStage(project.getOnlynum(), project.getStage().getId());
		putValuetoStack("approves", approves);
		
		return "appointUserUI";
	}
	//指定审批人
	public String appointUser(){
		
		Approve approve=new Approve();
		Long pid=Long.valueOf(ServletActionContext.getRequest().getParameter("pid"));
		Project project=this.projectService.getEntryById(pid);
		project.setMark(true);  //设置该项目有了审批人
		this.projectService.updateEntry(project);
		String onlynum=ServletActionContext.getRequest().getParameter("onlynum");
		Long stageId=Long.valueOf(ServletActionContext.getRequest().getParameter("stageId"));
		Long userId=Long.valueOf(ServletActionContext.getRequest().getParameter("userId"));
		
		
		approve.setStageId(stageId);
		approve.setUser(this.userService.getEntryById(userId)); //设置approve表和用户的关系
		approve.setOnlynum(onlynum);
		approve.setStatus(false);
		this.approveService.saveEntry(approve);
		
		if(this.approveService.getEntries().contains(approve)){
			json.setSuccess(true);
			json.setMsg("添加成功");
		}else {
			json.setSuccess(false);
			json.setMsg("添加失败");
		}
		jsonUtil(json);
		return null;
	}
	
	
	//领导审批
	public String approveUI(){
		Project project=this.projectService.getEntryById(this.getModel().getPid());
		pushValueStack(project);
		//Collection<ResultFile> results=this.fileService.getFilesByOnlynum(project.getOnlynum());
		Collection<ResultFile> results=this.fileService.getFilesByOnlynumAndStageId(project.getOnlynum(),
				project.getStage().getStageId());
		putValuetoStack("results", results);
		
		//User user=(User) loadSessionValue("user");				//从session中获取User对象
		Collection<Approve> approves=this.approveService.getApprovesByOnlynumAndStage(project.getOnlynum(),project.getStage().getStageId());
		putValuetoStack("approves",approves);
		return "approveUI";
	}
	//同意
	public String approve(){
		
		Long aid=Long.valueOf(ServletActionContext.getRequest().getParameter("aid"));
		Long pid=Long.valueOf(ServletActionContext.getRequest().getParameter("pid"));
		String onlynum=ServletActionContext.getRequest().getParameter("onlynum");
		Project project=this.projectService.getEntryById(pid);
		Approve approve=this.approveService.getApprovesByOnumAnduIdAndsId(onlynum, aid, project.getStage().getStageId());
		approve.setStatus(true);
		this.approveService.updateEntry(approve);
		
		//判断所有审批人是否都同意
		Collection<Approve> approves=this.approveService.getApprovesByOnlynumAndStage(project.getOnlynum(),project.getStage().getStageId());
		int flag=0;
		for (Approve approve2 : approves) {
			if(approve2.getStatus()==true){
				flag=1;
				continue;
			}else {
				flag=0;
				break;
			}
		}

		
		//全部审批通过
		if(flag==1) {
			Long stageId=project.getStage().getStageId();
			if (stageId==(this.projectStageService.getStageCount())) {  //判断是否已进入最后阶段
				//说明全部同意
				Project oldProject=this.projectService.getEntryById(pid);
				DateUtil dateUtil=new DateUtil();			
				BeanUtils.copyProperties(oldProject,project);
				project.setFreshDate(dateUtil.getCurrentTime());
				project.setStatus(2);		//0为推进中，1为审批中，2为完成
				ProjectStage stage=this.projectStageService.getEntryById(stageId);
				project.setStage(stage);			
				this.projectService.saveEntry(project);
			}else{
				//说明全部同意，进行下一阶段。项目的阶段变化，同时字段增加，需重新指定审批人
				Project oldProject=this.projectService.getEntryById(pid);
				DateUtil dateUtil=new DateUtil();

				BeanUtils.copyProperties(oldProject,project);
				project.setFreshDate(dateUtil.getCurrentTime());
				project.setFlag(true);		//为false不能在操作该项目,并且项目变为审批中
				project.setStatus(0);		//0为推进中，1为审批中，2为驳回
				project.setMark(false);    //进入下一阶段，审批人清空
				ProjectStage stage=this.projectStageService.getEntryById(stageId+1);
				project.setStage(stage);

				this.projectService.saveEntry(project);
			}

		}
		return "approveProject";

	}
	//不同意
	public String disapprove(){
		Long pid=Long.valueOf(ServletActionContext.getRequest().getParameter("pid"));
		Long uid=Long.valueOf(ServletActionContext.getRequest().getParameter("uid"));
		Long sid=Long.parseLong(ServletActionContext.getRequest().getParameter("stageId"));
		String onlynum=ServletActionContext.getRequest().getParameter("onlynum");
		String remark=ServletActionContext.getRequest().getParameter("remark");
		Approve approve=this.approveService.getApprovesByOnumAnduIdAndsId(onlynum, uid, sid);
		//approve.setStatus(false);
		approve.setRemark(remark);
		this.approveService.updateEntry(approve);
		Project project=this.projectService.getEntryById(pid);
		project.setStatus(0);//设置为推进中
		this.projectService.updateEntry(project);
		Json json=new Json();
		if(approve.getRemark()!=null||approve.getRemark()!=""){
			json.setSuccess(true);
			json.setMsg("驳回成功");
		}else {
			json.setSuccess(false);
			json.setMsg("驳回失败");
		}
		jsonUtil(json);
		return null;
	}
}
