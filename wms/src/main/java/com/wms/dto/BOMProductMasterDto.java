package com.wms.dto;
 
import java.util.List;
 
import com.fasterxml.jackson.annotation.JsonIgnore;
 
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import lombok.Data;
 
@Data
public class BOMProductMasterDto {
 
	private Long id;
	private Integer qty;
 
	@ManyToMany
	private List<ProductMasterDto> productMasterDto;
 
	@ManyToOne
	@JoinColumn
	@JsonIgnore
	private ConfigBOMProductMasterDto configMasterDto;
 
}