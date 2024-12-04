package com.drive.modules.api;

import java.util.Map;
import java.util.Optional;

import org.springframework.http.ResponseEntity;

public abstract class ApiController {

    protected <T> ResponseEntity<Object> processResponse(Optional<T> optional, String message) {
        return optional.isPresent() ? ResponseEntity.ok(optional.get())
                : ResponseEntity.status(404).body(Map.of("message", message));
    }

    protected ResponseEntity<Object> notFound(String message) {
        return ResponseEntity.status(404).body(Map.of("message", message));
    }
}
