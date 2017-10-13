package com.giced.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "assignment")
public class Assignment {
	
    @Id
    @Column(name = "assignment_id")
    private String assignment_id;
    
    @Column(name = "course_id")
    private String course_id;
    
    @Column(name = "subject_id")
    private String subject_id;
    
    @Column(name = "faculty_id")
    private String faculty_id;
    
    @Column(name = "assigned_duration")
    private String assigned_duration;
    
    @Column(name = "pending_duration")
    private String pending_duration;
    
    @Column(name = "start_date")
    private Date start_date;
    
    @Column(name = "end_date")
    private Date end_date;

	public String getAssignment_id() {
		return assignment_id;
	}

	public void setAssignment_id(String assignment_id) {
		this.assignment_id = assignment_id;
	}

	public String getCourse_id() {
		return course_id;
	}

	public void setCourse_id(String course_id) {
		this.course_id = course_id;
	}

	public String getSubject_id() {
		return subject_id;
	}

	public void setSubject_id(String subject_id) {
		this.subject_id = subject_id;
	}

	public String getFaculty_id() {
		return faculty_id;
	}

	public void setFaculty_id(String faculty_id) {
		this.faculty_id = faculty_id;
	}

	public String getAssigned_duration() {
		return assigned_duration;
	}

	public void setAssigned_duration(String assigned_duration) {
		this.assigned_duration = assigned_duration;
	}

	public String getPending_duration() {
		return pending_duration;
	}

	public void setPending_duration(String pending_duration) {
		this.pending_duration = pending_duration;
	}

	public Date getStart_date() {
		return start_date;
	}

	public void setStart_date(Date start_date) {
		this.start_date = start_date;
	}

	public Date getEnd_date() {
		return end_date;
	}

	public void setEnd_date(Date end_date) {
		this.end_date = end_date;
	}
    
    
}
