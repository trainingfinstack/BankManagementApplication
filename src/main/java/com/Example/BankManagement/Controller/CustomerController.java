package com.Example.BankManagement.Controller;

import com.Example.BankManagement.Entity.Customer;
import com.Example.BankManagement.Service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/customers")
public class CustomerController {
    @Autowired
    private CustomerService customerService;

    @PostMapping("/details")
    public ResponseEntity<Optional<Customer>> getCustomerDetails(@RequestBody Customer id) {
        Optional<Customer> customers = customerService.getCustomerDetails(id.getId());
        return ResponseEntity.ok(customers);
    }
}
