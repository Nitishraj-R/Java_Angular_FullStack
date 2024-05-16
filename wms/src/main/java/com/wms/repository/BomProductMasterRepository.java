package com.wms.repository;
 
import java.util.List;
 
import org.springframework.data.jpa.repository.JpaRepository;
 
import com.wms.model.BOMProductMaster;
import com.wms.model.ConfigBOMProductMaster;
 
public interface BomProductMasterRepository extends JpaRepository<BOMProductMaster,Long> {
 
  List<BOMProductMaster> findByConfigMaster(ConfigBOMProductMaster configMaster);
}