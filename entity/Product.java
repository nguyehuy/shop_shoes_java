package com.huynguyen.entity;

import java.io.Serializable;
import javax.persistence.*;

import java.util.List;

import java.util.Date;

/**
 * The persistent class for the student database table.
 * 
 */
@Entity(name = "product")
@Table
public class Product implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;

	@Column(name = "name")
	private String name;

	@Column(name = "price")
	private int price;

	@Column(name = "discount")
	private int discount;

	@Column(name = "image_link")
	private String image_link;

	@Column(name = "image_list")
	private String image_list;

	@Column(name = "view")
	private int view;

	// @ManyToOne
	// @JoinColumn(name="id", insertable = false, updatable = false)
	// private Category category;
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "catalog_id")
	private Category catalog_id;
	
	@OneToOne(mappedBy="product")
	private OrderItems orderItems;

	public Product() {
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

//	public Category getCatalog_id() {
//		return catalog_id;
//	}
//
//	public void setCatalog_id(Category catalog_id) {
//		this.catalog_id = catalog_id;
//	}
	

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public int getDiscount() {
		return discount;
	}

	public void setDiscount(int discount) {
		this.discount = discount;
	}

	public String getImage_link() {
		return image_link;
	}

	public void setImage_link(String image_link) {
		this.image_link = image_link;
	}

	public int getView() {
		return view;
	}

	public void setView(int view) {
		this.view = view;
	}

	public String getImage_list() {
		return image_list;
	}

	public void setImage_list(String image_list) {
		this.image_list = image_list;
	}

	public Category getCatalog_id() {
		return catalog_id;
	}

	public void setCatalog_id(Category catalog_id) {
		this.catalog_id = catalog_id;
	}

	public OrderItems getOrderItems() {
		return orderItems;
	}

	public void setOrderItems(OrderItems orderItems) {
		this.orderItems = orderItems;
	}

	
	
	

}