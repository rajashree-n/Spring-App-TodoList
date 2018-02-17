/**
 * 
 */
package edu.neu.csye6220.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
@Service
public class UserDetailsImpl implements UserDetailsService {

	@Autowired
	UserService userS;
	
	@Override
	public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
		edu.neu.csye6220.domain.User user = new edu.neu.csye6220.domain.User();
		try {
			user = userS.getUserByEmail(email);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new UsernameNotFoundException("Invalid user name");
		}
		
		if(user != null) {
			List<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();
			//String role = "Parent";
			authorities.add(new SimpleGrantedAuthority("Parent"));
			return new org.springframework.security.core.userdetails.User(email,user.getPassword(),authorities);
		}
		
		throw new UsernameNotFoundException("Invalid user name");
		
		
		
		
	}

}
