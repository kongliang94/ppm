package cn.panasonic.ppm.domain.basedata;

import java.io.Serializable;
import java.util.Set;

import cn.panasonic.ppm.domain.business.Project;


public class Department implements Serializable{
	private Long did;
	private String name;
	private String description;
	private Set<User> users;
	private Set<Project> projects;
	public Set<Project> getProjects() {
		return projects;
	}
	public void setProjects(Set<Project> projects) {
		this.projects = projects;
	}
	public Set<User> getUsers() {
		return users;
	}
	public void setUsers(Set<User> users) {
		this.users = users;
	}
	public Long getDid() {
		return did;
	}
	public void setDid(Long did) {
		this.did = did;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
}
