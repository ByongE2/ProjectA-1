package com.projectA.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.projectA.dto.UserDTO;

import util.DBManager;

public class UserDAO {
	
	private UserDAO() { }
	
	private static UserDAO instance = new UserDAO();
	
	public static UserDAO getInstance() {
		return instance;
	}
	
	public int userCheck(String email, String password){
		
		int result = -1;
		String sql = "select password from user where email=?";
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, email);
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				if(rs.getString("password").equals(password) && rs.getString("password") != null) {
					result = 1;   //일치
				}else {
					result=0;  //불일치
				}
			}else {   
				result = -1; //회원 아님
			}
			
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			DBManager.close(conn, pstmt, rs);
		}
		return result;
	}//userCheck

	public UserDTO selectUser(String email) {
		
		UserDTO uDto = null;
//		String sql = "select * from user where email=?";
		String sql = "select email, password from user where email=?";
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, email);
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				uDto = new UserDTO();
				uDto.setEmail(rs.getString("email"));
				uDto.setPassword(rs.getString("password"));
//				uDto.setName(rs.getString("name"));
//				uDto.setAddress_d(rs.getString("address_d"));
//				uDto.setPhone(rs.getString("phone"));
//				uDto.setGrade(rs.getString("grade"));
//				uDto.setMember_since(rs.getTimestamp("member_since"));
			}
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			DBManager.close(conn, pstmt, rs);
		}
		return uDto;
	}//selectUser
}//MemberDAO