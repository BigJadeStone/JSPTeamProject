package com.classboard.service;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.classboard.model.ClassBoardVO;

public interface CBService {
	
	//작성글 등록 메서드
	public void regist(HttpServletRequest request, HttpServletResponse response); 
	//글 조회 메서드
	public ArrayList<ClassBoardVO> getList(HttpServletRequest request, HttpServletResponse response);
	//글 내용 확인 메서드
	public ClassBoardVO getContent(HttpServletRequest request, HttpServletResponse response);
	//글 수정 메서드
	public void update(HttpServletRequest request, HttpServletResponse response);  
	//글 삭제 메서드
	public void delete(HttpServletRequest request, HttpServletResponse response);
	
}
