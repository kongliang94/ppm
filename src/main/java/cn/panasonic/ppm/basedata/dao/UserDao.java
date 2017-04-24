package cn.panasonic.ppm.basedata.dao;

import cn.panasonic.ppm.base.dao.BaseDao;
import cn.panasonic.ppm.domain.basedata.User;

public interface UserDao extends BaseDao<User>{
	
	public User getUserByName(final String logonname);

	public boolean checkLogin(String logonname, String logonpwd);
	public Long getUserCountByName(final String logonname,final  String logonpwd);
}
