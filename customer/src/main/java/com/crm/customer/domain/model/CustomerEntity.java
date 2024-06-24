
package com.crm.customer.domain.model;

import com.crm.customer.shared.utils.AppUserUtils;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "CUSTOMERS")
@NamedQuery(name = "CustomerEntity.findAll", query = "SELECT C FROM CustomerEntity C where C.cmpId=:cmpId AND C.status=:status")
@Entity
public class CustomerEntity implements Serializable {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "CUST_CMP_ID")
	private Long cmpId;

	@Column(name = "CUST_CMP_NAME")
	private String name;

	@Column(name = "CUST_CMP_CODE")
	private String code;

	@Column(name = "CUST_CMP_BUSINESS_TYPE")
	private String businessType;

	@Column(name = "CUST_CMP_GST")
	private String gst;

	@Column(name = "CUST_CMP_VAT")
	private String vat;

	@Column(name = "CUST_CMP_TAN")
	private String tan;

	@Column(name = "CUST_CMP_PAN")
	private String pan;

	@Column(name = "CUST_CMP_BILLING_CURRENCY")
	private String billingCurrency;

	@Column(name = "CUST_CMP_COUNTRY")
	private String country;

	@Column(name = "CUST_CMP_CURRENCY")
	private String currency;

	@Column(name = "CUST_CMP_EMAIL")
	private String email;

	@Column(name = "CUST_CMP_PHONE")
	private String phone;

	@Column(name = "CUST_CMP_WEBSITE")
	private String website;

	@Column(name = "CUST_CMP_STATUS")
	private Integer status;

	@Column(name = "CUST_CMP_CREATED_BY")
	private String createdBy;

	@Column(name = "CUST_CMP_CREATED_ON")
	private Date createdOn;

	@Column(name = "CUST_CMP_UPDATED_BY")
	private String updatedBy;

	@Column(name = "CUST_CMP_UPDATED_ON")
	private Date updatedOn;

	@OneToMany(mappedBy = "customerEntity", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	private List<CustomerAddressEntity> customerAddressEntities = new ArrayList();

	@OneToMany(mappedBy = "customerEntity", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	private List<CustomerContactsEntity> customerContacts = new ArrayList();


	@PrePersist
	public void onPrePersist() {
		this.setCreatedOn(AppUserUtils.getSysdate());
		this.setCreatedBy(AppUserUtils.getUserName());
		this.setUpdatedOn(AppUserUtils.getSysdate());
		this.setUpdatedBy(AppUserUtils.getUserName());
	}

	@PreUpdate
	public void onPreUpdate() {
		this.setUpdatedOn(AppUserUtils.getSysdate());
		this.setUpdatedBy(AppUserUtils.getUserName());
	}
}
