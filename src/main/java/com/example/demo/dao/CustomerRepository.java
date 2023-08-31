package com.example.demo.dao;
import com.example.demo.entity.Customer;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface CustomerRepository extends CrudRepository<Customer, Long> {
    List<Customer> findByFirstName (String f); //select * from customer where firstname like '%xyz%'

    //findByFirstName is similar to findByID which is used in service and inbuilt method
    List<Customer> findByLastName (String l);

}
