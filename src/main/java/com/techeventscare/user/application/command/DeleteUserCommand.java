package com.techeventscare.user.application.command;

import com.techeventscare.common.application.bus.Command;

import java.util.UUID;

public record DeleteUserCommand (
    UUID userId
) implements Command<Void> {}
