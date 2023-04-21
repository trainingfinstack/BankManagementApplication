package com.Example.BankManagement.Service;

import com.Example.BankManagement.Entity.Account;
import com.Example.BankManagement.Repository.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Random;

@Service
public class AccountService {

    @Autowired
 private AccountRepository accountRepository;

    public Account getAccountDetailsById(int customerid)
    {
      return accountRepository.getAccountDetailsBycustomerid(customerid);
    }

    public Account addAccount(int customerId,String accountType) {
        Account a1=new Account();
        a1.setCustomerid(customerId);
        a1.setAccountType(accountType);
        a1.setActiveStatus(true);
        a1.setBalance(0);
        a1.setOpenedDate(setdate().toString());
        a1.setAccountNumber(setAccNo());
        return accountRepository.save(a1);
    }
    String setAccNo()
    {
        LocalDateTime now = LocalDateTime.now();
        Random rand = new Random();
        int randomNum = rand.nextInt(9999);
        String a = now.toString().replaceAll("[^0-9]", "");
        String accountNumber=a.substring(0,16)+String.format("%04d", randomNum);
        return accountNumber;
    }
    public LocalDateTime setdate()
    {
        LocalDateTime now = LocalDateTime.now();
        return now;
    }
}
