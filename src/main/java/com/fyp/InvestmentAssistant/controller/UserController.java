package com.fyp.InvestmentAssistant.controller;

import com.fyp.InvestmentAssistant.entities.Users;
import com.fyp.InvestmentAssistant.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value="/User")
public class UserController {

    @Autowired
    UserService userService;

    @RequestMapping(value = "/SaveBudget/{userId}",method = RequestMethod.POST)
    public ResponseEntity<Users> saveBudget(@PathVariable("userId") int userId, @RequestBody Users users){
    Users user=userService.saveBudget(users);
    return new ResponseEntity<>(user, HttpStatus.OK);
    }

}
