package com.wms.vendor.test;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.Rollback;

import com.wms.model.VendorMaster;
import com.wms.repository.VendorMasterRepository;


@DataJpaTest
@AutoConfigureTestDatabase(replace = Replace.NONE)
@TestMethodOrder(OrderAnnotation.class)
class VendorRepositoryTest {

	
		
		@Autowired
		VendorMasterRepository repository;
		

		@Test
		@Order(1)
		@Rollback(value = false)
		void saveVendorTest() {

			VendorMaster vendor = VendorMaster.builder().vendorName("Nitish").vendorCode("5432").address("chennai")
					.emailAddress("nitish@gmail.com").status(true).build();

			repository.save(vendor);

			assertThat(vendor.getId()).isPositive();

		}

		@Test
		@Order(2)
		void getVendorTest() {

			VendorMaster vendor = repository.findById(1).get();

			assertThat(vendor.getId()).isEqualTo(1);
		}

		@Test
		@Order(3)
		void getAllVendorsTest() {

			List<VendorMaster> vendor = repository.findByStatus(true).get();

			assertThat(vendor).isNotEmpty();

		}

		@Test
		@Order(4)
		@Rollback(value = false)
		void updateProductTest() {

			VendorMaster vendor = repository.findById(1).get();

			vendor.setVendorName("Nitish Raj");

			VendorMaster vendorUpdated = repository.save(vendor);

			assertThat(vendorUpdated.getVendorName()).isEqualTo("Nitish Raj");

		}

		@Test
		@Order(5)
		@Rollback(value = false)
		void deleteProductTest() {

			VendorMaster findById = repository.findById(1).get();

			repository.delete(findById);

			VendorMaster vendorMaster = null;

			Optional<VendorMaster> optionalVendorMaster = repository.findById(1);

			if (optionalVendorMaster.isPresent()) {
				vendorMaster = optionalVendorMaster.get();

			}

			assertThat(vendorMaster).isNull();

		}


	


}
