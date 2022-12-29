package com.reqboard.model;

import java.sql.Timestamp;

public class reqBoardVO {
	
	private int rbno;
	private String id;
	private String title;
	private String content;
	private Timestamp regdate;
	
	//생성자
	public reqBoardVO() {
	}

	public reqBoardVO(int rbno, String id, String title, String content, Timestamp legdate) {
		super();
		this.rbno = rbno;
		this.id = id;
		this.title = title;
		this.content = content;
		this.regdate = legdate;
	}

	//get & set
	public int getRbno() {
		return rbno;
	}

	public void setRbno(int rbno) {
		this.rbno = rbno;
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

	public void setRegdate(Timestamp legdate) {
		this.regdate = legdate;
	}

	

}
