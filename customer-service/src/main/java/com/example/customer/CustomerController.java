package com.example.customer;

import com.example.customer.CustomerRepository;
import com.example.customer.Customer;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;

@RestController
@RequestMapping("/people")
@RequiredArgsConstructor
public class CustomerController {

    final CustomerRepository personRepository;

    @GetMapping
    public Flux<Customer> people() {
        return personRepository.findAll();
    }


}
