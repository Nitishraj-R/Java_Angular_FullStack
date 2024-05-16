package com.wms.product.servicetest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import com.wms.model.ProductMaster;
import com.wms.repository.ProductMasterRepository;
import com.wms.service.ProductMasterService;

@SpringBootTest
class ProductServiceTest {
	
	
	@MockBean
	ProductMasterRepository repository;
	
	@Autowired
	ProductMasterService service;
	
	@Test
	void saveProductMaster() {
		
		ProductMaster product=ProductMaster.builder()
				.productId("999")
				.productName("Engine")
				.productShortDesc("4 Stroke")
				.category("Automobile")
				.status(true)
				.build();
		
		when(repository.save(product)).thenReturn(product);
		
		assertEquals(product, service.createProduct(product));
				
	}
		
	@Test
	void getProductMaster() {
		
		ProductMaster product=ProductMaster.builder()
				.productId("999")
				.productName("Engine")
				.productShortDesc("4 Stroke")
				.category("Automobile")
				.status(true)
				.build();
		
		when(repository.findByProductId("999")).thenReturn(product);
		
		assertEquals("Engine",service.getProductByProductId("999").getProductName());
		
		
	}

	@Test
	void getProductMasterList() {
		
		ProductMaster product1=ProductMaster.builder()
				.productId("998")
				.productName("Engine")
				.productShortDesc("4 Stroke")
				.category("Automobile")
				.status(true)
				.build();
		
		ProductMaster product2=ProductMaster.builder()
				.productId("999")
				.productName("Tire")
				.productShortDesc("Car Tire")
				.category("Wheel")
				.status(true)
				.build();
		
		List<ProductMaster> productList=Arrays.asList(product1,product2);
		
		when(repository.findByStatusTrue()).thenReturn(productList);
		
		assertEquals(2, service.getProducts().size());
		
	}

	@Test
	void deleteProductMaster() {
		
		ProductMaster product=ProductMaster.builder()
				.productId("999")
				.productName("Engine")
				.productShortDesc("4 Stroke")
				.category("Automobile")
				.status(false)
				.build();
		
		when(service.getProductByProductId("999")).thenReturn(product);
		when(repository.save(product)).thenReturn(product);
		assertEquals(false, service.deleteProduct("999").getStatus());
		
	}




}
