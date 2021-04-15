package com.kitri.visitor.controller;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.kitri.visitor.service.VisitorService;
import com.kitri.visitor.service.VisitorServiceImpl;
import com.kitri.visitor.vo.VisitorVO;

@Controller
@RequestMapping("/visit")
public class VisitorController {
	
	// VisitorServiceImpl 객체
	@Resource(name = "visitorServiceImpl")
	VisitorService visitorService;
		
	
	
	@RequestMapping("")
	public String visitor(Model model, @RequestParam(defaultValue = "")String msg) {
		// model : request를 대체 가능한 객체
		System.out.println("visitor 호출");
		// 메인화면 실행될 때 바로 list 보여주도록
		List<VisitorVO> vList = visitorService.visitorList();
		model.addAttribute("vList", vList);
		
		return "visitor/visitor";	// ${contextPath}/WEB-INF/views/visitor/visitor.jsp
	}
	
	@RequestMapping(value = "/v-regist", method = RequestMethod.POST)
	public String vRegist(VisitorVO vo){
		visitorService.visitorRegist(vo);
		return "redirect: /visitor/visit";
	}
	
	@RequestMapping(value = "/update")
	public void update(VisitorVO vo, HttpServletResponse response) {
		System.out.println(vo.toString());
		String result = visitorService.visitorUpdate(vo);
		
		try {
			response.getWriter().print(result);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@RequestMapping(value = "/delete")
	public void delete(VisitorVO vo, HttpServletResponse response) {
		System.out.println("vo: "+vo);
		String result = visitorService.visitorDelete(vo.getvNo(), vo.getvPwd());
		
		try {
			response.getWriter().print(result);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
