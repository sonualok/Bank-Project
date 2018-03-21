package com.spring.model;

import java.util.Date;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

import org.hibernate.validator.constraints.Email;
import org.junit.Ignore;

import com.fasterxml.jackson.annotation.JsonIgnore;


@XmlRootElement(name = "message")
public class Message {

	private long id;
	private String message;
	private Date created;
	
	
	@Email(message="Wrong Email Format")
	private String author;
	
	@NotNull
	@Pattern(regexp="^[a-zA-Z0-9]{09}", message="Only 9 digits are allowed")
	private String postalCode;
	
	private String responsemessage;
	
	
	public String getResponsemessage() {
		return responsemessage;
	}

	public void setResponsemessage(String responsemessage) {
		this.responsemessage = responsemessage;
	}

	public String getPostalCode() {
		return postalCode;
	}

	public void setPostalCode(String postalCode) {
		this.postalCode = postalCode;
	}

	protected Message() {
	}
	
	public Message(long id, String message, String author) {
		this.id = id;
		this.message = message;
		this.author = author;
		this.created = new Date();
		
		System.out.println(created);
	}
	
	public long getId() {
		return id;
	}
	
	@XmlElement  
	public void setId(long id) {
		this.id = id;
	}
	public String getMessage() {
		return message;
	}
	
	 @XmlElement
	public void setMessage(String message) {
		this.message = message;
	}
	public Date getCreated() {
		return created;
	}
	
	 @XmlElement  
	public void setCreated(Date created) {
		this.created = created;
	}
	 
	public String getAuthor() {
		return author;
	}
	
	 @XmlElement
	public void setAuthor(String author) {
		this.author = author;
	}
}
