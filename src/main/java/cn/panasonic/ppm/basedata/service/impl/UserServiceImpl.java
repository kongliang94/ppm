package cn.panasonic.ppm.basedata.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import cn.panasonic.ppm.base.dao.BaseDao;
import cn.panasonic.ppm.base.service.impl.BaseServiceImpl;
import cn.panasonic.ppm.basedata.dao.UserDao;
import cn.panasonic.ppm.basedata.service.UserService;
import cn.panasonic.ppm.domain.basedata.User;

@Service("userService")
public class UserServiceImpl extends BaseServiceImpl<User> implements UserService{

	@Resource(name="userDao")
	private UserDao userDao;
	@Override
	public BaseDao getBaseDao() {
		return this.userDao;
	}
	@Override
	public User getUserByName(String logonname) {	
		return this.userDao.getUserByName(logonname);
	}
	@Override
	public boolean checkLogin(String logonname, String logonpwd) {
		return this.userDao.checkLogin(logonname,logonpwd);
	}

}
