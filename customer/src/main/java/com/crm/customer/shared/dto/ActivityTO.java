package com.crm.customer.shared.dto;

import java.io.Serializable;
import java.util.Date;

@lombok.Data
public class ActivityTO implements Serializable {
	private Date createdOn;
	private String createdBy;
	private Date updatedOn;
	private String updatedBy;
}
