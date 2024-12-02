package com.drive.tools;

public record ServerError(
        String error,
        String route) {
}
