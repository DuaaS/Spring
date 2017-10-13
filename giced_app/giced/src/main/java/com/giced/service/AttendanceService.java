package com.giced.service;

import java.util.List;

import com.giced.model.Attendance;



public interface AttendanceService {

	void addAttendance(Attendance attendance);
	
	void updateAttendance(Attendance attendance);

    void removeAttendance(String id);
	
	Attendance getAttendance(String id);
	
	List<Attendance> getAttendances(Integer page);
	
	List<Attendance> getAllAttendance();
	
	List<Attendance> getAttendanceforAssignment(String assignment_id);
	
	/*List<Attendance> getAttendanceforReport(String course_id,String subject_id,String faculty_id, String payment_check);*/
	
	/*List<AttendanceReport> getAllAttendances(String course_id,String subject_id,String faculty_id);*/

    /*SubCaste getSubCaste(String id);

    List<SubCaste> getSubCastes(Integer page);

    List<SubCaste> getSubCasteforCaste(String caste_id);
    
    List<SubCaste> getAllSubCastes();*/
}
