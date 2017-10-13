package com.giced.service;

import java.util.List;

import com.giced.model.Users;



public interface UsersService {

	void addUser(Users users);

    void updateUser(Users users);

    void removeUser(String id);

    Users getUser(String id);

    List<Users> getUsers(Integer page);

    List<Users> getUsers(String name);
    
    List<Users> getAllUsers();
    
    List<Users> validateUser(String name,String pass);
}
