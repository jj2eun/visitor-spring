package com.kitri.visitor.controller;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/member")
public class MemberController {

	@RequestMapping("/login")
	public String login(HttpSession session) {
		session.setAttribute("login", "id");
		
		return "redirect: /visitor/visit";
	}
	
	@RequestMapping("/logout")
	public String logout(HttpSession session) {
		if(session.getAttribute("login") != null) {
			session.invalidate();
		}
		
		return "redirect: /visitor/visit";
	}
}
