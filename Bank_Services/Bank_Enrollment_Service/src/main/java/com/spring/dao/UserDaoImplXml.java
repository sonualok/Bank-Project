//package com.spring.dao;
//
//import java.math.BigDecimal;
//import java.util.ArrayList;
//import java.util.Iterator;
//import java.util.List;
//import java.util.Map;
//
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.jdbc.core.JdbcTemplate;
//import org.springframework.stereotype.Repository;
//
//
//import com.spring.service.User;
//import com.spring.xml.UserListXml;
//import com.spring.xml.UserEnrollmentXml;
//@Repository
//public class UserDaoImplXml implements UserDaoXml
//{
//	@Autowired
//	private  JdbcTemplate  jt;
//	
//
//	public UserListXml findAllUsers() 
//	{
//		List<UserEnrollmentXml>   userList = new  ArrayList<UserEnrollmentXml>();
//		List  list=jt.queryForList("select * from  test.users");
//		System.out.println("connected to database");
//		Iterator  it = list.iterator();
//		while(it.hasNext())
//		{
//			Map  map=(Map)it.next();
//			UserEnrollmentXml  u = new  UserEnrollmentXml();
//			BigDecimal  bd=(BigDecimal)map.get("id");
//			int  i = bd.intValue();
//			u.setId(i);
//			u.setName((String)map.get("name"));
//			userList.add(u);
//		}
//		return new UserListXml(userList);
//	}
//
//	public UserEnrollmentXml findUserById(int id) 
//	{
//		Map  map = jt.queryForMap("select  *  from  test.users  where  id=?", id);
//		System.out.println("connected to database");
//		UserEnrollmentXml   u;
//		if(map != null)
//		{
//			u = new  UserEnrollmentXml();
//			BigDecimal  bd=(BigDecimal)map.get("id");
//			int  i = bd.intValue();
//			u.setId(i);
//			u.setName((String)map.get("name"));
//		}
//		else
//		{ 
//			u=null;
//		}
//		return  u;
//	}
//
//	public String addUser(UserEnrollmentXml obj) 
//	{
//		String  str;
//		int  id = obj.getId();
//		String  name=obj.getName();
//		System.out.println("inside insert method");
//		int  i = jt.update("insert  into  test.users values(?,?)", id,name);
//		if(i==1)
//		{
//			str="User  inserted.";
//		}
//		else
//		{
//			str="Sorry, User already exist";
//		}
//		return  str;
//		
//	}
//
//}
