package com.techeventscare.user.application.query;

import com.techeventscare.common.application.bus.Query;
import com.techeventscare.user.domain.User;

import java.util.List;

public record GetAllUsersQuery() implements Query<List<User>> {
}
