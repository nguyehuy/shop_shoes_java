package com.huynguyen.model;

import javax.validation.constraints.NotEmpty;

public class CategoryDTO {
	
    
	@NotEmpty
	private String name;
	
    @NotEmpty
    private String manufacture;
    
	private int id;
	public CategoryDTO() {
		super();
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
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	
	
	
}
