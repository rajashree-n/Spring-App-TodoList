package edu.neu.csye6220.service;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import edu.neu.csye6220.domain.Message;
import edu.neu.csye6220.doa.MessageDoa;

@Transactional
@Service
public class MessageServiceImpl implements MessageService {
	
	@Autowired
	MessageDoa msgDoa;
	
	@Override
	public void delete(String msg) throws Exception {
		msgDoa.delete(msg);

	}

	@Override
	public void add(Message msg) throws Exception {
		msgDoa.add(msg);

	}

	@Override
	public Collection<Message> getMsg() throws Exception {
		return msgDoa.getMsg();
	}

}
