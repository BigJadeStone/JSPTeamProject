package com.classboard.filter;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebFilter({"/classboard/classboard_modify.classboard",
			"/classboard/updateForm.classboard",
			"/classboard/classboard_delete.classboard"})//경로

public class CBAuthFilter implements Filter{

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		
		/*
		 * 세션의 user_id와 request로 넘어오는 작성자가 다르면 수정불가.
		 * 
		 * 1.각 요청경로에서 writer가 파라미터로 반드시 전달되도록 처리.
		 */
		request.setCharacterEncoding("utf-8");
		
		//권한검사
		HttpServletRequest req = (HttpServletRequest)request;
		HttpServletResponse res = (HttpServletResponse)response;
		
		//각요청에 넘어오는 writer파라미터
		String writer = request.getParameter("writer");
		
		//세션에 저장된 user_id, user_teacher
		HttpSession session = req.getSession();
		String user_id = (String)session.getAttribute("user_id");
		String user_teacher = (String)session.getAttribute("user_teacher");
		String user_classNo = (String)session.getAttribute("user_classNo");
		
//		System.out.println("글쓴이: "+ writer);
//		System.out.println("세션ID: " + user_id);
//		System.out.println("user_teacher: " + user_teacher);
//		System.out.println("user_classNo: " + user_classNo);
		
		
		
		if(writer.equals(user_id)  || user_teacher== null ) {
			
			chain.doFilter(request, response);
			
		} else if(!writer.equals(user_id) || user_teacher != null){
			
			String path = req.getContextPath(); //컨택스트패스
			System.out.println(path);
			
			res.setContentType("text/html; charset=utf-8");
			PrintWriter out = res.getWriter();
			out.println("<script>");
			out.println("alert('권한이 필요한 기능입니다');");
			out.println("location.href='"+path+"/classboard/classboard_list.classboard"+"';");
			out.println("</script>");
			
		}
		
		
		
		
		
		
		
		
//		if(!writer.equals(user_id)) {
//			
//			String path = req.getContextPath(); //컨택스트패스
//			System.out.println(path);
//			
//			res.setContentType("text/html; charset=utf-8");
//			PrintWriter out = res.getWriter();
//			out.println("<script>");
//			out.println("alert('권한이 필요한 기능입니다');");
//			out.println("location.href='"+path+"/classboard/classboard_list.classboard"+"';");
//			out.println("</script>");
//			
//			return;
//		}
//		chain.doFilter(request, response);
		
		
	}

}
