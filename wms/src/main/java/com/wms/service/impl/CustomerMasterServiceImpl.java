package com.wms.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wms.model.CustomerMaster;
import com.wms.repository.CustomerMasterRepository;
import com.wms.service.CustomerMasterService;

@Service
public class CustomerMasterServiceImpl implements CustomerMasterService{
	
	@Autowired
	CustomerMasterRepository customerMasterRepository;

	@Override
	public void createCustomer(CustomerMaster customerMaster) {
		customerMasterRepository.save(customerMaster);
		
	}

	@Override
	public List<CustomerMaster> getCustomers() {
		return (List<CustomerMaster>)customerMasterRepository.findAll();
	}

	@Override
	public CustomerMaster getCustomerByCode(String code) {
		return null;
//		return customerMasterRepository.getCode(code);
	}
	
	
}
