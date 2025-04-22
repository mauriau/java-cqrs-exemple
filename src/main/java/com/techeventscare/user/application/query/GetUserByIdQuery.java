package com.techeventscare.user.application.query;

import com.techeventscare.common.application.bus.Query;
import com.techeventscare.user.domain.User;

import java.util.UUID;

public record GetUserByIdQuery(UUID userId) implements Query<User> {
}
