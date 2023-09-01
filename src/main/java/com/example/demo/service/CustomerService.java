package com.example.demo.service;

import com.example.demo.dto.CustomerDto;
import com.example.demo.entity.Customer;

import java.util.List;

public interface CustomerService {
    public CustomerDto saveCustomer(Customer c1);
    public List<Customer> getCustomer();
    public Customer getCustomerId(long id);

    public void updateCustomer(Customer c2);

    public void deleteCustomer(Customer c3);

    public List<Customer> searchCustomer(Customer c5);

}
