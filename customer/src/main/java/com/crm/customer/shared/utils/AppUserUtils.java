package com.crm.customer.shared.utils;
import com.crm.customer.shared.dto.AppUserDetailTO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.context.SecurityContextHolder;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;


public class AppUserUtils {

	private static Logger log = LoggerFactory.getLogger(AppUserUtils.class);

	public static Long getUserId() {
		if (SecurityContextHolder.getContext().getAuthentication() == null) {
			log.error("  Authentication details are empty so returning   ");
			Integer defaultValue = 0;
			return Long.valueOf(defaultValue.intValue());
		}
		AppUserDetailTO appUserDetailTO = (AppUserDetailTO) SecurityContextHolder
				.getContext().getAuthentication().getPrincipal();

		return appUserDetailTO.getUserId();
	}

	

	public static String getToken() {
		if (SecurityContextHolder.getContext().getAuthentication() == null) {
			log.error("  Authentication details are empty so returning   ");
		
			return new String("000000");
		}
		AppUserDetailTO appUserDetails = (AppUserDetailTO) SecurityContextHolder
				.getContext().getAuthentication().getPrincipal();

		return appUserDetails.getToken();
	}
	
	public static Long getClientId() {
		if (SecurityContextHolder.getContext().getAuthentication() == null) {
			log.error("  Authentication details are empty so returning   ");		
			Integer defaultValue = 0;
			return Long.valueOf(defaultValue.longValue());
		}
		AppUserDetailTO appUserDetails = (AppUserDetailTO) SecurityContextHolder
				.getContext().getAuthentication().getPrincipal();

		return appUserDetails.getClientId();
	}
	
	public static String getClientCode() {
		if (SecurityContextHolder.getContext().getAuthentication() == null) {
			log.error("  Authentication details are empty so returning   ");
		
			return new String("C000000");
		}
		AppUserDetailTO appUserDetails = (AppUserDetailTO) SecurityContextHolder
				.getContext().getAuthentication().getPrincipal();

		return appUserDetails.getClientCode();
	}

	public static String getUserName() {
		if (SecurityContextHolder.getContext().getAuthentication() == null) {
			log.error("  Authentication details are empty so returning   ");
			return new String("C000000");
		}
		AppUserDetailTO appUserDetails = (AppUserDetailTO) SecurityContextHolder
				.getContext().getAuthentication().getPrincipal();

		return appUserDetails.getUsername();
	}
	
	public static List<Long> getRoleIds() {
		if (SecurityContextHolder.getContext().getAuthentication() == null) {
			log.error("  Authentication details are empty so returning   ");
			return new ArrayList<Long>();
		}
		AppUserDetailTO appUserDetails = (AppUserDetailTO) SecurityContextHolder
				.getContext().getAuthentication().getPrincipal();
		return appUserDetails.getRoleIds();
	}
	
	public static Timestamp getSysdate(){
		return 	 new Timestamp(new Date().getTime()); 
	}
	
}
