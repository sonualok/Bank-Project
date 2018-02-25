package com.spring.validation;

import org.apache.log4j.Logger;
import com.spring.xml.UserEnrollmentXml;

public class InputValidationImpl implements InputValidation {
	
	static final Logger logger=Logger.getLogger(InputValidationImpl.class);
	
	public InputValidationCheck startValidation(UserEnrollmentXml userEnrollmentXml){
		
		logger.debug("Started Validation Process inside InputValidation class and startValidation Method");
		
		System.out.println("Started Validation Process inside InputValidation class and startValidation Method");
		
		InputValidationCheck inputValidationCheck = new InputValidationCheck();
	   
        if(userEnrollmentXml.getBank_name()!=null && userEnrollmentXml.getBank_name().equals("City Bank") ){
        	inputValidationCheck.setBank_name(true);
        }
        else{
        	throw new RuntimeException();
        }
                    
        if(userEnrollmentXml.getCustomer_debit_card_selection()!=null){
        	inputValidationCheck.setCustomer_debit_card_selection(true);
        }
        
        if(userEnrollmentXml.getInsurer_client_name()!=null){
        	inputValidationCheck.setInsurer_client_name(true);
        }
        
        if(userEnrollmentXml.getBank_balance()<0){
        	inputValidationCheck.setBank_balance(true);
        }
        
        if(userEnrollmentXml.getFirst_name()!=null){
        	inputValidationCheck.setFirst_name(true);
        }
        
        if(userEnrollmentXml.getMiddle_name()!=null){
        	inputValidationCheck.setMiddle_name(true);
        }
        
        if(userEnrollmentXml.getLast_name()!=null){
        	inputValidationCheck.setLast_name(true);
        }
        
        if(userEnrollmentXml.getEmail_id()!=null){
        	inputValidationCheck.setEmail_id(true);
        }
        
        if(userEnrollmentXml.getFirst_line_address()!=null){
        	inputValidationCheck.setFirst_line_address(true);
        }
        
        if(userEnrollmentXml.getSecond_line_address()!=null){
        	inputValidationCheck.setSecond_line_address(true);
        }
        
        if(userEnrollmentXml.getFirst_line_office_address()!=null){
        	inputValidationCheck.setFirst_line_office_address(true);
        }
        
        if(userEnrollmentXml.getSecond_line_office_address()!=null){
        	inputValidationCheck.setSecond_line_office_address(true);
        }
        
        if(userEnrollmentXml.getPin_code()!=0){
        	inputValidationCheck.setPin_code(true);
        }
        
        if(userEnrollmentXml.getCountry()!=null){
        	inputValidationCheck.setCountry(true);
        }
        
        if(userEnrollmentXml.getCity()!=null){
        	inputValidationCheck.setCity(true);
        }
        
        if(userEnrollmentXml.getMobile_number()!=0){
        	inputValidationCheck.setMobile_number(true);
        }
        
        if(userEnrollmentXml.getDate_of_birth()!=null){
        	inputValidationCheck.setDate_of_birth(true);
        }

        return inputValidationCheck;
	}
}
