package com.user.model;

public class UserVO {
	
	//데이터 베이스 컬럼과 동일한 멤버변수
	private String id;
	private String pw;
	private String name;
	private int age;
	private String gender;
	private String classNo;
	private String teacher;
	
	//생성자
	public UserVO() {
	}

	public UserVO(String id, String pw, String name, int age, String gender, String classNo, String teacher) {
		super();
		this.id = id;
		this.pw = pw;
		this.name = name;
		this.age = age;
		this.gender = gender;
		this.classNo = classNo;
		this.teacher = teacher;
	}

	//get&set
	
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getPw() {
		return pw;
	}

	public void setPw(String pw) {
		this.pw = pw;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getClassNo() {
		return classNo;
	}

	public void setClassNo(String classNo) {
		this.classNo = classNo;
	}

	public String getTeacher() {
		return teacher;
	}

	public void setTeacher(String teacher) {
		this.teacher = teacher;
	}
	
	
	

}
