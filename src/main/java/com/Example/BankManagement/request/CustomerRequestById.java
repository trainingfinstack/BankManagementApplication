package com.Example.BankManagement.request;

public class CustomerRequestById {
    int id;

    public CustomerRequestById() {
    }

    public CustomerRequestById(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
