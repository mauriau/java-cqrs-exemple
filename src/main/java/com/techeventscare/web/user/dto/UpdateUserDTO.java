package com.techeventscare.web.user.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

import java.util.UUID;

public record UpdateUserDTO(
    @NotBlank
    String username,
    @Email @NotBlank
    String email,
    @NotBlank
    String password
) {
}
