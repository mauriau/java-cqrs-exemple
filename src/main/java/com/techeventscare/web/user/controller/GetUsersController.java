package com.techeventscare.web.user.controller;

import com.techeventscare.application.bus.QueryBus;
import com.techeventscare.application.user.handler.GetAllUsersQueryHandler;
import com.techeventscare.application.user.query.GetAllUsersQuery;
import com.techeventscare.domain.user.User;
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