package com.giced.service;

import java.util.List;

import com.giced.model.Role;



public interface RoleService {

	void addRole(Role role);

    void updateRole(Role role);

    void removeRole(String id);

    Role getRole(String id);

    List<Role> getRoles(Integer page);

    List<Role> getAllRoles();
}
