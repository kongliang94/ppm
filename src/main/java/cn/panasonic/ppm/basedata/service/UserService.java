package cn.panasonic.ppm.basedata.service;

import cn.panasonic.ppm.base.service.BaseService;
import cn.panasonic.ppm.domain.basedata.User;

public interface UserService extends BaseService<User>{

	public User getUserByName(String logonname);

	public boolean checkLogin(String logonname, String logonpwd);
}
