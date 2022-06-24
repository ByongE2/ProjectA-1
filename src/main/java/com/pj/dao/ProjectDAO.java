package com.pj.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.pj.dto.ProjectVO;
import util.DBManager;

public class ProjectDAO {
	
	private ProjectDAO() {}
	
	private static ProjectDAO instance = new ProjectDAO();
	
	public static ProjectDAO getInstance() {
		return instance;
		
	}

	public void JoinMember(ProjectVO pvo) {
		String sql = "insert into JoinEX(userid, pwd, name, phone, email)"
				+"values(?,?,?,?,?)";
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, pvo.getUserid());
			pstmt.setString(2, pvo.getPwd());
			pstmt.setString(3, pvo.getName());
			pstmt.setString(4, pvo.getPhone());
			pstmt.setString(5, pvo.getEmail());
			
			pstmt.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			DBManager.close(conn, pstmt);
		}
	}

	public int useID(String userid) {
		int result = -1;
		String sql = "select userid from JoinEX where userid=?";
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, userid);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				result = 1;
			}else {
				result = -1;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			DBManager.close(conn, pstmt, rs);
		}
		
		return result;
	}
	
}
