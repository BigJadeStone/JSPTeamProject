package com.sharecomment.service;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.sharecomment.model.ShareCommentDAO;
import com.sharecomment.model.ShareCommentVO;

public class ShareCommentServiceImpl implements ShareCommentService {

	@Override
	public void regist(HttpServletRequest request, HttpServletResponse response) {
		HttpSession session = request.getSession();
		
		String comment_id = (String) session.getAttribute("user_id");
		int comment_boardNum = Integer.parseInt(request.getParameter("sbno"));
		if(comment_boardNum == Integer.parseInt(request.getParameter("sbno"))) {
			System.out.println("맞음");
		}
		String comment_content = request.getParameter("comment_content");
		
		ShareCommentDAO dao = ShareCommentDAO.getInstance();
		dao.regist(comment_id, comment_content, comment_boardNum);
		
	}

	@Override
	public ArrayList<ShareCommentVO> getList(HttpServletRequest request, HttpServletResponse response) {
		ShareCommentDAO dao = ShareCommentDAO.getInstance();
		ArrayList<ShareCommentVO> list = dao.getList();
		return list;
	}

	@Override
	public int delete(HttpServletRequest request, HttpServletResponse response) {
		String boardNum = request.getParameter("boardNum");
		ShareCommentDAO dao = ShareCommentDAO.getInstance();
		int result = dao.delete(boardNum);
		return result;
	}

	
}
