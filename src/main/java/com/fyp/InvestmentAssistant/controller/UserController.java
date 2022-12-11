package com.fyp.InvestmentAssistant.controller;

import com.fyp.InvestmentAssistant.entities.Users;
import com.fyp.InvestmentAssistant.repository.UserRepository;
import com.fyp.InvestmentAssistant.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value="/User")
public class UserController {


    private final UserService userService;

    private final UserRepository userRepository;


    @Autowired
    public UserController(UserService userService, UserRepository userRepository) {
        this.userService = userService;
        this.userRepository = userRepository;
    }

    @RequestMapping(value = "/SaveBudget/{userId}",method = RequestMethod.POST)
    public ResponseEntity<Users> saveBudget(@PathVariable("userId") Users users,@RequestBody Long budget){
        users.setLastBudget(budget);
    Users user=userService.saveBudget(users);
    return new ResponseEntity<>(user, HttpStatus.OK);
    }

    @RequestMapping(value = "/login",method = RequestMethod.POST)
    public ResponseEntity<Users> Login(@RequestBody Users users){
        Users user=userRepository.findByUsernameAndPassword(users.getUsername(),users.getPassword());
        if(user==null){
            return new ResponseEntity<>(user,HttpStatus.UNAUTHORIZED);
        }else{
            return new ResponseEntity<>(user,HttpStatus.OK);
        }

    }


    @RequestMapping(value = "/register",method = RequestMethod.POST)
    public ResponseEntity<Users> Register(@RequestBody Users users){

        Users user=userRepository.findByUsernameAndPassword(users.getUsername(),users.getPassword());
        if(user==null){
            userRepository.save(users);
            user=users;
        }else{
            user.setUsername(users.getUsername());
            user.setPassword(users.getPassword());
            user.setFullName(users.getFullName());
            user.setEmail(users.getEmail());
            user.setPhoneNo(users.getPhoneNo());
            user.setAddress(users.getAddress());
            user.setUserType("CUSTOMER");
            user.setLastBudget(users.getLastBudget());
            userRepository.save(user);
        }
        return new ResponseEntity<>(user, HttpStatus.OK);
    }

}
