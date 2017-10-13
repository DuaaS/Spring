package com.giced.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AbstractAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import com.giced.model.Course;
import com.giced.model.Duration;
import com.giced.model.Subject;
import com.giced.model.Title;
import com.giced.service.CourseService;
import com.giced.service.DurationService;
import com.giced.service.SubjectService;
import com.giced.service.TitleService;

@Controller
public class CourseController {

	private DurationService durationService;
	private TitleService titleService;
	private SubjectService subjectService;
	private CourseService courseService;
	
	@Autowired
	public void setCourseService(CourseService courseService) {
		this.courseService = courseService;
	}

	@Autowired
	public void setDurationService(DurationService durationService) {
		this.durationService = durationService;
	}

	@Autowired
	public void setTitleService(TitleService titleService) {
		this.titleService = titleService;
	}

	@Autowired
	public void setSubjectService(SubjectService subjectService) {
		this.subjectService = subjectService;
	}

		//Show Course List
		@RequestMapping(value = "courses", method = RequestMethod.GET)
		public String listCourses(Model model) {
		        model.addAttribute("course", new Course());
		        model.addAttribute("listCourse", courseService.getAllCourses());
		        model.addAttribute("listDuration", durationService.getAllDurations());
		        model.addAttribute("listTitle", titleService.getAllTitles());
		        model.addAttribute("listSubject",subjectService.getAllSubjects());
		        AbstractAuthenticationToken auth = (AbstractAuthenticationToken)SecurityContextHolder.getContext().getAuthentication();
		        model.addAttribute("user_role", auth.getAuthorities());
		        return "list_course";
		 }
		
		//Show Add Course Form
		@RequestMapping(value = "add_course", method = RequestMethod.GET)
		public String addUserForm(Model model) {
			Course course=new Course();
			model.addAttribute("listDuration", durationService.getAllDurations());
	        model.addAttribute("listTitle", titleService.getAllTitles());
	        model.addAttribute("listSubject",subjectService.getAllSubjects());
			model.addAttribute("course", course);
			return "add_course";
		}
		
		//Add Course 
		@RequestMapping(value = "courses/add", method = RequestMethod.POST)
	    public String addCourse(@ModelAttribute("course")Course course, Model model) {
			try {
				courseService.addCourse(course);
			}
	        catch(Exception ex) {
	        	model.addAttribute("errorMsg", "Course Id already exist");
	        	model.addAttribute("listDuration", durationService.getAllDurations());
		        model.addAttribute("listTitle", titleService.getAllTitles());
		        model.addAttribute("listSubject",subjectService.getAllSubjects());
	        	return "add_course";
	        }
	        return "redirect:/courses";
	    }
		
		//Show Edit Course Form
		@RequestMapping("editCourse/{course_id}")
	    public String editCourseForm(@PathVariable("course_id") String id, Model model) {
			Course course=courseService.getCourse(id);
			model.addAttribute("course",course);
			model.addAttribute("listDuration", durationService.getAllDurations());
	        model.addAttribute("listTitle", titleService.getAllTitles());
	        model.addAttribute("listSubject",subjectService.getAllSubjects());
			return "edit_course";
	    }
		
		//Show Course Form
		@RequestMapping("showCourse/{course_id}")
		public String showCourseForm(@PathVariable("course_id") String id, Model model) {
			Course course=courseService.getCourse(id);
			model.addAttribute("course",course);
			if(course.getCourse_duration()==null) model.addAttribute("duration","--");			
			else {
				Duration d=durationService.getDuration(course.getCourse_duration());
				if(d!=null)	model.addAttribute("duration",d.getDuration_name());		
				else model.addAttribute("duration","--");
			}
			if(course.getCourse_title()=="NONE") model.addAttribute("title","--");			
			else {
				Title t=titleService.getTitle(course.getCourse_title());
				if(t!=null)	model.addAttribute("title",t.getTitle_name());		
				else model.addAttribute("title","--");	
			}
			
			String allSub=course.getCourse_subjects();
			String[] subject=allSub.split(",");
			List<String> listSubject=new ArrayList<String>();
			for(String s:subject) {
				Subject sub=subjectService.getSubject(s);
				listSubject.add(sub.getSubject_name());
			}
			model.addAttribute("listSubject", listSubject);
			return "show_course";
		}
		
		
		//Edit Course
		@RequestMapping(value = "courses/edit", method = RequestMethod.POST)
	    public String editCourse(@ModelAttribute("course") Course course, Model model) {
			courseService.updateCourse(course);
		    return "redirect:/courses";
	    }

		//Delete User
		@RequestMapping("removeCourse/{course_id}")
	    public String removeCourse(@PathVariable("course_id") String id) {
	       courseService.removeCourse(id);
	        return "redirect:/courses";
	    }
}
