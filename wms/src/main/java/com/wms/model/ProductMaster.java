package com.wms.model;

import java.util.Date;


import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ProductMaster {

	private Long id;

	private String skuNumber;

	private String productId;

	private String productidType;

	private String productName;

	private String productShortDesc;

	private Long parentSkuId;

	private String status;

	private Boolean isReturnable;

	private Long maxOrdQty;

	private Long maxAggShipQty;

	private Date preOrdLaunchDt;

	private Date preOrdEndDt;

	private Long preOrdQty;

	private Date preOrdRelDt;

	private Boolean isBackorder;

	private Long backOrderLimit;

	private String shippingOptions;

	private String dimensions;

	private String variantsAttributes;

	private String assetAttributes;

	private String productAttributes;

	private String discoveryAttributes;

	private String othersAttributies;

	private String legalAttributes;

	private String createdBy;

	private Date createdDate;

	private String modifiedBy;

	private Date lastmodifiedDate;

	private Boolean isPreOrderAllow;

	private Long lowStockThreshold;
	
	private String parentageType;

}
