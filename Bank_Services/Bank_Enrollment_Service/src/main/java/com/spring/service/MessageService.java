package com.spring.service;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Map;

import javax.xml.bind.annotation.XmlRootElement;

import org.spring.stubdatabase.DatabaseClass;

import com.spring.model.Message;

@XmlRootElement(name = "message-list")  
public class MessageService {
    
	private Map<Long, Message> messages = DatabaseClass.getMessage(); 
	private List<Message> messageList;  
	
	public MessageService() {
	messages.put(1L, new Message(1,"HelloWorld","Alok"));
	messages.put(2L, new Message(2,"HelloIndia","Sonu"));
	
	}

	public MessageService(List<Message> messageList) {  
		  this.messageList = messageList;  
		 }  
	
	@javax.xml.bind.annotation.XmlElement(name = "message")  
	public List<Message> getAllMessages(){
		return new ArrayList<Message>(messages.values());
	}
	
	@javax.xml.bind.annotation.XmlElement(name = "message1")  
	public List<Message> getAllMessagesforYear(int year){
		List<Message> messageForYear = new ArrayList<Message>();
		Calendar cal = Calendar.getInstance();
		
		for(Message message:messages.values()){
			cal.setTime(message.getCreated());
			if(cal.get(Calendar.YEAR)==year){
			}
		}
		return messageForYear;
	}
	
	@javax.xml.bind.annotation.XmlElement(name = "message2")  
	public List<Message> getAllMessagesPaginated(int start, int size){
		ArrayList<Message> list = new ArrayList<Message>(messages.values());
		return list.subList(start, start+size);
	}
	
	//@javax.xml.bind.annotation.XmlElement(name = "message2")
	public Message getMessage(long id){
		return messages.get(id);
	}
	
	//@javax.xml.bind.annotation.XmlElement(name = "message3")
	public Message addMessage(Message message){
		message.setId(messages.size() +1);
		messages.put(message.getId(),message);
		
		return message;
	}
	
	//@javax.xml.bind.annotation.XmlElement(name = "message4")
	public Message updateMessage(Message message){
		if(message.getId()<=0){
			return null;
		}
		messages.put(message.getId(),message);
		return message;
	}
	
	//@javax.xml.bind.annotation.XmlElement(name = "message5")
	public Message removeMessage(long id){
		return messages.remove(id);
	}
}
