package com.ezen.biz.user;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

import com.ezen.biz.board.BoardService;
import com.ezen.biz.dto.UserVO;

public class UserServiceTest {

	public static void main(String[] args) {
		AbstractApplicationContext container = new GenericXmlApplicationContext("appContext.xml");

		UserService userService = (UserService) container.getBean("UserService");
		
		UserVO vo = new UserVO("user1", "user1");
		
		UserVO result = userService.getUser(vo);
		if (result!=null) {
			System.out.println("로그인에 성공");
		} else {
			System.out.println("로그인 실패");
		}
		
		System.out.println(result);
		
		container.close();
	}

}
