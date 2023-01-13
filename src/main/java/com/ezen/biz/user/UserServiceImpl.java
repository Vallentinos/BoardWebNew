package com.ezen.biz.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ezen.biz.dao.UserDAO;
import com.ezen.biz.dto.UserVO;

@Service("UserService")
public class UserServiceImpl implements UserService {
	@Autowired
	UserDAO uDAO;
	
	@Override
	public UserVO getUser(UserVO vo) {
		return uDAO.getUser(vo);
	}

}
