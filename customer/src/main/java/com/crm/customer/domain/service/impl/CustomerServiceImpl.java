
package com.crm.customer.domain.service.impl;

import com.crm.customer.application.service.CustomerService;
import com.crm.customer.domain.model.CustomerEntity;
import com.crm.customer.domain.repository.CustomerRepository;
import com.crm.customer.domain.service.handler.CustomerHandler;
import com.crm.customer.shared.constants.CustomerConstants;
import com.crm.customer.shared.req.CustomerGetReq;
import com.crm.customer.shared.req.CustomerSaveReq;
import com.crm.customer.shared.resp.ApiResponse;
import com.crm.customer.shared.resp.CustomerPageResponse;
import com.crm.customer.shared.utils.AppUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.*;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestBody;
import reactor.core.publisher.Mono;

@Service
@Transactional
public class CustomerServiceImpl implements CustomerService {

    @Autowired
    private CustomerRepository customerRepository;

    @Override
    @Transactional(readOnly = true)
    public Mono<ResponseEntity<ApiResponse>> getCustomers(@RequestBody CustomerGetReq customerReq) {
        try {
            // Create Pageable for pagination
            Pageable pageable = PageRequest.of(
                    customerReq.getPage(),
                    customerReq.getPageSize(),
                    Sort.by(customerReq.getDirection(), customerReq.getSortBy())
            );

            // Fetch customers with repository method
            Page<CustomerEntity> customerEntities = customerRepository.findByCmpIdAndStatus(
                    customerReq.getCustomerTO().getCmpId(),
                    customerReq.getCustomerTO().getStatus(),
                    pageable);
            if (customerEntities.isEmpty()) {
                return Mono.just(ResponseEntity.status(HttpStatus.OK).body(AppUtil.getApiSuccessResponse("No customers found", HttpStatus.OK.value())));
            }
            ApiResponse apiResponse = AppUtil.getApiSuccessResponse("Customers retrieved successfully", HttpStatus.OK.value());

            customerEntities.stream().forEach(customerEntity -> {
                apiResponse.getCustomerPageResponse().getData().add(CustomerHandler.convertEntityToPOJO(customerEntity));
            });

            PageImpl page = ((PageImpl) customerEntities);
            apiResponse.getCustomerPageResponse().setSortBy(page.getSort().toString());
            apiResponse.getCustomerPageResponse().setCurrentPage(page.getNumber());
            apiResponse.getCustomerPageResponse().setPageSize(page.getSize());
            apiResponse.getCustomerPageResponse().setTotalPages(page.getTotalPages());
            apiResponse.getCustomerPageResponse().setTotalElements(page.getTotalElements());

            return Mono.just(ResponseEntity.ok(apiResponse))
                    .onErrorResume(e -> {
                        ApiResponse errorResponse = AppUtil.getApiSuccessResponse("Error while retrieving customers", HttpStatus.INTERNAL_SERVER_ERROR.value());
                        return Mono.just(ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(errorResponse));
                    });
        } catch (Exception e) {
            ApiResponse errorResponse = AppUtil.getApiSuccessResponse("Error while retrieving customers", HttpStatus.INTERNAL_SERVER_ERROR.value());
            return Mono.just(ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(errorResponse));
        }
    }

    @Override
    public Mono<ResponseEntity<ApiResponse>> saveCustomer(@RequestBody CustomerSaveReq customerSaveReq) {
        try {
            CustomerEntity customerEntity = customerRepository.save(CustomerHandler.convertPOJOToEntity(customerSaveReq.getCustomerTO()));
            CustomerPageResponse customerPageResponse = new CustomerPageResponse();
            customerPageResponse.getData().add(CustomerHandler.convertEntityToPOJO(customerEntity));

            ApiResponse apiResponse = new ApiResponse(
                    CustomerConstants.SUCCESS,
                    "Customer created successfully",
                    HttpStatus.OK.value(),
                    customerPageResponse
            );

            return Mono.just(ResponseEntity.ok(apiResponse));
        } catch (Exception e) {
            ApiResponse errorResponse = new ApiResponse(
                    CustomerConstants.ERROR,
                    "Error creating customer: " + e.getMessage(),
                    HttpStatus.INTERNAL_SERVER_ERROR.value(),
                    null
            );
            return Mono.just(ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(errorResponse));
        }
    }


}