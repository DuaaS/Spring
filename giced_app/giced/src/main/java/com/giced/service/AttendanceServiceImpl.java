package com.giced.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import com.giced.dao.AttendanceDao;
import com.giced.model.Attendance;




public class AttendanceServiceImpl implements AttendanceService {
	
	private AttendanceDao attendanceDao;
		
	@Autowired
	public AttendanceDao getAttendanceDao() {
		return attendanceDao;
	}

	@Autowired
	public void setAttendanceDao(AttendanceDao attendanceDao) {
		this.attendanceDao = attendanceDao;
	}

	@Override
	@Transactional
	public void addAttendance(Attendance attendance) {
		attendanceDao.addAttendance(attendance);
	}

	@Override
	@Transactional
	public Attendance getAttendance(String id) {
		return attendanceDao.getAttendance(id);
	}

	@Override
	@Transactional
	public List<Attendance> getAttendances(Integer page) {
		return attendanceDao.getAttendances(page);
	}

	@Override
	@Transactional
	public List<Attendance> getAttendanceforAssignment(String assignment_id) {
		return attendanceDao.getAttendanceforAssignment(assignment_id);
	}

	@Override
	@Transactional
	public void updateAttendance(Attendance attendance) {
		attendanceDao.updateAttendance(attendance);
	}

	@Override
	@Transactional
	public void removeAttendance(String id) {
		attendanceDao.removeAttendance(id);
	}

	@Override
	@Transactional
	public List<Attendance> getAllAttendance() {
		return attendanceDao.getAllAttendance();
	}

	/*@Override
	@Transactional
	public List<Attendance> getAttendanceforReport(String course_id, String subject_id,
			String faculty_id, String payment_check) {
		return attendanceDao.getAttendanceforReport(course_id, subject_id, faculty_id, payment_check);
	}
*/
	/*@Override
	@Transactional
	public List<AttendanceReport> getAllAttendances(String course_id, String subject_id, String faculty_id) {
		return attendanceDao.getAllAttendances(course_id, subject_id, faculty_id);
	}*/

	

	
}
