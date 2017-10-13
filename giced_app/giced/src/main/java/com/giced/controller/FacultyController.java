package com.giced.controller;

import java.text.SimpleDateFormat;
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

import com.giced.model.Appointment_Type;
import com.giced.model.Caste;
import com.giced.model.Category;
import com.giced.model.Countries;
import com.giced.model.Designation;
import com.giced.model.Faculty;
import com.giced.model.SubCaste;
import com.giced.model.Users;
import com.giced.service.AppointmentService;
import com.giced.service.CasteService;
import com.giced.service.CategoryService;
import com.giced.service.CountriesService;
import com.giced.service.DesignationService;
import com.giced.service.FacultyService;
import com.giced.service.SubCasteService;
import com.giced.service.UsersService;

@Controller
public class FacultyController {
	private FacultyService facultyService;
	private UsersService userService;
	private DesignationService designationService;
	private CountriesService countriesService;
	private CasteService casteService;
	private SubCasteService subcasteService;
	private CategoryService catService;
	private AppointmentService appointmentService;
	
	@Autowired
	public void setUserService(UsersService userService) {
		this.userService = userService;
	}

	@Autowired
	public void setFacultyService(FacultyService facultyService) {
		this.facultyService = facultyService;
	}
	
	@Autowired
	public void setDesignationService(DesignationService designationService) {
		this.designationService = designationService;
	}

	@Autowired
	public void setCountriesService(CountriesService countriesService) {
		this.countriesService = countriesService;
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
	public void setCategoryService(CategoryService catService) {
		this.catService = catService;
	}

	@Autowired
	public void setAppointmentService(AppointmentService appointmentService) {
		this.appointmentService = appointmentService;
	}

	//Show Faculty List
	@RequestMapping(value = "faculties", method = RequestMethod.GET)
	public String listFaculties( Model model) {
	        model.addAttribute("listFaculties", facultyService.getAllFaculties());
	        AbstractAuthenticationToken auth = (AbstractAuthenticationToken)SecurityContextHolder.getContext().getAuthentication();
	        model.addAttribute("user_role", auth.getAuthorities());
	        return "list_faculty";
	 }
	
		//Show Add Faculty Form
		@RequestMapping(value = "add_faculty", method = RequestMethod.GET)
		public String addFacultyForm(Model model) {
			model.addAttribute("faculty", new Faculty());
			model.addAttribute("listDesignation", designationService.getAllDesignations());
			model.addAttribute("listCountries", countriesService.getAllCountries());
			model.addAttribute("listCaste", casteService.getAllCastes());
			model.addAttribute("listCategory",catService.getAllCategories());
			model.addAttribute("listAppt",appointmentService.getAllAppointments());
			return "add_faculty";
		}
		
		
	
	@RequestMapping(value="getSubCaste.json")
	@ResponseStatus(HttpStatus.OK)
	public @ResponseBody  List<SubCaste> getSubCasteList(@RequestParam(value = "caste_id", required = true) String caste_id,
			@ModelAttribute("faculty") Faculty faculty, ModelMap modelMap ){
		//HashMap<String,String>  hashSubCaste = new HashMap<String,String>();
	    List<SubCaste> listSubCaste = subcasteService.getSubCasteforCaste(caste_id);
	    return listSubCaste;
	}
	
	//Add Faculty and Corresponding details into User
	@RequestMapping(value = "faculties/add", method = RequestMethod.POST)
    public String addFaculty(@ModelAttribute("faculty") Faculty faculty, Model model) {
		try {
			facultyService.addFaculty(faculty);
			Users user=new Users();
			user.setUser_name(faculty.getUser_name());
			user.setRole_id("FACULTY");
			model.addAttribute("user_role", "faculty");
			model.addAttribute("user", user);
		}
        catch(Exception ex) {
        	model.addAttribute("errorMsg", "Faculty Id/User Id already exist");
        	model.addAttribute("listDesignation", designationService.getAllDesignations());
			model.addAttribute("listCountries", countriesService.getAllCountries());
			model.addAttribute("listCaste", casteService.getAllCastes());
			model.addAttribute("listCategory",catService.getAllCategories());
			model.addAttribute("listAppt",appointmentService.getAllAppointments());
        	return "add_faculty";
        }
		
		return "add_user";

		
    }
	
	//Show Edit Faculty Form
	@RequestMapping("editFaculty/{faculty_id}/{user}")
    public String editFacultyForm(@PathVariable("faculty_id") String id,@PathVariable("user") String user , Model model) {
		Faculty faculty=facultyService.getFaculty(id);
		model.addAttribute("faculty",faculty);
		Date dob=faculty.getFaculty_dob();
		SimpleDateFormat outFormat = new SimpleDateFormat("MM/dd/yyyy");
		String formatted = outFormat.format(dob);
		model.addAttribute("dob",formatted);
		model.addAttribute("listDesignation", designationService.getAllDesignations());
		model.addAttribute("listCountries", countriesService.getAllCountries());
		model.addAttribute("listCaste", casteService.getAllCastes());
		model.addAttribute("listSubCaste", subcasteService.getSubCasteforCaste(faculty.getFaculty_caste()));
		model.addAttribute("listCategory",catService.getAllCategories());
		model.addAttribute("listAppt",appointmentService.getAllAppointments());
		if(user.equals("faculty")) {
			model.addAttribute("faculty_profile", "faculty_profile");
		}
	    return "edit_faculty";
    }
	
	//Show Faculty Form
	@RequestMapping("showFaculty/{faculty_id}")
	public String showFacultyForm(@PathVariable("faculty_id") String id, Model model) {
		Faculty faculty=facultyService.getFaculty(id);
		model.addAttribute("faculty",faculty);
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
	
	//Edit Faculty and Corresponding details from User
	@RequestMapping(value = "faculties/edit", method = RequestMethod.POST)
    public String editFaculty(@ModelAttribute("faculty") Faculty faculty) {
        facultyService.updateFaculty(faculty);
        return "redirect:/faculties";
    }

	//Delete Faculty and Corresponding details from User
	@RequestMapping("removeFaculty/{faculty_id}")
    public String removeFaculty(@PathVariable("faculty_id") String id) {
        facultyService.removeFaculty(id);
        userService.removeUser(id);
        return "redirect:/faculties";
    }
	
	
}
