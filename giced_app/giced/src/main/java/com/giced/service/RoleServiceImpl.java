package com.giced.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.giced.dao.RoleDao;
import com.giced.model.Role;

@Service
@Component
public class RoleServiceImpl implements RoleService {
	
	@Autowired
	private RoleDao roleDao;

	@Autowired
		public RoleDao getRoleDao() {
		return roleDao;
	}

	@Autowired
	public void setRoleDao(RoleDao roleDao) {
		this.roleDao = roleDao;
	}

	@Override
    @Transactional
	public void addRole(Role role) {
		roleDao.addRole(role);
	}

    @Override
    @Transactional
	public void updateRole(Role role){
    	roleDao.updateRole(role);
	}

    @Override
    @Transactional
    public void removeRole(String id) {
    	roleDao.removeRole(id);
	}

    @Override
    @Transactional
	public Role getRole(String id) {
		return roleDao.getRole(id);
	}

    @Override
    @Transactional
	public List<Role> getRoles(Integer page){
    	return roleDao.getRoles(page);
	}

    @Override
    @Transactional
	public List<Role> getAllRoles() {
		return roleDao.getAllRoles();
	}

}
