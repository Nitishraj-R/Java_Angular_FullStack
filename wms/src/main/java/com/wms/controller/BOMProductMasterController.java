package com.wms.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.wms.model.ConfigBOMProductMaster;
import com.wms.service.BOMProductMasterService;

@RestController
@RequestMapping("/wms/bomproduct/api")
@CrossOrigin(originPatterns="*",methods = {RequestMethod.POST,RequestMethod.GET,RequestMethod.PATCH},allowedHeaders = "Content-type")
public class BOMProductMasterController {
	
	@Autowired
	private BOMProductMasterService bomProductMasterService;

	@PostMapping("/create")
	public void create(ConfigBOMProductMaster bomProductMaster) {
		bomProductMasterService.createBOMProduct(bomProductMaster);
	}
	@PostMapping("/update")
	public void update() {
		
	}
	@PostMapping("/delete")
	public void delete() {
		
	}
	@GetMapping("/fetch/{productcode}")
	public void fetch() {
		
	}
	@GetMapping("/fetchAll")
	public void fetchAll() {
		
	}
}
