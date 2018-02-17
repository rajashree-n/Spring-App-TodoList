package edu.neu.csye6220.doa;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import edu.neu.csye6220.domain.User;

@Repository
@Transactional
public class UserDaoImpl extends DAO implements UserDao {

	@Override
	public User getUserByEmail(String email) throws Exception {
		User u1;
		try {
 	        begin();
 	      Query q = getSession().createQuery("FROM User where email = :email");
 		 q.setString("email",email);
 		 u1 = (User)q.uniqueResult();
	        commit();
 	   } catch (HibernateException e) {
	        rollback();
	        throw new Exception("Exception while posting : " + e.getMessage());
	    }

		return u1;
	}

	@Override
	public User create(User user) throws Exception {
		try {
 	        begin();
 	        getSession().save(user);
	        commit();
 	   } catch (HibernateException e) {
	        rollback();
	        throw new Exception("Exception while posting : " + e.getMessage());
	    }

		return user;
	}

	@Override
	public User update(User user) throws Exception {
		try {
 	        begin();
 	       Query q = getSession().createQuery("FROM User where email = :email");
 	 		 q.setString("email",user.getEmail());
 	 		 User u1 = (User)q.uniqueResult();
	        getSession().update(u1);
	        commit();
 	   } catch (HibernateException e) {
	        rollback();
	        throw new Exception("Exception while posting : " + e.getMessage());
	    }

		return user;
	}
	
}
