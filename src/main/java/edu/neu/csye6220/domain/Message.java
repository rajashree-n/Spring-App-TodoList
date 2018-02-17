package edu.neu.csye6220.domain;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.validator.constraints.NotEmpty;

@Entity
@Table(name ="message")
public class Message {

	@Id
	@Column(name="MSGID")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long msgid;
    
	@NotEmpty
	@Column(name="msg")
	private String msg;
	
	@ManyToOne//(cascade=CascadeType.ALL)
	@JoinColumn(name="Userid")
	private User user;
	
	public Long getMsgid() {
		return msgid;
	}

	public void setMsgid(Long msgid) {
		this.msgid = msgid;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}
	
	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

}
