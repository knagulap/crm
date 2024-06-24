package com.crm.customer.shared.resp;
import com.crm.customer.shared.dto.CustomerTO;
import lombok.Data;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Data
public class CustomerPageResponse implements Serializable {
	private int pageSize;
	private int currentPage;
	private String sortBy;
	private int totalPages;
	private Long totalElements;
	private List<CustomerTO> data = new ArrayList<>();

	public void CustomPageResponse(int currentPage, int totalPages, long totalElements, List<CustomerTO> data) {
		this.currentPage = currentPage;
		this.totalPages = totalPages;
		this.totalElements = totalElements;
		this.data = data;
	}
}
