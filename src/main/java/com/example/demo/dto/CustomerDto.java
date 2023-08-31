package com.example.demo.dto;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@Data
@ToString

public class CustomerDto {

    private int customerId;
    private String address;
    private String phoneNumber;

    public CustomerDto() {

    }

    public CustomerDto(int customerId, String address, String phoneNumber) {
        this.customerId = customerId;
        this.address = address;
        this.phoneNumber = phoneNumber;
    }


}
