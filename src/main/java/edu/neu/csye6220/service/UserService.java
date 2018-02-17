package edu.neu.csye6220.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import edu.neu.csye6220.domain.User;

@Service
@Transactional
public interface UserService {

	 User getUserByEmail(final String email) throws Exception;
	    User create(final User user) throws Exception;
	    User update(final User user) throws Exception;
}
