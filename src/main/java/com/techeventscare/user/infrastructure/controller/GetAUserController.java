package com.techeventscare.user.infrastructure.controller;

import com.techeventscare.common.application.bus.QueryBus;
import com.techeventscare.user.application.query.GetUserByIdQuery;
import com.techeventscare.user.domain.User;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/api/user")
public class GetAUserController {
    private final QueryBus queryBus;

    public GetAUserController(QueryBus queryBus) {
        this.queryBus = queryBus;
    }

    @GetMapping("/{id}")
    @ExceptionHandler(EntityNotFoundException.class)
    public User getUserById(@PathVariable UUID id) throws EntityNotFoundException {
        GetUserByIdQuery Query = new GetUserByIdQuery(id);
        try {
            return queryBus.handle(Query);
        }catch (Exception e) {
            throw new EntityNotFoundException(e.getMessage());
        }
    }
}
