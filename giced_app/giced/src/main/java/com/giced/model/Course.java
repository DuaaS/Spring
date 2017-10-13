package com.giced.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "course")
public class Course {
	
    @Column(name = "institution_name")
    private String institution_name;

    @Id
    @Column(name = "course_id")
    private String course_id;
    
    @Column(name = "course_duration")
    private String course_duration;
    
    @Column(name = "course_title")
    private String course_title;
    
    @Column(name = "course_name")
    private String course_name;
    
    @Column(name = "revision_year")
    private String revision_year;
    
    @Column(name = "course_semister")
    private int course_semister;
    
    @Column(name = "course_hours")
    private int course_hours;
    
    @Column(name = "course_subjects")
    private String course_subjects;
    

	public String getInstitution_name() {
		return institution_name;
	}

	public void setInstitution_name(String institution_name) {
		this.institution_name = institution_name;
	}

	public String getCourse_id() {
		return course_id;
	}

	public void setCourse_id(String course_id) {
		this.course_id = course_id;
	}

	public String getCourse_duration() {
		return course_duration;
	}

	public void setCourse_duration(String course_duration) {
		this.course_duration = course_duration;
	}

	public String getCourse_title() {
		return course_title;
	}

	public void setCourse_title(String course_title) {
		this.course_title = course_title;
	}

	public String getCourse_name() {
		return course_name;
	}

	public void setCourse_name(String course_name) {
		this.course_name = course_name;
	}

	public String getRevision_year() {
		return revision_year;
	}

	public void setRevision_year(String revision_year) {
		this.revision_year = revision_year;
	}

	public int getCourse_semister() {
		return course_semister;
	}

	public void setCourse_semister(int course_semister) {
		this.course_semister = course_semister;
	}

	public int getCourse_hours() {
		return course_hours;
	}

	public void setCourse_hours(int course_hours) {
		this.course_hours = course_hours;
	}

	public String getCourse_subjects() {
		return course_subjects;
	}

	public void setCourse_subjects(String course_subjects) {
		this.course_subjects = course_subjects;
	}
	
	
    
}
