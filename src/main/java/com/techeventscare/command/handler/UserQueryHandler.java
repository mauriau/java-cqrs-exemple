package com.techeventscare.command.handler;

import com.techeventscare.model.User;
import com.techeventscare.query.GetUserQuery;
import com.techeventscare.repository.UserRepository;
import org.springframework.stereotype.Service;

@Service
public class UserQueryHandler {
    private final UserRepository userRepository;

    public UserQueryHandler(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User handle(GetUserQuery query) {
        return userRepository.findById(query.getId())
                .orElseThrow(() -> new RuntimeException("User not found"));
    }
}