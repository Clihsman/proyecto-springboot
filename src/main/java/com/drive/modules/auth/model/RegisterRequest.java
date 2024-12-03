package com.drive.modules.auth.model;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;

public record RegisterRequest(
                @NotEmpty(message = "required firstName") String firstName,
                String middleName,
                @NotEmpty(message = "required lastName") String lastName,
                String secondLastName,
                @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd") Date dateOfBirth,
                @NotEmpty(message = "required address") String address,
                @NotEmpty(message = "required phone") String phone,
                @Email(message = "email not valid") @NotEmpty(message = "required email") String email,
                @NotEmpty(message = "required password") String password) {
}
