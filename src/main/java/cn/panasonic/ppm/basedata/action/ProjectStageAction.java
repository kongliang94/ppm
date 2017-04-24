package cn.panasonic.ppm.basedata.action;

import java.util.Collection;

import javax.annotation.Resource;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import cn.panasonic.ppm.base.action.BaseAction;
import cn.panasonic.ppm.basedata.service.ProjectStageService;
import cn.panasonic.ppm.domain.basedata.ProjectStage;

@Controller("projectStageAction")
@Scope("prototype")
public class ProjectStageAction extends BaseAction<ProjectStage>{

	@Resource(name="projectStageService")
	private ProjectStageService projectStageService;
	
	public String showAllStage(){
		Collection<ProjectStage> stages=this.projectStageService.getEntries();
		putValuetoStack("stages", stages);
		return listAction;
	}
}
