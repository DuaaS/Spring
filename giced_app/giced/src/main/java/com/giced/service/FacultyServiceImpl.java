package com.giced.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.giced.dao.FacultyDao;
import com.giced.model.Faculty;

@Service
@Component
public class FacultyServiceImpl implements FacultyService {
	
	@Autowired
	private FacultyDao facultyDao;

	@Autowired
	public FacultyDao getFacultyDao() {
		return facultyDao;
	}

	@Autowired
	public void setFacultyDao(FacultyDao facultyDao) {
		this.facultyDao = facultyDao;
	}

	@Override
    @Transactional
	public void addFaculty(Faculty faculty) {
    	facultyDao.addFaculty(faculty);

	}

    @Override
    @Transactional
	public void updateFaculty(Faculty faculty)  {
    	facultyDao.updateFaculty(faculty);
	}

    @Override
    @Transactional
    public void removeFaculty(String id) {
    	facultyDao.removeFaculty(id);
	}

    @Override
    @Transactional
	public Faculty getFaculty(String id) {
		return facultyDao.getFaculty(id);
	}

    @Override
    @Transactional
	public List<Faculty> getFaculties(Integer page) {
    	return facultyDao.getFaculties(page);
	}

    @Override
    @Transactional
	public List<Faculty> getFaculties(String name) {
		return facultyDao.getFaculties(name);
	}

	@Override
	@Transactional
	public List<Faculty> getAllFaculties() {
		return facultyDao.getAllFaculties();
	}

	@Override
	@Transactional
	public Faculty getFacultybyUsername(String username) {
		return facultyDao.getFacultybyUsername(username);
	}

}
