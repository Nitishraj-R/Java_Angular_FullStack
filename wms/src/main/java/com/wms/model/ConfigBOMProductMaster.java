package com.wms.model;

import java.util.List;

import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Setter
@Getter
public class ConfigBOMProductMaster {
	
	private Long id;
	
	List<BOMProductMaster> products;
	
	private String code;
	
	private String productidType;

	private String productName;

	private String productShortDesc;

	private Long parentSkuId;

	private String status;

	private Long lowStockThreshold;
	
	

}
