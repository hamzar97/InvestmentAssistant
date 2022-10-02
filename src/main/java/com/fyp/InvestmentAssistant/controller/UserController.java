package com.fyp.InvestmentAssistant.controller;

import com.fyp.InvestmentAssistant.entities.Users;
import com.fyp.InvestmentAssistant.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import redis.clients.jedis.Jedis;

@RestController
@RequestMapping(value="/User")
public class UserController {


    private final UserService userService;


    private final RedisTemplate redisTemplate;

    @Autowired
    public UserController(UserService userService, RedisTemplate redisTemplate) {
        this.userService = userService;
        this.redisTemplate = redisTemplate;
    }

    @RequestMapping(value = "/SaveBudget/{userId}",method = RequestMethod.POST)
    public ResponseEntity<Users> saveBudget(@PathVariable("userId") int userId, @RequestBody Users users){
    Users user=userService.saveBudget(users);
    redisTemplate.opsForValue().set(String.format("%s:%s",userId,"budget"),users.getLastBudget());
    return new ResponseEntity<>(user, HttpStatus.OK);
    }

}
