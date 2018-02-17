package edu.neu.csye6220.doa;

import java.util.Collection;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import edu.neu.csye6220.domain.Todo;

@Repository
@Transactional
public interface TodoDoa {
	
	void delete(String todo) throws Exception;
	void add(Todo todo) throws Exception;
	public Collection<Todo> getTodo() throws Exception;

}
