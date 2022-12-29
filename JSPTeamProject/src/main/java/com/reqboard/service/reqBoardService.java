package com.reqboard.service;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.reqboard.model.reqBoardVO;

public interface reqBoardService {
	
	//글작성
	public void regist(HttpServletRequest request, HttpServletResponse response);
	
	//글목록
	public ArrayList<reqBoardVO> getList(HttpServletRequest request, HttpServletResponse response);

	//글보기
	public reqBoardVO getContent(HttpServletRequest request, HttpServletResponse response);
	
	//글수정
	public void update(HttpServletRequest request, HttpServletResponse response);
	
	//글삭제
	public int delete(HttpServletRequest request, HttpServletResponse response);
}
