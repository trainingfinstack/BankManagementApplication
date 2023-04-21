package com.Example.BankManagement.request;

public class AccountRequest {
    int customerid;
    String accountType;

    public AccountRequest() {

    }

    public AccountRequest(int customerid, String accountType) {
        this.customerid = customerid;
        this.accountType = accountType;
    }

    public int getCustomerid() {
        return customerid;
    }

    public void setCustomerid(int customerid) {
        this.customerid = customerid;
    }

    public String getAccountType() {
        return accountType;
    }

    public void setAccountType(String accountType) {
        this.accountType = accountType;
    }
}