package com.drive.modules.auth.model;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;

public record SigninRequest(
                @Email(message = "email is required") @NotEmpty(message = "email is required") String email,
                @NotEmpty(message = "password is required") String password) {
}