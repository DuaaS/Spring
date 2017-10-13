package com.giced.dao;

import java.util.List;

import com.giced.model.Role;




public interface RoleDao {
	void addRole(Role role);

    void updateRole(Role role);

    void removeRole(String id);

    Role getRole(String id);

    List<Role> getRoles(Integer page);

    List<Role> getAllRoles();

}
