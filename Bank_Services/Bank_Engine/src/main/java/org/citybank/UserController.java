package org.citybank;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Scope;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.validation.BindException;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.annotation.JsonAppend;
import com.spring.dao.UserDao;
import com.spring.dao.UserDaoXml;
import com.spring.model.Message;
import com.spring.service.MessageService;
import com.spring.xml.UserListXml;
import com.spring.xml.UserEnrollmentXml;


@RestController
@RequestMapping("/messages")
//@Scope("prototype")
public class UserController 
{
	@Autowired
	private  UserDao  userDao;
	
	MessageService ms = new MessageService();
	
	Message message;
	
//	@Autowired
//	private MessageService message;
//	
//	@Autowired
//	private  UserDaoXml  userDaoXml;
	
	static final Logger  logger=Logger.getLogger(UserController.class);
	
	@RequestMapping(value="/addUser",  method=RequestMethod.POST, produces=MediaType.APPLICATION_XML_VALUE) 
			                                         //consumes=MediaType.APPLICATION_XML_VALUE)
	public   ResponseEntity<String>  EnrollmentProcess(@RequestBody UserEnrollmentXml userEnrollmentXml)
	{	System.out.println("Inside EnrollmentProcess");
	    logger.debug("Inside addUser Resource::::::Request to add the User at bank side");
	    
	    HttpHeaders responseHeaders = new HttpHeaders();
		String  str = userDao.enrollUser(userEnrollmentXml);
		return new ResponseEntity<String>(str,responseHeaders,HttpStatus.OK);
	}
	
	@RequestMapping(value="/messages/{messageId}/{name}",  method=RequestMethod.GET, produces=MediaType.APPLICATION_XML_VALUE)
	public   ResponseEntity<String>  pathparamtype(@PathVariable int messageId,@PathVariable String name)
	{	System.out.println("Inside Get Type");
	    logger.debug("Inside addUser Resource::::::Request to add the User at bank side");
	    
	    HttpHeaders responseHeaders = new HttpHeaders();
		String  str1 = Integer.toString(messageId);
		String  str2 = name;
		return new ResponseEntity<String>("message Id is "+str1+" name is "+str2,responseHeaders,HttpStatus.OK);
	}
	
	@RequestMapping(value="/messages/{messageId}/{name}",  method=RequestMethod.POST	, produces=MediaType.APPLICATION_XML_VALUE)
	public   ResponseEntity<String>  updatetype(@PathVariable int messageId,@PathVariable String name)
	{	System.out.println("Inside update Type");
	    logger.debug("Inside addUser Resource::::::Request to add the User at bank side");
	    
	    HttpHeaders responseHeaders = new HttpHeaders();
		String  str1 = Integer.toString(messageId);
		String  str2 = name;
		return new ResponseEntity<String>("message Id is "+str1+" name is "+str2,responseHeaders,HttpStatus.OK);
	}
	
	
	/*
	 * This resource will return array of xmls*/
	
	@RequestMapping(method=RequestMethod.GET, 
			        produces=MediaType.APPLICATION_JSON_VALUE,params={"year","start","size"})
    public ResponseEntity<MessageService>  getMessages(@RequestParam("year") int year,
											    	   @RequestParam("start") int start,
											    	   @RequestParam("size") int size){
		
		if(year>0){
		return new ResponseEntity<>(new MessageService(ms.getAllMessagesforYear(year)),HttpStatus.OK);
		}
		if(start>=0 && size>=0){
		return new ResponseEntity<>(new MessageService(ms.getAllMessagesPaginated(start, size)),HttpStatus.OK);
		}
		return new ResponseEntity<>(new MessageService(ms.getAllMessages()),HttpStatus.OK);	
	}
	
	/*
	 * need to read @PathVariable Documents for more implementations
	 * 
	 * */
	@RequestMapping(value="/{messageId}",  method=RequestMethod.GET, produces=MediaType.APPLICATION_JSON_VALUE)
	public   ResponseEntity<Message>  getmessagebyId(@PathVariable int messageId)
	{	System.out.println("Inside Get Type");
	   
	    return new ResponseEntity<>(ms.getMessage(messageId),HttpStatus.OK);
	    
	}
	

	@RequestMapping(method=RequestMethod.POST, produces=MediaType.APPLICATION_JSON_VALUE,
			consumes=MediaType.APPLICATION_JSON_VALUE)
	public   ResponseEntity<Message>  addmessage(@Valid @RequestBody Message message,
			BindingResult bindingResult) throws BindException
	{	System.out.println("Inside POST Type");
	
	    if (bindingResult.hasErrors()) {
	    	this.message = message;
	      throw new BindException(bindingResult);
	    }
	    message.setResponsemessage("Success");
	    return new ResponseEntity<>(ms.addMessage(message),HttpStatus.OK);
	}
	
	@ExceptionHandler(BindException.class)
    public @ResponseBody ResponseEntity<Message> handleException(BindException e) 
    {    System.out.println("Inside Exception");
         message.setResponsemessage(e.getFieldError().toString());
         return new ResponseEntity<>(message,HttpStatus.BAD_REQUEST);
    }

	
	@RequestMapping(method=RequestMethod.PUT, produces=MediaType.APPLICATION_JSON_VALUE,
			consumes=MediaType.APPLICATION_JSON_VALUE)
	public   ResponseEntity<Message>  updatemessage(@RequestBody Message message)
	{	System.out.println("Inside PUT Type");
	    
	    return new ResponseEntity<>(ms.updateMessage(message),HttpStatus.OK);
	}
	
	
	
//	@RequestMapping(value="/messages", 
//	        method=RequestMethod.GET, 
//	        produces=MediaType.APPLICATION_ATOM_XML_VALUE)
//	public Message  getMessages(){
//	
//	Message message1 = new Message(1L,"Hello World","Alok");
//
//	return message1;
//	}
	
//	@RequestMapping(value="/getUsersXml", method=RequestMethod.GET, produces=MediaType.APPLICATION_XML_VALUE)
//	public   @ResponseBody  List  getAllUsersXml()
//	{	
//		System.out.println("inside getAllusersXml");
//		List  userList = userDao.findAllUsers();
//		return userList;
//	}

	
	@RequestMapping(value="/getUsersXml", method=RequestMethod.GET, produces=MediaType.APPLICATION_XML_VALUE)
	public   @ResponseBody  List  respondejson()
	{	
		System.out.println("inside getAllusersXml");
		List  userList = userDao.findAllUsers();
		return userList;
	}
	
//	@RequestMapping(value="/getUserByIdXml/{id}", method=RequestMethod.GET, produces=MediaType.APPLICATION_XML_VALUE)
//	public   @ResponseBody  UserEnrollmentXml  getAllUserByIdXml(@PathVariable("id")int  id)
//	{	
//		System.out.println("inside getUserByIdXml");
//		UserEnrollmentXml  userList = userDaoXml.findUserById(id);
//		return userList;
//	}
}
