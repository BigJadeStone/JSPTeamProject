package com.shareboard.model;

import java.sql.Timestamp;

public class ShareBoardVO {
	private int sbno;
	private String writer;
	private String title;
	private String content;
	private Timestamp regdate;
	
	public ShareBoardVO() {
	}

	public ShareBoardVO(int sbno, String writer, String title, String content, Timestamp regdate) {
		super();
		this.sbno = sbno;
		this.writer = writer;
		this.title = title;
		this.content = content;
		this.regdate = regdate;
	}

	public int getSbno() {
		return sbno;
	}

	public void setSbno(int sbno) {
		this.sbno = sbno;
	}

	public String getWriter() {
		return writer;
	}

	public void setWriter(String writer) {
		this.writer = writer;
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
