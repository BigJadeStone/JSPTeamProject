package com.classboard.service;

import java.util.ArrayList;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.classboard.model.ClassBoardDAO;
import com.classboard.model.ClassBoardVO;

public class CBServiceImpl implements CBService {
	

	//작성글 등록 메서드
	public void regist(HttpServletRequest request, HttpServletResponse response) {
		
		HttpSession session = request.getSession();
		
		String id = (String)session.getAttribute("user_id");
		String title = request.getParameter("title");
		String content = request.getParameter("content");
		String classNo = request.getParameter("classNo");
		
		//classNo 제대로 넘어오는지 확인.
		System.out.println(classNo);
		
		//DAO에서 데이터베이스랑 작업하는 regist메서드 만들고오기.
		//DAO
		ClassBoardDAO dao = ClassBoardDAO.getInstance();
		dao.regist(id, title, content, classNo);
	}

	//게시판 모든 글 조회 메서드 , list 페이지
	public ArrayList<ClassBoardVO> getList(HttpServletRequest request, HttpServletResponse response) {
		
		//session 객체 생성
		HttpSession session = request.getSession();
		String classNo = (String)session.getAttribute("user_classNo");
		
		ClassBoardDAO dao = ClassBoardDAO.getInstance();
		ArrayList<ClassBoardVO> list = dao.getList(classNo);
		
		//글 잘 넘어오는지 확인
//		for(ClassBoardVO vo : list) {
//			System.out.println(vo);
//		}
		
		return list;
	}

	//게시판에 글 내용 확인 메서드
	public ClassBoardVO getContent(HttpServletRequest request, HttpServletResponse response) {
		
		//해당 글 조회를 위해서 글 번호가 필요
		String cbno = request.getParameter("cbno");
		
		//dao 생성
		ClassBoardDAO dao = ClassBoardDAO.getInstance();
		ClassBoardVO vo = dao.getContent(cbno);
		
		return vo;
	}

	//글 수정 메서드
	public void update(HttpServletRequest request, HttpServletResponse response) {
		
		//수정전에 수정할 글 출력하기 위해서 pk값인 cbno를 받음
		String cbno = request.getParameter("cbno");
		
		//변경할 내용들 -> title, content
		String title = request.getParameter("title");
		String content = request.getParameter("content");
		
		//dao메서드 호출
		ClassBoardDAO dao = ClassBoardDAO.getInstance();
		dao.update(cbno, title, content);
		
	}

	//글 삭제 메서드
	public void delete(HttpServletRequest request, HttpServletResponse response) {
		
		String cbno = request.getParameter("cbno");
		
		//DAO
		ClassBoardDAO dao = ClassBoardDAO.getInstance();
		dao.delete(cbno);
		
	}
	
	
	
	
	
	

}
