package cn.panasonic.ppm.basedata;

import org.junit.Test;

import cn.panasonic.ppm.basedata.dao.DepartmentDao;
import cn.panasonic.ppm.basedata.dao.ProjectStageDao;
import cn.panasonic.ppm.basedata.service.DepartmentService;
import cn.panasonic.ppm.basedata.service.ProjectStageService;
import cn.panasonic.ppm.business.service.ProjectService;
import cn.panasonic.ppm.domain.basedata.Department;
import cn.panasonic.ppm.domain.basedata.ProjectStage;
import cn.panasonic.ppm.domain.business.Project;
import cn.panasonic.ppm.query.PageResult;
import cn.panasonic.ppm.query.basedata.DepartmentQuery;


public class DepartmentTest extends SpringUtils{
	@Test
	public void testGetCount(){
		DepartmentDao departmentDao = (DepartmentDao)context.getBean("departmentDao");
		DepartmentQuery baseQuery = new DepartmentQuery();
		//baseQuery.setName("2");
		int count = departmentDao.getCount(baseQuery);
		System.out.println(count);
	}
	@Test
	public void testGetData(){
		DepartmentDao departmentDao = (DepartmentDao)context.getBean("departmentDao");
		DepartmentQuery baseQuery = new DepartmentQuery();
		baseQuery.setCurrentPage(2);
		PageResult<Department> result = departmentDao.findPageResult(baseQuery);
		for (Department department : result.getRows()) {
			System.out.println(department.getDid());
		}
		//System.out.println(result);
	}
	@Test
	public void testSaveDepartment(){
		DepartmentService departmentService = (DepartmentService)context.getBean("departmentService");
		Department department=new Department();
		department.setName("销售部");
		department.setDescription("命脉");
		departmentService.saveEntry(department);
	}
	@Test
	public void testSaveStage(){
		ProjectStageService projectStageService=(ProjectStageService) context.getBean("projectStageService");
		ProjectStage projectStage1=new ProjectStage();
		projectStage1.setStageId(1L);
		projectStage1.setName("企划");
		projectStageService.saveEntry(projectStage1);
		
		
		ProjectStage projectStage2=new ProjectStage();
		projectStage2.setStageId(2L);
		projectStage2.setName("设计");
		projectStageService.saveEntry(projectStage2);
		
		
		ProjectStage projectStage3=new ProjectStage();
		projectStage3.setStageId(3L);
		projectStage3.setName("测试");
		projectStageService.saveEntry(projectStage3);
		
		
		ProjectStage projectStage4=new ProjectStage();
		projectStage4.setStageId(4L);
		
		projectStage4.setName("本番判定");
		projectStageService.saveEntry(projectStage4);
	}
	@Test
	public void testCountStage(){
		ProjectStageService projectStageService=(ProjectStageService) context.getBean("projectStageService");
		System.out.println(projectStageService.getStageCount());
//		ProjectStageDao projectStageDao=(ProjectStageDao) context.getBean("projectStageDao");
//		System.out.println(projectStageDao.getCount(null));
	}
		
@Test
public void testUpdateStage(){
	ProjectService projectService=(ProjectService) context.getBean("projectService");
	Project project=projectService.getEntryById(4L);
	project.setName("本番判定");
	projectService.updateEntry(project);
}
}
