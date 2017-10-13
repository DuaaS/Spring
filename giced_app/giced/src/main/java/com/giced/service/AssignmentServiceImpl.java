package com.giced.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;

import com.giced.dao.AssignmentDao;
import com.giced.model.Assignment;



public class AssignmentServiceImpl implements AssignmentService {
	
	@Autowired
	private AssignmentDao assignmentDao;

	@Autowired
	public AssignmentDao getAssignmentDao() {
		return assignmentDao;
	}

	@Autowired
	public void setAssignmentDao(AssignmentDao assignmentDao) {
		this.assignmentDao = assignmentDao;
	}

	@Override
	@Transactional
	public void addAssignment(Assignment assignment) {
		assignmentDao.addAssignment(assignment);
	}

	@Override
	@Transactional
	public void updateAssignment(Assignment assignment) {
		assignmentDao.updateAssignment(assignment);
	}

	@Override
	@Transactional
	public void removeAssignment(String id) {
		assignmentDao.removeAssignment(id);
	}

	@Override
	@Transactional
	public Assignment getAssignment(String id) {
		return assignmentDao.getAssignment(id);
	}

	@Override
	@Transactional
	public List<Assignment> getAssignments(Integer page) {
		return assignmentDao.getAssignments(page);
	}

	@Override
	@Transactional
	public List<Assignment> getAssignmentforData(String course_id, String subject_id, String faculty_id) {
		return assignmentDao.getAssignmentforData(course_id, subject_id, faculty_id);
	}

	@Override
	@Transactional
	public List<Assignment> getAssignmentforFaculty(String faculty_id) {
		return assignmentDao.getAssignmentforFaculty(faculty_id);
	}

	@Override
	@Transactional
	public List<Assignment> getAllAssignments() {
		return assignmentDao.getAllAssignments();
	}
	
	
	
	

	
}
