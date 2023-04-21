package com.Example.BankManagement.Controller;

import com.Example.BankManagement.Entity.Account;
import com.Example.BankManagement.Entity.Customer;
import com.Example.BankManagement.Service.AccountService;
import com.Example.BankManagement.response.AccountResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/accounts")
public class AccountController {

    @Autowired
    private AccountService accountService;

    @PostMapping("/details")
    public ResponseEntity<Account> getAccountDetails(@RequestBody Account account1) {
       Account account = accountService.getAccountDetailsById(account1.getCustomerId());
        return ResponseEntity.ok(account);
    }
    @PostMapping("/add")
    public ResponseEntity<AccountResponse> addAccount(@RequestBody Account account1)
    {
        Account account= accountService.addAccount(account1.getCustomerId(),account1.getAccountType());
        AccountResponse r1=new AccountResponse();
        r1.setAccountNumber(account.getAccountNumber());
        return ResponseEntity.ok(r1);
    }

}
