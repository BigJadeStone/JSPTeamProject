package com.jobboard.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Timestamp;
import java.util.ArrayList;

import com.user.model.UserVO;
import com.util.Util;

public class JobBoardDAO {

	//DAO객체
	private static JobBoardDAO instance = new JobBoardDAO();
	
	private JobBoardDAO() {
		
		try {
			
			Class.forName("oracle.jdbc.driver.OracleDriver");
			
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("드라이버 로드 에러");
		}
	}

	//DAO객체 반환
	public static JobBoardDAO getInstance() {
		return instance;
	}
	
	public String URL = "jdbc:oracle:thin:@172.30.1.71:1521:xe";
	public String UID = "prjt";
	public String UPW = "prjt";

	private Connection con;
	private PreparedStatement pstmt;
	private ResultSet rs;
	
	UserVO vo = new UserVO();
	
	//취업게시판 '글 작성' 메서드 ( 관리자만 작성가능하고, 학생은 확인만 가능 )
	public void Jobregist( String id , String title, String content ) {
		
		String sql = "insert into jobboard(jno, id, title, content) values(jobboard_seq.nextval, ?, ?, ?)";
	
		try {
			
			con = DriverManager.getConnection(URL, UID, UPW);
			
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, id);
			pstmt.setString(2, title);
			pstmt.setString(3, content);
			
			pstmt.executeUpdate();
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			System.out.println("insert 실패");
			
		}finally {
			Util.close(con, pstmt, rs);
		}
	
	}
	
	//취업게시판 '글 조회' 메서드
	public ArrayList<JobBoardVO> JobgetList(){
		
		ArrayList<JobBoardVO> joblist = new ArrayList<>();
		
		String sql = "select * from jobboard order by jno desc";
		
		try {
			con = DriverManager.getConnection(URL, UID, UPW);
			
			pstmt = con.prepareStatement(sql);
			
			rs = pstmt.executeQuery();
			
			//결과값을 ArrayList에 저장하기
			while(rs.next()) {
				int jno = rs.getInt("jno");
				String id = rs.getString("id");
				String title = rs.getString("title");
				String content = rs.getString("content");
				Timestamp regdate = rs.getTimestamp("regdate");
				
				JobBoardVO vo = new JobBoardVO(jno, id, title, content, regdate);
				joblist.add(vo);
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}finally {
			Util.close(con, pstmt, rs);
		}
		return joblist;
	}
	
	//취업게시판 '글 내용' 메서드
	public JobBoardVO JobgetContent(String jno) {
		

		JobBoardVO vo = null;
		
		String sql = "select * from jobboard where jno = ?";
		
		try {
			con = DriverManager.getConnection(URL, UID, UPW);
			
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, jno);
			
			rs = pstmt.executeQuery();

			if(rs.next()) {
				vo = new JobBoardVO();
				vo.setJno( rs.getInt("jno"));
				vo.setId( rs.getString("id"));
				vo.setTitle( rs.getString("title"));
				vo.setContent( rs.getString("content"));
				vo.setRegdate( rs.getTimestamp("regdate"));
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}finally {
			Util.close(con, pstmt, rs);
		}
		
		return vo;
	}
	
	
	
	//글 수정 메서드
	public void update(String jno, String title, String content) {
		
		String sql = "update jobboard set title=?, content=? where jno=?";
		
		try {
			
			con = DriverManager.getConnection(URL,UID,UPW);
			
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, title);
			pstmt.setString(2, content);
			pstmt.setString(3, jno);
			
			pstmt.executeUpdate();
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			System.out.println("업데이트 안됨");
		}finally {
			Util.close(con, pstmt, rs);
		}

	}
	
	
	//글 삭제 메서드
	public void delete(String jno) {
		
		String sql = "delete from jobboard where jno = ?";
		
		try {
			con = DriverManager.getConnection(URL, UID, UPW);
			
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, jno);
			
			pstmt.executeUpdate();
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}finally {
			Util.close(con, pstmt, rs);
		}
		
	}
	
	
}
