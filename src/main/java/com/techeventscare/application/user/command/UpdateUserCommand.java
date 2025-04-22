package com.techeventscare.application.user.command;

import com.techeventscare.application.bus.Command;
import com.techeventscare.domain.user.User;
import jakarta.validation.constraints.Email;

import java.util.UUID;

public record UpdateUserCommand(
     UUID userId,
     String username,
     @Email(message = "Email non valide")
     String email,
     String password
)implements Command<User> {}
