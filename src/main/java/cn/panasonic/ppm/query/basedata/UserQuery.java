package cn.panasonic.ppm.query.basedata;

import java.util.Map;

import org.apache.commons.lang.StringUtils;

import cn.panasonic.ppm.query.BaseQuery;

public class UserQuery extends BaseQuery{

	private String username;
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	@Override
	public Map<String, Object> buildWhere() {
		if(StringUtils.isNotBlank(this.username)){
			this.getKeyValues().put("username", this.username);
		}
		return this.getKeyValues();
	}

}
