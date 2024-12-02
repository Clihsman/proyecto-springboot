package com.drive.modules.auth.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.drive.modules.auth.model.SigninRequest;
import com.drive.modules.auth.model.TokenResponse;
import com.drive.modules.auth.service.AuthService;
import com.drive.tools.Result;
import com.drive.tools.ServerError;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
public class AuthController {

    private final AuthService authService;

    @PostMapping("/signin")
    public ResponseEntity<Object> signin(@RequestBody final SigninRequest request) {

        final Result<TokenResponse> token = authService.signin(request);

        if (token.isError())
            return ResponseEntity.internalServerError().body(new ServerError(token.getMessage(), token.getErrorRoute()));

        return ResponseEntity.ok(token.getValue());
    }
}
