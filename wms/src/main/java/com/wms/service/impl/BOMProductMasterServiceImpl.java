package com.wms.service.impl;
 
import java.util.ArrayList;
import java.util.List;
 
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
 
import com.wms.dto.BOMProductMasterDto;
import com.wms.dto.ConfigBOMProductMasterDto;
import com.wms.dto.ProductMasterDto;
import com.wms.model.BOMProductMaster;
import com.wms.model.ConfigBOMProductMaster;
import com.wms.model.ProductMaster;
import com.wms.repository.BomProductMasterRepository;
import com.wms.repository.ConfigBOMProductMasterRepository;
import com.wms.repository.ProductMasterRepository;
import com.wms.service.BOMProductMasterService;
 
@Service
public class BOMProductMasterServiceImpl implements BOMProductMasterService {
 
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
	public ConfigBOMProductMasterDto createBOMProduct(ConfigBOMProductMasterDto bomProductDto) {
 
		ConfigBOMProductMaster configBOM = new ConfigBOMProductMaster();
 
		BeanUtils.copyProperties(bomProductDto, configBOM);
 
		ConfigBOMProductMaster save = bomProductMasterRepository.save(configBOM);
 
		List<BOMProductMaster> bomProductsList = new ArrayList<>();
 
		List<BOMProductMasterDto> bomProductsListDto = bomProductDto.getBomProductsList();
		List<ProductMaster> productMasterList = new ArrayList<>();
 
		bomProductsListDto.stream().peek(i -> System.out.println(i)).forEach(dto -> {
			BOMProductMaster bom = new BOMProductMaster();
			ProductMaster product = new ProductMaster();
			List<ProductMasterDto> productMasterDto = dto.getProductMasterDto();
			productMasterDto.forEach((productDto) -> {
				BeanUtils.copyProperties(productDto, product);
				productMasterList.add(product);
			});
			BeanUtils.copyProperties(dto, bom);
			bom.setProductMaster(productMasterList);
			bomProductsList.add(bom);
		});
 
		List<ProductMaster> productList = new ArrayList<>();
 
		bomProductsList.stream().forEach(bom -> {
//			Long productId = bom.getProductMaster().getId();
//			 ProductMaster productMaster = productRepo.findById(bom.getProductMaster().getId()).get();
			bom.getProductMaster().forEach(product -> {
				ProductMaster productMaster = productRepo.findById(product.getId()).get();
				productList.add(productMaster);
			});
			bom.setProductMaster(productList);
			bom.setConfigMaster(save);
			bomRepo.save(bom);
 
		});
 
		ConfigBOMProductMasterDto configDto = new ConfigBOMProductMasterDto();
 
		BeanUtils.copyProperties(save, configDto);
 
		return configDto;
 
	}
 
	@Override
	public List<ConfigBOMProductMaster> getVendors() {
		List<ConfigBOMProductMasterDto> configDtoList = new ArrayList<>();
 
		List<ConfigBOMProductMaster> configList = bomProductMasterRepository.findAll();
 
		configList.stream().forEach(config -> {
			List<BOMProductMaster> bomProduct = bomRepo.findByConfigMaster(config);
			config.setBomProductsList(bomProduct);
		});
 
		return configList;
 
//		 configList.stream().forEach( config-> {
//			 ConfigBOMProductMasterDto configDto = new ConfigBOMProductMasterDto();
//			 BeanUtils.copyProperties(config, configDto);
//			 configDtoList.add(configDto);
//		 }
//				 );
 
//		 return configDtoList;
	}
 
	@Override
	public ConfigBOMProductMaster getConfigBonProductByCode(String code) {
//		return bomProductMasterRepository.getCode(code);
		return null;
	}
 
}