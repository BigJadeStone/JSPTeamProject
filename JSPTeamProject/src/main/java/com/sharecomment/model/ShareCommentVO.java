package com.sharecomment.model;

import java.sql.Timestamp;

public class ShareCommentVO {
	
	private int comment_num;
	private int comment_boardNum;
	private String comment_id;
	private Timestamp comment_date;
	private String comment_content;
	
	public ShareCommentVO(int comment_num, int comment_boardNum, String comment_id, Timestamp comment_date,
			String comment_content) {
		super();
		this.comment_num = comment_num;
		this.comment_boardNum = comment_boardNum;
		this.comment_id = comment_id;
		this.comment_date = comment_date;
		this.comment_content = comment_content;
	}
	
	public ShareCommentVO() {
	}

	public int getComment_num() {
		return comment_num;
	}

	public void setComment_num(int comment_num) {
		this.comment_num = comment_num;
	}

	public int getComment_boardNum() {
		return comment_boardNum;
	}

	public void setComment_boardNum(int comment_boardNum) {
		this.comment_boardNum = comment_boardNum;
	}

	public String getComment_id() {
		return comment_id;
	}

	public void setComment_id(String comment_id) {
		this.comment_id = comment_id;
	}

	public Timestamp getComment_date() {
		return comment_date;
	}

	public void setComment_date(Timestamp comment_date) {
		this.comment_date = comment_date;
	}

	public String getComment_content() {
		return comment_content;
	}

	public void setComment_content(String comment_content) {
		this.comment_content = comment_content;
	}
}
