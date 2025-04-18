package com.techeventscare.web.user.controller;

import com.techeventscare.application.user.handler.GetAllUsersQueryHandler;
import com.techeventscare.application.user.query.GetAllUsersQuery;
import com.techeventscare.domain.user.User;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/users")
public class GetUsersController {
    private final GetAllUsersQueryHandler getAllUsersQueryHandler;

    public GetUsersController(GetAllUsersQueryHandler getAllUsersQueryHandler) {
        this.getAllUsersQueryHandler = getAllUsersQueryHandler;
    }

    @GetMapping
    public List<User> getAllUsers() {
        return getAllUsersQueryHandler.handle(new GetAllUsersQuery());
    }

}