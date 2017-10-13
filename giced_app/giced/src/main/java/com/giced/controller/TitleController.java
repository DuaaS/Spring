package com.giced.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AbstractAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.giced.model.Title;
import com.giced.service.TitleService;

@Controller
public class TitleController {
	
private TitleService titleService;
	
	@Autowired
	public void setTitleService(TitleService titleService) {
		this.titleService = titleService;
	}
	
	
	//ShowCourse_Title List
	@RequestMapping(value = "titles", method = RequestMethod.GET)
	public String listAppointments( Model model) {
	        model.addAttribute("listTitle", titleService.getAllTitles());
	        AbstractAuthenticationToken auth = (AbstractAuthenticationToken)SecurityContextHolder.getContext().getAuthentication();
	        model.addAttribute("user_role", auth.getAuthorities());
	        return "list_title";
	 }
	
	

	



	//Show AddCourse_Title Form
	@RequestMapping(value = "add_title", method = RequestMethod.GET)
	public String addAppointmentForm(Model model) {
		Title design=new Title();
		model.addAttribute("title", design);
		return "add_title";
	}
	
	//AddCourse_Title 
	@RequestMapping(value = "titles/add", method = RequestMethod.POST)
    public String addAppointment(@ModelAttribute("title")Title design, 
   		Model model) {
	   	try {
	   		titleService.addTitle(design);
	   	}
	    catch(Exception ex) {
	   		model.addAttribute("errorMsg", "Title Id already exist");
	   	    return "add_title";
	   	}
	   	return "redirect:/titles";
    }
	
	//Show EditCourse_Title Form
	@RequestMapping("editTitle/{title_id}")
    public String editAppointmentForm(@PathVariable("title_id") String id, Model model) {
		model.addAttribute("title", titleService.getTitle(id));
		return "edit_title";
    }
	
	//EditCourse_Title
	@RequestMapping(value = "titles/edit", method = RequestMethod.POST)
    public String editAppointment(@ModelAttribute("title")Title design,
    		final RedirectAttributes redirectAttributes) {
		titleService.updateTitle(design);
        redirectAttributes.addFlashAttribute("msg", "Updated Successfully!");
        return "redirect:/titles";
    }

	//Delete Appointment
	@RequestMapping("removeTitle/{title_id}")
    public String removeAppointment(@PathVariable("title_id") String id,
    		final RedirectAttributes redirectAttributes) {
		titleService.removeTitle(id);
        redirectAttributes.addFlashAttribute("msg", "Deleted Successfully!");
        return "redirect:/titles";
    }

}
