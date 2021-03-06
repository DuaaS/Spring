package com.giced.service;

import java.util.List;

import com.giced.model.Course;



public interface CourseService {

	void addCourse(Course course);

    void updateCourse(Course course);

    void removeCourse(String id);

    Course getCourse(String id);

    List<Course> getCourses(Integer page);

    List<Course> getAllCourses();
    
    
}
