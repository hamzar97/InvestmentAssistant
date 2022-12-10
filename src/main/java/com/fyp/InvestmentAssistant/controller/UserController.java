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


    private final UserService userService;


    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @RequestMapping(value = "/SaveBudget/{userId}",method = RequestMethod.POST)
    public ResponseEntity<Users> saveBudget(@PathVariable("userId") Users users,@RequestBody Long budget){
        users.setLastBudget(budget);
    Users user=userService.saveBudget(users);
    return new ResponseEntity<>(user, HttpStatus.OK);
    }

}
