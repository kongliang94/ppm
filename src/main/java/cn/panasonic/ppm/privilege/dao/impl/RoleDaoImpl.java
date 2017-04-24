package cn.panasonic.ppm.privilege.dao.impl;

import org.springframework.stereotype.Repository;

import cn.panasonic.ppm.base.dao.impl.BaseDaoImpl;
import cn.panasonic.ppm.domain.privilege.Role;
import cn.panasonic.ppm.privilege.dao.RoleDao;
@Repository("roleDao")
public class RoleDaoImpl extends BaseDaoImpl<Role> implements RoleDao{

}
