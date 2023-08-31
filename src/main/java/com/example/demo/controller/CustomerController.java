package com.example.demo.controller;

import com.example.demo.constants.CustomerConstants;
import com.example.demo.dto.CustomerDto;
import com.example.demo.entity.Customer;
import com.example.demo.service.CustomerService;
import org.slf4j.LoggerFactory;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.regex.Pattern;

/*@authorSai
*/


@RestController
public class CustomerController {

    private static final Logger log= LoggerFactory.getLogger(CustomerController.class);
    @Autowired //a shortcut to create an object
    CustomerService cs; //here we created object of CustomerService Interface, generally we can not create an object of an interface hence Autowired


    //@GetMapping("/number") OR @RequestMapping(value = "/number", method = RequestMethod.GET) - they are same
    @GetMapping("/number")
    //@RequestMapping(value = "/number", method = RequestMethod.GET)
    public long number(){
        return 7326404831l;
    } //Please dont get confused, pls ignore this part

    @PostMapping(CustomerConstants.SAVECUSTOMER)
    public CustomerDto saveCustomer(@RequestBody Customer c1){
        log.info("Entered into Controller");
        CustomerDto cs2 = null;
        //CustomerServiceImpl i1 = new CustomerServiceImpl();
        //i1.saveCustomer(c1);
        boolean phResult = Pattern.matches("[6-9][0-9]{9}", c1.getPhoneNumber()); //https://www.javatpoint.com/java-regex - Java Rejex
        if(phResult == false){
            log.error("Wrong format please check the input");
        }
        else {
            cs2 = cs.saveCustomer(c1);
            log.info("Saved Successfully in DB");
        }
        return cs2;
    }

    @PostMapping(CustomerConstants.SEARCHCUSTOMER)
    public List<Customer> searchCustomer(@RequestBody Customer c4){
        List<Customer> c = cs.searchCustomer(c4);
        return c;
    }

    @GetMapping(CustomerConstants.GETCUSTOMER)
    public List<Customer> getCustomer(){
        List<Customer> c = cs.getCustomer();
        return c;
    }
    @GetMapping(CustomerConstants.GETCUSTOMERID)
    public Customer getCustomerId(@PathVariable long id){
        Customer c = cs.getCustomerId(id);
        return c;
    }

    @PutMapping(CustomerConstants.UPDATECUSTOMER)
    public void updateCustomer(@RequestBody Customer c2){
        cs.updateCustomer(c2);
    }

    @DeleteMapping(CustomerConstants.DELETECUSTOMER)
    public void deleteCustomer(@RequestBody Customer c3){
        cs.deleteCustomer(c3);

    }

}
