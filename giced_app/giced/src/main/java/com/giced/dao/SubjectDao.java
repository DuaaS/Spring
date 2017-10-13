package com.giced.dao;

import java.util.List;

import com.giced.model.Subject;



public interface SubjectDao {
	
	void addSubject(Subject subject);

    void updateSubject(Subject subject);

    void removeSubject(String id);

    Subject getSubject(String id);

    List<Subject> getSubjects(Integer page);

    List<Subject> getAllSubjects();

}
