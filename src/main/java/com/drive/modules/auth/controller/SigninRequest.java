package com.drive.modules.auth.controller;

public record SigninRequest(
        String email,
        String password) {
}