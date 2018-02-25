package com.spring.dao;

import org.springframework.jdbc.core.JdbcTemplate;

import com.spring.xml.UserEnrollmentXml;

public interface SetUpAccount {
	
	public void setUpBankAccount(UserEnrollmentXml userEnrollmentXml,JdbcTemplate jt);
	public void setUpBankAccountHistory(UserEnrollmentXml userEnrollmentXml,JdbcTemplate jt);
    public void setUpcustomerDemographicDetails(UserEnrollmentXml userEnrollmentXml,JdbcTemplate jt);
	public boolean setUpBankAccountAndDebitnumber(UserEnrollmentXml userEnrollmentXml, JdbcTemplate jt);
	
}
