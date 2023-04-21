package com.Example.BankManagement.response;

public class AccountResponse {
    String accountNumber;

    public AccountResponse(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    public AccountResponse() {

    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }
}
