package com.wms.controller;

import java.util.List;

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
 
	public ProductMasterController(ProductMasterServiceImpl service) {
		super();
		this.service = service;
	}
 
	@PostMapping("saveProduct")
	public ProductMaster saveProduct(@RequestBody ProductMaster product) {
 
		return service.createProduct(product);
 
	}
 
	@GetMapping("getAllProducts")
	public List<ProductMaster> getAllProduct() {
 
		return service.getProducts();
		
 
	}
	
	@DeleteMapping("deleteProduct")
	public void deleteProduct(@RequestParam String productId) {
		
		 service.deleteProduct(productId);	
	}
	
	@PutMapping("updateProduct")
	public ProductMaster updateProduct(@RequestBody ProductMaster product) {
		
		return service.updateProduct(product);
		
	}
}
