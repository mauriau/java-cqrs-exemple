package com.techeventscare.user.application.handler;

import com.techeventscare.user.domain.UserRepository;
import org.springframework.stereotype.Service;

@Service
public class UserQueryHandler {
    private final UserRepository userRepository;

    public UserQueryHandler(UserRepository userRepository) {
        this.userRepository = userRepository;
    }


}