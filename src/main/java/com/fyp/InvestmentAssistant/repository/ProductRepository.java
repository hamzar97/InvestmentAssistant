package com.fyp.InvestmentAssistant.repository;

import com.fyp.InvestmentAssistant.entities.Products;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ProductRepository extends JpaRepository<Products,Integer> {

    @Query(value = "SELECT * FROM PRODUCT p WHERE p.CATEGORY_ID= ?1",nativeQuery = true)
    public List<Products> findProductsByCategoryId(int CategoryId);

    public Products findByProductId(int productId);

}
