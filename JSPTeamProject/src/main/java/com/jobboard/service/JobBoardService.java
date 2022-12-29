package com.jobboard.service;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jobboard.model.JobBoardVO;

public interface JobBoardService {

	public void Jobregist(HttpServletRequest request, HttpServletResponse response);
	
	public ArrayList<JobBoardVO> JobgetList(HttpServletRequest request, HttpServletResponse response);
	
	public JobBoardVO JobgetContent(HttpServletRequest request, HttpServletResponse response);
	
	
	public void update(HttpServletRequest request, HttpServletResponse response);
	
	public void delete(HttpServletRequest request, HttpServletResponse response);
	
	
}
