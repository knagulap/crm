package com.crm.customer.shared.req;

import com.crm.customer.shared.dto.CustomerTO;
import lombok.Data;

@Data
public class CustomerGetReq extends CustomerFilterReq {

	/**
	 * 
	 */
	private static final long serialVersionUID = 6526217036270683215L;
	private CustomerTO customerTO = new CustomerTO();

}
