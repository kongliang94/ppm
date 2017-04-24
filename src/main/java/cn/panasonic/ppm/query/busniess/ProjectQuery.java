package cn.panasonic.ppm.query.busniess;

import java.util.Map;

import org.apache.commons.lang.StringUtils;

import cn.panasonic.ppm.query.BaseQuery;

public class ProjectQuery extends BaseQuery{

	private String name;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	@Override
	public Map<String, Object> buildWhere() {
		if (StringUtils.isNotBlank(this.name)) {
			this.getKeyValues().put("name", name);
		}
		//this.getKeyValues().put("mark",true); //判断该项目是否显示
		
		return this.getKeyValues();
	}

}
