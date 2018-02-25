//package com.spring.entity;
//
//import java.sql.Time;
//
//import javax.persistence.Column;
//import javax.persistence.Entity;
//import javax.persistence.GeneratedValue;
//import javax.persistence.Id;
//import javax.persistence.Table;
//
//@Entity
//@Table(name="bank_account_main")
//public class BankAccountMain {
//
//	@Id
//    @Column(name="customer_bank_id")
//    @GeneratedValue
//	Integer customer_bank_id;
//	
//	@Column(name="customer_bank_id_trace")
//	Integer customer_bank_id_trace;
//	
//	@Column(name="bank_name")
//	String  bank_name;
//	
//	@Column(name="customer_bank_number")
//	Integer customer_bank_number;
//	
//	@Column(name="customer_debit_card_number")
//	Integer customer_debit_card_number;
//	
//	@Column(name="customer_debit_card_selection")
//	String  customer_debit_card_selection;
//	
//	@Column(name="insurer_client_name")
//	String  insurer_client_name;
//	
//	@Column(name="last_time_stamp")
//	Time    last_time_stamp;
//
//	
//	public Integer getCustomer_bank_id() {
//		return customer_bank_id;
//	}
//
//	public void setCustomer_bank_id(Integer customer_bank_id) {
//		this.customer_bank_id = customer_bank_id;
//	}
//
//	public Integer getCustomer_bank_id_trace() {
//		return customer_bank_id_trace;
//	}
//
//	public void setCustomer_bank_id_trace(Integer customer_bank_id_trace) {
//		this.customer_bank_id_trace = customer_bank_id_trace;
//	}
//
//	public String getBank_name() {
//		return bank_name;
//	}
//
//	public void setBank_name(String bank_name) {
//		this.bank_name = bank_name;
//	}
//
//	public Integer getCustomer_bank_number() {
//		return customer_bank_number;
//	}
//
//	public void setCustomer_bank_number(Integer customer_bank_number) {
//		this.customer_bank_number = customer_bank_number;
//	}
//
//	public Integer getCustomer_debit_card_number() {
//		return customer_debit_card_number;
//	}
//
//	public void setCustomer_debit_card_number(Integer customer_debit_card_number) {
//		this.customer_debit_card_number = customer_debit_card_number;
//	}
//
//	public String getCustomer_debit_card_selection() {
//		return customer_debit_card_selection;
//	}
//
//	public void setCustomer_debit_card_selection(String customer_debit_card_selection) {
//		this.customer_debit_card_selection = customer_debit_card_selection;
//	}
//
//	public String getInsurer_client_name() {
//		return insurer_client_name;
//	}
//
//	public void setInsurer_client_name(String insurer_client_name) {
//		this.insurer_client_name = insurer_client_name;
//	}
//
//	public Time getLast_time_stamp() {
//		return last_time_stamp;
//	}
//
//	public void setLast_time_stamp(Time last_time_stamp) {
//		this.last_time_stamp = last_time_stamp;
//	}	
//}
