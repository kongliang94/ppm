package cn.panasonic.ppm.domain.basedata;

import java.io.Serializable;
import java.util.Set;

import cn.panasonic.ppm.domain.business.Approve;
import cn.panasonic.ppm.domain.business.Project;
import cn.panasonic.ppm.domain.privilege.Role;

public class User implements Serializable{
	private Long uid;
	private String logonname;
	private String logonpwd;
	private String username;
	public Long getUid() {
		return uid;
	}
	public void setUid(Long uid) {
		this.uid = uid;
	}
	public String getLogonname() {
		return logonname;
	}
	public void setLogonname(String logonname) {
		this.logonname = logonname;
	}
	public String getLogonpwd() {
		return logonpwd;
	}
	public void setLogonpwd(String logonpwd) {
		this.logonpwd = logonpwd;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public Long getDutyId() {
		return dutyId;
	}
	public void setDutyId(Long dutyId) {
		this.dutyId = dutyId;
	}
	public Byte getApprovemark() {
		return approvemark;
	}
	public void setApprovemark(Byte approvemark) {
		this.approvemark = approvemark;
	}
	
	private String email;
	private String phone;
	private Long dutyId;
	//private String company;
	private Byte approvemark;
	 
	private Set<Role> roles;
	public Set<Role> getRoles() {
		return roles;
	}
	public void setRoles(Set<Role> roles) {
		this.roles = roles;
	}
	private Department department;
	public Department getDepartment() {
		return department;
	}
	public void setDepartment(Department department) {
		this.department = department;
	}
	
	private Set<Approve> approves;
	public Set<Approve> getApproves() {
		return approves;
	}
	public void setApproves(Set<Approve> approves) {
		this.approves = approves;
	}
	private Set<Project> projects;
	public Set<Project> getProjects() {
		return projects;
	}
	public void setProjects(Set<Project> projects) {
		this.projects = projects;
	}
}
