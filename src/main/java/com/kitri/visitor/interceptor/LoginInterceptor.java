package com.kitri.visitor.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

// implements 원하는 요청에 대해서만 interceptor할 수 있게 <-> extends는 모든 요청에 대해서 interceptor
public class LoginInterceptor implements HandlerInterceptor{

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		// 세션 만들기
		
		HttpSession session = request.getSession();
		String id = (String) session.getAttribute("login");
		
		boolean flag = false;
		System.out.println("id="+id);
		if(id != null) {
			// 로그인 상태
			flag = true;
		} else {
			// 로그아웃 상태
			flag = false;
			response.sendRedirect("/visit?msg=test");
		}
		return flag;
		// return 값이 false이면 postHandle로 넘어가지 않는다
	}

	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
		// TODO Auto-generated method stub
		
	}

}
