package com.drive.modules.auth.service;

import java.util.Map;

import org.springframework.stereotype.Service;

import com.drive.exception.NotAutorizedException;
import com.drive.modules.auth.model.SigninRequest;
import com.drive.modules.auth.model.TokenResponse;
import com.drive.modules.auth.model.UserModel;
import com.drive.modules.auth.repository.UserRepository;
import com.drive.tools.Result;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class AuthService {

    private final JwtService jwtService;
    private final UserRepository userRepository;

    public Result<TokenResponse> signin(SigninRequest request) {
        // se obtiene el usuario del repositorio
        Result<UserModel> userModel = userRepository.readByEmail(request.email());

        // se valída que no se presento ningún error
        if (userModel.isError())
            return Result.error(userModel);

        // se valida si el usuario existe

        if (userModel.getValue() == null)
            return Result.error(new NotAutorizedException("email or password is wrong"));

        Result<String> token = jwtService.generateToken("1", Map.of("email", request.email()));
        return token.isError() ? Result.error(token) : Result.success(new TokenResponse(token.getValue()));
    }
}
