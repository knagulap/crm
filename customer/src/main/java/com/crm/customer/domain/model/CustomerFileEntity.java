
package com.crm.customer.domain.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "CUSTOMER_FILES")
@NamedQuery(name = "CustomerFileEntity.findAll", query = "SELECT C FROM CustomerFileEntity C where C.custId=:custId AND C.cmpId=:cmpId AND C.status=:status")
@Entity
public class CustomerFileEntity implements Serializable {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "CUST_FILE_CMP_ID")
	private Long cmpId;

	@Column(name = "CUST_FILE_CUST_ID")
	private Long custId;

	@Column(name = "CUST_FILE_NAME")
	private String fileName;

	@Column(name = "CUST_FILE_TYPE")
	private String fileType;

	@Column(name = "CUST_FILE_STATUS")
	private Integer status;

	@Column(name = "CUST_FILE_CREATED_BY")
	private String createdBy;

	@Column(name = "CUST_FILE_CREATED_ON")
	private Date createdOn;

	@Column(name = "CUST_FILE_UPDATED_BY")
	private String udpatedBy;

	@Column(name = "CUST_FILE_UPDATED_ON")
	private Date updatedOn;

}

