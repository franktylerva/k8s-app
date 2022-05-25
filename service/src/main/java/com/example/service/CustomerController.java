package com.example.service;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;

@RestController
@RequestMapping("/people")
@RequiredArgsConstructor
public class PersonController {

    final PersonRepository personRepository;

    @GetMapping
    public Flux<Person> people() {
        return personRepository.findAll();
    }
}
