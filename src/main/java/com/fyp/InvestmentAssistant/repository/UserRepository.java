package com.fyp.InvestmentAssistant.repository;


import com.fyp.InvestmentAssistant.entities.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<Users,Long> {

    public Users findByUsernameAndPassword(String username,String password);

    public Users findByUserId(long userId);
}
