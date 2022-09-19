package com.fyp.InvestmentAssistant.repository;

import com.fyp.InvestmentAssistant.entities.Products;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ProductRepository extends JpaRepository<Products,Integer> {

    @Query(value = "SELECT * FROM PRODUCT p WHERE p.CATEGORY_ID= ?1",nativeQuery = true)
    public List<Products> findProductsByCategoryId(int CategoryId);

    @Query(value = "SELECT TOP 5 * FROM PRODUCT p WHERE p.PRODUCT_ID in(?1) ORDER BY PRODUCT_SALES DESC",nativeQuery = true)
    public List<Products> findProductsByBulk(String productId);

}
