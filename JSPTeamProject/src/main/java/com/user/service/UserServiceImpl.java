package com.user.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.user.model.UserDAO;
import com.user.model.UserVO;

public class UserServiceImpl implements UserService{

	//로그인
	public UserVO login(HttpServletRequest request, HttpServletResponse response) {
		
		String id = request.getParameter("id");
		String pw = request.getParameter("pw");
		
		//dao확인작업 
		UserDAO dao = UserDAO.getInstance();
		UserVO vo = dao.login(id, pw);
		
		return vo;
	}

	//회원정보 획득
	public UserVO getInfo(HttpServletRequest request, HttpServletResponse response) {
		
		//서비스영역에서 세션으로 유저ID값 가져오기
		HttpSession session = request.getSession();
		String id = (String)session.getAttribute("user_id");
		
		//dao작업
		UserDAO dao = UserDAO.getInstance();
		UserVO vo = dao.getInfo(id);
		return vo;
	}

	@Override
	public UserVO update(HttpServletRequest request, HttpServletResponse response) {
		
		String id = request.getParameter("id");
		String pw = request.getParameter("pw");
		String name = request.getParameter("name");
		String age = request.getParameter("age");
		String gender = request.getParameter("gender");
		String classNo = request.getParameter("classNo");
		String teacher = request.getParameter("teacher");
		
		//신규정보 업데이트
		UserDAO udao = UserDAO.getInstance();
		udao.update(id, pw, name, age, classNo);
		
		//신규정보를 가지고 나가야하므로
		UserVO vo = udao.getInfo(id);
		return vo;
		
	}
	

}
