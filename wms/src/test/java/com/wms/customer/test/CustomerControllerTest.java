package com.wms.customer.test;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.wms.controller.CustomerMasterController;
import com.wms.dto.CustomerMasterDto;
import com.wms.service.impl.CustomerMasterServiceImpl;

@WebMvcTest(CustomerMasterController.class)
public class CustomerControllerTest {

	@MockBean
	CustomerMasterServiceImpl service;

	@Autowired
	MockMvc mockMvc;

	@Test
	void saveCustomerTest() throws JsonProcessingException, Exception {

		CustomerMasterDto customerDto = CustomerMasterDto.builder().firstName("Nitish").lastName("R")
				.primaryEmailId("nit@gmail.com").secondaryEmailId("raj@gmail.com").customerCode("1234")
				.primaryContactNumber("9876543467").build();
		when(service.createCustomer(customerDto)).thenReturn(customerDto);

		mockMvc.perform(post("/wms/customer/api/create").contentType(MediaType.APPLICATION_JSON)
				.content(new ObjectMapper().writeValueAsString(customerDto))).andExpect(status().isOk());

	}

	@Test
	void getCustomer() throws Exception {

		CustomerMasterDto customerDto = CustomerMasterDto.builder().firstName("Nitish").lastName("R")
				.primaryEmailId("nit@gmail.com").secondaryEmailId("raj@gmail.com").customerCode("1234")
				.primaryContactNumber("9876543467").build();
	
		when(service.getCustomerByCode("1234")).thenReturn(customerDto);

		mockMvc.perform(get("/wms/customer/api/fetch/{customerCode}",1234).contentType(MediaType.APPLICATION_JSON))
				.andExpect(status().isOk()).andExpect(jsonPath("$.firstName").value("Nitish"));

	}

	@Test
	void getAllCustomers() throws Exception {

		CustomerMasterDto customerDto1 = CustomerMasterDto.builder().firstName("Nitish").lastName("R")
				.primaryEmailId("nit@gmail.com").secondaryEmailId("raj@gmail.com").customerCode("1234")
				.primaryContactNumber("9876543467").build();
		
		CustomerMasterDto customerDto2 = CustomerMasterDto.builder().firstName("Dev").lastName("C")
				.primaryEmailId("dev@gmail.com").secondaryEmailId("shri@gmail.com").customerCode("4321")
				.primaryContactNumber("8765445672").build();
	
		List<CustomerMasterDto> customerList = Arrays.asList(customerDto1, customerDto2);

		when(service.getCustomers()).thenReturn(customerList);

		mockMvc.perform(get("/wms/customer/api/fetchAll").contentType(MediaType.APPLICATION_JSON))
				.andExpect(status().isOk()).andExpect(jsonPath("$[1].firstName").value("Dev"));

	}

	@Test
	void deleteCustomer() throws Exception {
		String vendor = "Successfully deleted";
		
		when(service.deleteCustomer("1234")).thenReturn(vendor);
		
		mockMvc.perform(delete("/wms/customer/api/delete?customerCode=1234")).andExpect(status().isOk());
	
	}

}
