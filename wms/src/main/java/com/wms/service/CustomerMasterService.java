package com.wms.service;

import java.util.List;

import com.wms.dto.CustomerMasterDto;
import com.wms.model.CustomerMaster;

public interface CustomerMasterService {

	CustomerMasterDto createCustomer(CustomerMasterDto customerMasterDto);

	List<CustomerMasterDto> getCustomers();

	CustomerMasterDto getCustomerByCode(String customerCode);

	CustomerMasterDto updateCustomer(CustomerMasterDto customerMasterDto);

	String deleteCustomer(String customerCode);

	List<CustomerMasterDto> searchCustomer(String search);

}
