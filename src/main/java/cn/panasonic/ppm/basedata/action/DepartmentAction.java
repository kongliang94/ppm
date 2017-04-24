package cn.panasonic.ppm.basedata.action;

import javax.annotation.Resource;

import org.springframework.beans.BeanUtils;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.opensymphony.xwork2.ActionContext;

import cn.panasonic.ppm.base.action.BaseAction;
import cn.panasonic.ppm.basedata.service.DepartmentService;
import cn.panasonic.ppm.domain.basedata.Department;
import cn.panasonic.ppm.query.PageResult;
import cn.panasonic.ppm.query.basedata.DepartmentQuery;

@Controller("departmentAction")
@Scope("prototype")
public class DepartmentAction extends BaseAction<Department>{
	@Resource(name="departmentService")
	private DepartmentService departmentService;
	private DepartmentQuery baseQuery=new DepartmentQuery();
	public String showPageResult(){
		baseQuery.setCurrentPage(currentPage);
		PageResult<Department> departments=this.departmentService.getPageResult(baseQuery);
		ActionContext.getContext().put("departments", departments);
		return listAction;
	}
	public String add(){
		Department department=new Department();
		BeanUtils.copyProperties(this.getModel(),department);
		this.departmentService.saveEntry(department);
		return action2action;
	}
	public String updateUI(){
		Department department=this.departmentService.getEntryById(this.getModel().getDid());
		ActionContext.getContext().getValueStack().push(department);
		return updateUI;
	}
	public String update(){
		Department department=this.departmentService.getEntryById(this.getModel().getDid());
		BeanUtils.copyProperties(this.getModel(), department);
		this.departmentService.updateEntry(department);
		return action2action;
	}
}
