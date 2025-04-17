package com.techeventscare.command;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.UUID;

public record UpdateUserCommand (
    UUID id,
    String username,
    String email
){
}
