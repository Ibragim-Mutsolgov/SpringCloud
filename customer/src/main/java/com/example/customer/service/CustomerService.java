package com.example.customer.service;

import com.example.customer.controller.CustomerRegistrationRequest;
import com.example.customer.entity.Customer;
import com.example.customer.repository.CustomerRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
@AllArgsConstructor
public class CustomerService {

    private CustomerRepository repository;

    private final RestTemplate restTemplate;

    public void registerCustomer(CustomerRegistrationRequest customerRequest) {
        Customer customer = Customer.builder()
                .firstName(customerRequest.firstName())
                .lastName(customerRequest.lastName())
                .email(customerRequest.email())
                .build();
        // todo: check if email valid
        // todo: check if email not taken
        repository.saveAndFlush(customer);
        // todo: check if fraudster
        FraudResponse result = restTemplate.getForObject(
                "http://FRAUD/api/v1/fraud/{customerId}",
                FraudResponse.class,
                customer.getId()
        );
        if(result.isFraudster()) {
            throw new IllegalStateException("fraudster");
        }
        // todo: send notification
    }
}
