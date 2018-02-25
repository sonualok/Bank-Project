package com.spring.junitclass;

public class HelloWorld {

	  private String message = "Hello world. Default setting.";
	  
	  public String greet(){
	    return message; 
	  }
	  
	  public String getMessage() {
	    return message;
	  }
	  
	  public void setMessage(String message) {
	    this.message = message;
	  }
	  
	  
}
