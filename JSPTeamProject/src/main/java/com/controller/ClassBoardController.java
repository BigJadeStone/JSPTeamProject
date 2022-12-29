package com.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.classboard.model.ClassBoardVO;
import com.classboard.service.CBServiceImpl;

@WebServlet("*.classboard")
public class ClassBoardController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doAction(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doAction(request, response);
	}
	
	protected void doAction(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//한글처리
		request.setCharacterEncoding("UTF-8");
		
		//요청분기
		String uri = request.getRequestURI();
		String path = request.getContextPath();
		String command = uri.substring(path.length());
		
		//서비스 객체 생성
		CBServiceImpl sv = new CBServiceImpl();
		//세션 생성
		HttpSession session = request.getSession(); 
		
		//요청경로 확인
		System.out.println("요청경로>" + command);
		
		switch (command) {
		case "/classboard/classboard_write.classboard": {//글등록 페이지
			
			if(session.getAttribute("user_id")==null) {
				response.sendRedirect("../user/user_login.user");
				return; 
			}
			
			request.getRequestDispatcher("classboard_write.jsp").forward(request, response);
			
			break;
		}
		case "/classboard/registForm.classboard": {//글등록 처리
			
			sv.regist(request, response);
			
			response.sendRedirect("classboard_list.classboard");
			
			break;
		}
		case "/classboard/classboard_list.classboard": {//글목록페이지 - 이게 게시판 진입페이지
			
//			//다른반 학생이면 아얘 게시판의 리스트를 볼 수 없게 하고 mypage창으로 보내rl
//			String user_classNo = (String)session.getAttribute("user_classNo");
//			if(!user_classNo.equals("704")) {
//				response.sendRedirect("/JSPTeamProject/user/user_mypage.user"); //어떤 상황이든 내가 원하는데로 보내주고싶으면 절대경로 사용하기.
//				return;
//			}
			
			//접속한 사람의 classNo를 확인해서 DAO 클래스에서 해당 classNo의 글만 가져오도록 설정해놨음.
			
			//글 목록들의 객체(vo)를 리스트로 받아옴.
			ArrayList<ClassBoardVO> list = sv.getList(request, response);
			//다음페이지로 넘어갈 때 글 리스트정보 갖고 가도록 request에 저장
			request.setAttribute("list", list);
			//forward방식으로 데이터를 갖고 다음 페이지로 넘어감.
			request.getRequestDispatcher("classboard_list.jsp").forward(request, response);
			
			break;
		}
		case "/classboard/classboard_content.classboard": {//글 내용 페이지
			
			ClassBoardVO vo = sv.getContent(request, response);
			//다음페이지로 넘어갈 때 글 내용(vo) 갖고 나감
			request.setAttribute("vo",vo);
			//forward방식으로 content 페이지로 넘어감
			request.getRequestDispatcher("classboard_content.jsp").forward(request,response);
			
			break;
		}
		case "/classboard/classboard_modify.classboard": {//글 수정 페이지
			
			//조회한 글에 대한 정보 조회
			ClassBoardVO vo = sv.getContent(request, response);
			request.setAttribute("vo", vo);
			//forward방식으로 vo 값을 가지고 modify(수정화면) 페이지로 넘어감.
			request.getRequestDispatcher("classboard_modify.jsp").forward(request, response);
			
			break;
		}
		case "/classboard/updateForm.classboard": {//글 수정작업 처리
			
			//글 수정 작업 처리
			sv.update(request, response);
			//글 수정 완료 후 다시 classboard_content 페이지로
			//주의. content 페이지는 어떤 content를 보일지 식별하기 위해 cbno 값이 반드시 필요.
			response.sendRedirect("classboard_content.classboard?cbno="+request.getParameter("cbno"));
			
			break;
		}
		case "/classboard/classboard_delete.classboard": {//글 삭제
			
			//글 삭제 기능 수행
			sv.delete(request, response);
			
			//값을 갖고 가는 것 없이 list 화면으로 보내주기, 물론 컨트롤러 태워서
			response.sendRedirect("classboard_list.classboard");
			
			break;
		}
		default:
			break;
		}
		
		
		
	}

}
