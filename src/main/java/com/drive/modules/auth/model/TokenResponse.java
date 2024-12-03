package com.drive.modules.auth.model;

public record TokenResponse(
    String accessToken,
    String refreshToken
) {
}
