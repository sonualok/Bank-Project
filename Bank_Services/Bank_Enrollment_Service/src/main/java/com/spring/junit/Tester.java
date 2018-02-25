package com.spring.junit;

import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;

import com.spring.junitclass.MyTest;

public class Tester {
	
		  public static void main(String[] args) {
		    Result result = JUnitCore.runClasses(MyTest.class);
		    
		    for (Failure failure : result.getFailures()) {
		      System.out.println(failure.toString());
		    }
	  }
}
	

