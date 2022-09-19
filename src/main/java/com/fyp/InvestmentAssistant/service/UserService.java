package com.fyp.InvestmentAssistant.service;

import com.fyp.InvestmentAssistant.entities.Users;
import com.fyp.InvestmentAssistant.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    UserRepository userRepository;

    public Users saveBudget(Users user){
      return  userRepository.save(user);
    }
}
