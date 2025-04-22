package com.techeventscare.user.infrastructure.controller;

import com.techeventscare.common.application.bus.QueryBus;
import com.techeventscare.user.application.query.GetAllUsersQuery;
import com.techeventscare.user.domain.User;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/users")
public class GetUsersController {
    private final QueryBus queryBus;

    public GetUsersController(QueryBus queryBus) {
        this.queryBus = queryBus;
    }

    @GetMapping
    public List<User> getAllUsers() {
        GetAllUsersQuery Query = new GetAllUsersQuery();
        return queryBus.handle(Query);
    }

}