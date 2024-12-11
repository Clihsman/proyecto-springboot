package com.drive.modules.customers.controller.request;

import com.drive.modules.customers.model.Customer.SexType;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

public record RequestCustomer(
        @NotEmpty(message = "firstName is required") String firstName,
        String middleName,
        @NotEmpty(message = "firstSurname is required") String firstSurname,
        @NotEmpty(message = "secondLastName is required") String secondLastName,
        @NotNull(message = "documentNumber is required") Long documentNumber,
        String address,
        @Email(message = "email not valid") @NotEmpty(message = "address is required") String email,
        @NotEmpty(message = "phone is required") String phone,
        @NotNull(message = "sex is required") SexType sex,
        @NotNull(message = "institution is required") Integer institution,
        @NotNull(message = "educationalLevel is required") Integer educationalLevel) {
}
