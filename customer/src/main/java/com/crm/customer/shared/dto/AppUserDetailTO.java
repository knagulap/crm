package com.crm.customer.shared.dto;

import lombok.Data;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.User;

import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.Set;


@Data
public class AppUserDetailTO extends User {
		
	private Map<String, Boolean> appCodeTemplate;
	
	private String username;	
	private String password;	
	private Long userId;	
	
	private String name;	
	private String displayName;		
	private String token;
	
	private Long clientId;
	private String clientCode;
	
	private Set<GrantedAuthority> authorities;
	private List<Long> roleIds;
	
	
	public AppUserDetailTO(){
		super("Anonmous","NA",AuthorityUtils.NO_AUTHORITIES);
	}
	
	
	 
	public AppUserDetailTO(String username, String password,
                           Collection<? extends GrantedAuthority> authorities) {
		super(username, password,authorities);
		
		this.username = username;
		this.password = password;
	}

}
