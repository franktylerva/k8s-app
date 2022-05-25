package com.example.customer;

import lombok.Data;
import org.springframework.data.annotation.Id;

@Data
public class Customer {

    @Id
    String id;

    Name name;
    Address address;

    record Name(String firstName, String lastName) {}
    record Address(String street, String city, String state, String zip) {}
}
