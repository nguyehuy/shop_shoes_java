package com.huynguyen.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;
import java.util.List;

/**
 * The persistent class for the student database table.
 * 
 */
@Entity(name = "categories")
@Table
public class Category implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;

	@Column(name = "name")
	private String name;

	@Column(name = "manufacture")
	private String manufacture;
	
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
	
	@OneToMany(cascade=CascadeType.ALL, fetch = FetchType.EAGER, mappedBy="catalog_id")
	private List<Product> products;

	public Category() {
	}
	
	

	public Category( String name, String manufacture) {
		super();
		
		this.name = name;
		this.manufacture = manufacture;
		
	}



	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getManufacture() {
		return manufacture;
	}

	public void setManufacture(String manufacture) {
		this.manufacture = manufacture;
	}

	public List<Product> getProducts() {
		return products;
	}

	public void setProducts(List<Product> products) {
		this.products = products;
	}
	

	

}