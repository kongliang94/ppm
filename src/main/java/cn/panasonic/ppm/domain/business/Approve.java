package cn.panasonic.ppm.domain.business;

import java.io.Serializable;
import java.util.Set;

import cn.panasonic.ppm.domain.basedata.User;

public class Approve  implements Serializable {


  

     private Long id;
     private String onlynum;
     
     private Long stageId;
     private Boolean status;
     private String remark;
//     private Long userId;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getOnlynum() {
		return onlynum;
	}
	public void setOnlynum(String onlynum) {
		this.onlynum = onlynum;
	}
	public Long getStageId() {
		return stageId;
	}
	public void setStageId(Long stageId) {
		this.stageId = stageId;
	}
	public Boolean getStatus() {
		return status;
	}
	public void setStatus(Boolean status) {
		this.status = status;
	}
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}

	
	private  User user;
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	

}