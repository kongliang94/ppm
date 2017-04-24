package cn.panasonic.ppm.domain.privilege;

import java.io.Serializable;
import java.util.Set;

import cn.panasonic.ppm.domain.basedata.User;

public class Role implements Serializable{
	private Long rid;
	private Long pid;
	private String name;
	private Boolean isParent;//是否为父节点
	private Boolean Checked;
	public Long getRid() {
		return rid;
	}
	public void setRid(Long rid) {
		this.rid = rid;
	}
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
	public Boolean getIsParent() {
		return isParent;
	}
	public void setIsParent(Boolean isParent) {
		this.isParent = isParent;
	}
	public Boolean getChecked() {
		return Checked;
	}
	public void setChecked(Boolean checked) {
		Checked = checked;
	}
	public Set<User> getUsers() {
		return users;
	}
	public void setUsers(Set<User> users) {
		this.users = users;
	}
	private Set<User> users;
	private Set<Privilege> privileges;
	public Set<Privilege> getPrivileges() {
		return privileges;
	}
	public void setPrivileges(Set<Privilege> privileges) {
		this.privileges = privileges;
	}
}
