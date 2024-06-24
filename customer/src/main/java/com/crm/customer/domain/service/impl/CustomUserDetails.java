package com.crm.customer.domain.service.impl;

import lombok.Data;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.List;

@Data
public class CustomUserDetails implements UserDetails {

    private final String username;
    private final String password;
    private final String cmpCode;
    private final Collection<? extends GrantedAuthority> authorities;


    public CustomUserDetails(String username, String password, String cmpCode, List authorities) {
        this.username = username;
        this.password = password;
        this.cmpCode = cmpCode;
        this.authorities = authorities;
    }



    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return username;
    }

    public String getCmpCode() {
        return cmpCode;
    }
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return authorities;
    }

    // Implement other UserDetails methods as needed
    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
