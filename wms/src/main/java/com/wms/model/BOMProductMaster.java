package com.wms.model;
 
import java.util.List;
 
import com.fasterxml.jackson.annotation.JsonIgnore;
 
import jakarta.persistence.Entity;

import jakarta.persistence.GeneratedValue;

import jakarta.persistence.GenerationType;

import jakarta.persistence.Id;

import jakarta.persistence.JoinColumn;

import jakarta.persistence.ManyToMany;

import jakarta.persistence.ManyToOne;

import lombok.AllArgsConstructor;

import lombok.Data;

import lombok.NoArgsConstructor;
 
@Entity

@Data

@NoArgsConstructor

@AllArgsConstructor

public class BOMProductMaster  {

	@Id

	@GeneratedValue(strategy = GenerationType.AUTO)

	private Long id;

	private Integer qty;

	@ManyToMany

	private List<ProductMaster> productMaster;

	@ManyToOne

	@JoinColumn

	@JsonIgnore

	private ConfigBOMProductMaster configMaster;

 
}
