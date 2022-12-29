package com.user.model;

import java.sql.*;

import com.util.Util;

public class UserDAO {
	
	//싱글톤 객체생성
	private static UserDAO instance = new UserDAO();
	
	//생성자 private 처리
	private UserDAO() {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
		} catch (Exception e) {
			e.getStackTrace();
			System.out.println("드라이버 클래스 로드에러");
		}
	}
	
	//외부 객체생성 요구 때 반환관련
	public static UserDAO getInstance() {
		return instance;
	}
	
	//db작업 필요 변수
	public String URL = "jdbc:oracle:thin:@172.30.1.71:1521:xe";
	public String UID = "prjt";
	public String UPW = "prjt";
	
	private Connection conn = null;
	private PreparedStatement pstmt = null;
	private ResultSet rs = null;
	
	////////////////////////////////// 메서드 /////////////////////
	
	//1. 로그인 
	public UserVO login(String id, String pw) {
		
		UserVO vo = null;
		
		String sql = "select * from users where id = ? and pw = ?";
		
		try {
			
			//DB연결하기
			conn = DriverManager.getConnection(URL, UID, UPW);
			pstmt = conn.prepareStatement(sql);
			
			//값세팅
			pstmt.setString(1, id);
			pstmt.setString(2, pw);
			
			//DB실행
			rs = pstmt.executeQuery();
			
			//회원정보 저장
			if(rs.next()) { //회원정보가 존재한다면
				
				String id2 = rs.getString("id");
				String pw2 = rs.getString("pw");
				String name = rs.getString("name");
				int age = rs.getInt("age");
				String gender = rs.getString("gender");
				String classNo = rs.getString("classNo");
				String teacher = rs.getString("teacher"); 
				
				vo = new UserVO(id2, pw2, name, age, gender, classNo, teacher);
			}
			
		} catch (Exception e) {
			e.getStackTrace();
		} finally {
			Util.close(conn, pstmt, rs);
		}
		
		
		
		return vo;
	}

	//2. 회원정보 획득
	public UserVO getInfo(String id) {
		
		UserVO vo = null;
		
		String sql = "select * from users where id = ?";
		
		try {
			
			//DB연결
			conn = DriverManager.getConnection(URL, UID, UPW);
			pstmt = conn.prepareStatement(sql);
			
			//sql문 완성
			pstmt.setString(1, id);
			
			//실행
			rs = pstmt.executeQuery();
			
			//만약에 정보가 있다면
			if(rs.next()) {
				
				String id2 = rs.getString("id");
				String pw = rs.getString("pw");
				String name = rs.getString("name");
				int age = rs.getInt("age");
				String gender = rs.getString("gender");
				String classNO = rs.getString("classNo");
				String tecaher = rs.getString("teacher");
				
				vo = new UserVO(id2, pw, name, age, gender, classNO, tecaher);
			}
			
			
		} catch (Exception e) {
			e.getStackTrace();
			System.out.println("정보획득 실패");
		} finally {
			Util.close(conn, pstmt, rs);
		}
		
		return vo;
	}
	
	//3. 정보수정 메서드
	public void update(String id, String pw, String name, String age, String classNo) {
		
		String sql = "update users set pw =? ,name=? ,age =? ,classNo=? where id =?";
		
		try {
			
			conn = DriverManager.getConnection(URL, UID, UPW);
			
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, pw);
			pstmt.setString(2, name);
			pstmt.setString(3, age);
			pstmt.setString(4, classNo);
			pstmt.setString(5, id);
			
			rs = pstmt.executeQuery();
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			System.out.println("회원정보수정 실패");
		}finally {
			Util.close(conn, pstmt, rs);
		}
	}
	
}
