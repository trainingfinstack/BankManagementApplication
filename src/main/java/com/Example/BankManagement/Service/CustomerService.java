package com.Example.BankManagement.Service;

import com.Example.BankManagement.Entity.Customer;
import com.Example.BankManagement.Repository.CustomerRepository;
import com.Example.BankManagement.request.CustomerRequest;
import com.Example.BankManagement.response.CustomerResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.Random;

@Service
public class CustomerService {
    @Autowired
    private CustomerRepository customerRepository;
    public Customer getCustomerDetailsById(int id) {
       return customerRepository.getCustomerDetailsById(id);
    }

    public Customer addCustomer(CustomerRequest customer) {
        Random random = new Random();
        int num= random.nextInt(1000);
      //  customer.setId(num);
        Customer c1=new Customer();
        c1.setAge(customer.getAge());
        c1.setName(customer.getName());
        c1.setMobile(customer.getMobile());
        c1.setId(num);
        return customerRepository.save(c1);

    }
}
