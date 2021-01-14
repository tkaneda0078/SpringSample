package com.example.demo.login.domain.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.login.domain.model.User;
import com.example.demo.login.domain.repository.UserDao;

@Service
public class UserService {
	@Autowired
	UserDao dao;

	public boolean create(User user) {
		int rowNumber = dao.createOne(user);

		if (rowNumber > 0) {
			return true;
		} else {
			return false;
		}
	}
}
