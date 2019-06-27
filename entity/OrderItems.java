package com.huynguyen.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;
import java.util.List;

/**
 * The persistent class for the student database table.
 * 
 */
@Entity(name = "orderitems")
@Table
public class OrderItems implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;

	

	@Column(name = "number")
	private int number;
	
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
	
	
	@Column(name = "price")
	private int price;
	
	
	@OneToOne
    @JoinColumn(name = "product_id")
	private Product product;
	
	
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "order_id")
	private Order order;

	public OrderItems() {
	}
	
	

	public OrderItems( int number, int price, Order order) {
		super();
		
		this.number = number;
		this.price = price;
		this.order = order;
	}



	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	

	public int getNumber() {
		return number;
	}

	public void setNumber(int number) {
		this.number = number;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public Order getOrder() {
		return order;
	}

	public void setOrder(Order order) {
		this.order = order;
	}



	public Product getProduct() {
		return product;
	}



	public void setProduct(Product product) {
		this.product = product;
	}
	
	

	
	

	

}