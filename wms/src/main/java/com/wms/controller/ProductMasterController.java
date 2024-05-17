package com.wms.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.wms.model.ProductMaster;
import com.wms.service.impl.ProductMasterServiceImpl;

@RestController
@RequestMapping("/wms/product/api/")

@CrossOrigin(originPatterns="*",methods = {RequestMethod.POST,RequestMethod.GET,RequestMethod.PUT,RequestMethod.PATCH,RequestMethod.DELETE},allowedHeaders = {"Content-type"})

public class ProductMasterController {
 
	private ProductMasterServiceImpl service;
	
	Logger log=LoggerFactory.getLogger(ProductMasterController.class);
 

	public ProductMasterController(ProductMasterServiceImpl service) {
		super();
		this.service = service;
	}


	@PostMapping("saveProduct")
	public ProductMaster saveProduct(@RequestBody ProductMaster product) {

		log.info("ProductMaster Controller save method");
		log.info("ProductMaster code is {}",product.getProductId());
		
		return service.createProduct(product);

	}

	@GetMapping("getAllProducts")
	public List<ProductMaster> getAllProduct() {
		log.info("ProductMaster Controller fetch All method");
		
		return service.getProducts();
		

	}
	
	@GetMapping("getProduct")
	public ProductMaster getProduct(@RequestParam String productId) {
		log.info("ProductMaster Controller fetch method");
		
		return service.getProductByProductId(productId);
	}
	
	@DeleteMapping("deleteProduct")
	public ProductMaster deleteProduct(@RequestParam String productId) {
		
		log.info("ProductMaster Controller delete method");
		log.info("ProductMaster code is {}",productId);
		
		
		return service.deleteProduct(productId);	
	}
 

	
	@PutMapping("updateProduct")
	public ProductMaster updateProduct(@RequestBody ProductMaster product) {
		
		log.info("ProductMaster Controller update method");
		log.info("ProductMaster code is {}",product.getProductId());
		
		
		return service.updateProduct(product);
		
	}
	
	
	@GetMapping("search")
	public List<ProductMaster> searchProduct(@RequestParam String search){
		
		log.info("ProductMaster Controller search method");
		log.info("ProductMaster Controller search String is {}",search);
		
		
		return service.searchProduct(search);
		
		
	}
}


