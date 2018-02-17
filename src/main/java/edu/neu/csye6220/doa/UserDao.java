package edu.neu.csye6220.doa;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import edu.neu.csye6220.domain.User;

@Repository
@Transactional
public interface UserDao {

    User getUserByEmail(final String email) throws Exception;
    User create(final User user) throws Exception;
    User update(final User user) throws Exception;


}
