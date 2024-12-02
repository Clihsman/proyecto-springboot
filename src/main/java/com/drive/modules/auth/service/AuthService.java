package com.drive.modules.auth.service;

import org.springframework.stereotype.Service;

import com.drive.modules.auth.controller.SigninRequest;
import com.drive.modules.auth.controller.TokenResponse;
import com.drive.tools.Result;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class AuthService {

    private final JwtService jwtService;

    public Result<TokenResponse> signin(SigninRequest request) {

        Result<String> token = jwtService.generateToken("1", request.email());

        if (token.isError())
            return Result.error(token);

        return Result.success(new TokenResponse(token.getValue()));
    }
}
