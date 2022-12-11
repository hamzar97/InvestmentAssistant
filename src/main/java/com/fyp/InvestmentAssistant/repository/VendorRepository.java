package com.fyp.InvestmentAssistant.repository;

import com.fyp.InvestmentAssistant.entities.Vendor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VendorRepository  extends JpaRepository<Vendor,Long> {

    public Vendor findByVendorId(long vendorId);
}
