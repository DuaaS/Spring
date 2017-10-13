package com.giced.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.giced.dao.UsersDao;
import com.giced.model.Users;

@Service
@Component
public class UsersServiceImpl implements UsersService {
	
	@Autowired
	private UsersDao userDao;

	@Autowired	
    public UsersDao getUserDao() {
		return userDao;
	}

	@Autowired
	public void setUserDao(UsersDao userDao) {
		this.userDao = userDao;
	}

	@Override
    @Transactional
	public void addUser(Users users) {
    	userDao.addUser(users);

	}

    @Override
    @Transactional
	public void updateUser(Users users){
    	userDao.updateUser(users);
	}

    @Override
    @Transactional
    public void removeUser(String id) {
    	userDao.removeUser(id);
	}

    @Override
    @Transactional
	public Users getUser(String id) {
		return userDao.getUser(id);
	}

    @Override
    @Transactional
	public List<Users> getUsers(Integer page){
    	return userDao.getUsers(page);
	}

    @Override
    @Transactional
	public List<Users> getUsers(String name) {
		return userDao.getUsers(name);
	}
    
    @Override
    @Transactional
	public List<Users> validateUser(String name,String pass) {
		return userDao.validateUser(name,pass);
	}

	@Override
	@Transactional
	public List<Users> getAllUsers() {
		return userDao.getAllUsers();
	}

}
