package com.example.demo.Service;

import com.example.demo.Model.Customer;
import com.example.demo.Repository.CustomerRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerService {
    @Autowired
    CustomerRepo customerRepo;

    public List<Customer> viewAllCustomer() {
        return customerRepo.viewAllCustomer();
    }

    public Customer createCustomer(Customer customer) {
        return customerRepo.createCustomer(customer);
    }

    public Customer findCustomer(int customer_id){
        return customerRepo.findCustomer(customer_id);
    }

    public Customer updateCustomer(int customer_id, Customer customer) {
        return customerRepo.updateCustomer(customer_id, customer);
    }

    public Boolean deleteCustomer(int customer_id) {
        return customerRepo.deleteCustomer(customer_id);
    }
}
