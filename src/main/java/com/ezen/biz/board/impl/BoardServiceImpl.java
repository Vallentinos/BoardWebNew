package com.ezen.biz.board.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ezen.biz.board.BoardService;
import com.ezen.biz.dao.BoardDAO;
import com.ezen.biz.dto.BoardVO;

@Service("boardService")
public class BoardServiceImpl implements BoardService {
	
	@Autowired
	private BoardDAO bDao;

	@Override
	public void insertBoard(BoardVO board) {

		bDao.insertBoard(board);
	}

	@Override
	public void updateBoard(BoardVO board) {
		// TODO Auto-generated method stub
		bDao.updateBoard(board);
	}

	@Override
	public void deleteBoard(BoardVO board) {
		// TODO Auto-generated method stub
		bDao.deleteBoard(board);
	}

	@Override
	public BoardVO getBoard(BoardVO board) {
		
		return bDao.getBoard(board);
	}

	@Override
	public List<BoardVO> getBoardList() {
		// TODO Auto-generated method stub
		return bDao.getBoardList();
	}

	
	
	
}
