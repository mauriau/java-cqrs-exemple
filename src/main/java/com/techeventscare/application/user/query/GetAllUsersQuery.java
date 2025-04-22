package com.techeventscare.application.user.query;

import com.techeventscare.application.bus.Query;
import com.techeventscare.domain.user.User;

import java.util.List;

public record GetAllUsersQuery() implements Query<List<User>> {
}
