package com.wms.service;

import java.util.List;

import com.wms.model.CustomerMaster;

public interface CustomerMasterService {

	void createCustomer(CustomerMaster customerMaster);

	List<CustomerMaster> getCustomers();

	CustomerMaster getCustomerByCode(String code);

}
