package com.util;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class Util {
	
	public static void close(Connection conn, PreparedStatement pstmt, ResultSet rs) {
		
		try {
			//만약에 conn이 연결된 상태라면 닫아라
			if(conn != null) conn.close(); 
			//만약에 pstmt가 연결된 상태라면 닫아라
			if(pstmt != null) pstmt.close();
			//만약에 rs가 실행중이라면 닫아라
			if(rs != null) rs.close();
		} catch (Exception e) {
			e.getStackTrace();
			System.out.println("닫기 오류 발생");
		}
		
	}

}
