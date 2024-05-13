package com.wms.dto;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CustomerMasterDto {

	private Long id;
	
	private String customerCode;
	
	private Boolean status;
	
	private String title;
	
	private String firstName;
	
	private String lastName;
	
	private String midddleName;
	
	private String gender;
	
	private String email;
	
	private String mobileNum;
	
	private String phoneNum;
	
	private Date dob;
	
	private String source;
	
	private String defaultPaymentGateway;
	
	private String taxExempt;
	
	private String createdBy;
	
	private Date createdDate;
	
	private String modifiedBy;
	
	private Date lastmodifiedDate;
}
