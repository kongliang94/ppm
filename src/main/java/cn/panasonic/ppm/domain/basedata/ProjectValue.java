package cn.panasonic.ppm.domain.basedata;

import java.io.Serializable;
import java.util.Set;

import cn.panasonic.ppm.domain.business.Project;

public class ProjectValue implements Serializable{
	private Long vid;
	private String description;
	private Set<Project> projects;
	public Set<Project> getProjects() {
		return projects;
	}
	public void setProjects(Set<Project> projects) {
		this.projects = projects;
	}
	public Long getVid() {
		return vid;
	}
	public void setVid(Long vid) {
		this.vid = vid;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
}
