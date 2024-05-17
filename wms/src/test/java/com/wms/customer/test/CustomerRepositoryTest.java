package com.wms.customer.test;

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

import com.wms.model.CustomerMaster;
import com.wms.repository.CustomerMasterRepository;

@DataJpaTest
@AutoConfigureTestDatabase(replace = Replace.NONE)
@TestMethodOrder(OrderAnnotation.class)
class CustomerRepositoryTest {

	@Autowired
	CustomerMasterRepository repository;

	@Test
	@Order(1)
	@Rollback(value = false)
	void saveCustomerTest() {

		CustomerMaster customer = CustomerMaster.builder().firstName("Nitish").lastName("R")
				.primaryEmailId("nit@gmail.com").secondaryEmailId("raj@gmail.com").customerCode("1234")
				.primaryContactNumber("9876543467").build();

		repository.save(customer);

		assertThat(customer.getId()).isPositive();

	}

	@Test
	@Order(2)
	void getCustomerTest() {

		CustomerMaster cutomer = repository.findById(1L).get();

		assertThat(cutomer.getId()).isEqualTo(1L);
	}

	@Test
	@Order(3)
	void getAllCustomersTest() {

		List<CustomerMaster> customerList = repository.findAll();

		assertThat(customerList).isNotEmpty();

	}

	@Test
	@Order(4)
	@Rollback(value = false)
	void updateCustomerTest() {

		CustomerMaster customer = repository.findById(1L).get();

		customer.setLastName("Raj");
		;

		CustomerMaster updatedCustomer = repository.save(customer);

		assertThat(updatedCustomer.getLastName()).isEqualTo("Raj");

	}

	@Test
	@Order(5)
	@Rollback(value = false)
	void deleteCustomerTest() {

		CustomerMaster findById = repository.findById(1L).get();

		repository.delete(findById);

		CustomerMaster customer = null;

		Optional<CustomerMaster> optionalCustomerMaster = repository.findById(1L);

		if (optionalCustomerMaster.isPresent()) {
			customer = optionalCustomerMaster.get();

		}

		assertThat(customer).isNull();

	}

}
