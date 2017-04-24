package cn.panasonic.ppm.domain.business;

import java.io.Serializable;
import java.util.Set;

import cn.panasonic.ppm.domain.basedata.Department;
import cn.panasonic.ppm.domain.basedata.ProjectStage;
import cn.panasonic.ppm.domain.basedata.ProjectValue;
import cn.panasonic.ppm.domain.basedata.User;

public class Project implements Serializable{
	
	 private Long pid;       
     private String name;			//项目名称
   
     private String freshDate;		//项目刷新日期
     public Long getPid() {
		return pid;
	}
	public void setPid(Long pid) {
		this.pid = pid;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getFreshDate() {
		return freshDate;
	}
	public void setFreshDate(String freshDate) {
		this.freshDate = freshDate;
	}
	public String getNumber() {
		return number;
	}
	public void setNumber(String number) {
		this.number = number;
	}
	public Float getSum() {
		return sum;
	}
	public void setSum(Float sum) {
		this.sum = sum;
	}
	public String getOnlynum() {
		return onlynum;
	}
	public void setOnlynum(String onlynum) {
		this.onlynum = onlynum;
	}
	
	public Integer getStatus() {
		return status;
	}
	public void setStatus(Integer status) {
		this.status = status;
	}
	
	
	public Boolean getFlag() {
		return flag;
	}
	public void setFlag(Boolean flag) {
		this.flag = flag;
	}
	 public String getDescription() {
			return description;
		}
		public void setDescription(String description) {
			this.description = description;
		}
	private String number;			//项目编号
     private Float sum;				//项目规模(金额)
     private String onlynum;		//项目唯一编号
    
     private Integer status;		//项目审批状态(共0,1,2)
     private String  description;
	private Department department;		//部门
	public Department getDepartment() {
		return department;
	}
	public void setDepartment(Department department) {
		this.department = department;
	}
	private ProjectStage stage;		//项目阶段
   
    
	public ProjectStage getStage() {
		return stage;
	}
	public void setStage(ProjectStage stage) {
		this.stage = stage;
	}
	private ProjectValue nyd;			//项目难易度
	
	
	public ProjectValue getNyd() {
		return nyd;
	}
	public void setNyd(ProjectValue nyd) {
		this.nyd = nyd;
	}
	private User user;
	
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	private Boolean flag;			//是否可修改
	private Boolean mark;			//是否有审批人
	public Boolean getMark() {
		return mark;
	}
	public void setMark(Boolean mark) {
		this.mark = mark;
	}
	
	private String round;   //范围
	public String getRound() {
		return round;
	}
	public void setRound(String round) {
		this.round = round;
	}
}
