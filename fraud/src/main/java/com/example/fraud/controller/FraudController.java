package com.example.fraud.controller;

import com.example.fraud.service.FraudService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@AllArgsConstructor
@RequestMapping("api/v1/fraud")
public class FraudController {

    private FraudService service;

    @GetMapping(path = "{customerId}")
    public FraudResponse isFraudster(
            @PathVariable("customerId") Integer customerId) {
        boolean result = service.isFraudulentCustomer(customerId);
        log.info("fraud request for customer {}", customerId);
        return new FraudResponse(result);
    }
}
