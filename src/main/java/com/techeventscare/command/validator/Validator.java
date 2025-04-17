package com.techeventscare.command.validator;

import com.techeventscare.command.CommandInterface;
import com.techeventscare.command.CreateUserCommand;

public interface Validator {
    void validate(CommandInterface value);

    void validate(CreateUserCommand command);
}
