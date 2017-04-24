package cn.panasonic.ppm.basedata.action;

import java.util.Collection;

import javax.annotation.Resource;


import org.springframework.beans.BeanUtils;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.opensymphony.xwork2.ActionContext;

import cn.panasonic.ppm.base.action.BaseAction;
import cn.panasonic.ppm.basedata.service.DepartmentService;
import cn.panasonic.ppm.basedata.service.UserService;
import cn.panasonic.ppm.basedata.util.Json;
import cn.panasonic.ppm.domain.basedata.Department;
import cn.panasonic.ppm.domain.basedata.User;
import cn.panasonic.ppm.query.PageResult;
import cn.panasonic.ppm.query.basedata.UserQuery;
@Controller("userAction")
@Scope("prototype")
public class UserAction extends BaseAction<User>{
	
	@Resource(name="userService")
	private UserService userService;
	@Resource(name="departmentService")
	private DepartmentService departmentService;
	UserQuery userQuery=new UserQuery();
	
    private Long did;//页面上的部门id
	
	public Long getDid() {
		return did;
	}

	public void setDid(Long did) {
		this.did = did;
	}

	public String login(){
		if(this.userService.checkLogin(this.getModel().getLogonname(),this.getModel().getLogonpwd())){
			User user=this.userService.getUserByName(this.getModel().getLogonname());
			saveSessionValue("username",user.getUsername());
			return "loginSuccess";
		}else {
			putValuetoStack("result", "2");
			return "loginFail";
		}
	}
	public String logout(){
		//清空session
		removeSessionValue("username");
		//跳转登录页面
		return "logout";
	}
	public String addUI(){
		/**
		 * 列出所有的部门
		 */
		Collection<Department> departments = this.departmentService.getEntries();
		putValuetoStack("departments", departments);
		return addUI;
	}
	public String view(){
		User user = this.userService.getEntryById(this.getModel().getUid());
		ActionContext.getContext().getValueStack().push(user);
		/**
		 * 回显部门
		 * action中的属性did在对象栈中，所以只需要给did赋值就可以了
		 */
		this.did = user.getDepartment().getDid();
		
		/**
		 * 把部门提取出来
		 */
		Collection<Department> departments = this.departmentService.getEntries();
		ActionContext.getContext().put("departments", departments);
		return "view";
	}
	public String add(){
		/**
		 * 1、获取用户的一般属性
		 * 2、获取页面上did的值，根据did的值把department对象提取出来
		 * 3、建立用户与部门之间的关系
		 */
		User user = new User();
		BeanUtils.copyProperties(this.getModel(), user);
		
		Department department = this.departmentService.getEntryById(this.did);
		
		
		//建立用户与部门之间的关系
		user.setDepartment(department);
		System.out.println(user.getDepartment().getName());
		//用户和部门，用户负责维护关系
		this.userService.saveEntry(user);
		return action2action;
	}
	
	public String updateUI(){
		/**
		 * 回显用户的一般属性
		 */
		User user = this.userService.getEntryById(this.getModel().getUid());
		ActionContext.getContext().getValueStack().push(user);
		
		/**
		 * 回显部门
		 * action中的属性did在对象栈中，所以只需要给did赋值就可以了
		 */
		this.did = user.getDepartment().getDid();
		
		/**
		 * 把部门提取出来
		 */
		Collection<Department> departments = this.departmentService.getEntries();
		ActionContext.getContext().put("departments", departments);
		return updateUI;
	}
	
	public String update(){
		/**
		 * 用户的一般属性
		 */
		User user = this.userService.getEntryById(this.getModel().getUid());
		BeanUtils.copyProperties(this.getModel(), user);//把用户的属性的新的值获取到了
		
		Department department = this.departmentService.getEntryById(this.did);//该用户重新选择的部门
		
		user.setDepartment(department);//建立用户与部门之间的关系
		
		this.userService.updateEntry(user);
		
		return action2action;
	}
	public String delete(){
		Json json = new Json();
		
		json.setSuccess(true);
		json.setMsg("取消成功");
		
		jsonUtil(json);
		return null;
	}
	public String showPageResult(){
		userQuery.setCurrentPage(currentPage);
		
		PageResult<User> userPageResult= this.userService.getPageResult(userQuery);
		
		putValuetoStack("users", userPageResult);//在BaseAction中封装的
		for (User user : userPageResult.getRows()) {
			System.out.println(user.getDepartment().getName());
		}
		Collection<Department> departments = this.departmentService.getEntries();
		putValuetoStack("departments", departments);
		return listAction;
	}
	
}
