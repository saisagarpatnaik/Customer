package com.example.demo.entity;
import jakarta.persistence.*;
import lombok.*;

@Entity //This will be treated as table
//@Table(name = "xyz") - we can customize the table name as well, for now the table name is Customer
@Getter
@Setter
@Data
@ToString
@NoArgsConstructor //This is default constructor
@AllArgsConstructor //This is a parameterized consulter

public class Customer {

    @Id //primary key
    @GeneratedValue(strategy = GenerationType.IDENTITY) //unique id will be generated

    private int customerId;

    @Column
    private String firstName;
    @Column
    private String lastName;
    @Column
    private String presentAddress;
    @Column
    private String phoneNumber;

    @OneToOne (cascade = CascadeType.ALL)
    @JoinColumn(name = "addressId")
    private Address a1;

    public Customer(int id, String firstName, String lastName){
        this.customerId = id;
        this.firstName = firstName;
        this.lastName = lastName;
        //it is a constructor
    }
   /* public Customer(){ //This is a default constructor
    }*/
}
