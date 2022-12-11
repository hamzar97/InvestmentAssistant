package com.fyp.InvestmentAssistant.controller;

import com.fyp.InvestmentAssistant.DTO.BudgetAndCategory;
import com.fyp.InvestmentAssistant.DTO.VendorDetailsAndParams;
import com.fyp.InvestmentAssistant.entities.Category;
import com.fyp.InvestmentAssistant.entities.Orders;
import com.fyp.InvestmentAssistant.entities.Products;
import com.fyp.InvestmentAssistant.entities.Vendor;
import com.fyp.InvestmentAssistant.repository.OrderRepository;
import com.fyp.InvestmentAssistant.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.xml.bind.SchemaOutputResolver;
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
        String userId=Integer.toString(orders.getUserId());
        String productId=Integer.toString(orders.getProductId());
        String vendorId=Integer.toString(orders.getVendorId());
        String finalOrderId=userId+productId+vendorId;
        orders.setOrderId(Integer.parseInt(finalOrderId));
        orders.setOrderStatus("PENDING");
        orders.setTotalPrice(orders.getTotalQuantity()*orders.getPerUnitPrice());
        Orders orders1=orderRepository.findByOrderId(Integer.parseInt(finalOrderId));
        if(orders1==null){
            orderRepository.save(orders);
        }
        productService.sendOrderEmail(orders);
        return new ResponseEntity<>(orders, HttpStatus.OK);
    }

    @RequestMapping(value = "/getOrder",method = RequestMethod.POST)
    public ResponseEntity<?> getOrder(@RequestBody Orders orders){
          return new ResponseEntity<>(orderRepository.findByProductIdAndVendorIdAndUserId(orders.getProductId(), orders.getVendorId(), orders.getUserId()), HttpStatus.OK);
    }
    @RequestMapping(value = "/getAllOrder/{userId}",method = RequestMethod.GET)
    public ResponseEntity<?> getAllOrder(@PathVariable("userId") int userId){
        return new ResponseEntity<>(orderRepository.findByUserId(userId), HttpStatus.OK);
    }
    @RequestMapping(value = "/Vendor/{vendorId}/{productId}",method = RequestMethod.POST)
    public ResponseEntity<?> placeOrder(@PathVariable(name = "vendorId") int vendorId,
                                        @PathVariable(name = "productId")  int productId){
        return new ResponseEntity<>(productService.getVendor(vendorId,productId),HttpStatus.OK);
    }
}
