package com.wms.product.controllertest;

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
import com.wms.controller.ProductMasterController;
import com.wms.model.ProductMaster;
import com.wms.service.impl.ProductMasterServiceImpl;

@WebMvcTest(ProductMasterController.class)
class ProductControllerTest {

	@MockBean
	ProductMasterServiceImpl service;

	@Autowired
	MockMvc mockMvc;

	@Test
	void saveProductTest() throws JsonProcessingException, Exception {

		ProductMaster product = ProductMaster.builder().productId("999").productName("Engine")
				.productShortDesc("4 Stroke").category("Automobile").status(true).build();

		when(service.createProduct(product)).thenReturn(product);

		mockMvc.perform(post("/wms/product/api/saveProduct").contentType(MediaType.APPLICATION_JSON)
				.content(new ObjectMapper().writeValueAsString(product))).andExpect(status().isOk());

	}

	@Test
	void getProduct() throws Exception {

		ProductMaster product = ProductMaster.builder().productId("999").productName("Engine")
				.productShortDesc("4 Stroke").category("Automobile").status(true).build();

		when(service.getProductByProductId("999")).thenReturn(product);

		mockMvc.perform(get("/wms/product/api/getProduct?productId=999").contentType(MediaType.APPLICATION_JSON))
				.andExpect(status().isOk()).andExpect(jsonPath("$.productName").value("Engine"));

	}

	@Test
	void getAllProducts() throws Exception {

		ProductMaster product1 = ProductMaster.builder().productId("998").productName("Engine")
				.productShortDesc("4 Stroke").category("Automobile").status(true).build();

		ProductMaster product2 = ProductMaster.builder().productId("999").productName("Tire")
				.productShortDesc("Car Tire").category("Wheel").status(true).build();

		List<ProductMaster> productList = Arrays.asList(product1, product2);

		when(service.getProducts()).thenReturn(productList);

		mockMvc.perform(get("/wms/product/api/getAllProducts").contentType(MediaType.APPLICATION_JSON))
				.andExpect(status().isOk()).andExpect(jsonPath("$[1].productName").value("Tire"));

	}
	
	@Test
	void deleteProduct() throws Exception {
		ProductMaster product = ProductMaster.builder().productId("998").productName("Engine")
				.productShortDesc("4 Stroke").category("Automobile").status(false).build();
		
		when(service.deleteProduct("998")).thenReturn(product);
		
		mockMvc.perform(delete("/wms/product/api/deleteProduct?productId=998")).andExpect(status().isOk())
		.andExpect(jsonPath("$.status").value(false));
		
		
		
	}

}
