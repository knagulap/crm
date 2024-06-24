
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
@Table(name = "CUSTOMER_CONTACTS")
@NamedQuery(name = "CustomerContactsEntity.findAll", query = "SELECT C FROM CustomerContactsEntity C where C.custId=:custId AND C.cmpId=:cmpId AND C.status=:status")
@Entity
public class CustomerContactsEntity implements Serializable {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "CUST_CONT_CMP_ID")
	private Long cmpId;

	@Column(name = "CUST_CONT_CUST_ID")
	private Long custId;

	@ManyToOne
	@JoinColumn(name = "custId")
	private CustomerEntity customerEntity;

	@Column(name = "CUST_CONT_FIRST_NAME")
	private String firstName;

	@Column(name = "CUST_CONT_MIDDLE_NAME")
	private String middleName;

	@Column(name = "CUST_CONT_LAST_NAME")
	private String lastName;

	@Lob
	@Column(name = "CUST_CONT_PICTURE")
	private byte[] picture;

	@Column(name = "CUST_CONT_EMAIL")
	private String email;

	@Column(name = "CUST_CONT_PHONE")
	private String phone;

	@Column(name = "CUST_CONT_STATUS")
	private Integer status;

	@Column(name = "CUST_CONT_CREATED_BY")
	private String createdBy;

	@Column(name = "CUST_CONT_CREATED_ON")
	private Date createdOn;

	@Column(name = "CUST_CONT_UPDATED_BY")
	private String udpatedBy;

	@Column(name = "CUST_CONT_UPDATED_ON")
	private Date updatedOn;
}
