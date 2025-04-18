package com.techeventscare.application.user.handler;

import com.techeventscare.domain.user.UserRepository;
import org.springframework.stereotype.Service;

@Service
public class UserQueryHandler {
    private final UserRepository userRepository;

    public UserQueryHandler(UserRepository userRepository) {
        this.userRepository = userRepository;
    }


}