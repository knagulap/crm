package com.crm.customer.shared.req;

import lombok.Data;

@Data
public class JwtRequest  {
    private String username;
    private String password;

    // getters and setters
}

