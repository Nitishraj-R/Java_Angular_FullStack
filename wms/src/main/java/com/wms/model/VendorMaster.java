package com.wms.model;


import java.io.Serializable;
import java.util.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


/**
 * The Class Organization.
 */

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class VendorMaster implements Serializable {

	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	private String vendorName;

	private String registrationNo;

	private Integer status;

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
