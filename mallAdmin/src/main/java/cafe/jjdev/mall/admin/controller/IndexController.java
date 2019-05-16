package cafe.jjdev.mall.admin.controller;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class IndexController {
	
	@GetMapping("/")	
	public String index(HttpSession session) {
		if(session.getAttribute("adminId") == null) {
			return "redirect:" + "/admin/login";
		} else {
			System.out.println("[IndexController]\t index.jsp로 이동");
			return "index";
		}
	}
}