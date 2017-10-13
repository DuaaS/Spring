package com.giced.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.giced.dao.CourseDao;
import com.giced.model.Course;

@Service
@Component
public class CourseServiceImpl implements CourseService {
	
	@Autowired
	private CourseDao courseDao;

	@Autowired
	public CourseDao getCourseDao() {
		return courseDao;
	}

	@Autowired
	public void setCourseDao(CourseDao courseDao) {
		this.courseDao = courseDao;
	}

	@Override
    @Transactional
	public void addCourse(Course course) {
    	courseDao.addCourse(course);

	}

    @Override
    @Transactional
	public void updateCourse(Course course){
    	courseDao.updateCourse(course);
	}

    @Override
    @Transactional
    public void removeCourse(String id) {
    	courseDao.removeCourse(id);
	}

    @Override
    @Transactional
	public Course getCourse(String id) {
		return courseDao.getCourse(id);
	}

    @Override
    @Transactional
	public List<Course> getCourses(Integer page){
    	return courseDao.getCourses(page);
	}

 	    
    @Override
    @Transactional
	public List<Course> getAllCourses() {
		return courseDao.getAllCourses();
	}

    

}
