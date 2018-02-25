package com.spring.xml;

import java.util.List;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "UserXml-list")  
public class UserListXml {
	private List<UserEnrollmentXml> studentList;  
	  
	 public UserListXml() {  
	 }  
	  
	 public UserListXml(List<UserEnrollmentXml> studentList) {  
	  this.studentList = studentList;  
	 }  
	  
	 @javax.xml.bind.annotation.XmlElement(name = "student")  
	 public List<UserEnrollmentXml> getStudentList() {  
	  return studentList;  
	 }  
}
