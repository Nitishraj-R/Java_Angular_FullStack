package com.wms.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wms.dto.CustomerMasterDto;
import com.wms.dto.VendorMasterDto;
import com.wms.model.CustomerMaster;
import com.wms.model.VendorMaster;
import com.wms.repository.VendorMasterRepository;
import com.wms.service.VendorMasterService;

@Service
public class VendorMasterServiceImpl implements VendorMasterService{
	
	Logger log=LoggerFactory.getLogger(VendorMasterServiceImpl.class);
	public static final Boolean STATUS=true;
	@Autowired
	private VendorMasterRepository vendorMasterRepository;

	@Override
	public VendorMasterDto createVendor(VendorMasterDto vendorMasterDto) {
		log.info("vendor service Implementation class createVendor method");
		VendorMaster vendorMaster=new VendorMaster();
		vendorMasterDto.setStatus(STATUS);
		BeanUtils.copyProperties(vendorMasterDto, vendorMaster);
		vendorMaster=vendorMasterRepository.save(vendorMaster);
		vendorMasterDto.setId(vendorMaster.getId());
		return vendorMasterDto;
	}
	
	@Override
	public VendorMasterDto updateVendor(VendorMasterDto vendorMasterDto) {
		log.info("vendor service Implementation class updateVendor method");
		VendorMaster vendorMaster=new VendorMaster();
		BeanUtils.copyProperties(vendorMasterDto, vendorMaster);
		vendorMaster=vendorMasterRepository.save(vendorMaster);
//		vendorMasterDto.setId(vendorMaster.getId());
		return vendorMasterDto;
	}

	@Override
	public List<VendorMasterDto> getVendors() {
		log.info("vendor service Implementation class getAllVendor method");
		Optional<List<VendorMaster>> vendorMasters=vendorMasterRepository.findByStatus(STATUS);
		List<VendorMasterDto> vendorMasterDtos=new ArrayList<>();
		if(vendorMasters.isPresent()) {
			for(VendorMaster vendorMaster: vendorMasters.get()) {
				VendorMasterDto vendorMasterDto=new VendorMasterDto();
				BeanUtils.copyProperties(vendorMaster, vendorMasterDto);
				vendorMasterDtos.add(vendorMasterDto);
			}
		}
//		return (List<VendorMaster>)vendorMasterRepository.findAll();
			return vendorMasterDtos;
		
	}

	
	@Override
	public VendorMasterDto getVendorbyCode(String code) {
		log.info("vendor service Implementation class getAllVendorByCode method");
		Optional<VendorMaster> findByVendorCode = vendorMasterRepository.findByVendorCode(code);
		if(findByVendorCode.isPresent()) {
			VendorMasterDto vendorMasterDto=new VendorMasterDto();
			BeanUtils.copyProperties(findByVendorCode.get(), vendorMasterDto);
			return vendorMasterDto;
		}
		return null;
	}

	@Override
	public String deleteVendor(String vendorCode) {
		log.info("vendor service Implementation class deleteVendor method");
		log.info("vendor Code is {}",vendorCode);
		Optional<VendorMaster> findByVendorCode = vendorMasterRepository.findByVendorCode(vendorCode);
		if(findByVendorCode.isPresent()) {
			findByVendorCode.get().setStatus(!STATUS);
			vendorMasterRepository.save(findByVendorCode.get());
			return "Successfully deleted";
		}
		return "Not able to delete because invalid id";
	}


	@Override
	public List<VendorMasterDto> searchVendor(String search) {
		log.info("VendorMaster service Implementation class searchCustomer method");

	 List<VendorMaster> vendorMaster = vendorMasterRepository.findByVendorCodeOrVendorNameOrEmailAddressOrPrimaryContactNumberOrRegistrationNo(search, search, search,search,search);
	 
	 List<VendorMasterDto> vendorMasterDto=new ArrayList<>();
	 for (VendorMaster vendorMaster1 : vendorMaster) {
		 
		 VendorMasterDto customerDto=new VendorMasterDto();
		 BeanUtils.copyProperties(vendorMaster1, customerDto);
		 
		 vendorMasterDto.add(customerDto);
		
	}
	
	 return vendorMasterDto;
	}

}
