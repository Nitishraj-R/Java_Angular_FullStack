package com.wms.service.impl;

import java.beans.PropertyDescriptor;
import java.util.HashSet;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Set;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.BeanWrapper;
import org.springframework.beans.BeanWrapperImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wms.model.ProductMaster;
import com.wms.repository.ProductMasterRepository;
import com.wms.service.ProductMasterService;

@Service
public class ProductMasterServiceImpl implements ProductMasterService {

	Logger log = LoggerFactory.getLogger(ProductMasterServiceImpl.class);

	@Autowired
	private ProductMasterRepository productMasterRepository;

	@Override
	public ProductMaster createProduct(ProductMaster productMaster) {

		log.info("ProductMaster service Implementation class createProduct method");
		productMaster.setStatus(true);
		return productMasterRepository.save(productMaster);

	}

	@Override
	public List<ProductMaster> getProducts() {
		log.info("ProductMaster service Implementation class getProducts method");

		return productMasterRepository.findByStatusTrue();
	}

	@Override
	public ProductMaster getProductByProductId(String productId) {

		log.info("ProductMaster service Implementation class getProductByProductId method");

		return productMasterRepository.findByProductId(productId);
	}

	@Override
	public ProductMaster deleteProduct(String id) {

		log.info("ProductMaster service Implementation class deleteProduct method");

		ProductMaster productByCode = getProductByProductId(id);
		ProductMaster productMaster = new ProductMaster();
		BeanUtils.copyProperties(productByCode, productMaster);
		productMaster.setStatus(false);

		return productMasterRepository.save(productMaster);
	}

	@Override
	public ProductMaster updateProduct(ProductMaster product) {

		log.info("ProductMaster service Implementation class updateProduct method");

		ProductMaster existingProduct = productMasterRepository.findById(product.getId())
				.orElseThrow(NoSuchElementException::new);

		try {
			BeanUtils.copyProperties(product, existingProduct, getNullPropertyNames(product));

		} catch (Exception e) {
			e.printStackTrace();

		}

		return productMasterRepository.save(existingProduct);
	}

	private String[] getNullPropertyNames(ProductMaster product) {
		final BeanWrapper src = new BeanWrapperImpl(product);
		Set<String> emptyNames = new HashSet<>();
		for (PropertyDescriptor pd : src.getPropertyDescriptors()) {
			Object srcValue = src.getPropertyValue(pd.getName());
			if (srcValue == null)
				emptyNames.add(pd.getName());
		}
		String[] result = new String[emptyNames.size()];
		log.info("ProductMaster service Implementation class getNullPropertyNames method" + emptyNames.toArray(result));

		return emptyNames.toArray(result);
	}

	@Override
	public List<ProductMaster> searchProduct(String search) {
		log.info("ProductMaster service Implementation class searchProduct method");

		return productMasterRepository.findByProductIdOrProductNameOrSkuNumberOrManufacturerOrCategoryOrProductidType(search, search, search,search,search,search);
	}

}
