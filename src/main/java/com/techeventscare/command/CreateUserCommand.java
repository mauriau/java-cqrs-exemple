package com.techeventscare.command;
import jakarta.validation.constraints.Email;

public record CreateUserCommand(
     String username,
     @Email(message = "Email non valide")
     String email,
     String password
)implements CommandInterface {}
