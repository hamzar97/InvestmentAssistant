package com.fyp.InvestmentAssistant.controller;

import com.fyp.InvestmentAssistant.DTO.BudgetAndCategory;
import com.fyp.InvestmentAssistant.entities.Category;
import com.fyp.InvestmentAssistant.entities.Products;
import com.fyp.InvestmentAssistant.entities.Users;
import com.fyp.InvestmentAssistant.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/Products")
public class ProductController {

    @Autowired
    ProductService productService;

    @RequestMapping(value = "/getAllCategories",method = RequestMethod.GET)
    public List<Category> getAllCategories(){
        return productService.getAllCategories();
    }

    @RequestMapping(value = "/getProducts",method = RequestMethod.POST)
    public List<Products> getProducts(@RequestBody BudgetAndCategory budgetAndCategory){
       return productService.getProducts(budgetAndCategory.getUserId(),budgetAndCategory.getCategoryId(),budgetAndCategory.getBudget());
    }


}
