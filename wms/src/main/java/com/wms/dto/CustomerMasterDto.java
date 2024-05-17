package com.wms.dto;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CustomerMasterDto {

	private Long id;
	
	private String customerCode;
	
	private Boolean status;
	
	private String title;
	
	private String firstName;
	
	private String lastName;
	
	private String midddleName;
	
	private String gender;
	
	private String primaryEmailId;
	
	private String secondaryEmailId;
	
	private String primaryContactNumber;
	
	private String secondaryContactNumber;
	
	private Date dob;
	
	private String source;
	
	private String defaultPaymentGateway;
	
	private String taxExempt;
	
	private String createdBy;
	
	private Date createdDate;
	
	private String modifiedBy;
	
	private Date lastmodifiedDate;
}
