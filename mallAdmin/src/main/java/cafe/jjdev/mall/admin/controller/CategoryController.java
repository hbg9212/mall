package cafe.jjdev.mall.admin.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import cafe.jjdev.mall.admin.service.CategoryService;
import cafe.jjdev.mall.admin.vo.Category;

@Controller
public class CategoryController {
	@Autowired
	private CategoryService categoryService;
	
	@GetMapping("/category/addCategory")
	public String addCategory(HttpSession session) {
		if(session.getAttribute("adminId") == null) {
			return "redirect:" + "/admin/login";
		} else {
			return "/category/addCategory";
		}
		
	}
	
	@PostMapping("/category/addCategory")
	public String addCategory(HttpSession session, Category category) {
		if(session.getAttribute("adminId") == null) {
			return "redirect:" + "/admin/login";
		} else {
			categoryService.addCategory(category);
			return "redirect:" +"/category/categoryLsit";
		}

	}
	
	@GetMapping("/category/categoryLsit")
	public String getCategoryList(HttpSession session, Model model) {
		if(session.getAttribute("adminId") == null) {
			return "redirect:" + "/admin/login";
		} else {
			List<Category> category = categoryService.getCategoryList();
			model.addAttribute("category", category);
			return "/category/categoryList";
		}

	}
}
