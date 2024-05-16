package com.wms.customer.test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.wms.dto.CustomerMasterDto;
import com.wms.model.CustomerMaster;
import com.wms.repository.CustomerMasterRepository;
import com.wms.service.impl.CustomerMasterServiceImpl;

@SpringBootTest
class CustomerServiceTest {
	
	@MockBean
	CustomerMasterRepository repository;

	@Autowired
	CustomerMasterServiceImpl service;

	@Test
	void saveCustomerTest() {
		CustomerMaster customer = CustomerMaster.builder().firstName("Nitish").lastName("R")
				.primaryEmailId("nit@gmail.com").secondaryEmailId("raj@gmail.com").customerCode("1234")
				.primaryContactNumber("9876543467").build();

		
		CustomerMasterDto customerDto = CustomerMasterDto.builder().firstName("Nitish").lastName("R")
				.primaryEmailId("nit@gmail.com").secondaryEmailId("raj@gmail.com").customerCode("1234")
				.primaryContactNumber("9876543467").build();


		when(repository.save(customer)).thenReturn(customer);
		
		assertEquals(customerDto, service.createCustomer(customerDto));
		

	}
	
	@Test
	void getCustomerMaster() {
		CustomerMaster customer = CustomerMaster.builder().firstName("Nitish").lastName("R")
				.primaryEmailId("nit@gmail.com").secondaryEmailId("raj@gmail.com").customerCode("1234")
				.primaryContactNumber("9876543467").build();
	
		when(repository.findByCustomerCode("1234")).thenReturn(Optional.of(customer));
		
		assertEquals("Nitish",service.getCustomerByCode("1234").getFirstName());
		
		
	}

	@Test
	void getCustomerMasterList() {
		
		CustomerMaster customer1 = CustomerMaster.builder().firstName("Nitish").lastName("R")
				.primaryEmailId("nit@gmail.com").secondaryEmailId("raj@gmail.com").customerCode("1234")
				.primaryContactNumber("9876543467").build();
		
		CustomerMaster customer2 = CustomerMaster.builder().firstName("Dev").lastName("C")
				.primaryEmailId("dev@gmail.com").secondaryEmailId("shri@gmail.com").customerCode("4321")
				.primaryContactNumber("8765456784").build();
	
		
		List<CustomerMaster> customerList=Arrays.asList(customer1,customer2);
		
		when(repository.findByStatus(true)).thenReturn(Optional.of(customerList) );
		
		assertEquals(2, service.getCustomers().size());
		
	}

	@Test
	void deleteCustomerMaster() {
		
		CustomerMaster customer = CustomerMaster.builder().firstName("Nitish").lastName("R")
				.primaryEmailId("nit@gmail.com").secondaryEmailId("raj@gmail.com").customerCode("1234")
				.primaryContactNumber("9876543467").build();
		
		when(repository.findByCustomerCode("1234")).thenReturn(Optional.of(customer));
		when(repository.save(customer)).thenReturn(customer);
		 
		String result="Successfully deleted";
		
		assertEquals(result, service.deleteCustomer("1234"));
		
	}


}
