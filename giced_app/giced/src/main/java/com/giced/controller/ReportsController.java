package com.giced.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AbstractAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.giced.model.Assignment;
import com.giced.model.Attendance;
import com.giced.model.AttendanceReport;
import com.giced.model.Course;
import com.giced.model.Faculty;
import com.giced.model.Subject;
import com.giced.service.AssignmentService;
import com.giced.service.AttendanceService;
import com.giced.service.CourseService;
import com.giced.service.FacultyService;
import com.giced.service.SubjectService;

@Controller
public class ReportsController {

	private AssignmentService assignmentService;
	private AttendanceService attendanceService;
	private CourseService courseService;
	private SubjectService subjectService;
	private FacultyService facultyService;
	private List<AttendanceReport> listAttReport;
	
	public List<AttendanceReport> getListAttReport() {
		return listAttReport;
	}

	public void setListAttReport(List<AttendanceReport> listAttReport) {
		this.listAttReport = listAttReport;
	}

	@Autowired
	public void setAttendanceService(AttendanceService attendanceService) {
		this.attendanceService = attendanceService;
	}

	@Autowired
	public void setAssignmentService(AssignmentService assignmentService) {
		this.assignmentService = assignmentService;
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
	public void setFacultyService(FacultyService facultyService) {
		this.facultyService = facultyService;
	}

	
	@RequestMapping(value = "attendance_report", method = RequestMethod.POST)
    public String searchData(@ModelAttribute("attReport") AttendanceReport attReport, Model model) {
		List<AttendanceReport> listReport=new ArrayList<AttendanceReport>();
		List<Assignment> listAssignment=assignmentService.getAssignmentforData(attReport.getCourse(), attReport.getSubject(), attReport.getFaculty());
		for(Assignment ass:listAssignment) {
			AttendanceReport ar=new AttendanceReport();
			Course course=courseService.getCourse(ass.getCourse_id());
			Subject subject = subjectService.getSubject(ass.getSubject_id());
			Faculty faculty=facultyService.getFaculty(ass.getFaculty_id());
			ar.setAssignment_id(ass.getAssignment_id());
			ar.setCourse(course.getCourse_name());
			ar.setSubject(subject.getSubject_name());
			ar.setFaculty(faculty.getFaculty_firstname()+" "+ faculty.getFaculty_lastname());
			List<Attendance> listAt=attendanceService.getAttendanceforAssignment(ass.getAssignment_id());
	        double diff_completed = 0;
	        for(Attendance att:listAt) {
	        	double l_completed= Double.parseDouble(att.getCompleted_hours());
	        	diff_completed=diff_completed+l_completed;
	        }
	        ar.setCompleted_hours(String.valueOf(diff_completed));
			
			ar.setAssigned_hours(ass.getAssigned_duration());
			ar.setPending_hours(ass.getPending_duration());
			
			//listReport.add(ar);
			
			if(ar.getAssigned_hours()==ar.getCompleted_hours()) ar.setIs_completed("YES");
			else ar.setIs_completed("NO");
			
			if(attReport.getIs_completed().equals("NONE")) listReport.add(ar);
			else if(attReport.getIs_completed()==ar.getIs_completed()) listReport.add(ar);
		
		}
		//model.addAttribute("msg", attReport.getCourse()+" "+attReport.getSubject()+" "+attReport.getFaculty()+" "+listAssignment+" "+listReport);
		model.addAttribute("listReport", listReport);
		model.addAttribute("listCourse", courseService.getAllCourses());
		model.addAttribute("listSubject", subjectService.getAllSubjects());
		model.addAttribute("listFaculty", facultyService.getAllFaculties());
		model.addAttribute("attReport", attReport);
		AbstractAuthenticationToken auth = (AbstractAuthenticationToken)SecurityContextHolder.getContext().getAuthentication();
        model.addAttribute("role", auth.getAuthorities());
        setListAttReport(listReport);
		return "attendance_report";
    }
	
	
	@RequestMapping(value="export_pdf", method = RequestMethod.GET)
	public ModelAndView generatePdf(HttpServletRequest request,
	   HttpServletResponse response) throws Exception {

	  List<AttendanceReport> attReport=getListAttReport();
	  ModelAndView modelAndView = new ModelAndView("pdfView", "attReport",attReport);
	  
	  return modelAndView;
	 }
	
	@RequestMapping(value="export_excel", method = RequestMethod.GET)
	public ModelAndView generateExcel(HttpServletRequest request,
	   HttpServletResponse response) throws Exception {

	  List<AttendanceReport> attReport=getListAttReport();
	  ModelAndView modelAndView = new ModelAndView("excelView", "attReport",attReport);
	  
	  return modelAndView;
	 }
	
	
	
	@RequestMapping(value = "/get_report_page", method = RequestMethod.GET)
    public  String  getReportPage(Model model) {
		model.addAttribute("listCourse", courseService.getAllCourses());
		model.addAttribute("listSubject", subjectService.getAllSubjects());
		model.addAttribute("listFaculty", facultyService.getAllFaculties());
		model.addAttribute("attReport", new AttendanceReport());
		AbstractAuthenticationToken auth = (AbstractAuthenticationToken)SecurityContextHolder.getContext().getAuthentication();
        model.addAttribute("role", auth.getAuthorities());
		return "attendance_report";

   }
}
