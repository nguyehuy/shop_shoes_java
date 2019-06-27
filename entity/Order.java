package com.huynguyen.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;
import java.util.List;

/**
 * The persistent class for the student database table.
 * 
 */
@Entity(name = "orderbill")
@Table
public class Order implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;

	@Column(name = "transaction_id")
	private int transaction_id;
	
	@Column(name = "sttus")
	private boolean status;

	@OneToMany(cascade=CascadeType.ALL, fetch = FetchType.EAGER, mappedBy="order")
	private List<OrderItems> orderItems;
	
//	@JoinTable(
//			name = "Cate_id",
//	        joinColumns = @JoinColumn(
//	                name = "Cate_id",
//	                referencedColumnName = "id"
//	        ),
//	        inverseJoinColumns = @JoinColumn(
//	                name = "Pro_id",
//	                referencedColumnName = "id"
//	                )
//			)
	
//	@OneToMany(cascade=CascadeType.ALL, fetch = FetchType.EAGER, mappedBy="catalog_id")
//	private List<Product> products;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "user_id")
	private User user;

	public Order() {
	}
	
	

	public Order(int transaction_id, List<OrderItems> orderItems, boolean status) {
		super();
		this.transaction_id = transaction_id;
		this.orderItems = orderItems;
		this.status = status;
	}



	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getTransaction_id() {
		return transaction_id;
	}

	public void setTransaction_id(int transaction_id) {
		this.transaction_id = transaction_id;
	}

	

	public boolean isStatus() {
		return status;
	}

	public void setStatus(boolean status) {
		this.status = status;
	}

	public List<OrderItems> getOrderItems() {
		return orderItems;
	}

	public void setOrderItems(List<OrderItems> orderItems) {
		this.orderItems = orderItems;
	}



	public User getUser() {
		return user;
	}



	public void setUser(User user) {
		this.user = user;
	}

	

	
	
	

	
	

	

}