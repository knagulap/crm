package com.crm.customer.domain.service.impl;

import com.crm.customer.application.service.CustomUserDetailsService;
import com.crm.customer.domain.model.UserEntity;
import com.crm.customer.domain.repository.UserRepository;
import com.crm.customer.shared.utils.CustomAuthority;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CustomUserDetailsServiceImpl implements CustomUserDetailsService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UserEntity userEntity = userRepository.findByUsername(username);
        if(userEntity==null) {
            new UsernameNotFoundException("User not found with username: " + username);
        }

        List<GrantedAuthority> authorities = userEntity.getRoles().stream()
                .map(role -> new CustomAuthority(role)) // Assuming CustomAuthority is your custom implementation
                .collect(Collectors.toList());

        return new CustomUserDetails(
                userEntity.getUsername(),
                userEntity.getPassword(),   // Ensure this is hashed if necessary
                userEntity.getCmpCode(),    // Add any additional user details as needed
                authorities           // Assign roles/authorities to the UserDetails
        );


    }
}
