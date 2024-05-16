package com.wms.vendor.test;

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
import com.wms.controller.VendorMasterController;
import com.wms.dto.VendorMasterDto;
import com.wms.service.impl.VendorMasterServiceImpl;

@WebMvcTest(VendorMasterController.class)
class VendorControllerTest {

	@MockBean
	VendorMasterServiceImpl service;

	@Autowired
	MockMvc mockMvc;

	@Test
	void saveVendorTest() throws JsonProcessingException, Exception {

		VendorMasterDto vendor = VendorMasterDto.builder().vendorName("Nitish").vendorCode("5432").address("chennai")
				.emailAddress("nitish@gmail.com").status(true).build();

		when(service.createVendor(vendor)).thenReturn(vendor);

		mockMvc.perform(post("/wms/vendor/api/create").contentType(MediaType.APPLICATION_JSON)
				.content(new ObjectMapper().writeValueAsString(vendor))).andExpect(status().isOk());

	}

	@Test
	void getVendorByCode() throws Exception {

		VendorMasterDto vendor = VendorMasterDto.builder().vendorName("Nitish").vendorCode("5432").address("chennai")
				.emailAddress("nitish@gmail.com").status(true).build();

		when(service.getVendorbyCode("5432")).thenReturn(vendor);

		mockMvc.perform(get("/wms/vendor/api/fetch/{vendorCode}", "5432").contentType(MediaType.APPLICATION_JSON))
				.andExpect(status().isOk()).andExpect(jsonPath("$.vendorName").value("Nitish"));

	}

	@Test
	void getAllProducts() throws Exception {

		VendorMasterDto vendor1 = VendorMasterDto.builder().vendorName("Dev").vendorCode("1234").address("chennai")
				.emailAddress("dev@gmail.com").status(true).build();

		VendorMasterDto vendor2 = VendorMasterDto.builder().vendorName("Nitish").vendorCode("5432").address("chennai")
				.emailAddress("nitish@gmail.com").status(true).build();
		List<VendorMasterDto> vendorList = Arrays.asList(vendor1, vendor2);

		when(service.getVendors()).thenReturn(vendorList);

		mockMvc.perform(get("/wms/vendor/api/fetchAll").contentType(MediaType.APPLICATION_JSON))
				.andExpect(status().isOk()).andExpect(jsonPath("$[1].vendorName").value("Nitish"));

	}

		@Test
		void deleteProduct() throws Exception {
			String vendor = "Successfully deleted";
		
			when(service.deleteVendor("5432")).thenReturn(vendor);
			
			mockMvc.perform(delete("/wms/vendor/api/delete?vendorCode=5432")).andExpect(status().isOk());
				
		}

	

}
