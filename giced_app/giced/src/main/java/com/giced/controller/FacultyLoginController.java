package com.giced.controller;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AbstractAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.giced.model.Appointment_Type;
import com.giced.model.Assignment;
import com.giced.model.Attendance;
import com.giced.model.Caste;
import com.giced.model.Category;
import com.giced.model.Countries;
import com.giced.model.Designation;
import com.giced.model.Faculty;
import com.giced.model.SubCaste;
import com.giced.service.AppointmentService;
import com.giced.service.AssignmentService;
import com.giced.service.AttendanceService;
import com.giced.service.CasteService;
import com.giced.service.CategoryService;
import com.giced.service.CountriesService;
import com.giced.service.CourseService;
import com.giced.service.DesignationService;
import com.giced.service.FacultyService;
import com.giced.service.SubCasteService;
import com.giced.service.SubjectService;

@Controller
public class FacultyLoginController {

	private FacultyService facultyService;
	private AssignmentService assignmentService;
	private AttendanceService attendanceService;
	private CourseService courseService;
	private SubjectService subjectService;
	
	private CountriesService countriesService;
	private DesignationService designationService;
	private CasteService casteService;
	private SubCasteService subcasteService;
	private CategoryService catService;
	private AppointmentService appointmentService;
	
	@Autowired
	public void setAppointmentService(AppointmentService appointmentService) {
		this.appointmentService = appointmentService;
	}

	@Autowired
	public void setCountriesService(CountriesService countriesService) {
		this.countriesService = countriesService;
	}

	@Autowired
	public void setDesignationService(DesignationService designationService) {
		this.designationService = designationService;
	}

	@Autowired
	public void setCasteService(CasteService casteService) {
		this.casteService = casteService;
	}

	@Autowired
	public void setSubcasteService(SubCasteService subcasteService) {
		this.subcasteService = subcasteService;
	}

	@Autowired
	public void setCatService(CategoryService catService) {
		this.catService = catService;
	}

	@Autowired	
	public void setCourseService(CourseService courseService) {
		this.courseService = courseService;
	}

	@Autowired
	public void setSubjectService(SubjectService subjectService) {
		this.subjectService = subjectService;
	}

	@Autowired
	public void setAssignmentService(AssignmentService assignmentService) {
		this.assignmentService = assignmentService;
	}
	
	@Autowired
	public void setAttendanceService(AttendanceService attendanceService) {
		this.attendanceService = attendanceService;
	}

	@Autowired
	public void setFacultyService(FacultyService facultyService) {
		this.facultyService = facultyService;
	}
	
	
		//Show Self Profile
		@RequestMapping(value = "faculty_profiles", method = RequestMethod.GET)
		public String showFacultyProfile(Model model) {
			AbstractAuthenticationToken auth = (AbstractAuthenticationToken)SecurityContextHolder.getContext().getAuthentication();
		    Faculty faculty=facultyService.getFacultybyUsername(auth.getName());
			model.addAttribute("faculty", faculty);
			model.addAttribute("faculty_profile", "faculty_profile");
			Date dob=faculty.getFaculty_dob();
			SimpleDateFormat outFormat = new SimpleDateFormat("MM/dd/yyyy");
			String formatted = outFormat.format(dob);
			model.addAttribute("dob",formatted);
			if(faculty.getFaculty_designation()=="NONE") 
			{
				model.addAttribute("designation","--");			
			}
			else {
				Designation d=designationService.getDesignation(faculty.getFaculty_designation());
				if(d!=null)	model.addAttribute("designation",d.getDesignation_name());
				else model.addAttribute("designation","--");	
			}
			if(0!=faculty.getFaculty_nationality()) {
				Countries count=countriesService.getCountry(faculty.getFaculty_nationality());
				model.addAttribute("country",count.getCountry_name());
			}
			else model.addAttribute("country","--");
			if(null!=faculty.getFaculty_caste()) {
				Caste c=casteService.getCaste(faculty.getFaculty_caste());
				model.addAttribute("caste", c.getCaste_name());
			}
			else model.addAttribute("caste","--");
			if(faculty.getFaculty_subcaste()=="NONE" || faculty.getFaculty_subcaste()==null || faculty.getFaculty_subcaste()=="") {
				model.addAttribute("subcaste","--");
			}
			else {
				SubCaste sc=subcasteService.getSubCaste(faculty.getFaculty_subcaste());
				if(sc!=null) model.addAttribute("subcaste",sc.getSubcaste_name());
				else model.addAttribute("subcaste","--");
			}
			if(null!=faculty.getFaculty_category()) {
				Category cat=catService.getCategory(faculty.getFaculty_category());
				model.addAttribute("category",cat.getCategory_name());
			}
			else model.addAttribute("category","--");
			if(null!=faculty.getFaculty_appointment_type()) {
				Appointment_Type appt=appointmentService.getAppointment(faculty.getFaculty_appointment_type());
				model.addAttribute("appt",appt.getAppointment_name());
			}
			else model.addAttribute("appt","--");
			return "show_faculty";
		 }
		
		//Show Faculty Assignments
		@RequestMapping(value = "faculty_assignments", method = RequestMethod.GET)
		public String listAssignments(Model model) {
			AbstractAuthenticationToken auth = (AbstractAuthenticationToken)SecurityContextHolder.getContext().getAuthentication();
		    Faculty faculty=facultyService.getFacultybyUsername(auth.getName());
			List<Assignment> listAssignment=assignmentService.getAssignmentforFaculty(faculty.getFaculty_id());
	        model.addAttribute("listAssignment", listAssignment);
	        model.addAttribute("listCourse", courseService.getAllCourses());
	        model.addAttribute("listFaculty", facultyService.getAllFaculties());
	        model.addAttribute("listSubject", subjectService.getAllSubjects());
	        
	        return "faculty_assignments";
		}
		
		//Show Faculty Attendance
		@RequestMapping(value = "faculty_attendances", method = RequestMethod.GET)
		public String listAttendances(Model model) {
			AbstractAuthenticationToken auth = (AbstractAuthenticationToken)SecurityContextHolder.getContext().getAuthentication();
		    Faculty faculty=facultyService.getFacultybyUsername(auth.getName());
		    List<Assignment> listAssignment=assignmentService.getAssignmentforFaculty(faculty.getFaculty_id());
		    List<Attendance> listAttendance=new ArrayList<Attendance>();
		    for(Assignment as: listAssignment) {
		    	List<Attendance> listAtt=attendanceService.getAttendanceforAssignment(as.getAssignment_id());
		    	listAttendance.addAll(listAtt);
		    }
			model.addAttribute("listAttendance", listAttendance);
			model.addAttribute("listAssignment", listAssignment);
	        model.addAttribute("listCourse", courseService.getAllCourses());
	        model.addAttribute("listSubject", subjectService.getAllSubjects());
	        model.addAttribute("faculty_name", faculty.getFaculty_firstname()+" "+faculty.getFaculty_lastname());
	        return "faculty_attendances";
		}

		
}
