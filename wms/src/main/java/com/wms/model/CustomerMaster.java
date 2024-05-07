package com.wms.model;

import java.util.Date;

import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CustomerMaster {

	private Long id;
	
	private String title;
	
	private String firstName;
	
	private String lastName;
	
	private String midddleName;
	
	private String gender;
	
	private String email;
	
	private String mobileNum;
	
	private String phoneNum;
	
	private Date dob;
	
	private String status;
	
	private String source;
	
	private String defaultPaymemetGateway;
	
	private String taxExempt;
	
	private String createdBy;
	
	private Date createdDate;
	
	private String modifiedBy;
	
	private Date lastmodifiedDate;

}
