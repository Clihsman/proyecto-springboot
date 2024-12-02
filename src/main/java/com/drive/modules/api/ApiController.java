package com.drive.modules.api;

import java.util.Map;

import org.springframework.http.ResponseEntity;

import com.drive.exception.NotAutorizedException;
import com.drive.exception.NotFoundException;
import com.drive.tools.Result;
import com.drive.tools.ServerError;

public abstract class ApiController {
    protected ResponseEntity<Object> processResponse(Result<?> result) {
        if (result.isOk())
            return ResponseEntity.ok(result.getValue());

        if (result.isException(NotFoundException.class))
            return ResponseEntity.notFound().build();

        if (result.isException(NotAutorizedException.class))
            return ResponseEntity.status(403).body(Map.of("message", result.getMessage()));

        return ResponseEntity.internalServerError()
                .body(new ServerError(result.getMessage(), result.getErrorRoute()));
    }
}
