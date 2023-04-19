package com.Example.BankManagement.Service;

import com.Example.BankManagement.Entity.Customer;
import com.Example.BankManagement.Repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CustomerService {
    @Autowired
    private CustomerRepository customerRepository;
    public Optional<Customer> getCustomerDetails(int id) {
       return customerRepository.getCustomerDetailsById(id);
    }
}
