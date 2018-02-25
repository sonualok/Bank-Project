package com.spring.dao;

import java.util.List;

import com.spring.xml.UserListXml;
import com.spring.xml.UserEnrollmentXml;

public interface UserDaoXml
{
	UserListXml     findAllUsers();
	UserEnrollmentXml         findUserById(int  id);
	String          addUser(UserEnrollmentXml  obj);

}
