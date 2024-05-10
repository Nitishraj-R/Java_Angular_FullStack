package com.wms.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wms.model.BOMProductMaster;
import com.wms.model.ConfigBOMProductMaster;
import com.wms.model.ProductMaster;
import com.wms.repository.BomProductMasterRepository;
import com.wms.repository.ConfigBOMProductMasterRepository;
import com.wms.repository.ProductMasterRepository;
import com.wms.service.BOMProductMasterService;

@Service
public class BOMProductMasterServiceImpl implements BOMProductMasterService{

	
	private ConfigBOMProductMasterRepository bomProductMasterRepository;
	
	
	private ProductMasterRepository productRepo;
	
	
	private ConfigBOMProductMasterRepository configBomRepo;
	
	
	private BomProductMasterRepository bomRepo;
	
	
	
	public BOMProductMasterServiceImpl(ConfigBOMProductMasterRepository bomProductMasterRepository,
			ProductMasterRepository productRepo, ConfigBOMProductMasterRepository configBomRepo,
			BomProductMasterRepository bomRepo) {
		super();
		this.bomProductMasterRepository = bomProductMasterRepository;
		this.productRepo = productRepo;
		this.configBomRepo = configBomRepo;
		this.bomRepo = bomRepo;
	}

	@Override
	public ConfigBOMProductMaster createBOMProduct(ConfigBOMProductMaster bomProduct) {
		
		ConfigBOMProductMaster save = bomProductMasterRepository.save(bomProduct);
//		for (BOMProductMaster bom : bomProduct.getBomProductsList()) {
//			
//			Long productId = bom.getProductMaster().getId();
//			 ProductMaster productMaster = productRepo.findById(productId).get();
//			 bom.setProductMaster(productMaster);   			
//			 bom.setConfigMaster(save);
//			 bomRepo.save(bom);	 
//		}
		
		
		bomProduct.getBomProductsList()
		.stream()
		.forEach(bom-> {
			Long productId = bom.getProductMaster().getId();
			 ProductMaster productMaster = productRepo.findById(productId).get();
			 bom.setProductMaster(productMaster);   			
			 bom.setConfigMaster(save);
			 bomRepo.save(bom);	 

		});
		
		return save;
		
		
//	   Long id = bomProduct.getBomProductsList().get(0).getProductMaster().getId();
//	   
//	    ProductMaster productMaster = productRepo.findById(id).get();
//	    
//	    bomProduct.getBomProductsList().get(0).setProductMaster(productMaster);
//	    
//	    BOMProductMaster bomProductMaster = bomProduct.getBomProductsList().get(0);	    
//		 ConfigBOMProductMaster save = bomProductMasterRepository.save(bomProduct);
//		 bomProductMaster.setConfigMaster(save);
//         bomRepo.save(bomProductMaster);
         
		
	}

	@Override
	public List<ConfigBOMProductMaster> getVendors() {
		return (List<ConfigBOMProductMaster>) bomProductMasterRepository.findAll();
	}

	@Override
	public ConfigBOMProductMaster getConfigBonProductByCode(String code) {
//		return bomProductMasterRepository.getCode(code);
		return null;
	}

	

}
