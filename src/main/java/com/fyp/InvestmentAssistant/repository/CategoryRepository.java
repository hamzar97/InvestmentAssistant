package com.fyp.InvestmentAssistant.repository;

import com.fyp.InvestmentAssistant.entities.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoryRepository extends JpaRepository<Category,Integer> {

}
