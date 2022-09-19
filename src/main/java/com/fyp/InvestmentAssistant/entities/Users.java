package com.fyp.InvestmentAssistant.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "USERS")
public class Users {

    @Id
    private long userId;

    @Column(name="USERNAME")
    private String username;
    @Column(name="PASSWORD")
    private String password;
    @Column(name="FULL_NAME")
    private String fullName;
    @Column(name="EMAIL")
    private String email;
    @Column(name="PHONE_NO")
    private String phoneNo;
    @Column(name="ADDRESS")
    private String Address;
    @Column(name="USER_TYPE")
    private String userType;
    @Column(name="LAST_BUDGET")
    private Long lastBudget;

    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhoneNo() {
        return phoneNo;
    }

    public void setPhoneNo(String phoneNo) {
        this.phoneNo = phoneNo;
    }

    public String getAddress() {
        return Address;
    }

    public void setAddress(String address) {
        Address = address;
    }

    public String getUserType() {
        return userType;
    }

    public void setUserType(String userType) {
        this.userType = userType;
    }

    public Long getLastBudget() {
        return lastBudget;
    }

    public void setLastBudget(Long lastBudget) {
        this.lastBudget = lastBudget;
    }
}
