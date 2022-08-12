package com.example.fraud.service;

import com.example.fraud.entity.Fraud;
import com.example.fraud.repository.FraudRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
@AllArgsConstructor
public class FraudService {

    private final FraudRepository repository;

    public boolean isFraudulentCustomer(Integer customerId) {
        repository.save(
                Fraud.builder()
                        .customerId(customerId)
                        .isFraudster(false)
                        .createdAt(LocalDateTime.now())
                        .build()
        );
        return false;
    }
}
