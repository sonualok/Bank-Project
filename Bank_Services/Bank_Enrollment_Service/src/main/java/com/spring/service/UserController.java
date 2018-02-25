package com.spring.service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.spring.dao.UserDao;
import com.spring.dao.UserDaoXml;
import com.spring.xml.UserListXml;
import com.spring.xml.UserEnrollmentXml;

@Service
public class UserController 
{
	@Autowired
	private  UserDao  userDao;
	
	@Autowired
	private  UserDaoXml  userDaoXml;
	

	
	
}
