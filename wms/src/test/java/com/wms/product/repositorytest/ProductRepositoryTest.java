package com.wms.product.repositorytest;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import java.util.Optional;

//import java.util.List;
//import java.util.Optional;
//
//import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
//import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
//import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.Rollback;
import com.wms.model.ProductMaster;
import com.wms.repository.ProductMasterRepository;



@DataJpaTest
@AutoConfigureTestDatabase(replace = Replace.NONE)
@TestMethodOrder(OrderAnnotation.class)
class ProductRepositoryTest {
	
	@Autowired
	ProductMasterRepository repository;
	

	@Test
	@Order(1)
	@Rollback(value = false)
	void saveProductTest() {

		ProductMaster product = ProductMaster.builder().skuNumber("8765").productId("12356").productName("Tire")
				.productShortDesc("Wired").color("Black").dimensions("14 inch").build();

		repository.save(product);

		assertThat(product.getId()).isPositive();

	}

	@Test
	@Order(2)
	void getProductTest() {

		ProductMaster productMaster = repository.findById(1L).get();

		assertThat(productMaster.getId()).isEqualTo(1L);
	}

	@Test
	@Order(3)
	void getAllProductsTest() {

		List<ProductMaster> productList = repository.findAll();

		assertThat(productList).isNotEmpty();

	}

	@Test
	@Order(4)
	@Rollback(value = false)
	void updateProductTest() {

		ProductMaster productMaster = repository.findById(1L).get();

		productMaster.setColor("Pink");

		ProductMaster updatedProduct = repository.save(productMaster);

		assertThat(updatedProduct.getColor()).isEqualTo("Pink");

	}

	@Test
	@Order(5)
	@Rollback(value = false)
	void deleteProductTest() {

		ProductMaster findById = repository.findById(1L).get();

		repository.delete(findById);

		ProductMaster productMaster = null;

		Optional<ProductMaster> optionalProductMaster = repository.findBySkuNumber("8765");

		if (optionalProductMaster.isPresent()) {
			productMaster = optionalProductMaster.get();

		}

		assertThat(productMaster).isNull();

	}


}
