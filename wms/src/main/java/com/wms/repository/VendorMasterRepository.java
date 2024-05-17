package com.wms.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.wms.model.VendorMaster;



public interface VendorMasterRepository extends JpaRepository<VendorMaster, Integer> {


	
	Optional<VendorMaster> findByVendorCode(String vendorCode);

	Optional<List<VendorMaster>> findByStatus(Boolean status);
	
List<VendorMaster> findByVendorCodeOrVendorNameOrEmailAddressOrPrimaryContactNumberOrRegistrationNo(String vendorCode,
			                                                                                        String vendorName,
			                                                                                        String email,
			                                                                                        String contact,
			                                                                                        String registernumber);
	

}
