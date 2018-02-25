package com.spring.dao;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.spring.service.User;
import com.spring.validation.InputValidation;
import com.spring.validation.InputValidationCheck;
import com.spring.validation.InputValidationImpl;
import com.spring.xml.UserEnrollmentXml;

import oracle.sql.DATE;
import oracle.sql.TIMESTAMP;


@Repository
public class UserDaoImpl implements UserDao
{
	@Autowired
	private  JdbcTemplate  jt;
	
	@Autowired
	private  SetUpAccount setUpaccount;
	
	@Autowired
	private  InputValidation inputValidation;  
	
//	@Autowired
//    private SessionFactory sessionFactory;
//	
	static final Logger logger=Logger.getLogger(UserDaoImpl.class);
	
	//add init method
	public void initmethod(){
		System.out.println("intitilization Happened");
	}
	
	//add destroy method
		public void destroymethod(){
			System.out.println("destroy executed");
		}
	
	@Transactional(propagation=Propagation.REQUIRED)
	public String enrollUser(UserEnrollmentXml userEnrollmentXml){
		
		logger.debug("Starting Validation Process inside UserDaoImpl class and enrollUser Method");
		
		System.out.println("Starting Validation Process inside UserDaoImpl class and enrollUser Method");
		
		InputValidationCheck inputValidationCheck       = inputValidation.startValidation(userEnrollmentXml);
		boolean existinguser                            = new CheckExistingUser().existingCustomerCheck(userEnrollmentXml,jt);
		
		if(existinguser==false){
		boolean accountnumberdebitcardsetup = setUpaccount.setUpBankAccountAndDebitnumber(userEnrollmentXml,jt);	
		
		}
		else{
			return "User already exist";
		}
		return null;
	}
	
	public List<User> findAllUsers() 
	{
		
//	 return this.sessionFactory.getCurrentSession().createQuery("from BankAccountMain").list();
	 
	 
		List<User>   userList = new  ArrayList<User>();
		List  list=jt.queryForList("select * from  BANK.users");
		System.out.println("connected to database");
		Iterator  it = list.iterator();
		while(it.hasNext())
		{
			Map  map=(Map)it.next();
			User  u = new  User();
			BigDecimal  bd=(BigDecimal)map.get("id");
			int  i = bd.intValue();
			u.setId(i);
			u.setName((String)map.get("name"));
			userList.add(u);
		}
		return userList;
	}

	public User findUserById(int id) 
	{
		Map  map = jt.queryForMap("select  *  from  BANK.users  where  id=?", id);
		System.out.println("connected to database");
		User   u;
		if(map != null)
		{
			u = new  User();
			BigDecimal  bd=(BigDecimal)map.get("id");
			int  i = bd.intValue();
			u.setId(i);
			u.setName((String)map.get("name"));
		}
		else
		{ 
			u=null;
		}
		return  u;
	}

	public String addUser(User obj) 
	{
		String  str;
		int  id = obj.getId();
		String  name=obj.getName();
		System.out.println("inside insert method");
		int  i = jt.update("insert  into  BANK.users values(?,?)", id,name);
		if(i==1)
		{
			str="User  inserted.";
		}
		else
		{
			str="Sorry, User already exist";
		}
		return  str;
		
	}

}
