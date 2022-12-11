package com.fyp.InvestmentAssistant.repository;

import com.fyp.InvestmentAssistant.entities.Orders;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderRepository extends JpaRepository<Orders,Integer> {

    public Orders findByProductIdAndVendorIdAndUserId(int productId,int vendorId,int userId);
}
