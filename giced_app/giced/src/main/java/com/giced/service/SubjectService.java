package com.giced.service;

import java.util.List;


import com.giced.model.Subject;



public interface SubjectService {

	void addSubject(Subject subject);

    void updateSubject(Subject subject);

    void removeSubject(String id);

    Subject getSubject(String id);

    List<Subject> getSubjects(Integer page);

    List<Subject> getAllSubjects();
}
