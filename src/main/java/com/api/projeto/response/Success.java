package com.api.projeto.response;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

public class Success {
    public static <T> ResponseEntity<T> success200(T body) {
        return ResponseEntity.status(HttpStatus.OK).body(body);
    }
}
