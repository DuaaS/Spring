package com.giced.controller;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.authentication.AbstractAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.giced.model.Assignment;
import com.giced.model.Attendance;
import com.giced.model.Faculty;
import com.giced.model.Subject;
import com.giced.service.AssignmentService;
import com.giced.service.AttendanceService;
import com.giced.service.CourseService;
import com.giced.service.FacultyService;
import com.giced.service.SubjectService;

@Controller
public class AttendanceController {
	 
	private AssignmentService assignmentService;
	private AttendanceService attendanceService;
	private CourseService courseService;
	private SubjectService subjectService;
	private FacultyService facultyService;
	
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

	//Show Attendance List
	@RequestMapping(value = "attendances", method = RequestMethod.GET)
	public String listAttendance( Model model) {
	        model.addAttribute("listAttendance", attendanceService.getAllAttendance());
	        model.addAttribute("listAssignment", assignmentService.getAllAssignments());
	        model.addAttribute("listCourse", courseService.getAllCourses());
	        model.addAttribute("listSubject", subjectService.getAllSubjects());
	        model.addAttribute("listFaculty", facultyService.getAllFaculties());
	        AbstractAuthenticationToken auth = (AbstractAuthenticationToken)SecurityContextHolder.getContext().getAuthentication();
	        model.addAttribute("user_role", auth.getAuthorities());
	        return "list_attendance";
	 }
	
	//Show Add Attendance Form
	@RequestMapping(value = "add_attendance", method = RequestMethod.GET)
	public String addAttendanceForm(Model model) {
		model.addAttribute("assignment", new Assignment());
		model.addAttribute("attendance", new Attendance());
		model.addAttribute("listCourse", courseService.getAllCourses());
		return "add_attendance";
	}
		
	
	@RequestMapping(value="getSubject1.json")
	@ResponseStatus(HttpStatus.OK)
	public @ResponseBody  List<Subject> getSubject(@RequestParam(value = "course_id", required = true) String course_id,
			ModelMap modelMap ){
		List<Assignment> listAssign=assignmentService.getAssignmentforData(course_id, null, null);
		List<Subject> listSubject=new ArrayList<Subject>();
		for(Assignment a:listAssign) {
			String s=a.getSubject_id();
			listSubject.add(subjectService.getSubject(s));
		}
		return listSubject;
	}
	

	@RequestMapping(value="getFaculty.json")
	@ResponseStatus(HttpStatus.OK)
	public @ResponseBody  List<Faculty> getFaculty(@RequestParam(value = "course_id", required = true) String course_id,
			@RequestParam(value = "subject_id", required = true) String subject_id,
			ModelMap modelMap ){
		List<Assignment> listAssign=assignmentService.getAssignmentforData(course_id, subject_id, null);
		List<Faculty> listFaculty=new ArrayList<Faculty>();
		for(Assignment a:listAssign) {
			String f=a.getFaculty_id();
			listFaculty.add(facultyService.getFaculty(f));
		}
		return listFaculty;
	}
	

	@RequestMapping(value="getAssignment.json")
	@ResponseStatus(HttpStatus.OK)
	public @ResponseBody  List<Assignment> getAssignment(@RequestParam(value = "course_id", required = true) String course_id,
			@RequestParam(value = "subject_id", required = true) String subject_id,
			@RequestParam(value = "faculty_id", required = true) String faculty_id,
			ModelMap modelMap ){
		List<Assignment> listAssign=assignmentService.getAssignmentforData(course_id, subject_id, faculty_id);
		return listAssign;
	}
	
	//Add Assignment
	@RequestMapping(value = "attendances/add", method = RequestMethod.POST)
    public String addAttendance(@ModelAttribute("attendance") Attendance attendance, Model model) {
		DateFormat format;
		Date d1,d2;
		try {
			
			format = new SimpleDateFormat("HH:mm", Locale.ENGLISH);
	        d1 = format.parse(attendance.getIn_time());
	        d2 =  format.parse(attendance.getOut_time());
	            
	        long diff = d2.getTime() - d1.getTime();
	        long diffMinutes = diff / (60 * 1000) % 60 ;
	        long diffHours = diff / (60 * 60 * 1000) % 24;
	        if (diffMinutes==30) diffMinutes=50;
	        attendance.setCompleted_hours(diffHours+"."+diffMinutes);
	        attendanceService.addAttendance(attendance);
	        
	        setPendingDuration(attendance.getAssignment_id());
	           
		}
        catch(Exception ex) {
        	model.addAttribute("errorMsg", ex.getMessage());
        	model.addAttribute("listCourse", courseService.getAllCourses());
			return "add_attendance";
        }
		return "redirect:/attendances";
		
    }
		
	private void setPendingDuration(String assignment_id) {
		Assignment assignment=assignmentService.getAssignment(assignment_id);
        List<Attendance> listAt=attendanceService.getAttendanceforAssignment(assignment.getAssignment_id());
        
        double diff_completed = 0;
        for(Attendance at:listAt) {
        	double l_completed= Double.parseDouble(at.getCompleted_hours());
        	diff_completed=diff_completed+l_completed;
        }
        
        double l_assigned=Double.parseDouble(assignment.getAssigned_duration());
        double l_pending=l_assigned - diff_completed;
        
        assignment.setPending_duration(String.valueOf(l_pending));
        assignmentService.updateAssignment(assignment);
	}
	
	//Show Edit Attendance Form
		@RequestMapping("editAttendance/{id}")
	    public String editAttendanceForm(@PathVariable("id") String id, Model model) {
			Attendance attendance=attendanceService.getAttendance(id);
			model.addAttribute("attendance", attendance);
			Date date=attendance.getDate();
			SimpleDateFormat simpleDate = new SimpleDateFormat("MM/dd/yyyy");
			String formattedDate = simpleDate.format(date);
			model.addAttribute("date",formattedDate);
			model.addAttribute("listCourse", courseService.getAllCourses());
		    return "edit_attendance";
	    }
		
		
		//Edit Assignment Details
		@RequestMapping(value = "attendances/edit", method = RequestMethod.POST)
	    public String editAssignment(@ModelAttribute("attendance") Attendance attendance,Model model) {
			try {
				DateFormat format = new SimpleDateFormat("HH:mm", Locale.ENGLISH);
	            Date d1 = format.parse(attendance.getIn_time());
	            Date d2 =  format.parse(attendance.getOut_time());
	            long diff = d2.getTime() - d1.getTime();
	            long diffMinutes = diff / (60 * 1000) % 60 ;
	            long diffHours = diff / (60 * 60 * 1000) % 24;
	            if (diffMinutes==30) diffMinutes=50;
	            attendance.setCompleted_hours(diffHours+"."+diffMinutes);
	            attendanceService.updateAttendance(attendance);
	            setPendingDuration(attendance.getAssignment_id());
			}
			catch(Exception ex) {
	        	model.addAttribute("errorMsg", ex.getMessage());
	        	model.addAttribute("listCourse", courseService.getAllCourses());
				return "edit_attendance";
	        }
	        return "redirect:/assignments";
	    }
		
		//Delete Assignment
		@RequestMapping("removeAttendance/{id}")
	    public String removeFaculty(@PathVariable("id") String id) {
			Attendance attendance=attendanceService.getAttendance(id);
			String assignment_id=attendance.getAssignment_id();
			attendanceService.removeAttendance(id);
			setPendingDuration(assignment_id);
	        return "redirect:/assignments";
	    }
		
		
}
