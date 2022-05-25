package com.example.service;

import lombok.Data;
import lombok.Value;
import org.springframework.data.annotation.Id;

@Data
public class Person {

    @Id
    String id;

    Name name;
    Address address;

    record Name(String firstName, String lastName) {}
    record Address(String street, String city, String state, String zip) {}
}
