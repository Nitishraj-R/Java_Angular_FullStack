package com.wms.controller;

import java.util.List;

import org.apache.coyote.BadRequestException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.wms.dto.CustomerMasterDto;
import com.wms.dto.VendorMasterDto;
import com.wms.model.CustomerMaster;
import com.wms.model.VendorMaster;
import com.wms.service.CustomerMasterService;

import jakarta.websocket.server.PathParam;

@RestController
@RequestMapping("/wms/customer/api/")

@CrossOrigin(originPatterns="*",methods = {RequestMethod.POST,RequestMethod.GET,RequestMethod.PUT,RequestMethod.PATCH,RequestMethod.DELETE},allowedHeaders = {"Content-type"})

public class CustomerMasterController {

	Logger log=LoggerFactory.getLogger(CustomerMasterController.class);
	
	@Autowired
	protected CustomerMasterService customerMasterService;

	@PostMapping("/create")
	public CustomerMasterDto create(@RequestBody CustomerMasterDto customerMasterDto) {
		log.info("customerMaster Controller create method");
		log.info("customerMasterDto code is {}",customerMasterDto.getCustomerCode());
		try {
			return customerMasterService.createCustomer(customerMasterDto);
		}catch(Exception e) {
			log.error(e.getMessage());
//			throw new BadRequestException(e.getMessage());
			return null;
		}
		
	}
	@PutMapping("/update")
	public CustomerMasterDto update(@RequestBody CustomerMasterDto customerMasterDto) {
		log.info("Customer Controller update method");
		log.info("customerMasterDto code is {}",customerMasterDto.getCustomerCode());
		try {
			return customerMasterService.updateCustomer(customerMasterDto);
		}catch(Exception e) {
			log.error(e.getMessage());
//			throw new BadRequestException(e.getMessage());
			return null;
		}
		
	}
	
	
	@DeleteMapping("/delete")
	public void delete(@RequestParam String customerCode) {
		log.info("Customer Controller delete method");
		log.info("Customer code is {}",customerCode);
		try {
			String message= customerMasterService.deleteCustomer(customerCode);
			if(!"Successfully deleted".equals(message)) {
				throw new BadRequestException(message);
			}
		}catch(Exception e) {
			log.error(e.getMessage());
//			throw new BadRequestException(e.getMessage());
			
		}
		
	}
	@GetMapping("/fetch/{customerCode}")
	public CustomerMasterDto fetch(@PathVariable("customerCode") String customerCode) {
		log.info("customer Controller fetch method");
		try {
			return customerMasterService.getCustomerByCode(customerCode);
		}catch(Exception e) {
			log.error(e.getMessage());
//			throw new BadRequestException(e.getMessage());
			return null;
		}
		
	}
	@GetMapping("/fetchAll")
	public List<CustomerMasterDto> fetchAll() {
		log.info("Customer Controller fetchAll method");
		try {
			return customerMasterService.getCustomers();
		}catch(Exception e) {
			log.error(e.getMessage());
//			throw new BadRequestException(e.getMessage());
			return null;
		}
		
	}
}
