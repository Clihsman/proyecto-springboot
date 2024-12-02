package com.drive.modules.auth.model;

public record SigninRequest(
        String email,
        String password) {
}