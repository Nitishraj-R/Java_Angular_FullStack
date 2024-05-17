package com.wms.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;




import com.wms.model.VendorMaster;



public interface VendorMasterRepository extends JpaRepository<VendorMaster, Integer> {


	
	Optional<VendorMaster> findByVendorCode(String vendorCode);

	Optional<List<VendorMaster>> findByStatus(Boolean status);

}
