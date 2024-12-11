package com.drive.modules.parameters.institutions.controller.request;

import jakarta.validation.constraints.NotEmpty;

public record InstitutionRequest(
        @NotEmpty String name,
        String address,
        String phone,
        String email,
        Integer cityId) {
}
