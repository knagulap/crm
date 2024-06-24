package com.crm.customer.domain.service.handler;
import com.crm.customer.domain.model.CustomerEntity;
import com.crm.customer.shared.dto.CustomerTO;

public class CustomerHandler {

	public static CustomerEntity convertPOJOToEntity(CustomerTO customerTO) {
		CustomerEntity customerEntity = new CustomerEntity();
		if(customerTO.getId()!=null) {
			customerEntity.setId(customerTO.getId());
		}
		customerEntity.setCmpId(customerTO.getCmpId());
		customerEntity.setName(customerTO.getName());
		customerEntity.setEmail(customerTO.getEmail());
		customerEntity.setPhone(customerTO.getPhone());
		customerEntity.setStatus(customerTO.getStatus());
		customerEntity.setCreatedBy(customerTO.getCreatedBy());
		customerEntity.setCreatedOn(customerTO.getCreatedOn());
		customerEntity.setUpdatedBy(customerTO.getUpdatedBy());
		customerEntity.setUpdatedOn(customerTO.getUpdatedOn());
		return customerEntity;
	}

	public static CustomerTO convertEntityToPOJO(CustomerEntity customerEntity) {
		CustomerTO customerTO = new CustomerTO();
		customerTO.setId(customerEntity.getId());
		customerTO.setCmpId(customerEntity.getCmpId());
		customerTO.setName(customerEntity.getName());
		customerTO.setEmail(customerEntity.getEmail());
		customerTO.setPhone(customerEntity.getPhone());
		customerTO.setStatus(customerEntity.getStatus());
		customerTO.setCreatedBy(customerEntity.getCreatedBy());
		customerTO.setCreatedOn(customerEntity.getCreatedOn());
		customerTO.setUpdatedBy(customerEntity.getUpdatedBy());
		customerTO.setUpdatedOn(customerEntity.getUpdatedOn());
		return customerTO;
	}
}
