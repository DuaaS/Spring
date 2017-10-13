package com.giced.service;

import java.util.List;

import com.giced.model.Faculty;

public interface FacultyService {

	void addFaculty(Faculty faculty);

    void updateFaculty(Faculty faculty);

    void removeFaculty(String id);

    Faculty getFaculty(String id);

    List<Faculty> getFaculties(Integer page);

    List<Faculty> getFaculties(String name);
    
    List<Faculty> getAllFaculties();
    
    Faculty getFacultybyUsername(String username);
}
