package com.reqboard.service;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.reqboard.model.reqBoardDAO;
import com.reqboard.model.reqBoardVO;

public class reqBoardServiceImpl implements reqBoardService{

	//글작성
	public void regist(HttpServletRequest request, HttpServletResponse response) {
		
		String id = request.getParameter("id");
		String title = request.getParameter("title");
		String content = request.getParameter("content");

		//싱글톤 db객체 호출
		reqBoardDAO dao = reqBoardDAO.getInstance();
		dao.regist(id, title, content);
	}
	
	//글리스트 가저오기
	public ArrayList<reqBoardVO> getList(HttpServletRequest request, HttpServletResponse response) {
		
		reqBoardDAO dao = reqBoardDAO.getInstance();
		ArrayList<reqBoardVO> list = dao.getlist();
		
		return list;
	}

	//글내용 가져오기
	public reqBoardVO getContent(HttpServletRequest request, HttpServletResponse response) {
		
		String rbno = request.getParameter("rbno");
		
		reqBoardDAO dao = reqBoardDAO.getInstance();
		reqBoardVO vo = dao.getContent(rbno);
		
		return vo;
	}

	public void update(HttpServletRequest request, HttpServletResponse response) {
		
		String rbno = request.getParameter("rbno");
		String tilte = request.getParameter("title");
		String content = request.getParameter("content");
		
		reqBoardDAO dao = reqBoardDAO.getInstance();
		dao.update(tilte, content, rbno);
		
	}

	public int delete(HttpServletRequest request, HttpServletResponse response) {
		
		String rbno = request.getParameter("rbno");
		reqBoardDAO dao = reqBoardDAO.getInstance();
		int result = dao.delete(rbno);
		
		return result;
	}

}
