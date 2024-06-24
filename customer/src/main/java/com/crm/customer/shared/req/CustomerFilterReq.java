package com.crm.customer.shared.req;

import lombok.Data;
import org.springframework.data.domain.Sort;

import java.io.Serializable;

@Data
public class CustomerFilterReq implements Serializable {

	private static final long serialVersionUID = 6526217036270683215L;
	private String id;
	private String code;
	private Integer pageSize;
	private Integer page;
	private Integer totalCount;
	private String sortBy;
	private Sort.Direction direction;
	private boolean loginUser;
}
