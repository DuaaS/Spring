package com.giced.dao;

import java.util.List;

import com.giced.model.Attendance;

public interface AttendanceDao {
	
	void addAttendance(Attendance attendance);
	
	void updateAttendance(Attendance attendance);

    void removeAttendance(String id);
	
	Attendance getAttendance(String id);
	
	List<Attendance> getAttendances(Integer page);
	
	List<Attendance> getAllAttendance();
	
	List<Attendance> getAttendanceforAssignment(String assignment_id);
	
	
}
