package cn.panasonic.ppm.basedata.action;

import java.util.Collection;

import javax.annotation.Resource;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import cn.panasonic.ppm.base.action.BaseAction;
import cn.panasonic.ppm.basedata.service.ProjectValueService;
import cn.panasonic.ppm.domain.basedata.ProjectValue;

@Controller("projectValueAction")
@Scope("prototype")
public class ProjectValueAction extends BaseAction<ProjectValue>{

	@Resource(name="projectValueService")
	private ProjectValueService projectValueService;
	
	public String showAllStage(){
		Collection<ProjectValue> values=this.projectValueService.getEntries();
		putValuetoStack("values", values);
		return listAction;
	}
}
