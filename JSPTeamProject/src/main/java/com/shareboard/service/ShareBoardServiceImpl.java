package com.shareboard.service;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.shareboard.model.ShareBoardDAO;
import com.shareboard.model.ShareBoardVO;
import com.user.model.UserDAO;
import com.user.model.UserVO;

public class ShareBoardServiceImpl implements ShareBoardService {
	@Override
	public void regist(HttpServletRequest request, HttpServletResponse response) {
		
		//화면에서 입력한 값을 받아오는 작업
		String writer = request.getParameter("writer");
		String title = request.getParameter("title");
		String content = request.getParameter("content");
		
		//dao객체 생성
		ShareBoardDAO dao = ShareBoardDAO.getInstance();
		
		
		dao.regist(writer, title, content);
	}

	@Override
	public ArrayList<ShareBoardVO> getList(HttpServletRequest request, HttpServletResponse response) {
		ShareBoardDAO dao = ShareBoardDAO.getInstance();
		ArrayList<ShareBoardVO> list = dao.getList();
		
		return list;
	}

	@Override
	public ShareBoardVO getContent(HttpServletRequest request, HttpServletResponse response) {
		String sbno = request.getParameter("sbno");
		ShareBoardDAO dao = ShareBoardDAO.getInstance();
		ShareBoardVO vo = dao.getContent(sbno);
		return vo;
	}


	@Override
	public void update(HttpServletRequest request, HttpServletResponse response) {
		//화면에서 넘어오는 값
		String sbno = request.getParameter("sbno");
		String title = request.getParameter("title");
		String content = request.getParameter("content");
		ShareBoardDAO dao = ShareBoardDAO.getInstance();
		dao.update(sbno, title, content);
		
	}

	@Override
	public int delete(HttpServletRequest request, HttpServletResponse response) {
		String sbno = request.getParameter("sbno");
		ShareBoardDAO dao = ShareBoardDAO.getInstance();
		int result = dao.delete(sbno);
		
		return result;
	}
	
	
	
	
	
	
	
}
