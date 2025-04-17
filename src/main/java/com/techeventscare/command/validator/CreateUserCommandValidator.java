package com.techeventscare.command.validator;

import com.techeventscare.command.CreateUserCommand;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

@Component
public class CreateUserCommandValidator {

    public void validate(CreateUserCommand command) {
        if (!StringUtils.hasText(command.username())) {
            throw new IllegalArgumentException("Username cannot be empty");
        }
        if (!isValidEmail(command.email())) {
            throw new IllegalArgumentException("Email must be valid");
        }
    }

    private boolean isValidEmail(String email) {
        return email != null && email.contains("@") && email.contains(".");
    }
}