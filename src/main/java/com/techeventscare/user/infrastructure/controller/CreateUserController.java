package com.techeventscare.user.infrastructure.controller;


import com.techeventscare.common.application.bus.CommandBus;
import com.techeventscare.user.application.command.CreateUserCommand;
import com.techeventscare.user.domain.User;
import com.techeventscare.user.infrastructure.dto.CreateUserDTO;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/user")
public class CreateUserController {
    private final CommandBus commandBus;

    public CreateUserController(CommandBus commandBus) {
        this.commandBus = commandBus;
    }

    @PostMapping
    public ResponseEntity<User> createUser(@RequestBody @Valid CreateUserDTO dto) {
        CreateUserCommand command = new CreateUserCommand(
                dto.username(), dto.email(), dto.password()
        );
        User user = commandBus.send(command);
        return ResponseEntity.ok(user);
    }

}