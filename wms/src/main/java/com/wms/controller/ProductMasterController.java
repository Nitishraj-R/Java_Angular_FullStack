package com.wms.controller;

import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.wms.model.ProductMaster;
import com.wms.service.ProductMasterService;

@RestController
@RequestMapping("/wms/product/api/")

@CrossOrigin(originPatterns="*",methods = {RequestMethod.POST,RequestMethod.GET,RequestMethod.PUT,RequestMethod.PATCH,RequestMethod.DELETE},allowedHeaders = {"Content-type"})


public class ProductMasterController {
	
	private ProductMasterService productService;
	
	public ProductMasterController(ProductMasterService productService) {
		this.productService=productService;
	}
	
	@PostMapping(path = "/create")
	public ProductMaster createProductMaster(@RequestBody ProductMaster productMaster) {
		
	 return productService.createProduct(productMaster);
	}
	
	@GetMapping(path = "/getAllProducts")
	public List<ProductMaster> getAll() {
		return  productService.getProducts();
	}

}
