package com.sharecomment.service;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sharecomment.model.ShareCommentVO;

public interface ShareCommentService {
	
	void regist(HttpServletRequest request, HttpServletResponse response);
	
	ArrayList<ShareCommentVO> getList(HttpServletRequest request, HttpServletResponse response);
	
	int delete(HttpServletRequest request, HttpServletResponse response);
	
}
