package com.huynguyen.model;

import java.util.List;

public class OrderDTO {
	private int id;
	private List<OrderItemsDTO> itemsDTOs;
	private boolean status;
	private int transaction_id;
	private UserDTO userDTO;
	

	public OrderDTO() {
		super();
	}

	public List<OrderItemsDTO> getItemsDTOs() {
		return itemsDTOs;
	}

	public void setItemsDTOs(List<OrderItemsDTO> itemsDTOs) {
		this.itemsDTOs = itemsDTOs;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public boolean isStatus() {
		return status;
	}

	public void setStatus(boolean status) {
		this.status = status;
	}

	public int getTransaction_id() {
		return transaction_id;
	}

	public void setTransaction_id(int transaction_id) {
		this.transaction_id = transaction_id;
	}

	public UserDTO getUserDTO() {
		return userDTO;
	}

	public void setUserDTO(UserDTO userDTO) {
		this.userDTO = userDTO;
	}
	
	

}
