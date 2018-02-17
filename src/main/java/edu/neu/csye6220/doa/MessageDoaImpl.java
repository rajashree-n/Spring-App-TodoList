package edu.neu.csye6220.doa;

import java.util.Collection;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import edu.neu.csye6220.domain.Message;
import edu.neu.csye6220.domain.Todo;


@Repository
@Transactional
public class MessageDoaImpl extends DAO implements MessageDoa {

	@Override
	public void delete(String msg) throws Exception {
		try {
 	        begin();
 	       Query q = getSession().createQuery("FROM Message where msg =:msg");
 	       q.setString("msg", msg);
 	       Message t1 = (Message) q.uniqueResult();
 	       getSession().delete(t1);
	        commit();
 	   } catch (HibernateException e) {
	        rollback();
	        throw new Exception("Exception while posting : " + e.getMessage());
	    }

	}

	@Override
	public void add(Message msg) throws Exception {
		try {
 	        begin();
 	        getSession().save(msg);
	        commit();
 	   } catch (HibernateException e) {
	        rollback();
	        throw new Exception("Exception while posting : " + e.getMessage());
	    }

	}

	@Override
	public Collection<Message> getMsg() throws Exception {
		 try {
		        begin();
		Query q = getSession().createQuery("FROM Message");
		
		Collection<Message> list =  q.list();

		 commit();
		return list;
		 } catch (HibernateException e) {
		        rollback();
		        throw new Exception("Exception while fetching : " + e.getMessage());
		    }
	}

}
