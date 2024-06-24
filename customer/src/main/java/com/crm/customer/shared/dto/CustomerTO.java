package com.crm.customer.shared.dto;

@lombok.Data
public class CustomerTO extends ActivityTO {
	private Long id;
	private Long cmpId;
	private String name;
	private String email;
	private String phone;
	private Integer status;
}
