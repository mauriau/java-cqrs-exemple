package com.techeventscare.user.application.command;

import com.techeventscare.common.application.bus.Command;
import com.techeventscare.user.domain.User;
import jakarta.validation.constraints.Email;

public record CreateUserCommand(
     String username,
     @Email(message = "Email non valide")
     String email,
     String password
)implements Command<User> {}
