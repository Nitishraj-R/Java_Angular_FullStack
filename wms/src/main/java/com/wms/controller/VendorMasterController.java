package com.wms.controller;

import java.util.List;

import org.apache.coyote.BadRequestException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.wms.dto.VendorMasterDto;
import com.wms.service.VendorMasterService;

@RestController
@RequestMapping("/wms/vendor/api")
@CrossOrigin(originPatterns="*",methods = {RequestMethod.POST,RequestMethod.GET,RequestMethod.PUT,RequestMethod.PATCH,RequestMethod.DELETE},allowedHeaders = {"Content-type"})
public class VendorMasterController {
	
	Logger log=LoggerFactory.getLogger(VendorMasterController.class);
	@Autowired
	VendorMasterService vendorMasterService;

	@PostMapping("/create")
	public VendorMasterDto create(@RequestBody VendorMasterDto vendorMasterDto) {
		log.info("Vendor Controller create method");
		log.info("Vendor code is {}",vendorMasterDto.getVendorCode());
		try {
			return vendorMasterService.createVendor(vendorMasterDto);
		}catch(Exception e) { 
			log.error(e.getMessage());
//			throw new BadRequestException(e.getMessage());
			return null;
		}
		
	}
	@PutMapping("/update")
	public VendorMasterDto update(@RequestBody VendorMasterDto vendorMasterDto) {
		log.info("Vendor Controller update method");
		log.info("Vendor code is {}",vendorMasterDto.getVendorCode());
		try {
			return vendorMasterService.updateVendor(vendorMasterDto);
		}catch(Exception e) {
			log.error(e.getMessage());
//			throw new BadRequestException(e.getMessage());
			return null;
		}
		
	}
	@DeleteMapping("/delete")
	public void delete(@RequestParam String vendorCode) {
		log.info("Vendor Controller delete method");
		log.info("Vendor code is {}",vendorCode);
		try {
			String message=vendorMasterService.deleteVendor(vendorCode);
			if(!"Successfully deleted".equals(message)) {
				throw new BadRequestException(message);
			}
		}catch(Exception e) {
			log.error(e.getMessage());
//			throw new BadRequestException(e.getMessage());
			
		}
		
	}
	@GetMapping("/fetch/{vendorCode}")
	public VendorMasterDto fetch(@PathVariable("vendorCode") String vendorCode) {
		log.info("Vendor Controller fetch method");
		try {
			return vendorMasterService.getVendorbyCode(vendorCode);
		}catch(Exception e) {
			log.error(e.getMessage());
//			throw new BadRequestException(e.getMessage());
			return null;
		}
		
	}
	@GetMapping("/fetchAll")
	public List<VendorMasterDto> fetchAll() {
		log.info("Vendor Controller fetchAll method");
		try {
			return vendorMasterService.getVendors();
		}catch(Exception e) {
			log.error(e.getMessage());
//			throw new BadRequestException(e.getMessage());
			return null;
		}
		
	}
	
	@GetMapping("search")
	public List<VendorMasterDto> searchProduct(@RequestParam String search){
		
		log.info("VendorMaster Controller search method");
		log.info("VendorMaster Controller search String is {}",search);
		
		
		return vendorMasterService.searchVendor(search);
		
		
	}

}
