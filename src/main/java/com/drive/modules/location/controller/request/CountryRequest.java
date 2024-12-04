package com.drive.modules.location.controller.request;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;

public record CountryRequest(
        @NotEmpty String name,
        @NotNull Integer code,
        @NotEmpty @Min(2) @Max(3) String phoneCode) {
}
