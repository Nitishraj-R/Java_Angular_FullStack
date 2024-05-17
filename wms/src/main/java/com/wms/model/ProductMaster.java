package com.wms.model;

import java.util.Date;

import org.hibernate.annotations.DynamicUpdate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@DynamicUpdate
public class ProductMaster {


	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	private String skuNumber;

	@Column(unique = true)

	private String productId;

	private String productidType;

	private String productName;

	private String productShortDesc;

	private String manufacturer;

	private String category;

	private String subcategory;

	private String material;

	private String color;

	private String compatibilityNotes;

	private String warranty;

	private Long parentSkuId;

	private Boolean status;

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

	private String othersAttributes;

	private String legalAttributes;

	private String createdBy;

	private Date createdDate;

	private String modifiedBy;

	private Date lastmodifiedDate;

	private Boolean isPreOrderAllow;

	private Long lowStockThreshold;
	
	private String percentageType;

	@OneToOne
	private VendorMaster vendor;

}
