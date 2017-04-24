package cn.panasonic.ppm.business.action;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.net.URLDecoder;
import java.util.Collection;

import javax.annotation.Resource;

import org.apache.commons.io.FileUtils;
import org.apache.commons.io.FilenameUtils;
import org.apache.struts2.ServletActionContext;
import org.apache.struts2.util.TokenHelper;
import org.aspectj.weaver.patterns.ThisOrTargetAnnotationPointcut;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import cn.panasonic.ppm.base.action.BaseAction;
import cn.panasonic.ppm.business.service.FileService;
import cn.panasonic.ppm.business.service.ProjectService;
import cn.panasonic.ppm.business.util.DateUtil;
import cn.panasonic.ppm.domain.basedata.User;
import cn.panasonic.ppm.domain.business.Project;
import cn.panasonic.ppm.domain.business.ResultFile;

import com.opensymphony.xwork2.ActionSupport;
@Controller("fileAction")
@Scope("prototype")
public class FileAction extends BaseAction<ResultFile>{
	
	@Resource(name="fileService")
	private FileService fileService;
	private File file;
	
	private String fileFileName;

	public File getFile() {
		return file;
	}
	public void setFile(File file) {
		this.file = file;
	}
	public String getFileFileName() {
		return fileFileName;
	}
	public void setFileFileName(String fileFileName) {
		this.fileFileName = fileFileName;
	}
	public String getFileContentType() {
		return fileContentType;
	}
	public void setFileContentType(String fileContentType) {
		this.fileContentType = fileContentType;
	}
	private String fileContentType;
	
	
	
	//为下载提供全局参数
		private String name;
		private String dir;
	
	public String  uploadUI(){
		
		return "uploadUI";
	}
	public String  upload(){
		ResultFile resultFile=new ResultFile();
		String filePath=ServletActionContext.getRequest().getParameter("filePath");
		Long stageid=Long.valueOf(ServletActionContext.getRequest().getParameter("stage"));
		resultFile.setFileName(fileFileName);
		resultFile.setFilePath(filePath+"/"+stageid);
		
		User user=(User) loadSessionValue("user");
		resultFile.setLogonName(user.getUsername());   //设置登录用户名
		resultFile.setStageId(stageid);					//设置阶段id
		resultFile.setOnlynum(filePath);				//文件路径，这里如果重新部署，文件会缺失。需要注意
		//resultFile.setLogonName(ServletActionContext.getRequest().getSession().getAttribute("name").toString());
		DateUtil dateUtil=new DateUtil();
		resultFile.setUploadDate(dateUtil.getCurrentTime());
		if(file!=null){
			//文件上传
			//文件上传的真实路径
			String realPath = ServletActionContext.getServletContext().getRealPath("/"+filePath+"/"+stageid);
			File storeDirectory = new File(realPath);
			if(!storeDirectory.exists()){
				storeDirectory.mkdirs();
			}		

			try {
				FileUtils.copyFile(file, new File(storeDirectory, fileFileName));
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		//把成果物信息保存
		this.fileService.saveEntry(resultFile);
		//把成果物信息放在值栈顶，在列表显示
		
		return null;
	}
	
	public String download(){
		name=ServletActionContext.getRequest().getParameter("name");
		dir=ServletActionContext.getRequest().getParameter("dir");
		try {
			name=URLDecoder.decode(name,"utf-8");
			fileFileName=name;
			fileFileName=new String(fileFileName.getBytes(),"iso8859-1");
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "download";
	}
	/**
	 * 获取下载文件的输入流，这里的方法必须与stuts配置文件一致
	 * @return
	 */
	public InputStream getInStream(){
		return ServletActionContext.getServletContext().getResourceAsStream(dir+"/"+fileFileName);
	}
}
