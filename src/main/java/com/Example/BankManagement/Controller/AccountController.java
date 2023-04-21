package com.Example.BankManagement.Controller;

import com.Example.BankManagement.Entity.Account;
import com.Example.BankManagement.Entity.Customer;
import com.Example.BankManagement.Service.AccountService;
import com.Example.BankManagement.request.AccountRequest;
import com.Example.BankManagement.request.AccountRequestById;
import com.Example.BankManagement.response.AccountResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/accounts")
public class AccountController {

    @Autowired
    private AccountService accountService;

    @PostMapping("/details")
    public ResponseEntity<List<Account>> getAccountDetails(@RequestBody AccountRequestById account1) {
       List<Account> account = accountService.getAccountDetailsById(account1.getCustomerId());
        return ResponseEntity.ok(account);
    }
    @PostMapping("/add")
    public ResponseEntity<AccountResponse> addAccount(@RequestBody AccountRequest account1)
    {
        Account account= accountService.addAccount(account1.getCustomerid(),account1.getAccountType());
        AccountResponse r1=new AccountResponse();
        r1.setAccountNumber(account.getAccountNumber());
        return ResponseEntity.ok(r1);
    }

}
