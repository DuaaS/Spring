package com.giced.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "faculty")
public class Faculty {

	@Id
    @Column(name = "faculty_id")
    private String faculty_id;
	
	@Column(name = "faculty_designation")
    private String faculty_designation;
	
	@Column(name = "faculty_abbreviation")
    private String faculty_abbreviation;
	
	@Column(name = "faculty_firstname")
    private String faculty_firstname;
	
	@Column(name = "faculty_middlename")
    private String faculty_middlename;
	
	@Column(name = "faculty_lastname")
    private String faculty_lastname;
	
	@Column(name = "faculty_dob")
    private Date faculty_dob;
	
	@Column(name = "faculty_age")
    private int faculty_age;
	
	@Column(name = "faculty_gender")
    private String faculty_gender;
	
	@Column(name = "faculty_nationality")
    private int faculty_nationality;
	

	@Column(name = "faculty_caste")
    private String faculty_caste;
	
	@Column(name = "faculty_subcaste")
    private String faculty_subcaste;
	
	@Column(name = "faculty_category")
    private String faculty_category;
	
	@Column(name = "faculty_marital_status")
    private String faculty_marital_status;
	
	@Column(name = "faculty_building")
    private String faculty_building;
	
	@Column(name = "faculty_street")
    private String faculty_street;
	
	@Column(name = "faculty_area")
    private String faculty_area;
	
	@Column(name = "faculty_station")
    private String faculty_station;
	
	@Column(name = "faculty_city")
    private String faculty_city;
	
	@Column(name = "faculty_state")
    private String faculty_state;
	
	@Column(name = "faculty_pincode")
    private String faculty_pincode;
	
	@Column(name = "faculty_mobile")
    private String faculty_mobile;
	
	@Column(name = "faculty_alt_mobile")
    private String faculty_alt_mobile;
	
	@Column(name = "faculty_telephone")
    private String faculty_telephone;
	
	@Column(name = "faculty_email")
    private String faculty_email;
	
	@Column(name = "faculty_alt_email")
    private String faculty_alt_email;
	
	@Column(name = "faculty_pan")
    private String faculty_pan;
	
	@Column(name = "faculty_aadhar")
    private String faculty_aadhar;
	
	@Column(name = "faculty_bank_name")
    private String faculty_bank_name;
	
	@Column(name = "faculty_bank_account_no")
    private String faculty_bank_account_no;
	
	@Column(name = "faculty_bank_branch")
    private String faculty_bank_branch;
	
	@Column(name = "faculty_bank_ifsc")
    private String faculty_bank_ifsc;
	
	@Column(name = "faculty_degree")
    private String faculty_degree;
	
	@Column(name = "faculty_specialization")
    private String faculty_specialization;
	
	@Column(name = "faculty_masters")
    private String faculty_masters;
	
	@Column(name = "faculty_masters_specialization")
    private String faculty_masters_specialization;
	
	@Column(name = "faculty_phd")
    private String faculty_phd;
	
	@Column(name = "faculty_phd_specialization")
    private String faculty_phd_specialization;
	
	@Column(name = "faculty_experience")
    private String faculty_experience;
	
	
	@Column(name = "faculty_exp_type")
    private String faculty_exp_type;
	
	@Column(name = "faculty_appointment_type")
    private String faculty_appointment_type;
	
	@Column(name = "user_name")
    private String user_name;
	
	public String getUser_name() {
		return user_name;
	}

	public void setUser_name(String user_name) {
		this.user_name = user_name;
	}

	public String getFaculty_id() {
		return faculty_id;
	}

	public void setFaculty_id(String faculty_id) {
		this.faculty_id = faculty_id;
	}

	public String getFaculty_designation() {
		return faculty_designation;
	}

	public void setFaculty_designation(String faculty_designation) {
		this.faculty_designation = faculty_designation;
	}

	public String getFaculty_abbreviation() {
		return faculty_abbreviation;
	}

	public void setFaculty_abbreviation(String faculty_abbreviation) {
		this.faculty_abbreviation = faculty_abbreviation;
	}

	public String getFaculty_firstname() {
		return faculty_firstname;
	}

	public void setFaculty_firstname(String faculty_firstname) {
		this.faculty_firstname = faculty_firstname;
	}

	public String getFaculty_middlename() {
		return faculty_middlename;
	}

	public void setFaculty_middlename(String faculty_middlename) {
		this.faculty_middlename = faculty_middlename;
	}

	public String getFaculty_lastname() {
		return faculty_lastname;
	}

	public void setFaculty_lastname(String faculty_lastname) {
		this.faculty_lastname = faculty_lastname;
	}

	public Date getFaculty_dob() {
		return faculty_dob;
	}

	public void setFaculty_dob(Date faculty_dob) {
		this.faculty_dob = faculty_dob;
	}

	public int getFaculty_age() {
		return faculty_age;
	}

	public void setFaculty_age(int faculty_age) {
		this.faculty_age = faculty_age;
	}

	public String getFaculty_gender() {
		return faculty_gender;
	}

	public void setFaculty_gender(String faculty_gender) {
		this.faculty_gender = faculty_gender;
	}

	
	public int getFaculty_nationality() {
		return faculty_nationality;
	}

	public void setFaculty_nationality(int faculty_nationality) {
		this.faculty_nationality = faculty_nationality;
	}


	public String getFaculty_caste() {
		return faculty_caste;
	}

	public void setFaculty_caste(String faculty_caste) {
		this.faculty_caste = faculty_caste;
	}

	public String getFaculty_subcaste() {
		return faculty_subcaste;
	}

	public void setFaculty_subcaste(String faculty_subcaste) {
		this.faculty_subcaste = faculty_subcaste;
	}

	public String getFaculty_category() {
		return faculty_category;
	}

	public void setFaculty_category(String faculty_category) {
		this.faculty_category = faculty_category;
	}

	public String getFaculty_marital_status() {
		return faculty_marital_status;
	}

	public void setFaculty_marital_status(String faculty_marital_status) {
		this.faculty_marital_status = faculty_marital_status;
	}

	public String getFaculty_building() {
		return faculty_building;
	}

	public void setFaculty_building(String faculty_building) {
		this.faculty_building = faculty_building;
	}

	public String getFaculty_street() {
		return faculty_street;
	}

	public void setFaculty_street(String faculty_street) {
		this.faculty_street = faculty_street;
	}

	public String getFaculty_area() {
		return faculty_area;
	}

	public void setFaculty_area(String faculty_area) {
		this.faculty_area = faculty_area;
	}

	public String getFaculty_station() {
		return faculty_station;
	}

	public void setFaculty_station(String faculty_station) {
		this.faculty_station = faculty_station;
	}

	public String getFaculty_city() {
		return faculty_city;
	}

	public void setFaculty_city(String faculty_city) {
		this.faculty_city = faculty_city;
	}

	public String getFaculty_state() {
		return faculty_state;
	}

	public void setFaculty_state(String faculty_state) {
		this.faculty_state = faculty_state;
	}

	
	
	public String getFaculty_pincode() {
		return faculty_pincode;
	}

	public void setFaculty_pincode(String faculty_pincode) {
		this.faculty_pincode = faculty_pincode;
	}

	public String getFaculty_mobile() {
		return faculty_mobile;
	}

	public void setFaculty_mobile(String faculty_mobile) {
		this.faculty_mobile = faculty_mobile;
	}

	public String getFaculty_alt_mobile() {
		return faculty_alt_mobile;
	}

	public void setFaculty_alt_mobile(String faculty_alt_mobile) {
		this.faculty_alt_mobile = faculty_alt_mobile;
	}

	public String getFaculty_telephone() {
		return faculty_telephone;
	}

	public void setFaculty_telephone(String faculty_telephone) {
		this.faculty_telephone = faculty_telephone;
	}

	public String getFaculty_email() {
		return faculty_email;
	}

	public void setFaculty_email(String faculty_email) {
		this.faculty_email = faculty_email;
	}

	public String getFaculty_alt_email() {
		return faculty_alt_email;
	}

	public void setFaculty_alt_email(String faculty_alt_email) {
		this.faculty_alt_email = faculty_alt_email;
	}

	public String getFaculty_pan() {
		return faculty_pan;
	}

	public void setFaculty_pan(String faculty_pan) {
		this.faculty_pan = faculty_pan;
	}

	

	public String getFaculty_aadhar() {
		return faculty_aadhar;
	}

	public void setFaculty_aadhar(String faculty_aadhar) {
		this.faculty_aadhar = faculty_aadhar;
	}

	public String getFaculty_bank_name() {
		return faculty_bank_name;
	}

	public void setFaculty_bank_name(String faculty_bank_name) {
		this.faculty_bank_name = faculty_bank_name;
	}

	

	public String getFaculty_bank_account_no() {
		return faculty_bank_account_no;
	}

	public void setFaculty_bank_account_no(String faculty_bank_account_no) {
		this.faculty_bank_account_no = faculty_bank_account_no;
	}

	public String getFaculty_bank_branch() {
		return faculty_bank_branch;
	}

	public void setFaculty_bank_branch(String faculty_bank_branch) {
		this.faculty_bank_branch = faculty_bank_branch;
	}

	public String getFaculty_bank_ifsc() {
		return faculty_bank_ifsc;
	}

	public void setFaculty_bank_ifsc(String faculty_bank_ifsc) {
		this.faculty_bank_ifsc = faculty_bank_ifsc;
	}

	public String getFaculty_degree() {
		return faculty_degree;
	}

	public void setFaculty_degree(String faculty_degree) {
		this.faculty_degree = faculty_degree;
	}

	public String getFaculty_specialization() {
		return faculty_specialization;
	}

	public void setFaculty_specialization(String faculty_specialization) {
		this.faculty_specialization = faculty_specialization;
	}

	public String getFaculty_masters() {
		return faculty_masters;
	}

	public void setFaculty_masters(String faculty_masters) {
		this.faculty_masters = faculty_masters;
	}

	public String getFaculty_masters_specialization() {
		return faculty_masters_specialization;
	}

	public void setFaculty_masters_specialization(String faculty_masters_specialization) {
		this.faculty_masters_specialization = faculty_masters_specialization;
	}

	public String getFaculty_phd() {
		return faculty_phd;
	}

	public void setFaculty_phd(String faculty_phd) {
		this.faculty_phd = faculty_phd;
	}

	public String getFaculty_phd_specialization() {
		return faculty_phd_specialization;
	}

	public void setFaculty_phd_specialization(String faculty_phd_specialization) {
		this.faculty_phd_specialization = faculty_phd_specialization;
	}

	public String getFaculty_experience() {
		return faculty_experience;
	}

	public void setFaculty_experience(String faculty_experience) {
		this.faculty_experience = faculty_experience;
	}


	public String getFaculty_exp_type() {
		return faculty_exp_type;
	}

	public void setFaculty_exp_type(String faculty_exp_type) {
		this.faculty_exp_type = faculty_exp_type;
	}

	public String getFaculty_appointment_type() {
		return faculty_appointment_type;
	}

	public void setFaculty_appointment_type(String faculty_appointment_type) {
		this.faculty_appointment_type = faculty_appointment_type;
	}

	
}
