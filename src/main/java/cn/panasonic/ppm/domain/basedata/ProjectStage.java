package cn.panasonic.ppm.domain.basedata;

import java.io.Serializable;
import java.util.Set;

import cn.panasonic.ppm.domain.business.Project;

public class ProjectStage implements Serializable{
	private Long id;
	private Long stageId;
	private String name;
	private String description;
	private Set<Project> projects;
	public Set<Project> getProjects() {
		return projects;
	}
	public void setProjects(Set<Project> projects) {
		this.projects = projects;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Long getStageId() {
		return stageId;
	}
	public void setStageId(Long stageId) {
		this.stageId = stageId;
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
