package edu.neu.csye6220.doa;

import java.util.Collection;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import edu.neu.csye6220.domain.Message;

@Transactional
@Repository
public interface MessageDoa {

	void delete(String msg) throws Exception;
	void add(Message msg) throws Exception;
	public Collection<Message> getMsg() throws Exception;
}
