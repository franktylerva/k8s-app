package com.example.customer;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.config.AbstractMongoClientConfiguration;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@Configuration
@EnableMongoRepositories
public class MongoConfig extends AbstractMongoClientConfiguration {

    @Override
    protected String getDatabaseName() {
        return "people";
    }

    @Bean
    public CommandLineRunner commandLineRunner(CustomerRepository customerRepository) {
        return new CommandLineRunner() {
            @Override
            public void run(String... args) throws Exception {

                customerRepository.deleteAll().subscribe();

                var person = new Customer();
                    person.setAddress(new Customer.Address("419 Lacey Court",
                        "Leesburg", "VA", "20175"));
                    person.setName(new Customer.Name("Frank", "Tyler"));

                customerRepository.save(person).subscribe();

            }
        };
    }
}
