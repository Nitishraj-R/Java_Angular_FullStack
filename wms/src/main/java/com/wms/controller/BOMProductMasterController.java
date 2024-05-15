package com.wms.controller;

import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
 
import com.wms.dto.ConfigBOMProductMasterDto;
import com.wms.model.ConfigBOMProductMaster;
import com.wms.service.BOMProductMasterService;
 
@RestController
@RequestMapping("/wms/bomproduct/api")
@CrossOrigin(origins ={"http://localhost:4200"},methods = {RequestMethod.GET,RequestMethod.POST},allowedHeaders = "Content-type")
public class BOMProductMasterController {

	private BOMProductMasterService bomProductMasterService;

 
	public BOMProductMasterController(BOMProductMasterService bomProductMasterService) {
		super();
		this.bomProductMasterService = bomProductMasterService;
	}
	@PostMapping("/create")
	public ConfigBOMProductMasterDto create(@RequestBody ConfigBOMProductMasterDto bomProductMasterDto) {
	  return bomProductMasterService.createBOMProduct(bomProductMasterDto);
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
	public List<ConfigBOMProductMaster> fetchAll() {
		return bomProductMasterService.getVendors();
	}
}