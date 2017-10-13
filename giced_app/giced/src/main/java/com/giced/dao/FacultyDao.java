package com.giced.dao;

import java.util.List;

import com.giced.model.Faculty;

public interface FacultyDao {

	void addFaculty(Faculty faculty);

    void updateFaculty(Faculty faculty);

    void removeFaculty(String id);

    Faculty getFaculty(String id);

    List<Faculty> getFaculties(Integer page);

    List<Faculty> getFaculties(String name);
    
    List<Faculty> getAllFaculties();
    
    Faculty getFacultybyUsername(String username);
	
}
