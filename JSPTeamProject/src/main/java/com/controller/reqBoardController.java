package com.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.reqboard.model.reqBoardVO;
import com.reqboard.service.reqBoardServiceImpl;
import com.user.service.UserServiceImpl;

@WebServlet("*.reqBoard")
public class reqBoardController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public reqBoardController() {
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doAction(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doAction(request, response);
	}

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
		reqBoardServiceImpl service = new reqBoardServiceImpl();
		HttpSession session = request.getSession(); //자바에서 세션얻기
		
		if(command.equals("/reqBoard/reqBoard_write.reqBoard")) { //등록화면
			
			request.getRequestDispatcher("/reqBoard/reqBoard_write.jsp").forward(request, response);
		
		}else if(command.equals("/reqBoard/regist_Form.reqBoard")) { //글등록
			
			service.regist(request, response);
			response.sendRedirect("reqBoard_list.reqBoard"); //컨트롤러 타도록 정리
		
		}else if(command.equals("/reqBoard/reqBoard_list.reqBoard")) { //글목록
			
			ArrayList<reqBoardVO> list = service.getList(request, response);
			request.setAttribute("list", list); //목록화면에 데이터 뿌려주기위해 request사용
			
			request.getRequestDispatcher("/reqBoard/reqBoard_list.jsp").forward(request, response);
		}else if(command.equals("/reqBoard/reqBoard_content.reqBoard")) { //상세화면
			
			//글정보 가져오기
			reqBoardVO vo = service.getContent(request, response);
			request.setAttribute("vo", vo);
			
			request.getRequestDispatcher("/reqBoard/reqBoard_content.jsp").forward(request, response);
			
		}else if(command.equals("/reqBoard/reqBoard_modify.reqBoard")) { //수정화면
			
			//글정보 가져오기
			reqBoardVO vo = service.getContent(request, response);
			request.setAttribute("vo", vo);
			
			request.getRequestDispatcher("/reqBoard/reqBoard_modify.jsp").forward(request, response);
			
		}else if(command.equals("/reqBoard/reqBoard_Form.reqBoard")) { //수정완료했다면
			
			service.update(request, response);
			response.sendRedirect("reqBoard_content.reqBoard?rbno=" +request.getParameter("rbno"));
			
		}else if(command.equals("/reqBoard/reqBoard_delete.reqBoard")) { //삭제요청
			
			int result = service.delete(request, response);
			
			String msg = "";
			
			if(result == 1) { //삭제성공
				
				msg = "글을 삭제하였습니다.";
			}else { //삭제실패
				msg = "글 삭제에 실패하였습니다.";
			}
			
			//out객체를 이용해서 화면에 스크립트를 작성해서 보냄
			response.setContentType("text/html; charset=utf-8");
			PrintWriter out = response.getWriter();
			out.println("<script>");
			out.println("alert('"+ msg +"');");
			out.println("location.href='reqBoard_list.reqBoard';");
			out.println("</script>");
			
		}

	}
}
