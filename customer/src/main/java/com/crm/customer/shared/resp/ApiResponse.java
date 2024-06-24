package com.crm.customer.shared.resp;

import lombok.Data;

import java.io.Serializable;

@Data
public class ApiResponse implements Serializable {

    private String status;
    private String message;
    private Integer code;
    private CustomerPageResponse customerPageResponse = new CustomerPageResponse();

    public ApiResponse(String status, String message, Integer code, CustomerPageResponse customerPageResponse) {
        this.status = status;
        this.message = message;
        this.code = code;
        this.customerPageResponse = customerPageResponse;
    }

    public ApiResponse() {

    }
}
