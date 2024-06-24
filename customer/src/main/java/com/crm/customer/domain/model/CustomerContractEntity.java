
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
@Table(name = "CUSTOMERS_CONTRACT")
@NamedQuery(name = "CustomerContractEntity.findAll", query = "SELECT C FROM CustomerContractEntity C where C.custId=:custId AND C.cmpId=:cmpId AND C.status=:status")
@Entity
public class CustomerContractEntity implements Serializable {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "CUST_CONTR_CMP_ID")
	private Long cmpId;

	@Column(name = "CUST_CONTR_CUST_ID")
	private Long custId;

	@Column(name = "CUST_CONTR_STATUS")
	private Integer status;

	@Column(name = "CUST_CONTR_CREATED_BY")
	private String createdBy;

	@Column(name = "CUST_CONTR_CREATED_ON")
	private Date createdOn;

	@Column(name = "CUST_CONTR_UPDATED_BY")
	private String udpatedBy;

	@Column(name = "CUST_CONTR_UPDATED_ON")
	private Date updatedOn;}
