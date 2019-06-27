package com.huynguyen.model;

import javax.validation.constraints.NotEmpty;

public class ProductDTO {
	
    @NotEmpty
	private String catalog_id;
    @NotEmpty
	private String price;
    @NotEmpty
	private String name;
    @NotEmpty
	private String discount;
    @NotEmpty
	private String image_link;
    @NotEmpty
	private String image_list;
    
	private String view;
    
	private String enabled;
	private int id;
	public ProductDTO() {
		super();
	}
	
	public ProductDTO(String catalog_id, String price, String name, String discount, String image_link,
			String image_list, String view, String enabled, int id) {
		super();
		this.catalog_id = catalog_id;
		this.price = price;
		this.name = name;
		this.discount = discount;
		this.image_link = image_link;
		this.image_list = image_list;
		this.view = view;
		this.enabled = enabled;
		this.id = id;
	}

	public String getCatalog_id() {
		return catalog_id;
	}
	public void setCatalog_id(String catalog_id) {
		this.catalog_id = catalog_id;
	}
	public String getPrice() {
		return price;
	}
	public void setPrice(String price) {
		this.price = price;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDiscount() {
		return discount;
	}
	public void setDiscount(String discount) {
		this.discount = discount;
	}
	public String getImage_link() {
		return image_link;
	}
	public void setImage_link(String image_link) {
		this.image_link = image_link;
	}
	public String getImage_list() {
		return image_list;
	}
	public void setImage_list(String image_list) {
		this.image_list = image_list;
	}
	public String getView() {
		return view;
	}
	public void setView(String view) {
		this.view = view;
	}
	public String getEnabled() {
		return enabled;
	}
	public void setEnabled(String enabled) {
		this.enabled = enabled;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	
	
	
}
