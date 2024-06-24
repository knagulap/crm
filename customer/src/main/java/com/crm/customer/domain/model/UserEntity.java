package com.crm.customer.domain.model;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Data
@Entity
@Table(name = "users") // Customize table name if needed
public class UserEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true, nullable = false)
    private String username;

    private String password;

    private String cmpCode;

    private List<String> roles; // Assuming roles are stored as strings

    // Constructors, getters, setters, etc.
    public UserEntity() {
    }

    public UserEntity(String username, String password, String cmpCode , List roles) {
        this.username = username;
        this.password = password;
        this.cmpCode = cmpCode;
        this.roles = roles;

    }
}
