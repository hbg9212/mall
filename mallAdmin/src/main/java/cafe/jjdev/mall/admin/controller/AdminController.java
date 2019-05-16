package cafe.jjdev.mall.admin.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import cafe.jjdev.mall.admin.service.AdminService;
import cafe.jjdev.mall.admin.vo.Member;

@Controller
public class AdminController {

	@Autowired
	private AdminService adminService;
	
	@GetMapping("/admin/login")
	public String adminLogin() {
		return "/admin/login";
	}
	
	@PostMapping("/admin/login")
	public String adminLogin(HttpSession seesion, Member member) {
		Member loginMember = adminService.getMember(member);
		if(loginMember == null) {
			return "redirect:" + "/";
		} else {
			System.out.println("로그인 성공");
			seesion.setAttribute("adminNo", loginMember.getMemberNo());
			seesion.setAttribute("adminId", loginMember.getMemberId());
			seesion.setAttribute("adminName", loginMember.getMemberName());
			seesion.setAttribute("adminLevel", loginMember.getMemberLevel());
			return "redirect:" + "/";
		}
	}
	
	@GetMapping("/admin/logout")
	public String logout(HttpSession session) {
		session.invalidate();
		return "redirect:" + "/";
	}
}
