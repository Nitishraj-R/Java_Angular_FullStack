package com.wms.vendor.test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.wms.dto.VendorMasterDto;
import com.wms.model.VendorMaster;
import com.wms.repository.VendorMasterRepository;
import com.wms.service.impl.VendorMasterServiceImpl;

@SpringBootTest
class VendorServiceTest {

	@MockBean
	VendorMasterRepository repository;

	@Autowired
	VendorMasterServiceImpl service;

	@Test
	void saveVendorTest() {

		VendorMaster vendor = VendorMaster.builder().vendorName("Nitish").vendorCode("5432").address("chennai")
				.emailAddress("nitish@gmail.com").status(true).build();
		
		
		VendorMasterDto vendorDto = VendorMasterDto.builder().vendorName("Nitish").vendorCode("5432").address("chennai")
				.emailAddress("nitish@gmail.com").status(true).build();
		
		when(repository.save(vendor)).thenReturn(vendor);
		
		assertEquals(vendorDto, service.createVendor(vendorDto));
		

	}
	
	@Test
	void getVendorMaster() {
		VendorMaster vendor = VendorMaster.builder().vendorName("Nitish").vendorCode("5432").address("chennai")
				.emailAddress("nitish@gmail.com").status(true).build();
		
		when(repository.findByVendorCode("5432")).thenReturn(Optional.of(vendor));
		
		assertEquals("Nitish",service.getVendorbyCode("5432").getVendorName());
		
		
	}

	@Test
	void getVendorMasterList() {
		
		
		VendorMaster vendor1 = VendorMaster.builder().vendorName("Nitish").vendorCode("5432").address("chennai")
				.emailAddress("nitish@gmail.com").status(true).build();
		
		VendorMaster vendor2 = VendorMaster.builder().vendorName("Dev").vendorCode("1234").address("chennai")
				.emailAddress("dev@gmail.com").status(true).build();
		
		
		List<VendorMaster> vendorList=Arrays.asList(vendor1,vendor2);
		
		when(repository.findByStatus(true)).thenReturn(Optional.of(vendorList) );
		
		assertEquals(2, service.getVendors().size());
		
	}

	@Test
	void deleteVendorMaster() {
		
		VendorMaster vendor = VendorMaster.builder().vendorName("Nitish").vendorCode("5432").address("chennai")
				.emailAddress("nitish@gmail.com").status(true).build();
		
		when(repository.findByVendorCode("5432")).thenReturn(Optional.of(vendor));
		when(repository.save(vendor)).thenReturn(vendor);
		 
		String result="Successfully deleted";
		
		assertEquals(result, service.deleteVendor("5432"));
		
	}



}
