package edu.neu.csye6220.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;

@Entity
@Table(name ="user")
@Inheritance(strategy=InheritanceType.JOINED)
public class User {
	
	@Id
	@Column(name="USERID")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long Userid;
    
	@NotEmpty(message = "{user.error.name.required}")
	@Column(name="FNAME")
	private String fname;
	
	@NotEmpty(message = "{user.error.email.required}")
    @Email(message = "{login.error.email.invalid}")
	@Column(name="EMAIL")
	private String email;
	
	
	@NotEmpty(message = "{login.error.password.required}")
    @Size(min = 6, message = "{login.error.password.size}")
	@Column(name="PASSWORD")
	private String password;
	
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "user")
	private List<Todo> todos = new ArrayList<Todo>();
	
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "user")
	private List<Message> message = new ArrayList<Message>();

    public static final AtomicLong idSequence = new AtomicLong(); 
    
    
    
    public List<Message> getMessage() {
		return message;
	}

	public void setMessage(List<Message> message) {
		this.message = message;
	}

	public List<Todo> getTodos() {
		return todos;
	}

	public void setTodos(List<Todo> todos) {
		this.todos = todos;
	}

    
    
    public Long setUserId() {
    	this.Userid = idSequence.incrementAndGet();
		return Userid;
    	
    }
    
	public Long getUserid() {
		return Userid;
	}

	public void setUserid(Long userid) {
		Userid = userid;
	}

	public String getFname() {
		return fname;
	}

	public void setFname(String name) {
		this.fname = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	
}
