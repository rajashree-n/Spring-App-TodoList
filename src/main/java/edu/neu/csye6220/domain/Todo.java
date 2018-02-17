package edu.neu.csye6220.domain;

import java.util.concurrent.atomic.AtomicLong;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;  
import javax.persistence.Table;

import org.hibernate.annotations.NamedQueries;
import org.hibernate.annotations.NamedQuery;
import org.hibernate.validator.constraints.NotEmpty;

@Entity
@Table(name ="todo")
public class Todo {

	@Id
	@Column(name="ID")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long ID;    

	@NotEmpty
	@Column(name="todo")
	private String todo;
		    
	@ManyToOne//(cascade=CascadeType.ALL)
	@JoinColumn(name="Userid")
	private User user;
	
    public Long getId() {
		return ID;
	}

	public void setID(Long ID) {
		this.ID = ID;
	}

	public String getTodo() {
		return todo;
	}

	public void setTodo(String todo) {
		this.todo = todo;
	}

    public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

}
