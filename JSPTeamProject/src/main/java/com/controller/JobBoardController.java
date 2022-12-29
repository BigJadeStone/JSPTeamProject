package com.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.jobboard.model.JobBoardVO;
import com.jobboard.service.JobBoardService;
import com.jobboard.service.JobBoardServiceImpl;


@WebServlet("*.jobboard")
public class JobBoardController extends HttpServlet {
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

		String command = uri.substring( path.length() );

		System.out.println("요청경로 : " + command);
		
		//서비스와 세션 객체
		JobBoardService jobservice = new JobBoardServiceImpl();
		HttpSession session = request.getSession();
		
		//상세내용화면 content
		if(command.equals("/JobBoard/JobBoard_content.jobboard")) {
			
			JobBoardVO vo = jobservice.JobgetContent(request, response);
			request.setAttribute("vo", vo);
			
			request.getRequestDispatcher("JobBoard_content.jsp").forward(request, response);
			
			
		//글 작성화면 write ( 관리자는 작성가능, 학생은 읽기만 가능 )	
		}else if(command.equals("/JobBoard/JobBoard_write.jobboard")) {
			
			if(session.getAttribute("user_id") == null) {
				response.sendRedirect("../user/user_login.jsp");
				return;
			}
			
			request.getRequestDispatcher("/JobBoard/JobBoard_write.jsp").forward(request, response);
		
			
		//글의 list를 보여주는 화면
		}else if(command.equals("/JobBoard/JobBoard_list.jobboard")) {
			
			
			//글 조회 메서드블러오기
			ArrayList<JobBoardVO> joblist = jobservice.JobgetList(request, response);
			request.setAttribute("joblist", joblist);
			
			request.getRequestDispatcher("JobBoard_list.jsp").forward(request, response);
		
		
		//글의 수정화면
		}else if(command.equals("/JobBoard/JobBoard_modify.jobboard")) {
			
			JobBoardVO vo = jobservice.JobgetContent(request, response);
			request.setAttribute("vo", vo);
			
			request.getRequestDispatcher("JobBoard_modify.jsp").forward(request, response);
		
			
		// jsp화면구현 컨트롤러
		//글 등록 폼화면
		}else if(command.equals("/JobBoard/registForm.jobboard")) {
			
			jobservice.Jobregist(request, response);
			response.sendRedirect("JobBoard_list.jobboard");
		
			
		//글 수정업데이트 컨트롤러	
		}else if(command.equals("/JobBoard/updateForm.jobboard")) {
			
			jobservice.update(request, response);
			
			response.sendRedirect("JobBoard_content.jobboard?jno=" + request.getParameter("jno"));

		
		//글 삭제 컨트롤러
		}else if(command.equals("/JobBoard/JobBoard_delete.jobboard")) {
			
			jobservice.delete(request, response);
			
			response.sendRedirect("JobBoard_list.jobboard");
		}
		
		
		
		
		
		
		
	}

}
