package com.fyp.InvestmentAssistant.controller;

import com.fyp.InvestmentAssistant.DTO.BudgetAndCategory;
import com.fyp.InvestmentAssistant.DTO.VendorDetailsAndParams;
import com.fyp.InvestmentAssistant.entities.Category;
import com.fyp.InvestmentAssistant.entities.Orders;
import com.fyp.InvestmentAssistant.entities.Products;
import com.fyp.InvestmentAssistant.repository.OrderRepository;
import com.fyp.InvestmentAssistant.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping(value = "/Products")
public class ProductController {


    public final ProductService productService;

    public final OrderRepository orderRepository;

    @Autowired
    public ProductController(ProductService productService, OrderRepository orderRepository) {
        this.productService = productService;
        this.orderRepository = orderRepository;
    }


    @ResponseBody
    @RequestMapping(value = "/getAllCategories",method = RequestMethod.GET)
    public List<Category> getAllCategories(){
        return productService.getAllCategories();
    }

    @RequestMapping(value = "/getVendors/{productId}",method = RequestMethod.GET)
    public List<VendorDetailsAndParams> getVendors(@PathVariable int productId){
        return productService.getVendorsList(productId);
    }

    @RequestMapping(value = "/getProducts",method = RequestMethod.POST)
    public List<Products> getProducts(@RequestBody BudgetAndCategory budgetAndCategory){
       return productService.getProducts(budgetAndCategory.getUserId(),budgetAndCategory.getCategoryId(),budgetAndCategory.getBudget());
    }

    @RequestMapping(value = "/placeOrder",method = RequestMethod.POST)
    public ResponseEntity<?> placeOrder(@RequestBody Orders orders){
        orders.setOrderStatus("PENDING");
        orders.setTotalPrice(orders.getTotalQuantity()*orders.getPerUnitPrice());
        return new ResponseEntity<>(orderRepository.save(orders), HttpStatus.OK);
    }
}
