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

import com.giced.model.SubCaste;
import com.giced.service.CasteService;
import com.giced.service.SubCasteService;


@Controller
public class SubCasteController {
	
	private SubCasteService subcasteService;
	private CasteService casteService;
		
	@Autowired
	public void setSubcasteService(SubCasteService subcasteService) {
		this.subcasteService = subcasteService;
	}

	@Autowired
	public void setCasteService(CasteService casteService) {
		this.casteService = casteService;
	}

	//Show SubCaste List
	@RequestMapping(value = "subcastes", method = RequestMethod.GET)
	public String listSubCastess(Model model) {
	        model.addAttribute("subcaste", new SubCaste());
	        model.addAttribute("searchedsubcaste", new SubCaste());
	        model.addAttribute("listSubCaste", subcasteService.getAllSubCastes());
	        model.addAttribute("listCaste",casteService.getAllCastes());
	        AbstractAuthenticationToken auth = (AbstractAuthenticationToken)SecurityContextHolder.getContext().getAuthentication();
	        model.addAttribute("user_role", auth.getAuthorities());
	        return "list_subcaste";
	 }
	
	//Show Add SubCaste Form
	@RequestMapping(value = "add_subcaste", method = RequestMethod.GET)
	public String addSubCasteForm(Model model) {
		SubCaste subcaste=new SubCaste();
		subcaste.setSubcaste_id("");
		subcaste.setSubcaste_name("");
		subcaste.setCaste_id("");
		model.addAttribute("listCaste", casteService.getAllCastes());
		model.addAttribute("subcaste", subcaste);
		return "add_subcaste";
	}
	
	//Add SubCaste 
	@RequestMapping(value = "subcastes/add", method = RequestMethod.POST)
    public String addSubCaste(@ModelAttribute("subcaste") SubCaste subcaste, 
    		Model model) {
	   	try {
	   		subcasteService.addSubCaste(subcaste);
	   	}
	    catch(Exception ex) {
	   		model.addAttribute("errorMsg", "Sub-Caste Id already exist");
	   		model.addAttribute("listCaste", casteService.getAllCastes());
	   	    return "add_subcaste";
	   	}
		return "redirect:/subcastes";
    }
	
	//Show Edit SubCaste
	@RequestMapping("editSubCaste/{subcaste_id}")
    public String editSubCasteForm(@PathVariable("subcaste_id") String id, Model model) {
		model.addAttribute("subcaste", subcasteService.getSubCaste(id));
		model.addAttribute("listCaste", casteService.getAllCastes());
		return "edit_subcaste";
    }
	
	//Edit SubCaste
	@RequestMapping(value = "subcastes/edit", method = RequestMethod.POST)
    public String editSubCaste(@ModelAttribute("subcaste") SubCaste subcaste,
    		final RedirectAttributes redirectAttributes) {
        subcasteService.updateSubCaste(subcaste);
        redirectAttributes.addFlashAttribute("msg", "Updated Successfully!");
        return "redirect:/subcastes";
    }

	//Delete SubCaste
	@RequestMapping("removeSubCaste/{subcaste_id}")
    public String removeSubCaste(@PathVariable("subcaste_id") String id,
    		final RedirectAttributes redirectAttributes) {
        subcasteService.removeSubCaste(id);
        redirectAttributes.addFlashAttribute("msg", "Deleted Successfully!");
        return "redirect:/subcastes";
    }
	
	
}
