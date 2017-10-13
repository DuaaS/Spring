package com.giced.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "attendance")
public class Attendance {
	

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name = "id")
    private long id;

	@Column(name = "assignment_id")
    private String assignment_id;
    
    @Column(name = "date")
    private Date date;
    
    @Column(name = "in_time")
    private String in_time;
    
    @Column(name = "out_time")
    private String out_time;
    
    @Column(name = "completed_hours")
    private String completed_hours;
    
    @Column(name = "payment_check")
    private String payment_check;

	public String getAssignment_id() {
		return assignment_id;
	}

	public void setAssignment_id(String assignment_id) {
		this.assignment_id = assignment_id;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	

	public String getIn_time() {
		return in_time;
	}

	public void setIn_time(String in_time) {
		this.in_time = in_time;
	}

	public String getOut_time() {
		return out_time;
	}

	public void setOut_time(String out_time) {
		this.out_time = out_time;
	}

	public String getCompleted_hours() {
		return completed_hours;
	}

	public void setCompleted_hours(String completed_hours) {
		this.completed_hours = completed_hours;
	}

	public String getPayment_check() {
		return payment_check;
	}

	public void setPayment_check(String payment_check) {
		this.payment_check = payment_check;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	
    
    
}
