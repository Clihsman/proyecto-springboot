package com.drive.modules.auth.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.drive.modules.api.ApiController;
import com.drive.modules.auth.model.SigninRequest;
import com.drive.modules.auth.model.TokenResponse;
import com.drive.modules.auth.service.AuthService;
import com.drive.tools.Result;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
public class AuthController extends ApiController {

    private final AuthService authService;

    @PostMapping("/signin")
    public ResponseEntity<Object> signin(@Valid @RequestBody final SigninRequest request) {
        final Result<TokenResponse> token = authService.signin(request);
        return processResponse(token);
    }
}
