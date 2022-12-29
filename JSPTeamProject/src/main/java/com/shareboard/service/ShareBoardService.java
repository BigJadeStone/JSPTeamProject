package com.shareboard.service;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.shareboard.model.ShareBoardVO;

public interface ShareBoardService {
	
	//public 생략함
	//글 등록하기
	void regist(HttpServletRequest request, HttpServletResponse response);
	
	//글 목록
	ArrayList<ShareBoardVO> getList(HttpServletRequest request, HttpServletResponse response);
	
	//글 내용
	ShareBoardVO getContent(HttpServletRequest request, HttpServletResponse response);
	
	//글 수정
	void update(HttpServletRequest request, HttpServletResponse response);
	
	//글 삭제
	int delete(HttpServletRequest request, HttpServletResponse response);
	
	
}
