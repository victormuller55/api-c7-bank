package com.api.projeto.apic7bank.response;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

public class Success {
    public static <T> ResponseEntity<T> success200(T body) {
        return ResponseEntity.status(HttpStatus.OK).body(body);
    }
}
