package com.techeventscare.application.user.command;

import com.techeventscare.application.bus.Command;
import com.techeventscare.domain.user.User;
import jakarta.validation.constraints.Email;

public record CreateUserCommand(
     String username,
     @Email(message = "Email non valide")
     String email,
     String password
)implements Command<User> {}
