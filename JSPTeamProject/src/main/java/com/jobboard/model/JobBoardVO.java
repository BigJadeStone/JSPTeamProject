package com.jobboard.model;

import java.sql.Timestamp;

import com.user.model.UserVO;

public class JobBoardVO {

	private int jno;
	private String id;
	private String title;
	private String content;
	private Timestamp regdate;
	
	UserVO vo = new UserVO();
	
			
	public JobBoardVO() {
		super();
		
	}


	public JobBoardVO(int jno, String id, String title, String content, Timestamp regdate) {
		super();
		this.jno = jno;
		this.id = id;
		this.title = title;
		this.content = content;
		this.regdate = regdate;
	}


	public int getJno() {
		return jno;
	}


	public void setJno(int jno) {
		this.jno = jno;
	}


	public String getId() {
		return id;
	}


	public void setId(String id) {
		this.id = id;
	}


	public String getTitle() {
		return title;
	}


	public void setTitle(String title) {
		this.title = title;
	}


	public String getContent() {
		return content;
	}


	public void setContent(String content) {
		this.content = content;
	}


	public Timestamp getRegdate() {
		return regdate;
	}


	public void setRegdate(Timestamp regdate) {
		this.regdate = regdate;
	}

	

	
}
