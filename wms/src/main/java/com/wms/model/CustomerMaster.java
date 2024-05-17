package com.wms.model;

import java.util.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
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

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
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
