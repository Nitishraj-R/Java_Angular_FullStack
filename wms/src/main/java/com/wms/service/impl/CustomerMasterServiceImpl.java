package com.wms.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wms.dto.CustomerMasterDto;
import com.wms.model.CustomerMaster;
import com.wms.repository.CustomerMasterRepository;
import com.wms.service.CustomerMasterService;

@Service
public class CustomerMasterServiceImpl implements CustomerMasterService{
	
	Logger log=LoggerFactory.getLogger(CustomerMasterServiceImpl.class);
	
	private final static Boolean STATUS=true;
	@Autowired 
	CustomerMasterRepository customerMasterRepository;

	@Override
	public CustomerMasterDto createCustomer(CustomerMasterDto customerMasterDto) {
		log.info("Customer service Implementation class createCustomer method");
		CustomerMaster customerMaster=new CustomerMaster();
		customerMasterDto.setStatus(STATUS);
		BeanUtils.copyProperties(customerMasterDto, customerMaster);
		customerMaster=customerMasterRepository.save(customerMaster);
		customerMasterDto.setId(customerMaster.getId());
		return customerMasterDto;
		
		
	}

	@Override
	public List<CustomerMasterDto> getCustomers() {
		log.info("Customer service Implementation class getAllCustomer method");
		Optional<List<CustomerMaster>> customerMasters=customerMasterRepository.findByStatus(STATUS);
		List<CustomerMasterDto> customerMasterDtos=new ArrayList<>();
		if(customerMasters.isPresent()) {
			for(CustomerMaster customerMaster: customerMasters.get()) {
				CustomerMasterDto customerMasterDto=new CustomerMasterDto();
				BeanUtils.copyProperties(customerMaster, customerMasterDto);
				customerMasterDtos.add(customerMasterDto);
			}
		}
			return customerMasterDtos;
		
//		return (List<CustomerMaster>)customerMasterRepository.findAll();
	}

	@Override
	public CustomerMasterDto getCustomerByCode(String customerCode) {
		log.info("Customer service Implementation class getAllCustomerByCode method");
		Optional<CustomerMaster> findByCustomerCode = customerMasterRepository.findByCustomerCode(customerCode);
		if(findByCustomerCode.isPresent()) {
			CustomerMasterDto customerMasterDto=new CustomerMasterDto();
			BeanUtils.copyProperties(findByCustomerCode.get(), customerMasterDto);
			return customerMasterDto;
		}
		return null;
	}

	@Override
	public CustomerMasterDto updateCustomer(CustomerMasterDto customerMasterDto) {
		log.info("Customer service Implementation class updateCustomer method");
		CustomerMaster customerMaster =new CustomerMaster();
		BeanUtils.copyProperties(customerMasterDto, customerMaster);
		customerMaster=customerMasterRepository.save(customerMaster);
//		customerMaster.setId(customerMaster.getId());
		return customerMasterDto;
	}

	@Override
	public String deleteCustomer(String customerCode) {
		log.info("Customer service Implementation class deleteCustomer method");
		log.info("Customer Code is {}",customerCode);
		Optional<CustomerMaster> findByCustomerCode = customerMasterRepository.findByCustomerCode(customerCode);
		if(findByCustomerCode.isPresent()) {
			findByCustomerCode.get().setStatus(!STATUS);
			customerMasterRepository.save(findByCustomerCode.get());
			return "Successfully deleted";
		}
		return "Not able to delete because invalid id";
	}

	@Override
	public List<CustomerMasterDto> searchCustomer(String search) {
		log.info("CustomerMaster service Implementation class searchCustomer method");

	 List<CustomerMaster> customerMaster = customerMasterRepository.findByCustomerCodeOrFirstNameOrLastNameOrPrimaryEmailIdOrPrimaryContactNumber(search, search, search,search,search);
	 
	 List<CustomerMasterDto> customerMasterDto=new ArrayList<>();
	 for (CustomerMaster customerMaster1 : customerMaster) {
		 
		 CustomerMasterDto customerDto=new CustomerMasterDto();
		 BeanUtils.copyProperties(customerMaster1, customerDto);
		 
		 customerMasterDto.add(customerDto);
		
	}
	
	 return customerMasterDto;
	}
	
	
	
	
}
