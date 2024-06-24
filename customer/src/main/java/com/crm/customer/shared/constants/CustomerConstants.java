package com.crm.customer.shared.constants;

import java.io.Serializable;

public class CustomerConstants implements Serializable {
    private static final long serialVersionUID = -923474679747855169L;

    public static final String CUSTOMER_PATH_URL ="/api/customer/" ;
    public static final String GET_CUSTOMERS ="getCustomers"; ;
    public static final String SAVE_CUSTOMER ="saveCustomer"; ;


    public final static String BILLING_ADDRESS = "BILLING_ADDRESS";
    public final static String SHIPPING_ADDRESS = "SHIPPING_ADDRESS";


    public final static String SUCCESS = "Success";
    public final static String ERROR = "Error";

    public final static String FAILURE = "Failure";
}
