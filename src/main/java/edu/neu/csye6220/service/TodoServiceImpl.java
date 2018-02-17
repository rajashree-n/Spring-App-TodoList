package edu.neu.csye6220.service;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import edu.neu.csye6220.doa.TodoDoa;
import edu.neu.csye6220.domain.Todo;

@Service
@Transactional
public class TodoServiceImpl implements TodoService {

	@Autowired
	TodoDoa todoDoa;
	
	@Override
	@Transactional
	public void add(Todo todo) throws Exception {
		todoDoa.add(todo);
	}
	
	@Override
	@Transactional
	public Collection<Todo> getTodo() throws Exception {
		return todoDoa.getTodo();
	}

	@Override
	@Transactional
	public void delete(String todo) throws Exception {
		todoDoa.delete(todo);
		
	}

}
