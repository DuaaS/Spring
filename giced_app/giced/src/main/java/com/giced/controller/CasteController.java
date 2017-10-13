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

import com.giced.model.Caste;
import com.giced.service.CasteService;


@Controller
public class CasteController {
	
	private CasteService casteService;
	
	@Autowired
    public void setCasteService(CasteService casteService) {
        this.casteService = casteService;
    }

	//Show Caste List
	@RequestMapping(value = "castes", method = RequestMethod.GET)
	public String listCastes( Model model) {
	        model.addAttribute("caste", new Caste());
	        model.addAttribute("listCaste", casteService.getAllCastes());
	        AbstractAuthenticationToken auth = (AbstractAuthenticationToken)SecurityContextHolder.getContext().getAuthentication();
	        model.addAttribute("user_role", auth.getAuthorities());
	        return "list_caste";
	 }
	
	//Show Add Caste Form
	@RequestMapping(value = "add_caste", method = RequestMethod.GET)
	public String addCasteForm(Model model) {
		Caste caste=new Caste();
		caste.setCaste_id("");
		caste.setCaste_name("");
		model.addAttribute("caste", caste);
		return "add_caste";
	}
	
	//Add Caste 
	@RequestMapping(value = "castes/add", method = RequestMethod.POST)
    public String addCaste(@ModelAttribute("caste") Caste caste, 
    		 Model model) {
		try {
			casteService.addCaste(caste);
		}
        catch(Exception ex) {
        	model.addAttribute("errorMsg", "Caste Id already exist");
        	return "add_caste";
        }
		return "redirect:/castes";
    }
	
	//Show Edit Caste Form
	@RequestMapping("editCaste/{caste_id}")
    public String editCasteForm(@PathVariable("caste_id") String id, Model model) {
		model.addAttribute("caste", casteService.getCaste(id));
		return "edit_caste";
    }
	
	//Edit Caste
	@RequestMapping(value = "castes/edit", method = RequestMethod.POST)
    public String editCaste(@ModelAttribute("caste") Caste caste,
    		final RedirectAttributes redirectAttributes) {
        casteService.updateCaste(caste);
        redirectAttributes.addFlashAttribute("msg", "Updated Successfully!");
        return "redirect:/castes";
    }

	//Delete Caste
	@RequestMapping("removeCaste/{caste_id}")
    public String removeCaste(@PathVariable("caste_id") String id,
    		final RedirectAttributes redirectAttributes) {
        casteService.removeCaste(id);
        redirectAttributes.addFlashAttribute("msg", "Deleted Successfully!");
        return "redirect:/castes";
    }
	
	
}
