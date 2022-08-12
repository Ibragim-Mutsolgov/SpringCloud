package com.example.fraud.repository;

import com.example.fraud.entity.Fraud;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FraudRepository extends JpaRepository<Fraud, Integer> {
}
