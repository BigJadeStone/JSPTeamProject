package com.sharecomment.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import com.util.Util;

public class ShareCommentDAO {
	
	private static ShareCommentDAO instance = new ShareCommentDAO();
	
	//드라이버 클래스 로드(DB접근용)
	private ShareCommentDAO() {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
		} catch (Exception e) {
			System.out.println("드라이버 클래스 오류");
		}
	}
	
	public static ShareCommentDAO getInstance() {
		return instance;
	}
	
	//DB 변수
	public String URL = "jdbc:oracle:thin:@172.30.1.71:1521:xe";
	public String UID = "prjt";
	public String UPW = "prjt";
	
	private Connection conn;
	private PreparedStatement pstmt;
	private ResultSet rs;
	
	//댓글 등록
	public void regist(String comment_id, String comment_content, int comment_boardNum) {
		String sql = "insert into board_comment(comment_num, comment_boardNum, comment_id, comment_content)\r\n"
				+ "values(shareboardcomment_seq.nextval, ?, ?, ?)";
		try {
			conn = DriverManager.getConnection(URL, UID, UPW);
			pstmt = conn.prepareStatement(sql);
			System.out.println(comment_boardNum);
			System.out.println(comment_id);
			System.out.println(comment_content);
			pstmt.setInt(1, comment_boardNum);
			pstmt.setString(2, comment_id);
			pstmt.setString(3, comment_content);
			pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			Util.close(conn, pstmt, rs);
		}
	}

	public ArrayList<ShareCommentVO> getList() {
		ArrayList<ShareCommentVO> list = new ArrayList<>();
		String sql = "select * from board_comment order by comment_num desc";
		try {
			conn = DriverManager.getConnection(URL, UID, UPW);
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				ShareCommentVO vo = new ShareCommentVO(
						rs.getInt("comment_num"), 
						rs.getInt("comment_boardNum"), 
						rs.getString("comment_id"), 
						rs.getTimestamp("comment_date"), 
						rs.getString("comment_content"));
				list.add(vo);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			Util.close(conn, pstmt, rs);
		}
		return list;
	}
	
	public int delete(String boardNum) {
		int result = 0;
		String sql = "delete from board_comment where comment_num = ?";
		try {
			conn = DriverManager.getConnection(URL, UID, UPW);
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, boardNum);
			result = pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			Util.close(conn, pstmt, rs);
		}
		
		return result;
	}
	
	
}
