package com.Example.BankManagement.Entity;


import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Account {
  @Id
  String accountNumber;
    int customerid;
String accountType;
int Balance;
String openedDate;
boolean activeStatus;

    public Account(int customerid,String accountNumber, String accountType, int balance, String openedDate, boolean activeStatus) {
       this.customerid=customerid;
        this.accountNumber = accountNumber;
        this.accountType = accountType;
        Balance = balance;
        this.openedDate = openedDate;
        this.activeStatus = activeStatus;
    }

    public Account() {
    }
    public int getCustomerId() {
        return customerid;
    }
    public String getAccountNumber() {
        return accountNumber;
    }


    public String getAccountType() {
        return accountType;
    }

    public int getBalance() {
        return Balance;
    }

    public String getOpenedDate() {
        return openedDate;
    }

    public boolean isActiveStatus() {
        return activeStatus;
    }

    public void setCustomerid(int customerid) {
        this.customerid = customerid;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    public void setAccountType(String accountType) {
        this.accountType = accountType;
    }

    public void setBalance(int balance) {
        Balance = balance;
    }

    public void setOpenedDate(String openedDate) {
        this.openedDate = openedDate;
    }

    public void setActiveStatus(boolean activeStatus) {
        this.activeStatus = activeStatus;
    }

    @Override
    public String toString() {
        return "Account{" +
                "customerid=" + customerid +
                ", accountNumber='" + accountNumber + '\'' +
                ", accountType='" + accountType + '\'' +
                ", Balance=" + Balance +
                ", openedDate='" + openedDate + '\'' +
                ", activeStatus=" + activeStatus +
                '}';
    }
}
