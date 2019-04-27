package com.example.demo;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.example.demo.controller.User;
import com.example.demo.service.UserService;


@RunWith(SpringRunner.class)
@SpringBootTest
public class JdbcTemplate1ApplicationTests {
	@Autowired
	UserService userService;

	@Test
	public void test1() {
		for (int i = 0; i < 9; i++) {
			User user = new User();
			user.setUsername("xcvb" + i);
			user.setPassword("23242");
			userService.saveUser(user);
		}
	}
}
