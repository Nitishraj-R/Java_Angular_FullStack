package com.wms.dto;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class VendorMasterDto {

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
