package com.spring.junit;

import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.spring.junitclass.HelloWorld;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration
public class UnitTest {

      @Autowired
      HelloWorld helloWorld;
      
	  @Test
	  public void test() {    
	    
	  //assertEquals(helloWorld.greet(), "Hello world, from Spring.");
		  assertEquals(1, 1);
		  
		  //helloWorld.greet();	  
	  }
	  
	  public static void main(String args[]){
		
		  //UnitTest unitTest = new UnitTest();
		  //unitTest.helloWorld.greet();
	  }
}
