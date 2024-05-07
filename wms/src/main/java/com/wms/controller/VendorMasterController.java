package com.wms.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.wms.model.VendorMaster;
import com.wms.service.VendorMasterService;

import jakarta.websocket.server.PathParam;

@RestController
@RequestMapping("/wms/vendor/api")
public class VendorMasterController {
	
	@Autowired
	VendorMasterService vendorMasterService;

	@PostMapping("/create")
	public void create(VendorMaster vendor) {
		vendorMasterService.createVendor(vendor);
	}
	@PostMapping("/update")
	public void update(VendorMaster vendor) {
		vendorMasterService.createVendor(vendor);
	}
	@PostMapping("/delete")
	public void delete() {
		
	}
	@GetMapping("/fetch/{vendorcode}")
	public VendorMaster fetch(@PathParam("vendorCode") String vendorCode) {
		return vendorMasterService.getVendorbyCode(vendorCode);
	}
	@GetMapping("/fetchAll")
	public List<VendorMaster> fetchAll() {
		return vendorMasterService.getVendors();
	}
}
