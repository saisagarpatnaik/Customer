package com.example.demo.service;
import com.example.demo.dao.CustomerRepository;
import com.example.demo.dto.CustomerDto;
import com.example.demo.entity.Customer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.List;
import java.util.Optional;

@Service
public class CustomerServiceImpl implements CustomerService {

    private static final Logger log= LoggerFactory.getLogger(CustomerServiceImpl.class);
    @Autowired
    CustomerRepository cs1;

    @Override
    public CustomerDto saveCustomer(Customer c1) {
        log.info("from serviceImpl class");
        log.info(c1.toString());
        Customer c3 = cs1.save(c1);
        CustomerDto customerDto = new CustomerDto();
        customerDto.setCustomerId(c3.getCustomerId());
        customerDto.setAddress(c3.getPresentAddress());
        customerDto.setPhoneNumber(c3.getPhoneNumber());
        CustomerDto c4 = new CustomerDto(c3.getCustomerId(), c3.getPresentAddress(), c3.getPhoneNumber());
        log.info("Saved successfully in db");
        return c4;
    }

    @Override
    public List<Customer> getCustomer() {

        return (List<Customer>) cs1.findAll();
    }

    @Override
    public Customer getCustomerId(long id) {
        try {
            Optional<Customer> c1 = cs1.findById(id);
            return c1.get();
        } catch (Exception e) {
            log.info(e + ":   Please enter in right format");
        }
        return null;
    }

    public Customer getCustomerStaticData() {
        Customer c = new Customer();
        c.setCustomerId(1);
        c.setFirstName("Sai");
        c.setLastName("Patnaik");
        c.setPresentAddress("India");
        Customer c1 = new Customer(1, "Sai", "Patnaik");
        //Customer c2 = new Customer(2, "Sagar", "Patnaik", "India", "732");
        return c1;
    }

    @Override
    public void updateCustomer(Customer c2) {
        Optional<Customer> c3 = null;
        try {
            c3 = cs1.findById(Long.valueOf(c2.getCustomerId()));
                Customer c = c3.get();
                c.setPhoneNumber(c2.getPhoneNumber());
                c.setFirstName(c2.getFirstName());
                c.setLastName(c2.getLastName());
                c.setPresentAddress(c2.getPresentAddress());
                cs1.save(c);
        }
        catch (Exception e){
            log.info("Its an exception error");
        }
    }

    @Override
    public void deleteCustomer(Customer c3) {
        cs1.delete(c3);
    }

    @Override
    public List<Customer> searchCustomer(Customer c5) {
        List<Customer> searchResult = null;

        if(!StringUtils.isEmpty(c5.getFirstName())){ //if(c5.getFirstName() != null) {
            searchResult = cs1.findByFirstName(c5.getFirstName());
        }
        else if(!StringUtils.isEmpty(c5.getLastName())) {  //else if(c5.getLastName() != null) {
            searchResult = cs1.findByLastName(c5.getLastName());
        }

        else{

            log.info("no data found");
        }
        return searchResult;
    }
}