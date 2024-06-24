
package com.crm.customer.domain.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "CUSTOMER_FILE_CONTENT")
@NamedQuery(name = "CustomerFileContentEntity.findAll", query = "SELECT C FROM CustomerFileContentEntity C where C.fileId=:fileId AND C.cmpId=:cmpId AND C.custId=:custId")
@Entity
public class CustomerFileContentEntity implements Serializable {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "CUST_FILE_ID")
	private Long fileId;

	@Column(name = "CUST_FILE_CONTENT_CMP_ID")
	private Long cmpId;

	@Column(name = "CUST_FILE_CONTENT_CUST_ID")
	private Long custId;

	@Lob
	@Column(name = "CUST_FILE_CONTENT_DATA")
	private byte[] content;
}
