package com.techeventscare.controller;

import com.techeventscare.model.User;
import com.techeventscare.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import io.swagger.v3.oas.annotations.Operation;

import java.util.List;

@RestController
@RequestMapping("/api/users")
public class GetUsersController {

    private final UserRepository userRepository;

    @Autowired
    public GetUsersController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }



    @Operation(summary = "Récupérer une seule taches Todos")
    @GetMapping
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

}