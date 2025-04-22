package com.techeventscare.application.user.command;

import com.techeventscare.application.bus.Command;

import java.util.UUID;

public record DeleteUserCommand (
    UUID userId
) implements Command<Void> {}
