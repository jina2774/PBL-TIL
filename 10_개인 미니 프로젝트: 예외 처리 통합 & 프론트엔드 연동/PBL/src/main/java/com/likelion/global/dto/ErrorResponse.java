package com.likelion.global.dto;

public record ErrorResponse(
        int status,
        String message
) {
}