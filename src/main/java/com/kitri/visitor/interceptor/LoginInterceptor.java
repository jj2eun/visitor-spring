package com.kitri.visitor.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

// implements ���ϴ� ��û�� ���ؼ��� interceptor�� �� �ְ� <-> extends�� ��� ��û�� ���ؼ� interceptor
public class LoginInterceptor implements HandlerInterceptor{

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		// ���� �����
		
		HttpSession session = request.getSession();
		String id = (String) session.getAttribute("login");
		
		boolean flag = false;
		System.out.println("id="+id);
		if(id != null) {
			// �α��� ����
			flag = true;
		} else {
			// �α׾ƿ� ����
			flag = false;
			response.sendRedirect("/visit?msg=test");
		}
		return flag;
		// return ���� false�̸� postHandle�� �Ѿ�� �ʴ´�
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
