package cn.panasonic.ppm.privilege.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import cn.panasonic.ppm.base.dao.BaseDao;
import cn.panasonic.ppm.base.service.impl.BaseServiceImpl;
import cn.panasonic.ppm.domain.privilege.Role;
import cn.panasonic.ppm.privilege.dao.RoleDao;
import cn.panasonic.ppm.privilege.service.RoleService;
@Service("roleService")
public class RoleServiceImpl extends BaseServiceImpl<Role> implements RoleService{

	@Resource(name="roleDao")
	private RoleDao roleDao;
	@Override
	public BaseDao getBaseDao() {
		// TODO Auto-generated method stub
		return this.roleDao;
	}

}
