package edu.neu.csye6220.service;

import java.util.Collection;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import edu.neu.csye6220.domain.Todo;

@Service
@Transactional
public interface TodoService {

	void add(Todo todo) throws Exception;
	void delete(String todo) throws Exception;
	public Collection<Todo> getTodo() throws Exception;
}
