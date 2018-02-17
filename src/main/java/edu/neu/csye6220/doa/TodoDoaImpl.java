package edu.neu.csye6220.doa;

import java.util.Collection;
import java.util.HashMap;

import javax.annotation.Resource;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import edu.neu.csye6220.domain.Todo;
import edu.neu.csye6220.domain.User;

@Repository
@Transactional
public class TodoDoaImpl extends DAO implements TodoDoa {
	

	HashMap<Long,Todo> td = new HashMap<Long,Todo>();
	
	@Override
	public void add(Todo todo)throws Exception {
	 	    try {
	 	        begin();
	 	       getSession().flush();
	 	        getSession().save(todo);
		        commit();
		        getSession().flush();
	 	   } catch (HibernateException e) {
		        rollback();
		        throw new Exception("Exception while posting : " + e.getMessage());
		    }

	}

	@Override
	public Collection<Todo> getTodo() throws Exception {
		 try {
		        begin();
		        getSession().flush();
		Query q = getSession().createQuery("FROM Todo");
		
		Collection<Todo> list =  q.list();

		 commit();
		return list;
		 } catch (HibernateException e) {
		        rollback();
		        throw new Exception("Exception while fetching : " + e.getMessage());
		    }
	}

	@Override
	public void delete(String id) throws Exception {
		try {
 	        begin();
 	        System.out.println("inside dao--" + id);
 	       Query q = getSession().createQuery("FROM Todo where todo =:ID");
 	       q.setString("ID", id);
 	       Todo t1 = (Todo) q.uniqueResult();
 	       getSession().delete(t1);
 	        commit();
	        

 	   } catch (HibernateException e) {
	        rollback();
	        throw new Exception("Exception while posting : " + e.getMessage());
	    }

		
	}
}
