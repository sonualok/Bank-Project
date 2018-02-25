package com.spring.dao;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import com.spring.xml.UserEnrollmentXml;


public class CheckExistingUser {
	
	private  List           user = null;
	
    public boolean existingCustomerCheck(UserEnrollmentXml userEnrollmentXml, JdbcTemplate jt){
    	
    System.out.println("Started Checking user exist at bank side  " + userEnrollmentXml.getSsn()+
    		" "+userEnrollmentXml.getBank_name());
    
    user = jt.queryForList("select  *  from  test.bank_account_main  where ssn = ?", userEnrollmentXml.getSsn());
    System.out.println(user);	
    if(user.isEmpty())
	{
    	System.out.println("User does not exist at bank side");
    	return false;
	}
	else
	{ 
		System.out.println("User exist at bank side");
		return true;
	}
        	  
   }
}
