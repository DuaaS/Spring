package com.giced.dao;

import java.util.List;

import com.giced.model.Assignment;



public interface AssignmentDao {
	
	void addAssignment(Assignment assignment);

    void updateAssignment(Assignment assignment);

    void removeAssignment(String id);

    Assignment getAssignment(String id);

    List<Assignment> getAssignments(Integer page);
    
    List<Assignment> getAllAssignments();
    
    List<Assignment> getAssignmentforData(String course_id,String subject_id,String faculty_id);
    
    List<Assignment> getAssignmentforFaculty(String faculty_id);
    
}
