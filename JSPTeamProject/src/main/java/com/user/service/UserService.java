package com.user.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.user.model.UserVO;

public interface UserService {
	
	//로그인
	public UserVO login(HttpServletRequest request, HttpServletResponse response);
	
	//유저정보 획득
	public UserVO getInfo(HttpServletRequest request, HttpServletResponse response);

	//회원정보수정
	public UserVO update(HttpServletRequest request, HttpServletResponse response);
}
