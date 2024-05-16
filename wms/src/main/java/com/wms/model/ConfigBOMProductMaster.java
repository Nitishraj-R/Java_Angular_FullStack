package com.wms.model;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
 
@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ConfigBOMProductMaster {
 
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private String code;
	private String productidType;
 
	private String productName;
 
	private String productShortDesc;
 
	private Long parentSkuId;
 
	private String status;
 
	private Long lowStockThreshold;
	@OneToMany(mappedBy = "configMaster")
	private List<BOMProductMaster> bomProductsList;

 
}