
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
@Table(name = "CUSTOMER_ADDRESS")
@NamedQuery(name = "CustomerAddressEntity.findAll", query = "SELECT C FROM CustomerAddressEntity C where C.custId=:custId AND C.cmpId=:cmpId")
@Entity
public class CustomerAddressEntity implements Serializable {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "CUST_ADDRS_CUST_ID")
	private Long custId; // Customer Id

	@ManyToOne
	@JoinColumn(name = "custId")
	private CustomerEntity customerEntity;

	@Column(name = "CUST_ADDRS_CMP_ID")
	private Long cmpId;

	@Column(name = "CUST_ADDRS_ADDRESS_TYPE")
	private String addressType; //  CustomerConstants.BILLING_ADDRESS / CustomerConstants.SHIPPING_ADDRESS

	@Column(name = "CUST_ADDRS_COUNTRY")
	private String country;

	@Column(name = "CUST_ADDRS_ZIP")
	private String zip;

	@Column(name = "CUST_ADDRS_PROVINCE")
	private String province;

	@Column(name = "CUST_ADDRS_STATE")
	private String state;

	@Column(name = "CUST_ADDRS_CITY")
	private String city;

	@Column(name = "CUST_ADDRS_STREET")
	private String street;

	@Column(name = "CUST_ADDRS_address")
	private String address;

	@Column(name = "CUST_ADDRS_CREATED_BY")
	private String createdBy;

	@Column(name = "CUST_ADDRS_CREATED_ON")
	private Date createdOn;

	@Column(name = "CUST_ADDRS_UPDATED_BY")
	private String udpatedBy;

	@Column(name = "CUST_ADDRS_UPDATED_ON")
	private Date updatedOn;
}
