package com.crm.customer.shared.utils;

import com.crm.customer.shared.constants.CustomerConstants;
import com.crm.customer.shared.resp.ApiResponse;
import com.crm.customer.shared.resp.CustomerPageResponse;
import org.springframework.http.HttpStatus;

public class AppUtil {
    public static ApiResponse getApiSuccessResponse(String message, int status) {
       ApiResponse apiResponse = new ApiResponse(
                CustomerConstants.SUCCESS,
                "Customers retrieved successfully",
                HttpStatus.OK.value(),
                new CustomerPageResponse()
        );
        return apiResponse;
    }

    public static ApiResponse getApiFailureResponse(String message, int status) {
        ApiResponse apiResponse = new ApiResponse(
                CustomerConstants.FAILURE,
                "Customers retrieved successfully",
                status,
                new CustomerPageResponse()
        );
        return apiResponse;
    }

}
