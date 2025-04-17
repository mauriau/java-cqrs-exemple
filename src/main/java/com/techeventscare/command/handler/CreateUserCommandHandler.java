package com.techeventscare.command.handler;

import com.techeventscare.command.CreateUserCommand;
import com.techeventscare.model.User;
import com.techeventscare.repository.UserRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class CreateUserCommandHandler {

    @Autowired
    private final UserRepository userRepository;

    public CreateUserCommandHandler(UserRepository userRepository) {
        this.userRepository = userRepository;
    }


    public User handle(CreateUserCommand command) {
        User user = new User(null, command.username(), command.email(), command.password());
        return userRepository.save(user);
    }

}
