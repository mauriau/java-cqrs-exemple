package com.techeventscare.user.infrastructure.controller;


import com.techeventscare.common.application.bus.CommandBus;
import com.techeventscare.user.application.command.DeleteUserCommand;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/api/user/{id}")
public class DeleteUserController {
    private final CommandBus commandBus;

    public DeleteUserController(CommandBus commandBus) {
        this.commandBus = commandBus;
    }

    @DeleteMapping()
    public ResponseEntity<Void> deletUser(@PathVariable UUID id) {
        DeleteUserCommand command = new DeleteUserCommand(id);
        commandBus.send(command);
        return ResponseEntity.noContent().build();
    }

}