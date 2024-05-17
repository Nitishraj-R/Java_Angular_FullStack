package com.wms.model;


import java.util.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


/**
 * The Class Organization.
 */

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class VendorMaster {

	

	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
	private int id;

	private String vendorName;

	private String registrationNo;

	private Boolean status;

	private String address;

	private String phoneNumber;

	private String emailAddress;

	private Float shippingCost;

	private String tax;
	
	private String vendorCode;

	private String paymentTerm;

	private String createdBy;

	private Date createdDate;

	private String modifiedBy;

	private Date lastmodifiedDate;

	private Integer rmaPolicy;
	
	private String adminEmailId;
	
	private String primaryContactNumber;
	
	private String secondaryContactNumber;
	

}