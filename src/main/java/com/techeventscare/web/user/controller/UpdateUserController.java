package com.techeventscare.web.user.controller;


import com.techeventscare.application.bus.CommandBus;
import com.techeventscare.application.user.command.UpdateUserCommand;
import com.techeventscare.domain.user.User;
import com.techeventscare.web.user.dto.UpdateUserDTO;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/api/user/{id}")
public class UpdateUserController {
    private final CommandBus commandBus;

    public UpdateUserController(CommandBus commandBus) {
        this.commandBus = commandBus;
    }

    @PutMapping()
    public ResponseEntity<User> updateUser(@PathVariable UUID id, @RequestBody @Valid UpdateUserDTO dto) {
        UpdateUserCommand command = new UpdateUserCommand(id, dto.username(), dto.email(), dto.password());
        User user = commandBus.send(command);
        return ResponseEntity.ok(user);
    }

}