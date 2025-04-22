package com.techeventscare.application.user.query;

import com.techeventscare.application.bus.Query;
import com.techeventscare.domain.user.User;

import java.util.UUID;

public record GetUserByIdQuery(UUID userId) implements Query<User> {
}
