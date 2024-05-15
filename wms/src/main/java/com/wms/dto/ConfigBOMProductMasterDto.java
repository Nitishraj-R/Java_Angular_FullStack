package com.wms.dto;
 
import java.util.List;
 
import com.wms.model.BOMProductMaster;
 
import jakarta.persistence.OneToMany;
import lombok.Data;
 
@Data
public class ConfigBOMProductMasterDto {
	private Long id;
 
	private String code;
 
	private String productidType;
 
	private String productName;
 
	private String productShortDesc;
 
	private Long parentSkuId;
 
	private String status;
 
	private Long lowStockThreshold;
 
	@OneToMany(mappedBy = "configMaster")
	private List<BOMProductMasterDto> bomProductsList;
 
}