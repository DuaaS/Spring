package com.giced.controller;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

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
import com.giced.model.Course;
import com.giced.model.Subject;
import com.giced.service.AssignmentService;
import com.giced.service.CourseService;
import com.giced.service.FacultyService;
import com.giced.service.SubjectService;

@Controller
public class AssignmentController {
	 
	private AssignmentService assignmentService;
	private CourseService courseService;
	private SubjectService subjectService;
	private FacultyService facultyService;
	
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

	//Show Assignment List
	@RequestMapping(value = "assignments", method = RequestMethod.GET)
	public String listAssignments(Model model) {
	        model.addAttribute("listAssignment", assignmentService.getAllAssignments());
	        model.addAttribute("listCourse", courseService.getAllCourses());
	        model.addAttribute("listFaculty", facultyService.getAllFaculties());
	        model.addAttribute("listSubject", subjectService.getAllSubjects());
	        AbstractAuthenticationToken auth = (AbstractAuthenticationToken)SecurityContextHolder.getContext().getAuthentication();
	        model.addAttribute("user_role", auth.getAuthorities());
	        return "list_assignment";
	 }
	
		//Show Add Assignment Form
		@RequestMapping(value = "add_assignment", method = RequestMethod.GET)
		public String addAssignmentForm(Model model) {
			model.addAttribute("assignment", new Assignment());
			model.addAttribute("listCourse", courseService.getAllCourses());
			model.addAttribute("listFaculty", facultyService.getAllFaculties());
			return "add_assignment";
		}
		
		
	
	@RequestMapping(value="getSubject.json")
	@ResponseStatus(HttpStatus.OK)
	public @ResponseBody  List<Subject> getSubject(@RequestParam(value = "course_id", required = true) String course_id,
			ModelMap modelMap ){
		Course course=courseService.getCourse(course_id);
		String allSub=course.getCourse_subjects();
		String[] subject=allSub.split(",");
		List<Subject> listSubject=new ArrayList<Subject>();
		for(String s:subject) {
			Subject sub=subjectService.getSubject(s);
			listSubject.add(sub);
		}
	    return listSubject;
	}
	
	//Add Assignment
	@RequestMapping(value = "assignments/add", method = RequestMethod.POST)
    public String addAssignment(@ModelAttribute("assignment") Assignment assignment, Model model) {
		try {
			assignment.setPending_duration(assignment.getAssigned_duration());
			assignmentService.addAssignment(assignment);
		}
        catch(Exception ex) {
        	model.addAttribute("errorMsg", "Assignment Id already exist");
        	model.addAttribute("listCourse", courseService.getAllCourses());
			model.addAttribute("listFaculty", facultyService.getAllFaculties());
        	return "add_assignment";
        }
		return "redirect:/assignments";

		
    }
	
	//Show Edit Assignment Form
	@RequestMapping("editAssignment/{assignment_id}")
    public String editAssignmentForm(@PathVariable("assignment_id") String id, Model model) {
		Assignment assign=assignmentService.getAssignment(id);
		model.addAttribute("assignment", assign);
		Date start=assign.getStart_date();
		SimpleDateFormat simpleStart = new SimpleDateFormat("MM/dd/yyyy");
		String formattedStart = simpleStart.format(start);
		model.addAttribute("start_date",formattedStart);
		Date end=assign.getEnd_date();
		SimpleDateFormat simpleEnd = new SimpleDateFormat("MM/dd/yyyy");
		String formattedEnd = simpleEnd.format(end);
		model.addAttribute("end_date",formattedEnd);
		model.addAttribute("listCourse", courseService.getAllCourses());
		Course course=courseService.getCourse(assign.getCourse_id());
		String allSub=course.getCourse_subjects();
		String[] subject=allSub.split(",");
		List<Subject> listSubject=new ArrayList<Subject>();
		for(String s:subject) {
			Subject sub=subjectService.getSubject(s);
			listSubject.add(sub);
		}
		model.addAttribute("listSubject",listSubject);
		model.addAttribute("listFaculty",facultyService.getAllFaculties());
		
	    return "edit_assignment";
    }
	
	
	//Edit Assignment Details
	@RequestMapping(value = "assignments/edit", method = RequestMethod.POST)
    public String editAssignment(@ModelAttribute("assignment") Assignment assignment) {
        assignmentService.updateAssignment(assignment);
        return "redirect:/assignments";
    }

	//Delete Assignment
	@RequestMapping("removeAssignment/{assignment_id}")
    public String removeFaculty(@PathVariable("assignment_id") String id) {
        assignmentService.removeAssignment(id);
        return "redirect:/assignments";
    }
	
	
}
