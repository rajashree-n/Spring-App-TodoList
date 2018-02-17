package edu.neu.csye6220.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import edu.neu.csye6220.doa.UserDao;
import edu.neu.csye6220.domain.User;

@Service
@Transactional
public class UserServiceImpl implements UserService {
	
	@Autowired
	UserDao userDao;

	@Override
	public User getUserByEmail(String email) throws Exception {

		return userDao.getUserByEmail(email);
	}

	@Override
	public User create(User user) throws Exception {
		return userDao.create(user);
	}

	@Override
	public User update(User user) throws Exception {
		return userDao.update(user);
	}
}
