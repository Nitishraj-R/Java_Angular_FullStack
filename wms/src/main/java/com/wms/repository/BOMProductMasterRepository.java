package com.wms.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.wms.model.BOMProductMaster;

public interface BomProductMasterRepository extends JpaRepository<BOMProductMaster,Long> {

}
