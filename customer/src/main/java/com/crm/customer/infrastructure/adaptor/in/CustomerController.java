
package com.crm.customer.infrastructure.adaptor.in;

import com.crm.customer.application.service.CustomerService;
import com.crm.customer.shared.constants.CustomerConstants;
import com.crm.customer.shared.req.CustomerGetReq;
import com.crm.customer.shared.req.CustomerSaveReq;
import com.crm.customer.shared.resp.ApiResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping(CustomerConstants.CUSTOMER_PATH_URL)
@PreAuthorize("hasRole('USER')")
public class CustomerController {

    @Autowired
    private CustomerService customerService;

    @PostMapping(value = CustomerConstants.GET_CUSTOMERS)
    public Mono<ResponseEntity<ApiResponse>> getCustomers(@RequestBody CustomerGetReq customerReq) {
        return customerService.getCustomers(customerReq);
    }


    @PostMapping(value = CustomerConstants.SAVE_CUSTOMER)
    public Mono<ResponseEntity<ApiResponse>> saveCustomer(@RequestBody CustomerSaveReq customerSaveReq) {
        return customerService.saveCustomer(customerSaveReq);
    }

}
