package com.techeventscare.web.user.controller;


import com.techeventscare.application.bus.CommandBus;
import com.techeventscare.application.user.command.CreateUserCommand;
import com.techeventscare.domain.user.User;
import com.techeventscare.web.user.dto.CreateUserDTO;
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
        User user = commandBus.dispatch(command);
        return ResponseEntity.ok(user);
    }

}