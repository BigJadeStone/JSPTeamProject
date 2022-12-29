package com.reqboard.model;

import java.sql.*;
import java.util.ArrayList;

import com.util.Util;

public class reqBoardDAO {
	
	//싱글톤 객체 생성
	private static reqBoardDAO instance = new reqBoardDAO();
	
	//생성자 private 처리
	private reqBoardDAO() {
		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
		} catch (Exception e) {
			e.getStackTrace();
			System.out.println("건의 게시판 드라이버 클래스 로드에러");
		}
	}

	//외부에서 객체생성 요구시 반환관련
	public static reqBoardDAO getInstance() {
		return instance;
	}
	
	//db작업 필요 변수
	public String URL = "jdbc:oracle:thin:@172.30.1.71:1521:xe";
	public String UID = "prjt";
	public String UPW = "prjt";
	
	private Connection conn = null;
	private PreparedStatement pstmt = null;
	private ResultSet rs = null;
	
	///////////////////////////메서드///////////////////////////////
	
	//1. 글작성
	public void regist(String id, String title, String content) {
		
		String sql = "insert into reqboard(rbno, id, title, content) values(reqboard_seq.nextval, ?,?,?)";
		
		try {
			
			//db연결
			conn = DriverManager.getConnection(URL, UID, UPW);
			pstmt = conn.prepareStatement(sql);
			
			//sql문 완성
			pstmt.setString(1, id );
			pstmt.setString(2, title);
			pstmt.setString(3, content);
			
			//실행
			pstmt.executeUpdate(); //성공시 1 실패시 0
			
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("글작성 오류");
		} finally {
			Util.close(conn, pstmt, rs);
		}
		
	}

	//2. 목록출력
	public ArrayList<reqBoardVO> getlist(){
		
		ArrayList<reqBoardVO> list = new ArrayList<>();
		reqBoardVO vo = null;
		String sql = "select * from reqboard order by rbno desc";
		
		try {
			//db연결
			conn = DriverManager.getConnection(URL, UID, UPW);
			pstmt = conn.prepareStatement(sql);
			
			rs = pstmt.executeQuery();
			
			//데이터가 있다면 반복
			while(rs.next()) {
				
				int rbno = rs.getInt("rbno");
				String id = rs.getString("id");
				String title = rs.getString("title");
				String content = rs.getString("content");
				Timestamp regdate = rs.getTimestamp("regdate");
				
				vo = new reqBoardVO(rbno, id, title, content, regdate);
				list.add(vo);
			}
		
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("리스트 호출 오류");
		} finally {
			Util.close(conn, pstmt, rs);
		}
		
		return list;
	}

	//3. 글내용 출력
	public reqBoardVO getContent(String bno) {
		
		reqBoardVO vo = null;
		String sql = "select * from reqboard where rbno = ? ";
		
		try {
			
			//db 연결
			conn = DriverManager.getConnection(URL, UID, UPW);
			pstmt = conn.prepareStatement(sql);
			
			//sql문 세팅
			pstmt.setString(1, bno);
			
			//실행
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				
				int rbno = rs.getInt("rbno");
				String id = rs.getString("id");
				String title = rs.getString("title");
				String content = rs.getString("content");
				Timestamp regdate = rs.getTimestamp("regdate");
				
				vo = new reqBoardVO(rbno, id, title, content, regdate);
			}

		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("작성된 글 불러오기 오류");
		} finally {
			Util.close(conn, pstmt, rs);
		}
		
		return vo;
		
	}

	//4. 글업데이트
	public void update(String title, String content, String rbno) {
		
		String sql = "update reqboard set title =?, content =? where rbno =?";
		
		try {
			//db연결
			conn = DriverManager.getConnection(URL, UID, UPW);
			pstmt = conn.prepareStatement(sql);
			
			//sql문 세팅
			pstmt.setString(1, title );
			pstmt.setString(2, content);
			pstmt.setString(3, rbno);
			
			//실행
			pstmt.executeUpdate(); //성공 1 실패 0
			
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("글업데이트 오류");
		} finally {
			Util.close(conn, pstmt, rs);
		}
		
	}

	//5. 글삭제
	public int delete(String rbno) {
		
		String sql = "delete from reqboard where rbno =?";
		
		try {
			
			//db연결
			conn = DriverManager.getConnection(URL, UID, UPW);
			pstmt = conn.prepareStatement(sql);
			
			//sql 값 세팅
			pstmt.setString(1, rbno);
			
			//실행
			int result = pstmt.executeUpdate(); //성공1 실패0
			
			return result;
			
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("글삭제 오류");
		} finally {
			Util.close(conn, pstmt, rs);
		}
		
		return 0;
		
	}

}
