package com.ezen.biz.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.ezen.biz.common.JDBCUtil;
import com.ezen.biz.dto.BoardVO;

@Repository("BoardDAO")
public class BoardDAO {
	Connection conn = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;

	// SQL 명령어 상수
	private static final String BOARD_INSERT = "insert into BOARD(SEQ, TITLE, WRITER, CONTENT) values(board_seq.NEXTVAL, ?, ?, ?)";

	// 게시글 등록
	public void insertBoard(BoardVO board) {
		System.out.println("===> JDBC로 insertBoard() 기능 처리");

		try {
			conn = JDBCUtil.getConnection();
			pstmt = conn.prepareStatement(BOARD_INSERT);
			pstmt.setString(1, board.getTitle());
			pstmt.setString(2, board.getWriter());
			pstmt.setString(3, board.getContent());

			pstmt.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JDBCUtil.close(conn, pstmt);
		}
	}

	private static final String BOARD_UPDATE = "update BOARD set ? where SEQ=?";

	public void updateBoard(BoardVO board) {
		System.out.println("===> JDBC로 updateBoard()기능 처리");

		try {
			conn = JDBCUtil.getConnection();
			pstmt = conn.prepareStatement(BOARD_UPDATE);
			pstmt.setString(1, ""); // 매커니즘을 모르겠다
			pstmt.setString(2, Integer.toString(board.getSeq()));

			pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JDBCUtil.close(conn, pstmt);
		}
	}

	private static final String BOARD_DELETE = "DELETE BOARD where SEQ=?";

	public void deleteBoard(BoardVO board) {
		System.out.println("===> JDBC로 deleteBoard()기능 처리");

		try {
			conn = JDBCUtil.getConnection();
			pstmt = conn.prepareStatement(BOARD_DELETE);
			pstmt.setString(1, Integer.toString(board.getSeq()));
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JDBCUtil.close(conn, pstmt);
		}

	}

	private static final String BOARD_GET = "select * from BOARD where SEQ=?";

	public BoardVO getBoard(BoardVO board) {
		System.out.println("===>JDBC로 getBoard()처리");
		BoardVO vo = null;

		try {
			conn = JDBCUtil.getConnection();
			pstmt = conn.prepareStatement(BOARD_GET);
			pstmt.setString(1, Integer.toString(board.getSeq()));

			rs = pstmt.executeQuery();
			
			if(rs.next()){
				vo = new BoardVO();
				
				vo.setSeq(rs.getInt("seq"));
				vo.setTitle(rs.getString("title"));
				vo.setWriter(rs.getString("writer"));
				vo.setContent(rs.getString("content"));
				vo.setRegDate(rs.getDate("regdate"));
				vo.setCnt(rs.getInt("cnt"));
				
			}
		

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JDBCUtil.close(conn, pstmt, rs);
		}
		return vo;
	}

	private static final String BOARD_LIST = "select * from BOARD order by SEQ";

	public List<BoardVO> getBoardList() {
		System.out.println("===>JDBC로 listBoard()처리");
		List<BoardVO> boardList = new ArrayList<BoardVO>();
		try {
			conn = JDBCUtil.getConnection();
			pstmt = conn.prepareStatement(BOARD_LIST);
			rs = pstmt.executeQuery();

			while (rs.next()) {
				BoardVO vo = new BoardVO();
				vo.setSeq(rs.getInt("seq"));
				vo.setTitle(rs.getString("title"));
				vo.setWriter(rs.getString("writer"));
				vo.setContent(rs.getString("content"));
				vo.setRegDate(rs.getDate("regDate"));
				vo.setCnt(rs.getInt("cnt"));

				boardList.add(vo);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JDBCUtil.close(conn, pstmt, rs);
		}

		return boardList;
	}
}
