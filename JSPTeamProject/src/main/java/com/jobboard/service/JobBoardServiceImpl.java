package com.jobboard.service;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jobboard.model.JobBoardDAO;
import com.jobboard.model.JobBoardVO;
import com.user.model.UserDAO;
import com.user.model.UserVO;

public class JobBoardServiceImpl implements JobBoardService{

	@Override
	public void Jobregist(HttpServletRequest request, HttpServletResponse response) {
		
		String id = request.getParameter("id");
		String title = request.getParameter("title");
		String content = request.getParameter("content");
		
		System.out.println(id);
		
		UserDAO dao = UserDAO.getInstance();
		JobBoardDAO jdao = JobBoardDAO.getInstance();
		
		jdao.Jobregist(id, title, content);
		
	}

	@Override
	public ArrayList<JobBoardVO> JobgetList(HttpServletRequest request, HttpServletResponse response) {
		JobBoardDAO jdao = JobBoardDAO.getInstance();
		ArrayList<JobBoardVO> joblist = jdao.JobgetList();
		
		return joblist;
	}

	@Override
	public JobBoardVO JobgetContent(HttpServletRequest request, HttpServletResponse response) {
		String jno = request.getParameter("jno");
		
		JobBoardDAO jdao = JobBoardDAO.getInstance();
		JobBoardVO vo = jdao.JobgetContent(jno);
		
		return vo;
	}

	@Override
	public void update(HttpServletRequest request, HttpServletResponse response) {
		
		String jno = request.getParameter("jno");
		String title = request.getParameter("title");
		String content = request.getParameter("content");
		
		JobBoardDAO jdao = JobBoardDAO.getInstance();
		jdao.update(jno, title, content);
		
	}

	@Override
	public void delete(HttpServletRequest request, HttpServletResponse response) {
		
		String jno = request.getParameter("jno");
		
		JobBoardDAO jdao = JobBoardDAO.getInstance();
		jdao.delete(jno);
	}

}
