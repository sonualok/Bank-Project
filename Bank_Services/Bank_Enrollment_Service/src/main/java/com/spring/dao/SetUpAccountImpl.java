package com.spring.dao;

import java.sql.Types;
import java.util.HashMap;
import java.util.List;
import java.util.Random;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.spring.xml.UserEnrollmentXml;


@Transactional(rollbackFor = Exception.class)
public class SetUpAccountImpl implements SetUpAccount{

	
	int debitCardNumber;     
	int bank_account_number;
	
	
    public boolean setUpBankAccountAndDebitnumber(UserEnrollmentXml userEnrollmentXml,JdbcTemplate jt) {
    	boolean operation = false;
    	List    user = null;
    	int i; 
    	
		System.out.println("Set up bank account number and debit card number ");
		
		debitCardNumber        = get10RandomNumber();     
		bank_account_number    = get10RandomNumber();
		
		user = jt.queryForList("select  customer_bank_number, customer_debit_card_number  "
				+ "from  Test.bank_account_number where ssn=?", userEnrollmentXml.getSsn());
		
		if(user.isEmpty()){
			
			i = jt.update("insert  into  Test.bank_account_number values(?,?,?,?)",
					                                                          "1",
					                                                          bank_account_number,
					                                                          debitCardNumber,
					                                                          userEnrollmentXml.getSsn());
			if(i==1){
				operation = true;
				System.out.println("Sucessfully insterted in table bank_account_number");
				setUpBankAccount(userEnrollmentXml,jt);
			}
		}
		return operation;
	}

	
	public void setUpBankAccount(UserEnrollmentXml userEnrollmentXml, JdbcTemplate jt) {
		HashMap l = (HashMap) jt.queryForMap("select  customer_bank_id  from  test.bank_account_number  where ssn = ?", userEnrollmentXml.getSsn());
	    l.get("CUSTOMER_BANK_ID");
	    
	    java.util.Date date = new java.util.Date();
	     
	    long t = date.getTime();
	    java.sql.Timestamp sqlTimestamp = new java.sql.Timestamp(t); 
	    
	    System.out.println("Customer Bank Id " +l.get("CUSTOMER_BANK_ID"));
		int i = jt.update("insert  into  Test.bank_account_main values(?,?,?,?,?,?,?,?,?,?)",
				                                               l.get("CUSTOMER_BANK_ID"),
				                                               "1",
				                                               userEnrollmentXml.getBank_name(),
				                                               bank_account_number,
		                                                       debitCardNumber,
		                                                       userEnrollmentXml.getCustomer_debit_card_selection(),
		                                                       userEnrollmentXml.getInsurer_client_name(),
		                                                       userEnrollmentXml.getBank_balance(),
		                                                       userEnrollmentXml.getSsn(),
		                                                       new java.sql.Timestamp(System.currentTimeMillis()));
				                                               
		if(i==1){
			System.out.println("sucessfully inserted in table bank_account_main");
			setUpBankAccountHistory(userEnrollmentXml,jt);
			
		}		
	}
	
	public void setUpBankAccountHistory(UserEnrollmentXml userEnrollmentXml,JdbcTemplate jt) {
		
		HashMap l = (HashMap) jt.queryForMap("select  customer_bank_id  from  test.bank_account_number  where ssn = ?", userEnrollmentXml.getSsn());

	    HashMap l1 = (HashMap) jt.queryForMap("select  customer_bank_id_trace  from  test.bank_account_main  where customer_bank_id = ?", l.get("CUSTOMER_BANK_ID"));

	    
	}

	public void setUpcustomerDemographicDetails(UserEnrollmentXml userEnrollmentXml,JdbcTemplate jt) {
		// TODO Auto-generated method stub
		
	}
	
	private static int get10RandomNumber() {
	    Random random=new Random();
	    int randomNumber=0;
	    boolean loop=true;
	    while(loop) {
	        randomNumber=random.nextInt();
	        if(Integer.toString(randomNumber).length()==10 && !Integer.toString(randomNumber).startsWith("-")) {
	            loop=false;
	        }
	        }
	    return randomNumber;
	}
}
