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

import com.giced.model.Category;
import com.giced.service.CategoryService;


@Controller
public class CategoryController {
	
	private CategoryService catService;
	
	@Autowired
    public void setCatService(CategoryService catService) {
        this.catService = catService;
    }

	//Show Category List
	@RequestMapping(value = "categories", method = RequestMethod.GET)
	public String listCategoryss(Model model) {
	        model.addAttribute("cat", new Category());
	        model.addAttribute("listCat", catService.getAllCategories());
	        AbstractAuthenticationToken auth = (AbstractAuthenticationToken)SecurityContextHolder.getContext().getAuthentication();
	        model.addAttribute("user_role", auth.getAuthorities());
	        return "list_category";
	 }
	
	//Show Add Category Form
	@RequestMapping(value = "add_category", method = RequestMethod.GET)
	public String addCategoryForm(Model model) {
		Category cat=new Category();
		cat.setCategory_id("");
		cat.setCategory_name("");
		model.addAttribute("cat", cat);
		return "add_category";
	}
	
	//Add Category 
	@RequestMapping(value = "categories/add", method = RequestMethod.POST)
    public String addCategory(@ModelAttribute("cat") Category cat, 
    		 Model model) {
    	try {
    		catService.addCategory(cat);
    	}
        catch(Exception ex) {
    		model.addAttribute("errorMsg", "Category Id already exist");
    	    return "add_category";
    	}
		return "redirect:/categories";
    }
	
	//Show Edit Category Form
	@RequestMapping("editCategory/{category_id}")
    public String editCategoryForm(@PathVariable("category_id") String id, Model model) {
		model.addAttribute("cat", catService.getCategory(id));
		return "edit_category";
    }
	
	//Edit Category
	@RequestMapping(value = "categories/edit", method = RequestMethod.POST)
    public String editCategory(@ModelAttribute("cat") Category cat,
    		final RedirectAttributes redirectAttributes) {
		catService.updateCategory(cat);
        redirectAttributes.addFlashAttribute("msg", "Updated Successfully!");
        return "redirect:/categories";
    }

	//Delete Category
	@RequestMapping("removeCategory/{category_id}")
    public String removeCategory(@PathVariable("category_id") String id,
    		final RedirectAttributes redirectAttributes) {
		catService.removeCategory(id);
        redirectAttributes.addFlashAttribute("msg", "Deleted Successfully!");
        return "redirect:/categories";
    }
	
	
}
