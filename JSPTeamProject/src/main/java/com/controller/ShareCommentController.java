package com.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.sharecomment.service.ShareCommentServiceImpl;

@WebServlet("*.cm")
public class ShareCommentController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doAction(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doAction(request, response);
	}

	protected void doAction(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("utf-8");
		
		String uri = request.getRequestURI();
		String path = request.getContextPath();
		String command = uri.substring(path.length());
		
		System.out.println("요청(댓글링크) : " + command);
		
		ShareCommentServiceImpl service = new ShareCommentServiceImpl();
		HttpSession session = request.getSession();
		
		if(command.equals("/shareboard/commentRegi.cm")) { //댓글 등록
			service.regist(request, response);
			response.sendRedirect("shareboard_content.sb?sbno=" + request.getParameter("sbno"));
		}
		else if(command.equals("/shareboard/sharecomment_delete.cm")) { //댓글 삭제
			int result = service.delete(request, response);
			String msg = "";
			if(result == 1) {
				msg = "삭제되었습니다";
			} else {
				msg = "댓글 삭제 실패";
			}
			response.setContentType("text/html; charset=utf-8");
			PrintWriter out = response.getWriter();
			out.println("<script>");
			out.println("alert('" + msg + "')");
			out.println("location.href='shareboard_content.sb?sbno=" + request.getParameter("sbno") + "';");
			out.println("</script>");
//			response.sendRedirect("shareboard_content.sb?sbno=" + request.getParameter("sbno"));
		}
		
	}
}
