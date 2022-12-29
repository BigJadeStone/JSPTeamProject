package com.classboard.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import com.util.Util;

public class ClassBoardDAO {
	
	//싱글톤 형식으로 DAO 설계 - 한개의 객체만 만들어지도록함.
	//1. 나 자신의 객체를 생성해서 1개로 제한.
	private static ClassBoardDAO instance = new ClassBoardDAO();
	
	//2. 직접 객체를 생성할 수 없도록 생성자를 private로 지정.
	private ClassBoardDAO() {
		
		//드라이버 클래스 로드
		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
		} catch (Exception e) {
			System.out.println("드라이버클래스 로드에러");
		}
	};
	
	//3. 외부에서 객체생성을 요구할 때 getter메서드를 통해 1번의 객체르 ㄹ반환
	public static ClassBoardDAO getInstance() {
		return instance;
	}
	
	//4.필요한 데이터베이스 변수 선언
	public String URL = "jdbc:oracle:thin:@172.30.1.71:1521:xe";
	public String UID = "prjt";
	public String UPW = "prjt";
	
	//사용할 객체 참조변수 선언, 원래는 지역변수로 만들어줘야 한다고 함.
	private Connection conn;
	private PreparedStatement pstmt;
	private ResultSet rs;
	
	//------ 위에서 여기까지 DAO 기본 환경 구축 완료 ------------
	// 아래서 부터는 사용할 메서드 작성내용.
	
	
	//글 작성 메소드
	public void regist(String id, String title, String content, String classNo) {
		
		String sql = "insert into classBoard values(classBoard_seq.nextval, ?, ?, ?, sysdate, ?)";
		
		try {
			
			//db 연결
			conn = DriverManager.getConnection(URL, UID, UPW);
			pstmt = conn.prepareStatement(sql);
			
			//sql문 완성
			pstmt.setString(1, id);
			pstmt.setString(2, title);
			pstmt.setString(3, content);
			pstmt.setString(4, classNo);
			
			//crud pstmt 
			pstmt.executeUpdate(); //성공시 1반환, 실패시 0반환. 하지만 값 받지 않음.
			
		} catch (Exception e) {
			e.getStackTrace();
		} finally {
			Util.close(conn, pstmt, rs);
		}
		
	}//글작성메소드 끝.
	
	//리스트페이지 글 조회 메소드 -> 반 게시판 리스트 페이지에 출력하게 될것.
	public ArrayList<ClassBoardVO> getList(String classNo){
		
		ArrayList<ClassBoardVO> list = new ArrayList<>();
		
		String sql = "select * from classboard where classNo =? order by CBno desc";
		
		try {
			conn = DriverManager.getConnection(URL,UID,UPW);
			pstmt = conn.prepareStatement(sql);
			
			//sql문 완성
			pstmt.setString(1, classNo);
			
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				
				ClassBoardVO vo = new ClassBoardVO();
				
				vo.setCbno(rs.getInt("cbno"));
				vo.setId(rs.getString("id"));
				vo.setTitle(rs.getString("title"));
				vo.setContent(rs.getString("content"));
				vo.setRegdate(rs.getTimestamp("regdate"));
				vo.setClassNo(rs.getString("classNo"));
				
				list.add(vo);
				
			}
			
		} catch (Exception e) {
			e.getStackTrace();
		} finally {
			Util.close(conn, pstmt, rs);
		}
		
		return list;
	}//list 메서드 끝
	
	//글 내용(content) 확인 메소드
	public ClassBoardVO getContent(String cbno) {
		
		ClassBoardVO vo = null; //지역변수이기 때문에 초기에 값도 선언해줘야함.
		
		String sql = "select * from classBoard where cbno = ?";
		
		try {
			
			conn = DriverManager.getConnection(URL,UID,UPW);
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, cbno);
			
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				
				vo = new ClassBoardVO();
				
				vo.setCbno(rs.getInt("cbno"));
				vo.setId(rs.getString("ID"));
				vo.setTitle(rs.getString("title"));
				vo.setContent(rs.getString("content"));
				vo.setRegdate(rs.getTimestamp("regdate"));
				
			}
			
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			Util.close(conn, pstmt, rs);
		}
		
		return vo;
	}
	
	//글 수정 메서드
	public void update(String cbno, String title, String content) {
		
		String sql = "update ClassBoard set title = ?, content = ? where cbno = ?";
		
		try {
			
			conn = DriverManager.getConnection(URL,UID,UPW);
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, title);
			pstmt.setString(2, content);
			pstmt.setString(3, cbno);
			
			pstmt.executeUpdate();
			
		} catch(Exception e) {
			e.getStackTrace();
		} finally {
			Util.close(conn, pstmt, rs);
		}
		
	}
	
	//글 삭제 메서드
	public void delete(String cbno) {
		
		String sql = "delete from classboard where cbno = ?";
		
		try {
			
			conn = DriverManager.getConnection(URL,UID,UPW);
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, cbno);
			
			pstmt.execute(); //sql 성공시 1반환, 실패시 0 반환
			
		} catch(Exception e) {
			e.getStackTrace();
		} finally {
			Util.close(conn, pstmt, rs);
		}
		
	}
	
	
	

}
