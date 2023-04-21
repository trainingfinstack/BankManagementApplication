package com.Example.BankManagement.request;

public class AccountRequestById {
    int customerId;
    public AccountRequestById(int customerId) {
        this.customerId = customerId;
    }

    public AccountRequestById() {
    }

    public int getCustomerId() {
        return customerId;
    }

    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }
}
