package com.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.user.model.UserVO;
import com.user.service.UserServiceImpl;

@WebServlet("*.user")
public class UserController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public UserController() {
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doAction(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doAction(request, response);
	}
	
	//get , post 하나로 묶는 작업
	protected void doAction(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//한글처리
		request.setCharacterEncoding("utf-8");
		
		//요청분기 처리
		String uri = request.getRequestURI();
		String path = request.getContextPath();
		
		//기본주소처리
		String command = uri.substring(path.length());
		System.out.println("요청경로> " + command);
		
		//서비스영역
		UserServiceImpl service = new UserServiceImpl();
		HttpSession session = request.getSession(); //자바에서 세션얻기
	
		UserVO vo = new UserVO();
		
		if(command.equals("/user/user_login.user")) { //로그인화면
			
			request.getRequestDispatcher("user_login.jsp").forward(request, response);
		}else if(command.equals("/user/login_Form.user")) { //로그인요청
			
			vo = service.login(request, response);
			
			if(vo == null) { //로그인실패 + 추후 수정수정
				request.setAttribute("msg", "우리 학원 사람이 아닌거같은데");
				request.getRequestDispatcher("user_login.jsp").forward(request, response);
			}else {//로그인 성공
				
				//세션 저장해서 아이디 이름 전달
				session.setAttribute("user_id", vo.getId());
				session.setAttribute("user_name", vo.getName());
				session.setAttribute("user_age", vo.getAge());
				session.setAttribute("user_gender", vo.getGender());
				session.setAttribute("user_classNo", vo.getClassNo());
				session.setAttribute("user_teacher", vo.getTeacher());
				//페이지 이동
				response.sendRedirect("user_mypage.user");//컨트롤러 태우기
				
			}
		}else if(command.equals("/user/user_mypage.user")) {
			
			request.getRequestDispatcher("user_mypage.jsp").forward(request, response);
			
		
		//정보수정
		}else if(command.equals("/user/user_info.user")) {
			
			vo = service.getInfo(request, response);
			request.setAttribute("vo", vo);
			
			request.getRequestDispatcher("user_info.jsp").forward(request, response);
			
		}else if(command.equals("/user/updateForm.user")) {
			
			vo = service.update(request, response);
			session.setAttribute("user_id", vo.getId());
			session.setAttribute("user_pw", vo.getPw());
			session.setAttribute("user_name", vo.getName());
			session.setAttribute("user_age", vo.getAge());
			session.setAttribute("user_gender", vo.getGender());
			session.setAttribute("user_classNo", vo.getClassNo());
			session.setAttribute("user_teacher", vo.getTeacher());
			
			request.getRequestDispatcher("user_mypage.user").forward(request, response);
		}
	
	}
}
