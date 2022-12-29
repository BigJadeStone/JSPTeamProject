package com.jobboard.filter;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


@WebFilter({"/JobBoard/JobBoard_write.jobboard",
		"/JobBoard/JobBoard_modify.jobboard",
		"/JobBoard/registForm.jobboard",
		"/JobBoard/updateForm.jobboard",
		"/JobBoard/JobBoard_delete.jobboard"})
public class JAuthFilter extends HttpFilter implements Filter {
       
	//User 컬럼 teacher에서 null값일 경우 글 작성 가능, null이 없을 경우 글 작성 불가능
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		request.setCharacterEncoding("utf-8");
		
		HttpServletRequest req = (HttpServletRequest)request;
		HttpServletResponse res = (HttpServletResponse)response;
		
		HttpSession session = req.getSession();
		String teacher = (String)session.getAttribute("user_teacher");
		
		//담당선생님이 있을경우 학생이므로 작성권한을 없앤다.
		if(teacher != null) {
			
			String path = req.getContextPath();
			
			res.setContentType("text/html; charset=UTF-8");
			PrintWriter out = res.getWriter();
			out.println("<script>");
			out.println("alert('권한이 없습니다.');");
			out.println("location.href='"+ path + "/user/user_login.user" +"';");
			out.println("</script>");
    	  
			return;
		}
		
		
		chain.doFilter(request, response);
	}
}