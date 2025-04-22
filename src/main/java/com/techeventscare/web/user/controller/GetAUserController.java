package com.techeventscare.web.user.controller;

import com.techeventscare.application.bus.QueryBus;
import com.techeventscare.application.user.handler.GetUserByIdQueryHandler;
import com.techeventscare.application.user.query.GetAllUsersQuery;
import com.techeventscare.application.user.query.GetUserByIdQuery;
import com.techeventscare.domain.user.User;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
@RequestMapping("/api/user")
public class GetAUserController {
    private final QueryBus queryBus;

    public GetAUserController(QueryBus queryBus) {
        this.queryBus = queryBus;
    }

    @GetMapping("/{id}")
    public User getUserById(@PathVariable UUID id) throws ChangeSetPersister.NotFoundException {
        GetUserByIdQuery Query = new GetUserByIdQuery(id);
        return queryBus.handle(Query);
    }
}
