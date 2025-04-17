package com.techeventscare.controller;


import com.techeventscare.command.CreateUserCommand;
import com.techeventscare.command.handler.CreateUserCommandHandler;
import com.techeventscare.model.User;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/user")
public class CreateUserController {
    private final CreateUserCommandHandler createUserCommandHandler;

    public CreateUserController(CreateUserCommandHandler createUserCommandHandler) {
        this.createUserCommandHandler = createUserCommandHandler;
    }

    @PostMapping
    public User create(@RequestBody CreateUserCommand command) {
        return createUserCommandHandler.handle(command);
    }

}