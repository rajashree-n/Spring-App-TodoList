package edu.neu.csye6220.service;

import java.util.Collection;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import edu.neu.csye6220.domain.Message;

@Transactional
@Service
public interface MessageService {

	void delete(String msg) throws Exception;
	void add(Message msg) throws Exception;
	public Collection<Message> getMsg() throws Exception;
}
