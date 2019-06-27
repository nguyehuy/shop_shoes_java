package com.huynguyen.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;

/**
 * The persistent class for the student database table.
 * 
 */
@Entity(name = "transaction")
public class Transaction implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;

	@Column(name = "sttus")
	private boolean sttus;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "user_id")
	private User user;

	@Column(name = "user_name")
	private String user_name;

	@Column(name = "user_phone")
	private String user_phone;

	@Column(name = "total_money")
	private int total_money;

	@Column(name = "payment")
	private String payment;

	@Column(name = "payment_info")
	private String payment_info;

	@Column(name = "message")
	private String message;

	@Column(name = "security")
	private int security;

	@Column(name = "created")
	private Date created;

	@Column(name = "user_address")
	private String user_address;

	public Transaction() {
	}
	

	public Transaction(boolean sttus, User user, String user_name, String user_phone, int total_money,
			String payment, String payment_info, String message, int security, Date created, String user_address) {
		super();
		this.sttus = sttus;
		this.user = user;
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


	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public boolean isSttus() {
		return sttus;
	}

	public void setSttus(boolean sttus) {
		this.sttus = sttus;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
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

	

	public int getTotal_money() {
		return total_money;
	}


	public void setTotal_money(int total_money) {
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

	public int getSecurity() {
		return security;
	}

	public void setSecurity(int security) {
		this.security = security;
	}

	public Date getCreated() {
		return created;
	}

	public void setCreated(Date created) {
		this.created = created;
	}

	public String getUser_address() {
		return user_address;
	}

	public void setUser_address(String user_address) {
		this.user_address = user_address;
	}

}