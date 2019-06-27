package com.huynguyen.model;

import javax.validation.constraints.NotEmpty;

public class TransactionDTO {
	
    
	
	private int id;
	
    @NotEmpty
    private boolean sttus ;
    
    
    private int user_id;
    @NotEmpty
    private String user_name;
    @NotEmpty
    private String user_phone;
    @NotEmpty
    private String total_money;
    
    private String payment;
    
    private String payment_info;
    @NotEmpty
    private String message;
    
    private String security;
  
    private String created;
    @NotEmpty
    private String user_address;
    
	
	public TransactionDTO() {
		super();
	}
	
	
	public TransactionDTO(boolean sttus, int user_id, String user_name, String user_phone, String total_money,
			String payment, String payment_info, String message, String security, String created, String user_address) {
		super();
		this.sttus = sttus;
		this.user_id = user_id;
		this.user_name = user_name;
		this.user_phone = user_phone;
		this.total_money = total_money;
		this.payment = payment;
		this.payment_info = payment_info;
		this.message = message;
		this.security = security;
		this.created = created;
		this.user_address = user_address;
	}


	public boolean isSttus() {
		return sttus;
	}

	public void setSttus(boolean sttus) {
		this.sttus = sttus;
	}

	public int getUser_id() {
		return user_id;
	}

	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}

	public String getUser_name() {
		return user_name;
	}

	public void setUser_name(String user_name) {
		this.user_name = user_name;
	}

	public String getUser_phone() {
		return user_phone;
	}

	public void setUser_phone(String user_phone) {
		this.user_phone = user_phone;
	}

	public String getTotal_money() {
		return total_money;
	}

	public void setTotal_money(String total_money) {
		this.total_money = total_money;
	}

	public String getPayment() {
		return payment;
	}

	public void setPayment(String payment) {
		this.payment = payment;
	}

	public String getPayment_info() {
		return payment_info;
	}

	public void setPayment_info(String payment_info) {
		this.payment_info = payment_info;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getSecurity() {
		return security;
	}

	public void setSecurity(String security) {
		this.security = security;
	}

	public String getCreated() {
		return created;
	}

	public void setCreated(String created) {
		this.created = created;
	}

	public String getUser_address() {
		return user_address;
	}

	public void setUser_address(String user_address) {
		this.user_address = user_address;
	}

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	
	
	
}
