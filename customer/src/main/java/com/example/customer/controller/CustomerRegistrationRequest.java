package com.example.customer.controller;

public record CustomerRegistrationRequest(
        String firstName,
        String lastName,
        String email
) {
}
