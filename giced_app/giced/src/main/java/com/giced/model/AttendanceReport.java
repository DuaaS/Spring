package com.giced.model;

public class AttendanceReport {
	

	//private long id;

	private String assignment_id;
	
	private String course;
	
	private String subject;
	
	private String faculty;
    
    //private Date date;
    
    //private String in_time;
    
    //private String out_time;
    
    private String completed_hours;
    
    private String assigned_hours;
    
    private String pending_hours;
    
    private String is_completed;
    
    private String payment_check;
    
   

	public String getAssignment_id() {
		return assignment_id;
	}

	public void setAssignment_id(String assignment_id) {
		this.assignment_id = assignment_id;
	}

	public String getCourse() {
		return course;
	}

	public void setCourse(String course) {
		this.course = course;
	}

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	public String getFaculty() {
		return faculty;
	}

	public void setFaculty(String faculty) {
		this.faculty = faculty;
	}

	public String getCompleted_hours() {
		return completed_hours;
	}

	public void setCompleted_hours(String completed_hours) {
		this.completed_hours = completed_hours;
	}

	public String getAssigned_hours() {
		return assigned_hours;
	}

	public void setAssigned_hours(String assigned_hours) {
		this.assigned_hours = assigned_hours;
	}

	public String getPending_hours() {
		return pending_hours;
	}

	public void setPending_hours(String pending_hours) {
		this.pending_hours = pending_hours;
	}
	
	public String getIs_completed() {
		return is_completed;
	}

	public void setIs_completed(String is_completed) {
		this.is_completed = is_completed;
	}


	public String getPayment_check() {
		return payment_check;
	}

	public void setPayment_check(String payment_check) {
		this.payment_check = payment_check;
	}

	
    
}
