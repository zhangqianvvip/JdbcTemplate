package com.example.demo.service;


import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.controller.User;
import com.example.demo.controller.UserRepository;

@Service
public class UserService {
@Inject
private UserRepository userRepository;
@Inject
private UserService userService;
@Transactional(propagation = Propagation.REQUIRED)
public void saveUser(User user) {
	this.userRepository.saveAndFlush(user);
}
}
