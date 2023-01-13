package com.ezen.biz.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.ezen.biz.common.JDBCUtil;
import com.ezen.biz.dto.UserVO;
import com.ezen.biz.user.UserService;
@Repository("UserDAO")
public class UserDAO implements UserService {
	Connection conn = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;
	
	
	public UserVO getUser(UserVO vo) {
		UserVO user = null;
		try {
			conn = JDBCUtil.getConnection();
			pstmt = conn.prepareStatement("Select * from USERS where ID= ? and password=?");
			pstmt.setString(1, vo.getId());
			pstmt.setString(2, vo.getPassword());

			rs = pstmt.executeQuery();
			
			if (rs.next()) {
				user = new UserVO();
				user.setId(rs.getString("id"));
				user.setPassword(rs.getString("password"));
				user.setName(rs.getString("name"));
				user.setRole(rs.getString("role"));
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JDBCUtil.close(conn, pstmt, rs);
		}
		return user;
	}
	/*public List<UserVO> getUserList() {
		
		try {
			conn = JDBCUtil.getConnection();
			pstmt = conn.prepareStatement("Select * from USERS order by ROLE");
			
			rs=pstmt.executeQuery();
		}
	}*/
}
