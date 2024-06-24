package com.crm.customer.application.service;

import com.crm.customer.shared.req.CustomerGetReq;
import com.crm.customer.shared.req.CustomerSaveReq;
import com.crm.customer.shared.resp.ApiResponse;
import org.springframework.http.ResponseEntity;
import reactor.core.publisher.Mono;

public interface CustomerService  {
	Mono<ResponseEntity<ApiResponse>> getCustomers(CustomerGetReq customerReq);
	Mono<ResponseEntity<ApiResponse>>  saveCustomer(CustomerSaveReq customerSaveReq);
}
